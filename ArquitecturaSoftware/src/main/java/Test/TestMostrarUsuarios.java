package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


import CasosUso.MostrarUsuarios;

import Entidades.LineaTelefonica;

class TestMostrarUsuarios {

	@Test
	void obtenerCasoDeUso() {
		MostrarUsuarios cargarUsuarios= new MostrarUsuarios(new ArrayList<LineaTelefonica>());
		assertEquals("CasoDeUsoMostrarUsuarios", cargarUsuarios.obtenerCasoDeUso());
	}
}
