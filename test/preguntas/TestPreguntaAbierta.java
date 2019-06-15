package preguntas;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Encuestado;
import respuestas.Respuesta;

class TestPreguntaAbierta {
	
	PreguntaAbierta preguntaAbierta;
	
	Respuesta respuestaAbierta;
	Encuestado contenedor;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//DUC
		respuestaAbierta= mock( Respuesta.class);
		contenedor= mock( Encuestado.class);
		
		//SUT
		preguntaAbierta = new PreguntaAbierta(null, contenedor, preguntaAbierta);
		
	}
	@Test
	void testPreguntaAbierta() {
		
		assertEquals( "¿Te gusta ?" , preguntaAbierta.getPregunta() );
	}

	@Test
	void testEncuestadoResponde() {	
		preguntaAbierta.responder("capaz");
		when( respuestaAbierta.getRespuesta()).thenReturn("capaz");
		assertEquals( "capaz", respuestaAbierta.getRespuesta() );
	}
	

	@Test
	void test2doEncuestadoResponde() {
		preguntaAbierta.responder("no se");
		when( respuestaAbierta.getRespuesta()).thenReturn("no se");
		assertEquals( "no se", respuestaAbierta.getRespuesta() );
	}
	
	
	@Test
	void testSeGuardoLaRespuestaEnElContenedor() {	
		
		List<Respuesta> spyRespuestas= spy(new ArrayList<Respuesta>());	
		Encuestado contenedor= new Encuestado(null);
		
		preguntaAbierta.responder("no se");
		//when( respuestaAbierta.getRespuesta()).thenReturn("no se");


		preguntaAbierta.responder("capaz");
		//when( respuestaAbierta.getRespuesta()).thenReturn("capaz");

		contenedor.addRespuesta(null);// hay que agregar las respuestas a los parametros
		contenedor.addRespuesta(null); 

		
		assertEquals( new Integer(2), contenedor.getRespuestasDelEncuestado().size()  );	
		verify(spyRespuestas).size();

	}
	
	
}



































