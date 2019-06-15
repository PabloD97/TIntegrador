package preguntas;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Formulario;
import respuestas.RespuestaCerrada;

class TestPreguntaDeMultipleSeleccion {
	
	PreguntaDeMultipleSeleccion preguntaMultiple;
	RespuestaCerrada respuestaCerrada1;
	RespuestaCerrada respuestaCerrada2;
	RespuestaCerrada respuestaCerrada3;
	RespuestaCerrada respuestaCerrada4;
	Formulario contenedor;
	

	@BeforeEach
	void setUp() throws Exception {
		
		contenedor = spy(new Formulario(null, null,null));

		respuestaCerrada1 = mock(RespuestaCerrada.class);
		respuestaCerrada2 = mock(RespuestaCerrada.class);
		respuestaCerrada3 = mock(RespuestaCerrada.class);
		
		
		preguntaMultiple= new PreguntaDeMultipleSeleccion("�Que colores te gustan?", contenedor);
		
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



