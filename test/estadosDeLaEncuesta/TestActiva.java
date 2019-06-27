package estadosDeLaEncuesta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;
import preguntas.PreguntaAbierta;

class TestActiva {

	Activa activa;
	Encuesta encuesta;
	PreguntaAbierta preguntaAbierta;
	Encuestado encuestado;
	Editable editable;
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		preguntaAbierta= mock(PreguntaAbierta.class);
		encuesta= new Encuesta("a", 0, 0, 0);
		activa= new Activa();
		editable= new Editable();
		encuestado= new Encuestado("pepe", "diaz", encuesta);
	}

	@Test
	void testNoPuedoAgregarPreguntas() {
		encuesta.setEstado(activa);
		encuesta.agregarPregunta(preguntaAbierta);
		assertTrue( encuesta.getProtocoloDePreguntas().isEmpty() );
	}
	@Test
	void testNoPuedoEliminarPregunta() {
		encuesta.setEstado(editable);
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.siguienteEstado();
		encuesta.eliminarPregunta(preguntaAbierta);
		assertFalse( encuesta.getProtocoloDePreguntas().isEmpty() );
	}
	
	@Test
	void testComenzarEncuesta() {
		encuesta.setEstado(editable);
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.siguienteEstado();
		encuesta.comenzarEncuesta(encuestado);
		assertEquals( preguntaAbierta, encuestado.getPreguntaActual() );
	}

	@Test
	void testEncuestaDisponible() {
		encuesta.setEstado(activa);
		assertTrue( encuesta.encuestaDisponible() );
	}
	
}
