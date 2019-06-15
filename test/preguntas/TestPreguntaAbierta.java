package preguntas;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Formulario;
import respuestas.RespuestaAbierta;

class TestPreguntaAbierta {
	
	PreguntaAbierta preguntaAbierta;
	
	RespuestaAbierta respuestaAbierta;
	Formulario contenedor;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//DUC
		respuestaAbierta= mock( RespuestaAbierta.class);
		contenedor= mock( Formulario.class);
		
		//SUT
		preguntaAbierta = new PreguntaAbierta("¿Te gusta ?", respuestaAbierta, contenedor);
		
		
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
		
		List<String> spyRespuestas= spy(new ArrayList<String>());	
		Formulario contenedor= new Formulario((ArrayList<String>) spyRespuestas);
		
		preguntaAbierta.responder("no se");
		//when( respuestaAbierta.getRespuesta()).thenReturn("no se");


		preguntaAbierta.responder("capaz");
		//when( respuestaAbierta.getRespuesta()).thenReturn("capaz");

		contenedor.addRespuesta("no se");
		contenedor.addRespuesta("capaz");

		
		assertEquals( new Integer(2), contenedor.getRespuestasDelEncuestado().size()  );	
		verify(spyRespuestas).size();

	}
	
	
}



































