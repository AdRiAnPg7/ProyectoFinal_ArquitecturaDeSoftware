package CasosUso;

import Persistencia.IRepositorio;

public class CalcularCDRs implements ICalcularCDRs {
	public IRepositorio repositorio;
	String nombre;
	
	public CalcularCDRs( IRepositorio repositorio) {
		this.repositorio = repositorio;
		this.nombre="CasoDeUSoCalcularCDRs";
	}

	@Override
	public void calcularCosto(String fecha) {
		repositorio.guardarCDRsCalculados(fecha);
	}
	
	public String obtenerCasoDeUso() {
		return nombre;
	}
	
	
}
