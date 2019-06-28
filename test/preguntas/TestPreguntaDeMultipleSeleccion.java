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
	

	@BeforeEach
	void setUp() throws Exception {
		
		encuestado = spy(new Encuestado("pepe", "pepon",null));

		respuestaCerrada1 = mock(Respuesta.class);
		respuestaCerrada2 = mock(Respuesta.class);
		respuestaCerrada3 = mock(Respuesta.class);
		
		
		preguntaMultiple= new PreguntaDeMultipleSeleccion("que colores te gustan?", preguntaMultiple);
		
		
		preguntaMultiple.elegirRespuesta(respuestaCerrada1, encuestado);
		preguntaMultiple.elegirRespuesta(respuestaCerrada3, encuestado);
		
		preguntaMultiple.responder(encuestado );
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
	
		when( respuestaCerrada1.getRespuesta()).thenReturn( "azul" );
		when( respuestaCerrada2.getRespuesta()).thenReturn( "verde" );
		when( respuestaCerrada3.getRespuesta()).thenReturn( "marron" );
		
		
		List<Respuesta>respuestas= new ArrayList<Respuesta>();
		respuestas.add(respuestaCerrada1);
		respuestas.add(respuestaCerrada2);
		respuestas.add(respuestaCerrada3);
		assertEquals(respuestas, preguntaMultiple.getOpciones());
	}
	
	

}



