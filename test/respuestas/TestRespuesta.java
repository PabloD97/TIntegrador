package respuestas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import preguntas.PreguntaAbierta;
import static org.mockito.Mockito.*;

class TestRespuesta {
	
	Respuesta respuesta;
	PreguntaAbierta preguntaAbierta;
	
	@BeforeEach
	void setUp() throws Exception {
		
		respuesta= new Respuesta("azul");
		
		preguntaAbierta= mock(PreguntaAbierta.class);
		
	}

	@Test
	void testSeteoDeLaRespuesta() {
		respuesta.setRespuesta("rojo");
		assertEquals(new String("rojo"), respuesta.getRespuesta());
	}

	@Test
	void testDecimeAQuePreguntaPerteneces() {
		respuesta.setPregunta(preguntaAbierta);
		assertEquals(preguntaAbierta, respuesta.getPreguntaALaQuePertenece());
	}
}
