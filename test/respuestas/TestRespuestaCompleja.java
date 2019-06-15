package respuestas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import preguntas.PreguntaAbierta;
import preguntas.PreguntaDeMultipleSeleccion;
import static org.mockito.Mockito.*;

class TestRespuestaCompleja {
	
	RespuestaCompleja respuestaCompleja;
	PreguntaAbierta preguntaAbierta;
	PreguntaDeMultipleSeleccion preguntaDeMultiplesSeleccion;
	
	@BeforeEach
	void setUp() throws Exception {
		
		preguntaAbierta = mock(PreguntaAbierta.class);
		preguntaDeMultiplesSeleccion= mock (PreguntaDeMultipleSeleccion.class);
		
		respuestaCompleja = new RespuestaCompleja( "Marron", preguntaAbierta , preguntaDeMultiplesSeleccion); 	
	}

	@Test
	void testRespuestaDeRespuestaCompleja() {
		assertEquals( "Marron" , respuestaCompleja.getRespuesta() );
	}
	@Test
	void testDameTuSiguientePregunta() {
		assertEquals( preguntaAbierta  , respuestaCompleja.getSiguientePregunta()  );
	}
	
	@Test
	void testDameAnteriorPregunta() {
		assertEquals( preguntaDeMultiplesSeleccion , respuestaCompleja.getAnteriorPregunta());
	}
	
}
