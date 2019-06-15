package respuestas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

///import Contenedor.Formulario;
import preguntas.PreguntaAbierta;
import static org.mockito.Mockito.*;

class TestRespuestaAbierta {

	RespuestaAbierta respuestaAbierta;
	PreguntaAbierta preguntaAbierta;
	PreguntaAbierta preguntaAbierta2;
	//Formulario contenedor;
	
	@BeforeEach
	void setUp() throws Exception {

		preguntaAbierta = mock(PreguntaAbierta.class);
		preguntaAbierta2 = mock(PreguntaAbierta.class);
		respuestaAbierta = new RespuestaAbierta( preguntaAbierta, preguntaAbierta2 );
	
		
	}

	@Test
	void testSetRespuesta() {
		respuestaAbierta.setRespuesta("Me gusto mucho xque bla bla");
		assertEquals( new String("Me gusto mucho xque bla bla") , respuestaAbierta.getRespuesta() );
	}

	@Test
	void testSiguientePregunta() {		
		assertEquals(preguntaAbierta2  , respuestaAbierta.getSiguientePregunta() );
	}
	
	
}
