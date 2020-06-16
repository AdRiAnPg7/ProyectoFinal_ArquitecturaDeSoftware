package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import CasosUso.CargarUsuarios;
import Persistencia.RegistrosSQL;

class TestCargarUsuarios {

	@Test
	void obtenerCasoDeUso() {
		CargarUsuarios cargarUsuarios= new CargarUsuarios(new RegistrosSQL());
		assertEquals("CasoDeUsoCargarUsuarios", cargarUsuarios.obtenerCasoDeUso());
	}

}
