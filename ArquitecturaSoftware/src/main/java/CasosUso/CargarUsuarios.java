package CasosUso;

import Persistencia.IRepositorio;

public class CargarUsuarios implements ICargarUsuarios{
	
	public IRepositorio repositorio;
	String nombre;
	
	public CargarUsuarios( IRepositorio repositorio) {
		this.repositorio = repositorio;
		this.nombre="CasoDeUsoCargarUsuarios";
	}
	
	@Override
	public void cargarUsuarios() {
		repositorio.cargarPlanATelefonos();
	}
	
	public String obtenerCasoDeUso() {
		return nombre;
	}

	
}
