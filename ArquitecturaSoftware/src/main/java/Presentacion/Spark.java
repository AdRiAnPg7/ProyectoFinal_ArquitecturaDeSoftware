package Presentacion;

import static spark.Spark.get;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import CasosUso.CalcularCDRs;
import CasosUso.CargarCDRs;
import CasosUso.CargarUsuarios;
import CasosUso.IMostrarCDRs;
import CasosUso.IMostrarUsuarios;
import CasosUso.MostrarCDRs;
import CasosUso.MostrarUsuarios;
import Entidades.CDR;
import Entidades.LineaTelefonica;
import Persistencia.IRepositorio;
import Persistencia.RegistrosCSV;
import Persistencia.RegistrosSQL;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;


import static spark.Spark.*;


import spark.Filter;


public class Spark implements IPresentacion {
	
	public IRepositorio repositorio ;
	public ArrayList<CDR> CDRs;
	public ArrayList<LineaTelefonica> usuarios;
	public IMostrarCDRs mostrarCDRs;
	public IMostrarUsuarios mostrarUsuarios;
	DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
	public void iniciarPresentacion() {
        
		
		get("/", (request, response) -> {
				Map<String, Object> model = new HashMap<>();
				return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/index.vm"));
			});
		
		 get("/Configuracion", (request, response) -> {
	        	Map<String, Object> model = new HashMap<>();
	        	return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/Configuracion/Configuracion.vm"));
	        });
		 
		 get("/CDRs", (request, response) -> {
			 	
			 	mostrarCDRs = new MostrarCDRs(CDRs);
	        	Map<String, Object> model = new HashMap<>();
	        	model.put("CDRs", mostrarCDRs.obtenerCDRs());      
	        	model.put("Title","CDRs");
	        	return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/CDRs/CDRs.vm"));
	        });
		 
		 post("/CDRs", (request, response) -> {
			 	var tipo = request.queryParams("tipoArchivo");
			 	asignarPersistencia(tipo);
			 	var cargarCDRs = new CargarCDRs(repositorio);
			 	cargarCDRs.cargarCDRs();
			 	CDRs = repositorio.obtenerCDRs();
			 	mostrarCDRs = new MostrarCDRs(CDRs);
			 	
	        	Map<String, Object> model = new HashMap<>();
	        	model.put("CDRs", mostrarCDRs.obtenerCDRs() );      
	        	model.put("Title","CDRs");
	        	return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/CDRs/CDRs.vm"));
	        });
		 
		 get("/Usuarios", (request, response) -> {
			 	var cargarUsuarios = new CargarUsuarios(repositorio);
			 	cargarUsuarios.cargarUsuarios();	
			 	usuarios = repositorio.obtenerUsuarios();
			 	mostrarUsuarios = new MostrarUsuarios(usuarios);
			 
			  	Map<String, Object> model = new HashMap<>();
	        	model.put("Usuarios", mostrarUsuarios.obtenerUsuarios());
	        	return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/Usuarios/Usuarios.vm"));
	        });
		
		 get("/CDRsTarificados", (request, response) -> {
			 	var calcularCDRs= new CalcularCDRs(repositorio);
			 	LocalDateTime hoy = LocalDateTime.now();
			 	calcularCDRs.calcularCosto(hoy.getYear()+"_"+hoy.getMonth()+"_"+hoy.getDayOfMonth()+"_"+hoy.getHour()+"_"+hoy.getMinute()+"_"+hoy.getSecond());
			 	mostrarCDRs = new MostrarCDRs(CDRs);
			  	Map<String, Object> model = new HashMap<>();
	        	model.put("CDRs", mostrarCDRs.obtenerCDRs());
	        	model.put("Title","CDRs Tarificados");
	        	return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/CDRs/CDRsTarificados.vm"));
	        });
		 
		 get("/Tarificaciones", (request, response) -> {
			 	LocalDateTime hoy = LocalDateTime.now();
			 	mostrarCDRs = new MostrarCDRs(CDRs);
			  	Map<String, Object> model = new HashMap<>();
	        	model.put("CDRs", mostrarCDRs.obtenerCDRs());
	        	model.put("Title",fecha.format(hoy));
	        	return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/Tarificaciones/Tarificaciones.vm"));
	        });
		 
		  
		  //JSONs
		  
		  after((Filter) (request, response) -> {
	            response.header("Access-Control-Allow-Origin", "*");
	            response.header("Access-Control-Allow-Methods", "GET");
	        });

		  get("/UsuariosJson", (request, response) -> {
			  usuarios = repositorio.obtenerUsuarios();
			 	mostrarUsuarios = new MostrarUsuarios(usuarios);
			 
			  	Map<String, Object> model = new HashMap<>();
	        	model.put("Usuarios", mostrarUsuarios.obtenerUsuarios());
	        	return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/Usuarios/UsuariosJson.vm"));
	        });
		  
		  get("/CDRsJson", (request, response) -> {
			 	mostrarCDRs = new MostrarCDRs(CDRs);
	        	Map<String, Object> model = new HashMap<>();
	        	model.put("CDRs", mostrarCDRs.obtenerCDRs());      
	        	return new VelocityTemplateEngine().render(new ModelAndView(model, "velocity/CDRs/CDRsJson.vm"));
	      });
		 
	}
	
	  //Methods
	  private void asignarPersistencia(String tipo) {
		  if("sql".equals(tipo)) {
		 		repositorio = new RegistrosSQL();
		 	}else{
		 		repositorio = new RegistrosCSV();
		 	}
	  }
}
