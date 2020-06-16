package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


import CasosUso.CargarCDRs;
import Persistencia.RegistrosSQL;

class TestCargarCDRs {


	@Test
	void obtenerCasoDeUso() {
		CargarCDRs cargarCDRs= new CargarCDRs(new RegistrosSQL());
		assertEquals("CasoDeUsoCargarCDRs", cargarCDRs.obtenerCasoDeUso());
	}

}
