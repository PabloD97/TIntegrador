package encuesta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contenedor.Formulario;
import preguntas.PreguntaAbierta;
import preguntas.PreguntaCompleja;
import preguntas.PreguntaDeMultipleSeleccion;
import respuestas.RespuestaCerrada;

import static org.mockito.Mockito.*;

class TestEncuesta {

	Encuesta encuesta1;
	Encuesta encuesta2;
	
	
	
	Formulario formulario;
	Formulario formulario2;
	Formulario formulario3;

	
	PreguntaAbierta preguntaAbiert1;
	PreguntaCompleja preguntaCompleja;
	PreguntaDeMultipleSeleccion preguntaDeMultipleSeleccion;
	PreguntaAbierta preguntaLibre;
	RespuestaCerrada respuestaCerrada = new RespuestaCerrada("marron", preguntaDeMultipleSeleccion, preguntaLibre);
	RespuestaCerrada respuestaCerrada2 = new RespuestaCerrada("azul", preguntaDeMultipleSeleccion, preguntaLibre);
	RespuestaCerrada respuestaCerrada3 = new RespuestaCerrada("amarillo", preguntaDeMultipleSeleccion, preguntaLibre);
	RespuestaCerrada respuestaCerrada4 = new RespuestaCerrada("Ninguno", preguntaDeMultipleSeleccion, preguntaLibre);


	

	
	@BeforeEach
	void setUp() throws Exception {
		
		formulario= mock(Formulario.class);
		formulario2= mock(Formulario.class);
		formulario3= mock(Formulario.class);
		
		preguntaAbiert1= mock(PreguntaAbierta.class);
		preguntaCompleja= mock(PreguntaCompleja.class);
		preguntaDeMultipleSeleccion= mock(PreguntaDeMultipleSeleccion.class);


		
		encuesta1= new Encuesta();
		encuesta2= new Encuesta();
		
		
		
		
	}

	@Test
	void testAgregarPreguntas() {
		encuesta1.addPregunta(preguntaAbiert1);
		encuesta1.addPregunta(preguntaCompleja);
		encuesta1.addPregunta(preguntaDeMultipleSeleccion);
		
		assertEquals(new Integer(3) ,encuesta1.getProtocoloDePreguntas().size()  );
		
	}
	
	@Test 
	void testQuitarPregunta() {
		encuesta1.addPregunta(preguntaAbiert1);
		encuesta1.eliminarPregunta(preguntaAbiert1);
		assertEquals( new Integer(0) , encuesta1.getProtocoloDePreguntas().size() );
	}
	
	@Test 
	void testEncuestaFinalizada() {
		encuesta1.encuestaFinalizada(formulario);
		encuesta1.encuestaFinalizada(formulario2);
		encuesta1.encuestaFinalizada(formulario3);
		
		assertEquals( new Integer(3),encuesta1.vecesFinalizado() );
	}
	
	@Test
	void testEliminarFormulario() {
		encuesta1.encuestaFinalizada(formulario);
		encuesta1.eliminarFormulario(formulario);
		assertEquals(false,encuesta1.getFormularios().contains(formulario));
	}
	@Test 
	void testrespuestasDelFormulario()
	 {
		formulario.addRespuesta(respuestaCerrada.getRespuesta());
		encuesta1.encuestaFinalizada(formulario);
		assertEquals(1,encuesta1.getTodasLasRespuestas().size());
	}
	@Test 
	void testGetRespuestas() {
		PreguntaDeMultipleSeleccion colorFavorito=new PreguntaDeMultipleSeleccion("¿Cual de estos Colores te gusta mas?", formulario);
		colorFavorito.addRespuesta(respuestaCerrada);
		colorFavorito.addRespuesta(respuestaCerrada2);
		colorFavorito.addRespuesta(respuestaCerrada3);
		colorFavorito.addRespuesta(respuestaCerrada4);
		encuesta2.addPregunta(colorFavorito);
		colorFavorito.elegirRespuesta(respuestaCerrada);
		colorFavorito.elegirRespuesta(respuestaCerrada2);
		colorFavorito.responder();
		assertEquals(true,encuesta2.getTodasLasRespuestas().contains("marron") && encuesta2.getTodasLasRespuestas().contains("azul") && encuesta2.getTodasLasRespuestas().size()==2);
		
	}

}




















