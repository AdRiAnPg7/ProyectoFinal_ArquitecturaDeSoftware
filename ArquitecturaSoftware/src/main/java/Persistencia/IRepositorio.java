package Persistencia;

import java.util.ArrayList;

import Entidades.CDR;
import Entidades.LineaTelefonica;

public interface IRepositorio {
	
	public ArrayList <CDR> obtenerCDRs();
	public ArrayList <LineaTelefonica> obtenerUsuarios();
	public void leerCDRs();
	public void mostrarCDRs();
	public void cargarPlanATelefonos();
	public void guardarCDRsCalculados(String fecha);
	public int cantidadUsuarios();
	public int cantidadCDRs();
}
