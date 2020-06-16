package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CasosUso.TarifarCDRs;
import Persistencia.RegistrosSQL;

class TestTarifarCDRs {
	
	@Test
	void obtenerCasoDeUso() {
		TarifarCDRs cargarUsuarios= new TarifarCDRs(new RegistrosSQL());
		assertEquals("CasoDeUSoTarifarCDRs", cargarUsuarios.obtenerCasoDeUso());
	}

}
