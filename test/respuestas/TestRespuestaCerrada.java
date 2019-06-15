package respuestas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Formulario;
import preguntas.PreguntaAbierta;
import preguntas.PreguntaDeMultipleSeleccion;
import static org.mockito.Mockito.*;
  

class TestRespuestaCerrada {

	RespuestaCerrada respuestaCerrada;
	
	PreguntaDeMultipleSeleccion preguntaDeMultiplesSeleccion;
	PreguntaAbierta preguntaLibre;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		preguntaDeMultiplesSeleccion = mock( PreguntaDeMultipleSeleccion.class );
		preguntaLibre = mock( PreguntaAbierta.class );
		respuestaCerrada = new RespuestaCerrada("marron", preguntaDeMultiplesSeleccion, preguntaLibre);
		
		
	}

	@Test
	void testRespuestaDameTuRespuesta() {
		assertEquals( respuestaCerrada.getRespuesta() , new String("marron") );
	}
	
	
	@Test
	void testSiguientePregunta() {
		assertEquals( preguntaLibre  , respuestaCerrada.getSiguientePregunta() );
	}
	
	

	@Test
	void testAnteriorPregunta() {
		assertEquals(preguntaDeMultiplesSeleccion , respuestaCerrada.getAnteriorPregunta() );
	}
	
	

}
