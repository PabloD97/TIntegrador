package preguntas;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;
import respuestas.Respuesta;

class TestPreguntaCompleja {
	
	PreguntaDeSimpleSeleccion preguntaCompleja;
	
	PreguntaAbierta preguntaAbierta1;
	PreguntaDeMultipleSeleccion preguntaCerrada;
	Encuesta encuesta;
	
	
	Respuesta got;
	Respuesta twd;
	
	

	Encuestado encuestado;

	@BeforeEach
	void setUp() throws Exception {
	 
		preguntaAbierta1= new PreguntaAbierta("que series ves?", preguntaCerrada);
		
	
		preguntaCerrada= new PreguntaDeMultipleSeleccion("que series ves?", null);
		
		encuestado= spy( new Encuestado("Pablo", "Diaz",encuesta) );
		
		got= mock(Respuesta.class);
		twd= mock(Respuesta.class);
		
		//SUT
		preguntaCompleja= new PreguntaDeSimpleSeleccion("que series ves?", preguntaAbierta1);
	
		 
	}

	@Test
	void testPreguntaDameTuPregunta() {
		assertEquals( "que series ves?", preguntaCompleja.getPregunta() );
	}
	
	@Test
	void testDameTuRespuestas() {
		preguntaCompleja.addRespuesta(got);
		preguntaCompleja.addRespuesta(twd);
		
		assertEquals( 2, preguntaCompleja.getOpciones().size() );
	}
	
	
	@Test
	void testResponde() {
		encuestado.setPreguntaActual(preguntaCompleja);
		preguntaCompleja.elegirRespuesta(got, encuestado);
		assertEquals(encuestado.getRespuestasElegidas().size() , new Integer (1) );
		encuestado.responder();
		assertEquals( 1, encuestado.getRespuestasDelEncuestado().size() );

	}

	@Test
	void testRespuestaElegidaDameTuSiguientePregunta() {
		encuestado.setPreguntaActual(preguntaCompleja);
		preguntaCompleja.elegirRespuesta(got, encuestado);
		assertEquals(encuestado.getRespuestasElegidas().size() , new Integer (1) );
		
		encuestado.responder();
		assertTrue(  encuestado.getRespuestasDelEncuestado().contains(got) );
		assertEquals(preguntaCompleja.getSiguientePregunta(),  preguntaAbierta1);
		assertEquals(  preguntaAbierta1, preguntaCompleja.getSiguientePregunta());
		assertEquals(  preguntaAbierta1.getAnteriorPregunta(), preguntaCompleja);
		
		
		assertEquals(  preguntaAbierta1,encuestado.getPreguntaActual() );
		// ESTE FUNCIONA, PERO LAS DEMAS TIPOS DE PREGUNTA NO :/
	}

}






























