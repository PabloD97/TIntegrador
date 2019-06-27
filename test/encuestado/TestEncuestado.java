package encuestado;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;
import static org.mockito.Mockito.*;

class TestEncuestado {

	Encuestado encuestado;
	Encuesta encuesta;

	
	@BeforeEach
	void setUp() throws Exception {
	
		
		encuestado= new Encuestado("Pepe", "Pepon",encuesta);
	
	//	encuestado.agregarRespuesta(null); // .addRespuesta("kaskote");
		//encuestado.agregarRespuesta(null); // aca hay que pasarle una Respuesta
		
	}

	@Test
	void testDameLosDatosDeTuEncuestado() {
		assertEquals( "Pepe Pepon" , encuestado.getDatosDelEncuestado() );
	}




	
}
