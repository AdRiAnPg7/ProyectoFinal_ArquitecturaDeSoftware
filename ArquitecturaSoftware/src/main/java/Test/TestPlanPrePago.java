package Test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


import Planes.IPlan;
import Planes.PlanPrePago;

class TestPlanPrePago {

	IPlan planPrePago = new PlanPrePago();
	
	@Test
	void obtenerNombre() {
		assertEquals("PlanPrePago", planPrePago.obtenerNombre());
	}
	
}
