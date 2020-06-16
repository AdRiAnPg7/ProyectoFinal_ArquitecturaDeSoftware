package CasosUso;

import Persistencia.IRepositorio;

public class TarifarCDRs implements ITarifarCDRs {
	
	public IRepositorio repositorio;
	String nombre;
	
	public TarifarCDRs( IRepositorio repositorio) {
		this.repositorio = repositorio;
		this.nombre="CasoDeUSoTarifarCDRs";
	}

	@Override
	public void calcularCosto(String fecha) {
		repositorio.guardarCDRsCalculados(fecha);
	}
	
	public String obtenerCasoDeUso() {
		return nombre;
	}
	
}
