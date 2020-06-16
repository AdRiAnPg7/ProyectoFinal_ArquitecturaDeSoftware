package CasosUso;

import java.util.ArrayList;

import Entidades.LineaTelefonica;


public class MostrarUsuarios implements IMostrarUsuarios {

	public ArrayList<LineaTelefonica> usuarios;
	String nombre;
	
	public MostrarUsuarios( ArrayList<LineaTelefonica> usuarios) {
		this.usuarios = usuarios;
		this.nombre="CasoDeUsoMostrarUsuarios";
	}
	
	@Override
	public ArrayList<LineaTelefonica> obtenerUsuarios() {
		return usuarios;
	}
	
	public String obtenerCasoDeUso() {
		return nombre;
	}

}
