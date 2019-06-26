package encuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuestado.Encuestado;
import estadosDeLaEncuesta.Activa;
import estadosDeLaEncuesta.Editable;
import preguntas.Pregunta;
import preguntas.PreguntaAbierta;
import preguntas.PreguntaDeSimpleSeleccion;
import preguntas.PreguntaDeMultipleSeleccion;
import respuestas.Respuesta;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

class TestEncuesta {

	Encuesta encuesta1;
	Encuesta encuesta2;
	
	Editable editable;
	Activa activa;
	
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

		editable= new Editable();
		activa = new Activa();
		
		encuesta1= new Encuesta("encuesta2", 119, 6, 20);
		encuesta2= new Encuesta("encuesta3", 119, 6, 21);
		
		
		
		
	}
	
	@Test
	void testDameTuEstado() {
		encuesta1.setEstado(editable);
		assertEquals(editable , encuesta1.getEstado());
	}

	@Test
	void testAgregarPreguntas() {
		encuesta1.setEstado(editable);

		ArrayList<Pregunta>preguntas= new ArrayList<Pregunta>();
		
		preguntas.add(preguntaAbierta);
		preguntas.add(preguntaCompleja);
		preguntas.add(preguntaDeMultipleSeleccion);
		
		encuesta1.agregarPregunta(preguntaAbierta);
		encuesta1.agregarPregunta(preguntaCompleja);
		encuesta1.agregarPregunta(preguntaDeMultipleSeleccion);
		
		assertEquals(preguntas, encuesta1.getProtocoloDePreguntas());
	}
	
	@Test 
	void testQuitarPregunta() {
		encuesta1.setEstado(editable);
		
		encuesta1.agregarPregunta(preguntaAbierta);
		encuesta1.agregarPregunta(preguntaCompleja);

		encuesta1.eliminarPregunta(preguntaAbierta);
		encuesta1.eliminarPregunta(preguntaCompleja);
		assertTrue(encuesta1.getProtocoloDePreguntas().isEmpty());
	
	}
	
	@Test  
	void testEncuestaFinalizada() {
		encuesta1.setEstado(activa);
		encuesta1.encuestaFinalizada(encuestado1);
		encuesta1.encuestaFinalizada(encuestado2);
		assertEquals( new Integer(2), encuesta1.vecesFinalizado() );
		
	}
	
	
	@Test
	void testEliminarFormulario() {
		encuesta1.setEstado(activa);

		
		encuesta1.encuestaFinalizada(encuestado1);
		encuesta1.encuestaFinalizada(encuestado2);
		
		encuesta1.eliminarFormulario(encuestado1);
		encuesta1.eliminarFormulario(encuestado2);
		
		assertEquals( new Integer(0), encuesta1.vecesFinalizado() );
	}
	@Test 
	void testrespuestasDelFormulario() {
		
	}
	
	
	@Test 
	void testGetRespuestas() {
		
	}

}




















