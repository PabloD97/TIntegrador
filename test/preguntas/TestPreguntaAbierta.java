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
	Encuestado contenedor;
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		encuesta= mock(Encuesta.class);
		//preguntaAbierta2= new PreguntaAbierta
		
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
}



































