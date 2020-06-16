package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


import Persistencia.IRepositorio;
import Persistencia.RegistrosCSV;
import Persistencia.RegistrosSQL;


class TestPersistencia {

	IRepositorio repositorio;
	@Test
	void obtenerCantidadCDRs() {
		repositorio= new RegistrosCSV();
		repositorio.leerCDRs();
		//repositorio.cargarPlanATelefonos();
		repositorio.cantidadUsuarios();
		assertEquals(7, repositorio.cantidadCDRs());
	}
	
	@Test
	void obtenerCantidadUsuarios() {
		repositorio= new RegistrosCSV();
		repositorio.leerCDRs();
		repositorio.cargarPlanATelefonos();
		repositorio.cantidadUsuarios();
		assertEquals(6, repositorio.cantidadUsuarios());
	}
	
	
	@Test
	void obtenerCantidadCDRsSQL() {
		repositorio= new RegistrosSQL();
		repositorio.leerCDRs();
	
		repositorio.cantidadUsuarios();
		assertEquals(3, repositorio.cantidadCDRs());
	}
	
	@Test
	void obtenerCantidadUsuariosSQL() {
		repositorio= new RegistrosSQL();
		repositorio.leerCDRs();
	
		repositorio.cantidadUsuarios();
		assertEquals(3, repositorio.cantidadUsuarios());
	}

}
