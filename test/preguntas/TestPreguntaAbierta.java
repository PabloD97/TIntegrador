package preguntas;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;
import investigador.Investigador;

class TestPreguntaAbierta {
	
	PreguntaAbierta preguntaAbierta;
	PreguntaAbierta preguntaAbierta2;
	
	Investigador investigador;
	Encuesta encuesta;
	Encuestado contenedor;
	
	@BeforeEach
	void setUp() throws Exception {
		
		investigador = mock(Investigador.class);
		encuesta= mock(Encuesta.class);
		
		preguntaAbierta = new PreguntaAbierta("¿que color te gusta?", preguntaAbierta2);
		
	}
	@Test
	void testPreguntaAbierta() {
		assertEquals( new String("¿que color te gusta?") , preguntaAbierta.getPregunta() );
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
	void testAgregarInteresado() {
		preguntaAbierta.agregarInteresado(investigador);
		assertEquals( new Integer(1), preguntaAbierta.getInteresados().size());
	}

	@Test
	void testSacarInteresado() {
		preguntaAbierta.agregarInteresado(investigador);
		assertEquals( new Integer(1), preguntaAbierta.getInteresados().size());
		preguntaAbierta.sacarInteresado(investigador);
		assertTrue( preguntaAbierta.getInteresados().isEmpty() );
	}
	@Test
	void testAQueEncuestaPerteneces() {
		preguntaAbierta.setEncuesta(encuesta);
		assertEquals(encuesta , preguntaAbierta.getEncuesta() );
	}
}



































