package preguntas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Encuestado;
import respuestas.Respuesta;


class TestPreguntaDeMultipleSeleccion {
	
	PreguntaDeMultipleSeleccion preguntaMultiple;
	Respuesta respuestaCerrada1;
	Respuesta respuestaCerrada2;
	Respuesta respuestaCerrada3;
	Respuesta respuestaCerrada4;
	Encuestado contenedor;
	

	@BeforeEach
	void setUp() throws Exception {
		
		contenedor = spy(new Encuestado(null, null,null));

		respuestaCerrada1 = mock(Respuesta.class);
		respuestaCerrada2 = mock(Respuesta.class);
		respuestaCerrada3 = mock(Respuesta.class);
		
		
		preguntaMultiple= new PreguntaDeMultipleSeleccion(null, contenedor, preguntaMultiple);
		
		preguntaMultiple.addRespuesta(respuestaCerrada1);
		preguntaMultiple.addRespuesta(respuestaCerrada2);
		preguntaMultiple.addRespuesta(respuestaCerrada3);
	
		when( respuestaCerrada1.getRespuesta()).thenReturn( "azul" );
		when( respuestaCerrada2.getRespuesta()).thenReturn( "verde" );
		when( respuestaCerrada3.getRespuesta()).thenReturn( "marron" );
		
		preguntaMultiple.elegirRespuesta(respuestaCerrada1);
		preguntaMultiple.elegirRespuesta(respuestaCerrada3);
		
		preguntaMultiple.responder( );
	}

	@Test
	void testPreguntaDeLaPregunta() {
		assertEquals( new String("�Que colores te gustan?") , preguntaMultiple.getPregunta() );  
	}
	
	
	@Test
	void testPreguntaDameTusOpciones() {
		assertEquals(  preguntaMultiple.getRespuestas().size() , 3 );
	}
	
	@Test
	void testResponderLaPregunta() {
		
		assertEquals( contenedor.getRespuestasDelEncuestado()  , contenedor.getRespuestasDelEncuestado() );
	}

}



