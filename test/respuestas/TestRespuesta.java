package respuestas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import investigador.Investigador;
import preguntas.Pregunta;
import preguntas.PreguntaAbierta;
import preguntas.PreguntaDeMultipleSeleccion;

import static org.mockito.Mockito.*;

class TestRespuesta {
	
	Respuesta respuesta;
	PreguntaAbierta preguntaAbierta;
	Pregunta multipleSeleccion;
	Investigador investigador;
	
	@BeforeEach
	void setUp() throws Exception {
		multipleSeleccion= new PreguntaDeMultipleSeleccion("que colores te gustan");
		preguntaAbierta= mock(PreguntaAbierta.class);

		
		respuesta= new Respuesta("rojo", multipleSeleccion);
		investigador = new Investigador();
		
		//multipleSeleccion= mock(PreguntaDeMultipleSeleccion.class);
		
	}

	@Test
	void testSeteoDeLaRespuesta() {
		assertEquals(new String("rojo"), respuesta.getRespuesta());
	}

	@Test
	void testDecimeAQuePreguntaPerteneces() {
		respuesta.setPreguntaPertenencia(preguntaAbierta);
		assertEquals(preguntaAbierta, respuesta.getPreguntaALaQuePertenece());
	}
	
	@Test 
	void testNotificar() {
		Investigador investigador1= spy(new Investigador());
		investigador1.meInteresa(respuesta);
		respuesta.notificar();
		verify(investigador1).notificar();
	}
	
	@Test 
	void testDameTuSiguientePregunta() {
		assertEquals(multipleSeleccion, respuesta.getSiguientePregunta());
	}
}
