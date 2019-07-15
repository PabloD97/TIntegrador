package investigador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import preguntas.PreguntaAbierta;
import proyecto.Proyecto;
import respuestas.Respuesta;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

class TestInvestigador {

	Investigador investigador;
	Proyecto proyecto1;
	Proyecto proyecto2;
	PreguntaAbierta pregunta1;
	PreguntaAbierta pregunta2;
	
	Respuesta respuesta;
	
	@BeforeEach
	void setUp() throws Exception {
		
		respuesta=mock(Respuesta.class);
		proyecto1= mock(Proyecto.class);
		proyecto2= mock(Proyecto.class);
		pregunta1= mock(PreguntaAbierta.class);
		pregunta2= mock(PreguntaAbierta.class);
		
		
		investigador= new Investigador( );
		
	}

	@Test
	void testAgregarUnProyecto() {
		ArrayList<Proyecto>proyectos= new ArrayList<Proyecto>();
		proyectos.add(proyecto1);
		proyectos.add(proyecto2);
		
		investigador.agregarProyecto(proyecto1);
		investigador.agregarProyecto(proyecto2);
		
		assertEquals(proyectos, investigador.getProyectos());
	}
	
	@Test 
	void testRemoverUnProyecto() {
		investigador.agregarProyecto(proyecto1);
		assertEquals( 1, investigador.getProyectos().size() );
		investigador.darDeBajaProyecto(proyecto1);
		assertEquals( 0, investigador.getProyectos().size() );
	}

	@Test
	void testSuscribirseAUnaRespuesta() {
		investigador.meInteresa(respuesta);
		assertTrue( investigador.getSuscripciones().contains(respuesta) );
	}
	
	@Test
	void testDesuscribirseAUnaRespuesta() {
		investigador.meInteresa(respuesta);
		assertTrue( investigador.getSuscripciones().contains(respuesta) );
		
		investigador.noMeInteresa(respuesta);
		assertFalse( investigador.getSuscripciones().contains(respuesta) );
	}
	// FALTA TESTEAR LO DE SUSCRIBIRSE A UNA RESPUESTA( AUN NO ENTIENDO MUY BIEN ESA PARTE), LO DE
	// NOTIFICARME, LO DE DESUSCRIBIRSE A LA RESPUESTA Y GETSUSCRIPCIONES
	
	
}











