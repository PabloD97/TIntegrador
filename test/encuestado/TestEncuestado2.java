package encuestado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import encuesta.Encuesta;
import estadosDeLaEncuesta.Activa;
import estadosDeLaEncuesta.Cerrada;
import estadosDeLaEncuesta.Editable;
import estadosDeLaEncuesta.Estado;
import investigador.Investigador;
import preguntas.MultiplesOpciones;
import preguntas.PreguntaDeMultipleSeleccion;
import preguntas.PreguntaDeSimpleSeleccion;
import respuestas.Respuesta;

class TestEncuestado2 {
	
	Investigador investigador;

	
	Estado activa;
	Estado cerrada;
	Estado editable;
	
	Encuestado encuestado;
	Encuesta encuesta;
	
	MultiplesOpciones primerPregunta;
	
	MultiplesOpciones preguntaSiElegisAzul;
	MultiplesOpciones preguntaSiElegisRojo;
	
	
	Respuesta azul;
	Respuesta rojo;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		primerPregunta= new PreguntaDeSimpleSeleccion("que color te gusta?");
		preguntaSiElegisAzul= new PreguntaDeMultipleSeleccion("te gusta el mar?");
		preguntaSiElegisRojo= new PreguntaDeMultipleSeleccion("que te produce ver ese color?");
		
		azul= new Respuesta("azul", preguntaSiElegisAzul);
		rojo= new Respuesta("rojo", preguntaSiElegisRojo);

		encuesta = new Encuesta("encuestaDeColores", 119, 7, 5);

		
		encuestado = new Encuestado("jose", "marmol", encuesta);
		
		editable= new Editable();
		activa= new Activa();
		cerrada= new Cerrada();
		
		investigador = new Investigador();

		
	}

	@Test
	void testDameTusDatos() {
		assertEquals( encuestado.getDatosDelEncuestado() , new String( "jose marmol" ) );
	}
	
	@Test
	void testComenzarEncuesta() {
		
		encuesta.setEstado(editable);
		
		encuesta.agregarPregunta(primerPregunta);
		encuesta.agregarPregunta(preguntaSiElegisAzul);
		encuesta.agregarPregunta(preguntaSiElegisRojo);
		
		encuesta.siguienteEstado();
		encuesta.comenzarEncuesta(encuestado);

		
		assertEquals( primerPregunta, encuestado.getPreguntaActual() );
	}
	
	@Test 
	void testResponderUnaPregunta() {
		encuesta.setEstado(editable);
		
		encuesta.agregarPregunta(primerPregunta);
		encuesta.agregarPregunta(preguntaSiElegisAzul);
		encuesta.agregarPregunta(preguntaSiElegisRojo);
		
		encuesta.siguienteEstado();
		encuesta.comenzarEncuesta(encuestado);

		
		assertEquals( primerPregunta, encuestado.getPreguntaActual() );
		
		primerPregunta.addRespuesta(azul);
		primerPregunta.addRespuesta(rojo);
		
		primerPregunta.elegirRespuesta(azul, encuestado);
		
		encuestado.responder();
		
		assertTrue( encuestado.getRespuestasDelEncuestado().contains(azul) );
		
		assertEquals( preguntaSiElegisAzul, encuestado.getPreguntaActual() );
		
	}
	
	
	
	
	

}
