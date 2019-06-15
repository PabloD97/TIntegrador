package contenedor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;


class TestFormulario {

	Encuestado formulario;
	Encuesta encuesta;

	
	@BeforeEach
	void setUp() throws Exception {
		
		formulario= new Encuestado("Pepe", "Pepon",encuesta);
	
		formulario.addRespuesta(null); // .addRespuesta("kaskote");
		formulario.addRespuesta(null); // aca hay que pasarle una Respuesta
		
	}

	@Test
	void testDameLosDatosDeTuEncuestado() {
		assertEquals( "Pepe Pepon" , formulario.getDatosDelEncuestado() );
	}

	@Test
	void testDameLasRespuestasDeTuEncuestado() {
		ArrayList<String>respuestas= new ArrayList<String>();
		respuestas.add("kaskote");
		respuestas.add("kakote");
		assertEquals( respuestas  , formulario.getRespuestasDelEncuestado());
	}

	
}
