package Planes;

import Entidades.CDR;
import Tarifas.ITarifaStrategy;

public class PlanWow implements IPlan {

	public ITarifaStrategy tarifa;
	
	public String obtenerNombre(){
		return "PlanWow";
	}
	public void aniadirTarifa(ITarifaStrategy tarifa) {
		this.tarifa = tarifa;
	}

	public float obtenerTarifa(CDR CDR) {
		return tarifa.calcularTarifa(CDR);
	}
}