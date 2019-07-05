package encuestado;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;
import estadosDeLaEncuesta.Activa;
import estadosDeLaEncuesta.Cerrada;
import estadosDeLaEncuesta.Editable;
import investigador.Investigador;
import preguntas.Pregunta;
import preguntas.PreguntaAbierta;
import preguntas.PreguntaDeMultipleSeleccion;
import preguntas.PreguntaDeSimpleSeleccion;
import respuestas.Respuesta;

//import static org.mockito.Mockito.*;

class TestEncuestado {

	Investigador interesado;
	
	Encuestado encuestado;
	Encuesta encuesta;
	
	Editable editable;
	Activa activa;
	Cerrada cerrada;
	
	Pregunta pregunta;
	
	PreguntaAbierta preguntaAbierta;
	PreguntaDeMultipleSeleccion preguntaDeMultipleSeleccion;
	PreguntaDeSimpleSeleccion preguntaDeSimpleSeleccion;
	PreguntaDeMultipleSeleccion preguntaDeMultipleSeleccion1;
	PreguntaDeMultipleSeleccion preguntaDeMultipleSeleccion2;

	Respuesta colorAzul;
	Respuesta colorRojo;
	Respuesta colorVerde;
	
	Respuesta quinceMil;
	Respuesta diezMil;
	
	Respuesta si;
	Respuesta no;
	
	Respuesta casaPropia;
	Respuesta alquilo;
	
	
	@BeforeEach
	void setUp() throws Exception {
	
		interesado= new Investigador();
		editable= new Editable();
		activa= new Activa();
		cerrada= new Cerrada();
		
		
		encuestado= new Encuestado("Pepe", "Pepon",encuesta);
	
		encuesta= new Encuesta("encuestaA", 119, 6, 27);
		
		preguntaAbierta= new PreguntaAbierta("cual es tu nombre?");
		
		preguntaDeMultipleSeleccion= new PreguntaDeMultipleSeleccion("que colores te gustan?");
		
		preguntaDeSimpleSeleccion= new PreguntaDeSimpleSeleccion("posee casa propia o alquila?");
		
		
		preguntaDeMultipleSeleccion1= new PreguntaDeMultipleSeleccion("cuanto paga de alquiler?");
		
		preguntaDeMultipleSeleccion2= new PreguntaDeMultipleSeleccion("vive solo?");
	
		
		preguntaDeMultipleSeleccion1.siSoyUltima();
		preguntaDeMultipleSeleccion2.siSoyUltima();
		
		colorAzul = new Respuesta("azul");
		colorRojo = new Respuesta("rojo");
		colorVerde = new Respuesta("verde");
		
		casaPropia=new Respuesta("casaPropia");
		alquilo=new Respuesta("alquilo");
	
		quinceMil= new Respuesta("quinceMil");
		diezMil= new Respuesta("diezMil");
		
		si=new Respuesta("si");
		no=new Respuesta("no");
		
	}

	@Test
	void testDameLosDatosDeTuEncuestado() {
		assertEquals( "Pepe Pepon" , encuestado.getDatosDelEncuestado() );
	}

	@Test
	void testComenzarEncuesta() {
		encuesta.setEstado(editable);
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion);
		encuesta.agregarPregunta(preguntaDeSimpleSeleccion);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion1);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion2);
		encuesta.setEstado(activa);
		encuesta.comenzarEncuesta(encuestado);
		
		assertEquals( preguntaAbierta , encuestado.getPreguntaActual() );
	}

	@Test
	void testContestarPregunta() {
		encuesta.setEstado(editable);
		
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion);
		encuesta.agregarPregunta(preguntaDeSimpleSeleccion);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion1);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion2);
		
		encuesta.setEstado(activa);
		
		encuesta.comenzarEncuesta(encuestado);
		
		preguntaAbierta.escribirRespuesta("pablo", encuestado);
		
		assertEquals(1, encuestado.getRespuestasElegidas().size() );
		
		assertEquals( preguntaAbierta , encuestado.getPreguntaActual() );
		
		encuestado.responder();
		assertEquals( 1, encuestado.getRespuestasDelEncuestado().size() );
		//assertEquals( 1, encuestado.getPreguntaActual()); 
		
	}
	@Test
	void testContestarPregunta2() {
		encuesta.setEstado(editable);
		
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion);
		encuesta.agregarPregunta(preguntaDeSimpleSeleccion);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion1);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion2);
		
		encuesta.setEstado(activa);
		
		encuesta.comenzarEncuesta(encuestado);
		
		preguntaAbierta.escribirRespuesta("pablo", encuestado);
		
		assertEquals(1, encuestado.getRespuestasElegidas().size() );
		
		assertEquals( preguntaAbierta , encuestado.getPreguntaActual() );
		
		
		
		encuestado.responder();
		assertEquals( 1, encuestado.getRespuestasDelEncuestado().size() );
		
		preguntaDeMultipleSeleccion.addRespuesta(colorAzul);
		preguntaDeMultipleSeleccion.addRespuesta(colorRojo);
		preguntaDeMultipleSeleccion.addRespuesta(colorVerde);
		
		//assertEquals(  preguntaDeMultipleSeleccion , preguntaAbierta.getSiguientePregunta() );// recibe null

		encuestado.setPreguntaActual(preguntaDeMultipleSeleccion);
		
		preguntaDeMultipleSeleccion.elegirRespuesta(colorAzul, encuestado);
		preguntaDeMultipleSeleccion.elegirRespuesta(colorVerde, encuestado);
		
		assertEquals(2, encuestado.getRespuestasElegidas().size() );
		
		encuestado.responder();
		assertEquals( 3, encuestado.getRespuestasDelEncuestado().size() );

	}
	
	@Test
	void testContestarPregunta3() {
	encuesta.setEstado(editable);
		
		encuesta.agregarPregunta(preguntaAbierta);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion);
		encuesta.agregarPregunta(preguntaDeSimpleSeleccion);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion1);
		encuesta.agregarPregunta(preguntaDeMultipleSeleccion2);
		
		encuesta.setEstado(activa);
		
		encuesta.comenzarEncuesta(encuestado);
		
		preguntaAbierta.escribirRespuesta("pablo", encuestado);
		
		assertEquals(1, encuestado.getRespuestasElegidas().size() );
		
		assertEquals( preguntaAbierta , encuestado.getPreguntaActual() );
		
		encuestado.responder();
		assertEquals( 1, encuestado.getRespuestasDelEncuestado().size() );
		
		preguntaDeMultipleSeleccion.addRespuesta(colorAzul);
		preguntaDeMultipleSeleccion.addRespuesta(colorRojo);
		preguntaDeMultipleSeleccion.addRespuesta(colorVerde);
		
		//assertEquals(  preguntaDeMultipleSeleccion , preguntaAbierta.getSiguientePregunta() );// recibe null

		encuestado.setPreguntaActual(preguntaDeMultipleSeleccion);
		
		preguntaDeMultipleSeleccion.elegirRespuesta(colorAzul, encuestado);
		preguntaDeMultipleSeleccion.elegirRespuesta(colorVerde, encuestado);
		
		assertEquals(2, encuestado.getRespuestasElegidas().size() );
		
		encuestado.responder();
		assertEquals( 3, encuestado.getRespuestasDelEncuestado().size() );

		preguntaDeSimpleSeleccion.addRespuesta(alquilo);
		preguntaDeSimpleSeleccion.addRespuesta(casaPropia);

		encuestado.setPreguntaActual(preguntaDeSimpleSeleccion);
		
		preguntaDeSimpleSeleccion.elegirRespuesta(casaPropia, encuestado);
		
		assertEquals(encuestado.getRespuestasElegidas().size() , new Integer (1) );
		//encuestado.responder();
		//assertEquals(4 , encuestado.getRespuestasDelEncuestado().size() );

		//assertEquals( 4, encuestado.getRespuestasDelEncuestado().size() );
		
		
		/*
		 * 
		 * AHORA TIRA NULL AL QUERER AGREGAR UNA RESPUESTA
		 * 
		 */
		
	}
	
}


















