package CasosUso;

import Persistencia.IRepositorio;

public class CargarCDRs implements ICargarCDRs{

	public IRepositorio repositorio;
	String nombre;
	
	public CargarCDRs( IRepositorio repositorio) {
		this.repositorio = repositorio;
		this.nombre="CasoDeUsoCargarCDRs";
	}

	
	@Override
	public void cargarCDRs() {
		repositorio.leerCDRs();
	}
	
	public String obtenerCasoDeUso() {
		return nombre;
	}

}
