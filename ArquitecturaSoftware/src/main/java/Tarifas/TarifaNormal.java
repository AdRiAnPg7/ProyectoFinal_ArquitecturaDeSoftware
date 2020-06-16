package Tarifas;

import Entidades.CDR;

public class TarifaNormal implements ITarifaStrategy {

	float tarifaBsMinuto= 1.00f;

	public float calcularTarifa(CDR CDR) {
		return tarifaBsMinuto;
	}

}
