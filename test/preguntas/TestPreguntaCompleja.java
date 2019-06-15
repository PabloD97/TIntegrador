package preguntas;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import contenedor.Formulario;
import encuesta.Encuesta;
import respuestas.RespuestaCompleja;

class TestPreguntaCompleja {
	
	PreguntaCompleja preguntaCompleja;
	PreguntaAbierta preguntaAbierta1;
	PreguntaDeMultipleSeleccion preguntaCerrada;
	Encuesta encuesta;
	
	
	RespuestaCompleja got;
	
	
	RespuestaCompleja twd;
	
	

	Formulario contenedor;

	@BeforeEach
	void setUp() throws Exception {
	
		got= mock( RespuestaCompleja.class );
		preguntaAbierta1= mock(PreguntaAbierta.class);
		
		
		
		twd= mock( RespuestaCompleja.class );
		preguntaCerrada= mock(PreguntaDeMultipleSeleccion.class);
		
		contenedor= spy( new Formulario("Pablo", "Diaz",encuesta) );
		
		
		//SUT
		preguntaCompleja = new PreguntaCompleja("�Cual serie ves?", contenedor);
	
		when(got.getSiguientePregunta()).thenReturn( preguntaAbierta1 );
		when(twd.getSiguientePregunta()).thenReturn( preguntaCerrada);
		
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
		
		assertEquals(  listaAComparar , preguntaCompleja.getRespuestas() );
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






























