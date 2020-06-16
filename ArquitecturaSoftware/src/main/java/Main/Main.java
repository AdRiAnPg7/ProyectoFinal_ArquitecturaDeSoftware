package Main;

import Presentacion.IPresentacion;
import Presentacion.Spark;

public class Main {
	
	public static IPresentacion spark = new Spark ();

	public static void main(String[] args) {
		spark.iniciarPresentacion();
		
		/*ICDRRepositorio prueba = new RegistrosSQL();
		prueba.leerCDRs();
		prueba.mostrarCDRs();
		prueba.guardarCDRsCalculados();
	*/}
    
}                                                                                                                      
             