package preguntas;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuestado.Encuestado;
import respuestas.Respuesta;

class TestPreguntaAbierta {
	
	PreguntaAbierta preguntaAbierta1;
	PreguntaAbierta preguntaAbierta2;

	
	Respuesta respuestaAbierta;
	Encuestado contenedor;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//DUC
		respuestaAbierta= mock( Respuesta.class);
		preguntaAbierta2= mock(PreguntaAbierta.class);
		
		//SUT
		preguntaAbierta1 = new PreguntaAbierta("¿que color te gusta?", preguntaAbierta2);
		
	}
	@Test
	void testPreguntaAbierta() {
		assertEquals( new String("¿que color te gusta?") , preguntaAbierta1.getPregunta() );
	}

	
	

	
	
}



































