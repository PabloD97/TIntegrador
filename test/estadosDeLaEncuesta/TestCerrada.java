package estadosDeLaEncuesta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;
import preguntas.PreguntaAbierta;

class TestCerrada {
	Estado cerrada;
	Encuesta encuesta;
	PreguntaAbierta preguntaAbierta;
	Encuestado encuestado;
	Editable editable;
	
	@BeforeEach
	void setUp() throws Exception {
		cerrada= new Cerrada();
		
		preguntaAbierta= mock(PreguntaAbierta.class);
		encuesta= new Encuesta("a", 0, 0, 0);
		encuestado= new Encuestado("pepe", "diaz", encuesta);
	}

	@Test
	void testNoPuedoAgregarPreguntas() {
		encuesta.setEstado(cerrada);
		encuesta.agregarPregunta(preguntaAbierta);
		assertTrue( encuesta.getProtocoloDePreguntas().isEmpty() );
	}
	@Test
	void testNoPuedoEliminarPregunta() {
		encuesta.setEstado(cerrada);
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.siguienteEstado();
		encuesta.eliminarPregunta(preguntaAbierta);
		assertTrue( encuesta.getProtocoloDePreguntas().isEmpty() );
	}
	
	@Test
	void testNoPuedeComenzarLaEncuesta() {
		encuesta.setEstado(cerrada);
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.siguienteEstado();
		encuesta.comenzarEncuesta(encuestado);
		assertNull( encuestado.getPreguntaActual());
	}

	@Test
	void testEncuestaDisponible() {
		encuesta.setEstado(cerrada);
		assertFalse( encuesta.encuestaDisponible() );
	}
}












