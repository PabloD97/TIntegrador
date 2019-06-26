package preguntas;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

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
	
	

	Encuestado contenedor;

	@BeforeEach
	void setUp() throws Exception {
	
		got= mock( Respuesta.class );
		preguntaAbierta1= mock(PreguntaAbierta.class);
		
		
		
		twd= mock( Respuesta.class );
		preguntaCerrada= mock(PreguntaDeMultipleSeleccion.class);
		
		contenedor= spy( new Encuestado("Pablo", "Diaz",encuesta) );
		
		
		//SUT
		preguntaCompleja = new PreguntaDeSimpleSeleccion(null, preguntaAbierta1);
	
				
		when(got.getRespuesta()).thenReturn( "got");
		when(twd.getRespuesta()).thenReturn( "twd");
		
		
		preguntaCompleja.addRespuesta(got);
		preguntaCompleja.addRespuesta(twd);
	
		
	}

	@Test
	void testPreguntaDameTuPregunta() {
		assertEquals( "�Cual serie ves?", preguntaCompleja.getPregunta() );
	}
	
	@Test
	void testDameTuRespuestas() {
		ArrayList<String> listaAComparar= new ArrayList<String>();
		listaAComparar.add("got");
		listaAComparar.add("twd");
		
		assertEquals(  listaAComparar , preguntaCompleja.getRespuesta() );
	}
	
	@Test
	void testSetEncuestadoDeLaPregunta() {
		preguntaCompleja.setEncuestado(contenedor);
	}
	
	@Test
	void testPreguntaResponde() {
		preguntaCompleja.responder(got);
		ArrayList<String>respuestaElegida= new	ArrayList<String>();
		respuestaElegida.add("got");
		
		assertEquals( respuestaElegida , contenedor.getRespuestasDelEncuestado());
	}

	@Test
	void testRespuestaElegidaDameTuSiguientePregunta() {
		preguntaCompleja.responder(got);
		assertEquals( preguntaAbierta1 , preguntaCompleja.getSiguientePregunta() );
		
	}

}






























