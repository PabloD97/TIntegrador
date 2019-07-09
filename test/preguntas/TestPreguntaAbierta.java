package preguntas;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;

class TestPreguntaAbierta {
	
	PreguntaAbierta preguntaAbierta;
	PreguntaAbierta preguntaAbierta2;
	
	Encuesta encuesta;
	Encuestado encuestado;
	
	@BeforeEach
	void setUp() throws Exception {
		
		preguntaAbierta2= new PreguntaAbierta(null, null);
		encuesta= mock(Encuesta.class);
		encuestado= spy(new Encuestado(null, null, encuesta));
		preguntaAbierta = new PreguntaAbierta("cual es tu nombre?", preguntaAbierta2);
		
	}
	@Test
	void testPreguntaAbierta() {
		assertEquals( new String("cual es tu nombre?") , preguntaAbierta.getPregunta() );
	}

	@Test
	void testEsPrimerPregunta() {
		preguntaAbierta.esPrimerPregunta();
		assertTrue( preguntaAbierta.primerPregunta() );
	}
	
	@Test
	void testEsUltimaPregunta() {
		preguntaAbierta.esUltimaPregunta();
		assertTrue( preguntaAbierta.ultimaPregunta() );
	}

	@Test
	void testDameTuSiguientePregunta() {
		assertEquals(preguntaAbierta2, preguntaAbierta.getSiguientePregunta());
	}

	
	@Test
	void testAQueEncuestaPerteneces() {
		preguntaAbierta.setEncuesta(encuesta);
		assertEquals(encuesta , preguntaAbierta.getEncuesta() );
	}
	
	@Test 
	void testSeEscribeLaRespuesta() {
		preguntaAbierta.escribirRespuesta("pepito", encuestado);
		assertTrue(encuestado.getRespuestasDelEncuestado().isEmpty());
		assertEquals(new Integer(1), encuestado.getRespuestasElegidas().size());
	}
	
	@Test
	void testAlguienRespondeLaPregunta() {
		encuestado.setPreguntaActual(preguntaAbierta);
		preguntaAbierta.escribirRespuesta("pepito", encuestado);
		encuestado.responder();
		assertEquals( preguntaAbierta2.getAnteriorPregunta() , preguntaAbierta );
		assertTrue(encuestado.getRespuestasElegidas().isEmpty());
		assertTrue(!encuestado.getRespuestasDelEncuestado().isEmpty());
		assertEquals(preguntaAbierta2, encuestado.getPreguntaActual());

		
	}
}



































