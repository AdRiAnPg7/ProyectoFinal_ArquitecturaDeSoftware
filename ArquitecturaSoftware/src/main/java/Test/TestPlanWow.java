package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import Planes.IPlan;
import Planes.PlanWow;

class TestPlanWow {

	IPlan planWow = new PlanWow();
	
	@Test
	void obtenerNombre() {
		assertEquals("PlanWow", planWow.obtenerNombre());
	}

}
