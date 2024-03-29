package respuestas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import investigador.Investigador;
import preguntas.Pregunta;
import preguntas.PreguntaAbierta;
import preguntas.PreguntaDeMultipleSeleccion;
import preguntas.PreguntaDeSimpleSeleccion;

import static org.mockito.Mockito.*;

class TestRespuesta {
	
	Respuesta respuesta;
	PreguntaAbierta preguntaAbierta;
	Pregunta multipleSeleccion;
	Investigador investigador;

	PreguntaDeSimpleSeleccion seleccionSimple;
	
	@BeforeEach
	void setUp() throws Exception {
		multipleSeleccion= new PreguntaDeMultipleSeleccion("que colores te gustan",null);
		preguntaAbierta= mock(PreguntaAbierta.class);
		seleccionSimple=new PreguntaDeSimpleSeleccion("¿Como te llamas?");
		
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
	void testNotificarALosInteresados() {
		Investigador investigador1= spy(new Investigador());
		investigador1.meInteresa(respuesta);
		respuesta.notificar();
		verify(investigador1).notificar();
		
	}
	
	@Test 
	void testDameTuSiguientePregunta() {
		assertEquals(multipleSeleccion, respuesta.getSiguientePregunta());
	}
	
	@Test
	void testAInvestigadorNoLeInteresaLaPregunta() {
		Investigador investigador1= spy(new Investigador());
		
		respuesta.notificar();
		
		verifyZeroInteractions(investigador1);
	}
	

	@Test
	void testSacarInteresado() {
		respuesta.agregarInteresado(investigador);
		respuesta.sacarInteresado(investigador);
		assertFalse( respuesta.getInteresados().contains(investigador) );
	}
}















