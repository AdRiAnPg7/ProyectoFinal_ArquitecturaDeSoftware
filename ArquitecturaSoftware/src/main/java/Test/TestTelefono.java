package Test;

import Planes.IPlan;
import Planes.PlanPostPago;
import Planes.PlanPrePago;
import Planes.PlanWow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Entidades.LineaTelefonica;

class TestTelefono {
	
	int numeroTelefono = 77556644;
	IPlan planPrePago = new PlanPrePago();
	IPlan planPostPago = new PlanPostPago();
	IPlan planWow= new PlanWow();
	String nombre1= "Adrian";
	String nombre2= "Andres";
	String nombre3= "Gamal";
	
	
	@Test
	void obtenerNumeroTelefonico() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,null);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
	}
	
	@Test
	void obtenerPlanPrePago() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago);
		assertEquals("PlanPrePago", telefono.obtenerPlan().obtenerNombre());
	}
	
	@Test
	void obtenerPlanPostPago() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago);
		assertEquals("PlanPostPago", telefono.obtenerPlan().obtenerNombre());
	}
	
	@Test
	void obtenerPlanWow() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow);
		assertEquals("PlanWow", telefono.obtenerPlan().obtenerNombre());
	}
	
	@Test
	void obtenerNombreAdrian() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago,nombre1);
		assertEquals("Adrian", telefono.obtenerNombre());
	}
	
	@Test
	void obtenerNombreAndres() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago, nombre2);
		assertEquals("Andres", telefono.obtenerNombre());
	}
	
	@Test
	void obtenerNombreGamal() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow, nombre3);
		assertEquals("Gamal", telefono.obtenerNombre());
	}
	
	@Test
	void obtenerTodosLosDatos() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPrePago, nombre1);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals("Adrian", telefono.obtenerNombre());
		assertEquals("PlanPrePago", telefono.obtenerPlan().obtenerNombre());
	}
	@Test
	void obtenerTodosLosDatos2() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planPostPago, nombre2);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals("Andres", telefono.obtenerNombre());
		assertEquals("PlanPostPago", telefono.obtenerPlan().obtenerNombre());
	}
	@Test
	void obtenerTodosLosDatos3() {
		LineaTelefonica telefono = new LineaTelefonica(numeroTelefono,planWow, nombre3);
		assertEquals(numeroTelefono, telefono.obtenerNumero());
		assertEquals("Gamal", telefono.obtenerNombre());
		assertEquals("PlanWow", telefono.obtenerPlan().obtenerNombre());
	}



}
