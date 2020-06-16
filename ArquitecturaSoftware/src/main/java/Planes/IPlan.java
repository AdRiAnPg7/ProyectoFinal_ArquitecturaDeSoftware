package Planes;

import Entidades.CDR;
import Tarifas.ITarifaStrategy;

public interface IPlan {
	
	public void aniadirTarifa(ITarifaStrategy tarifa);
	public float obtenerTarifa(CDR CDR);
	public String obtenerNombre();
}
