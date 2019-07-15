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
import investigador.Investigador;
import respuestas.Respuesta;

class TestPreguntaDeSimpleSeleccion {
	
	PreguntaDeSimpleSeleccion preguntaCompleja;
	
	PreguntaAbierta preguntaAbierta1;
	PreguntaDeMultipleSeleccion preguntaCerrada;
	Encuesta encuesta;
	
	
	Respuesta got;
	Respuesta twd;
	
	Investigador investigador;

	Encuestado encuestado;

	@BeforeEach
	void setUp() throws Exception {
	 
		
	
		
		encuestado= spy( new Encuestado("Pablo", "Diaz",encuesta) );
		
		preguntaCerrada = new PreguntaDeMultipleSeleccion(null, preguntaAbierta1);
		
		got= new Respuesta("got", preguntaCerrada);
		twd= mock(Respuesta.class);
		
		investigador = new Investigador();
		
		//SUT
		preguntaCompleja= new PreguntaDeSimpleSeleccion("que series ves?");
	
		 
	}

	@Test
	void testDameTuPregunta() {
		assertEquals( "que series ves?", preguntaCompleja.getPregunta() );
	}
	
	@Test
	void testDameTuRespuestas() {
		preguntaCompleja.addRespuesta(got);
		preguntaCompleja.addRespuesta(twd);
		
		assertTrue(  preguntaCompleja.getOpciones().contains(got) && preguntaCompleja.getOpciones().contains(twd) );
	}
	
	
	@Test
	void testResponde() {
		preguntaCompleja.addRespuesta(got);
		preguntaCompleja.addRespuesta(twd);
		
		encuestado.setPreguntaActual(preguntaCompleja);
		assertEquals(encuestado.getPreguntaActual(),preguntaCompleja);
		
		preguntaCompleja.elegirRespuesta(got, encuestado);
		assertTrue(encuestado.getRespuestasElegidas().contains(got) );
	
		
		encuestado.responder();
		assertTrue(  encuestado.getRespuestasDelEncuestado().contains(got) ); 

	}

	@Test
	void testRespuestaElegidaDameTuSiguientePregunta() {
		preguntaCompleja.addRespuesta(got);
		preguntaCompleja.addRespuesta(twd);
		
		encuestado.setPreguntaActual(preguntaCompleja);
		preguntaCompleja.elegirRespuesta(got, encuestado);
		assertEquals(encuestado.getRespuestasElegidas().size() , new Integer (1) );
		
		encuestado.responder();
		assertTrue(  encuestado.getRespuestasDelEncuestado().contains(got) );
	
		
		assertEquals(  preguntaCerrada,encuestado.getPreguntaActual() );
	}

}






























