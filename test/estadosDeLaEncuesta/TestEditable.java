package estadosDeLaEncuesta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;
import preguntas.PreguntaAbierta;

class TestEditable {

	Encuesta encuesta;
	PreguntaAbierta preguntaAbierta;
	Encuestado encuestado;
	Estado editable;
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		preguntaAbierta= mock(PreguntaAbierta.class);
		encuesta= new Encuesta("a", 0, 0, 0);
		editable= new Editable();
		encuestado= new Encuestado("pepe", "diaz", encuesta);
	}

	@Test
	void testPuedoAgregarPreguntas() {
		encuesta.setEstado(editable);
		encuesta.agregarPregunta(preguntaAbierta);
		assertFalse( encuesta.getProtocoloDePreguntas().isEmpty() );
	}
	@Test
	void testPuedoEliminarPregunta() {
		encuesta.setEstado(editable);
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.eliminarPregunta(preguntaAbierta);
		assertTrue( encuesta.getProtocoloDePreguntas().isEmpty() );
	}
	
	@Test
	void testNoPuedeComenzarLaEncuesta() {
		encuesta.setEstado(editable);
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.comenzarEncuesta(encuestado);
		assertNull( encuestado.getPreguntaActual() );
	}

	@Test
	void testEncuestaNoDisponible() {
		encuesta.setEstado(editable);
		assertFalse( encuesta.encuestaDisponible() );
	}
}










