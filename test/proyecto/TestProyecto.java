package proyecto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

class TestProyecto {
	
	Proyecto proyectoPrincipal;
	Proyecto subProyecto1;
	Proyecto subProyecto2;
	
	Encuesta encuesta1;
	Encuesta encuesta2;
	Encuesta encuesta3;
	Encuesta encuesta4;
	
	
	@BeforeEach
	void setUp() throws Exception {
		proyectoPrincipal= new Proyecto("Descripcion", "Proposito");
		subProyecto1 = new Proyecto("Descripcion", "Proposito");
		subProyecto2 = new Proyecto("Descripcion", "Proposito");
		
		encuesta1= mock(Encuesta.class);
		encuesta2= mock(Encuesta.class);
		encuesta3= mock(Encuesta.class);
		encuesta4= mock(Encuesta.class);
		
	}

	@Test
	void testDameTuPropositoYDescripcion() {
		assertEquals(new String("Descripcion"), proyectoPrincipal.getDescripcion());
		assertEquals(new String("Proposito"), proyectoPrincipal.getProposito());
	}
	
	@Test
	void testAgregarSubProyecto() {
		ArrayList<Proyecto> subProyectos= new ArrayList<Proyecto>();
		subProyectos.add(subProyecto1);
		subProyectos.add(subProyecto2);
		
		proyectoPrincipal.agregarSubProyecto(subProyecto1);
		proyectoPrincipal.agregarSubProyecto(subProyecto2);
		assertEquals(subProyectos, proyectoPrincipal.getSubProyectos());
	}
	
	@Test
	void testQuitarSubProyecto() {
		proyectoPrincipal.agregarSubProyecto(subProyecto1);
		proyectoPrincipal.removerSubProyecto(subProyecto1);
		assertTrue( proyectoPrincipal.getSubProyectos().isEmpty());
	}

	@Test
	void testAgregandoEncuestas() {
		ArrayList<Encuesta> encuestas= new ArrayList<Encuesta>();
		encuestas.add(encuesta1);
		encuestas.add(encuesta2);
		
		proyectoPrincipal.agregarUnaEncuesta(encuesta1);
		proyectoPrincipal.agregarUnaEncuesta(encuesta2);
		
		assertEquals(encuestas, proyectoPrincipal.getEncuestas());
	}
	
	@Test
	void testEncuestaMasContestada() {
		when(encuesta1.vecesFinalizado()).thenReturn(8);
		when(encuesta2.vecesFinalizado()).thenReturn(2);
		when(encuesta3.vecesFinalizado()).thenReturn(5);
		when(encuesta4.vecesFinalizado()).thenReturn(0);
		
		
		proyectoPrincipal.agregarUnaEncuesta(encuesta1);
		proyectoPrincipal.agregarUnaEncuesta(encuesta2);
		proyectoPrincipal.agregarUnaEncuesta(encuesta3);
		proyectoPrincipal.agregarUnaEncuesta(encuesta4);
		
		assertEquals( encuesta1, proyectoPrincipal.encuestaMasContestada() );
	}
	
	@Test
	void testEncuestasOrdenadasAlfabeticamente() {
		when(encuesta1.dameTuNombre()).thenReturn("encuestaA");
		when(encuesta2.dameTuNombre()).thenReturn("encuestaB");
		when(encuesta3.dameTuNombre()).thenReturn("encuestaC");
		when(encuesta4.dameTuNombre()).thenReturn("encuestaD");
		
		ArrayList<Encuesta> encuestas= new ArrayList<Encuesta>();
		encuestas.add(encuesta1);
		encuestas.add(encuesta2);
		encuestas.add(encuesta3);
		encuestas.add(encuesta4);
		
		
		proyectoPrincipal.agregarUnaEncuesta(encuesta4);
		proyectoPrincipal.agregarUnaEncuesta(encuesta2);
		proyectoPrincipal.agregarUnaEncuesta(encuesta1);
		proyectoPrincipal.agregarUnaEncuesta(encuesta3);
		
		assertEquals(encuestas , proyectoPrincipal.encuestasPorOrdenAlfabetico() );
	}
}














