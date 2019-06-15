package proyecto;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

class TestProyecto {
	
	Proyecto proyecto1;
	Proyecto proyecto2;
	Proyecto proyecto3;

	Encuesta encuesta1;
	Encuesta encuesta2;
	Encuesta encuesta3;
	
	@BeforeEach
	void setUp() throws Exception {
		
		encuesta1 = mock(Encuesta.class);
		encuesta2 = mock(Encuesta.class);
		encuesta3 = mock(Encuesta.class);
		
		proyecto1= new Proyecto("En este proyecto hablaremos sobre...", "El proposito del proyecto es lograr que...");
		proyecto2= new Proyecto("En este proyecto hablaremos sobre...", "El proposito del proyecto es lograr que...");
	}

	@Test
	void testDameTuDescripcion() {
		assertEquals( "En este proyecto hablaremos sobre..." , proyecto1.getDescripcion() );
	}

	@Test
	void testDameTuProposito() {
		assertEquals( "El proposito del proyecto es lograr que..." , proyecto1.getProposito() );
	}

	@Test
	void testDameTusEncuestas() {
		ArrayList<Encuesta>encuestas= new ArrayList<Encuesta>();
		encuestas.add(encuesta1);
		encuestas.add(encuesta2);
		
		proyecto1.agregarUnaEncuesta(encuesta1);
		proyecto1.agregarUnaEncuesta(encuesta2);
		
		assertEquals( encuestas , proyecto1.getEncuestas() );
	}
	
	//test de subProyectos
	@Test
	void testDameTusSubProyectos() {
		ArrayList<Proyecto>subProyectos = new ArrayList<Proyecto>();
		proyecto1.agregarSubProyecto(proyecto2);
		proyecto1.agregarSubProyecto(proyecto3);
		
		assertEquals( subProyectos , proyecto1.getSubProyectos());
	}
	
	void testNoPuedoAgregarSubProytecto() {
		proyecto1.agregarSubProyecto(proyecto2);
		
		assertFalse( proyecto2.puedoAgregarProyecto(proyecto1));
		/*assertEquals("El proyecto no puede ser agregado", proyecto1.agregarSubProyecto(proyecto2));
		 * TODO arreglar test*/
	}
}
