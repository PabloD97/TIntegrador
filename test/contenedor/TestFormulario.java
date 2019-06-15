package contenedor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;


class TestFormulario {

	Formulario formulario;
	Encuesta encuesta;

	
	@BeforeEach
	void setUp() throws Exception {
		
		formulario= new Formulario("Pepe", "Pepon",encuesta);
	
		formulario.addRespuesta("kaskote");
		formulario.addRespuesta("kakote");
		
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
