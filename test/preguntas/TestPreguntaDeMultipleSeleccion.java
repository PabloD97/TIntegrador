package preguntas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuestado.Encuestado;
import respuestas.Respuesta;


class TestPreguntaDeMultipleSeleccion {
	
	PreguntaDeMultipleSeleccion preguntaMultiple;
	Respuesta respuestaCerrada1;
	Respuesta respuestaCerrada2;
	Respuesta respuestaCerrada3;
	Respuesta respuestaCerrada4;
	Encuestado encuestado;
	MultiplesOpciones preguntaDeSimpleSeleccion;

	@BeforeEach
	void setUp() throws Exception {
		
		encuestado = spy(new Encuestado("pepe", "pepon",null));

		preguntaDeSimpleSeleccion= mock(PreguntaDeSimpleSeleccion.class);
		respuestaCerrada1 = mock(Respuesta.class);
		respuestaCerrada2 = mock(Respuesta.class);
		respuestaCerrada3 = mock(Respuesta.class);
		
		
		preguntaMultiple= new PreguntaDeMultipleSeleccion("que colores te gustan?", preguntaDeSimpleSeleccion);
		
		
		
	}

	@Test
	void testPreguntaDeLaPregunta() {
		assertEquals( new String("que colores te gustan?") , preguntaMultiple.getPregunta() );  
	}
	
	
	@Test
	void testPreguntaDameTusOpciones() {
		preguntaMultiple.addRespuesta(respuestaCerrada1);
		preguntaMultiple.addRespuesta(respuestaCerrada2);
		preguntaMultiple.addRespuesta(respuestaCerrada3);
		
		List<Respuesta>respuestas= new ArrayList<Respuesta>();
		respuestas.add(respuestaCerrada1);
		respuestas.add(respuestaCerrada2);
		respuestas.add(respuestaCerrada3);
		assertEquals(respuestas, preguntaMultiple.getOpciones());
	}
	
	@Test
	void testDameTuSiguientePregunta() {
		assertEquals(preguntaDeSimpleSeleccion, preguntaMultiple.getSiguientePregunta());
	}
	
	@Test
	void testAgregarOpciones() {
		preguntaMultiple.addRespuesta(respuestaCerrada1);
		preguntaMultiple.addRespuesta(respuestaCerrada2);
		preguntaMultiple.addRespuesta(respuestaCerrada3);
	
		assertEquals( preguntaMultiple.getOpciones().size() , 3 );
	}
	
	@Test
	void testEncuestadoRespondeLaPregunta() {
		encuestado.setPreguntaActual(preguntaMultiple);
		
		preguntaMultiple.addRespuesta(respuestaCerrada1);
		preguntaMultiple.addRespuesta(respuestaCerrada2);
		preguntaMultiple.addRespuesta(respuestaCerrada3);
		
		preguntaMultiple.elegirRespuesta(respuestaCerrada1, encuestado);
		preguntaMultiple.elegirRespuesta(respuestaCerrada2, encuestado);
		
		encuestado.responder();
		assertEquals(preguntaDeSimpleSeleccion, encuestado.getPreguntaActual());
		assertTrue( encuestado.getRespuestasDelEncuestado().contains(respuestaCerrada1) && encuestado.getRespuestasDelEncuestado().contains(respuestaCerrada2) );
	}

}






















