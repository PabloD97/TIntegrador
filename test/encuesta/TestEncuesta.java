package encuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuestado.Encuestado;
import estadosDeLaEncuesta.Editable;
import preguntas.PreguntaAbierta;
import preguntas.PreguntaDeSimpleSeleccion;
import preguntas.PreguntaDeMultipleSeleccion;
import respuestas.Respuesta;

import static org.mockito.Mockito.*;

class TestEncuesta {

	Encuesta encuesta1;
	Encuesta encuesta2;
	
	Editable editable;
	
	Encuestado encuestado1;
	Encuestado encuestado2;
	Encuestado encuestado3;

	
	
	
	
	PreguntaDeSimpleSeleccion preguntaCompleja;
	
	PreguntaDeMultipleSeleccion preguntaDeMultipleSeleccion;
	
	PreguntaAbierta preguntaAbierta;
	
	Respuesta respuestaCerrada = new Respuesta("marron");
	Respuesta respuestaCerrada2 = new Respuesta("azul");
	Respuesta respuestaCerrada3 = new Respuesta("amarillo");
	Respuesta respuestaCerrada4 = new Respuesta("Ninguno");


	

	
	@BeforeEach
	void setUp() throws Exception {
		
		encuestado1= mock(Encuestado.class);
		encuestado2= mock(Encuestado.class);
		encuestado3= mock(Encuestado.class);
		
		preguntaAbierta= mock(PreguntaAbierta.class);
		preguntaCompleja= mock(PreguntaDeSimpleSeleccion.class);
		preguntaDeMultipleSeleccion= mock(PreguntaDeMultipleSeleccion.class);

		editable= mock(Editable.class);
		
		encuesta1= new Encuesta("encuesta2", 119, 6, 20);
		encuesta2= new Encuesta("encuesta3", 119, 6, 21);
		
		
		
		
	}
	
	@Test
	void testDameTuEstado() {
		when(editable.getEstado()).thenReturn(editable);
		encuesta1.setEstado(editable);
		assertEquals(editable, encuesta1.getEstado());
	}

	@Test
	void testAgregarPreguntas() {
	
		
	}
	
	@Test 
	void testQuitarPregunta() {
	
	}
	
	@Test 
	void testEncuestaFinalizada() {
		
	}
	
	@Test
	void testEliminarFormulario() {
	
	}
	@Test 
	void testrespuestasDelFormulario() {
		
	}
	
	
	@Test 
	void testGetRespuestas() {
		
	}

}




















