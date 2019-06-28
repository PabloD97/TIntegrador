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
	
	

	Encuestado encuestado;

	@BeforeEach
	void setUp() throws Exception {
	 
		got= mock( Respuesta.class );
		preguntaAbierta1= mock(PreguntaAbierta.class);
		
		
		
		twd= mock( Respuesta.class );
		preguntaCerrada= mock(PreguntaDeMultipleSeleccion.class);
		
		encuestado= spy( new Encuestado("Pablo", "Diaz",encuesta) );
		
		
		//SUT
		preguntaCompleja = new PreguntaDeSimpleSeleccion("que series ves?", preguntaAbierta1);
	
				
		when(got.getRespuesta()).thenReturn( "got");
		when(twd.getRespuesta()).thenReturn( "twd");
		
		
		preguntaCompleja.addRespuesta(got);
		preguntaCompleja.addRespuesta(twd);
	
		
	}

	@Test
	void testPreguntaDameTuPregunta() {
		assertEquals( "que series ves?", preguntaCompleja.getPregunta() );
	}
	
	@Test
	void testDameTuRespuestas() {
		ArrayList<String> listaAComparar= new ArrayList<String>();
		listaAComparar.add("got");
		listaAComparar.add("twd");
		
		assertEquals(  listaAComparar , preguntaCompleja.getRespuesta() );
	}
	
	
	
	@Test
	void testPreguntaResponde() { 
	
	}

	@Test
	void testRespuestaElegidaDameTuSiguientePregunta() {
	
		
	}

}






























