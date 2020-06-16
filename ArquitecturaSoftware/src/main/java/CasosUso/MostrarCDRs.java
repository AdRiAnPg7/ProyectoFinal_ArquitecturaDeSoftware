package CasosUso;

import java.util.ArrayList;

import Entidades.CDR;

public class MostrarCDRs implements IMostrarCDRs{
	
	public ArrayList<CDR> CDRs;
	String nombre;
	
	public MostrarCDRs( ArrayList<CDR> CDRs) {
		this.CDRs = CDRs;
		this.nombre= "CasoDeUsoMostrarCDRs";
	}
	
	@Override
	public ArrayList<CDR> obtenerCDRs() {
		return CDRs;
	}
	
	public String obtenerCasoDeUso() {
		return nombre;
	}

}
