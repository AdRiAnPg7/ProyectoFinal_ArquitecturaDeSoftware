package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import CasosUso.MostrarCDRs;

import Entidades.CDR;


class TestMostrarCDRs {

	@Test
	void obtenerCasoDeUso() {
		MostrarCDRs cargarUsuarios= new MostrarCDRs(new ArrayList<CDR>());
		assertEquals("CasoDeUsoMostrarCDRs", cargarUsuarios.obtenerCasoDeUso());
	}

}
