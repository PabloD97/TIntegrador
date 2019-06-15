package investigador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import proyecto.Proyecto;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

class TestInvestigador {

	Investigador investigador;
	Proyecto cubaNegra;
	Proyecto cubaNegra1;

	
	@BeforeEach
	void setUp() throws Exception {
		
		cubaNegra= mock(Proyecto.class);
		cubaNegra1= mock(Proyecto.class);
		
		investigador= new Investigador( );
		
	}

	@Test
	void testAgregarUnProyecto() {
		ArrayList<Proyecto>proyectos= spy(new ArrayList<Proyecto>());
		Investigador investigador1 = new Investigador(proyectos);
		
		investigador1.sumarProyectoALaLista(cubaNegra);
		
		verify(proyectos).add(cubaNegra);
		
	}

	@Test
	void testInvestigadorDameTusProyectos() {
		ArrayList<Proyecto>proyectos= new ArrayList<Proyecto>();
		proyectos.add(cubaNegra);
		proyectos.add(cubaNegra1);
		
		investigador.sumarProyectoALaLista(cubaNegra);
		investigador.sumarProyectoALaLista(cubaNegra1);

		assertEquals( proyectos , investigador.getProyectos() );
	}
	
	@Test 
	void testRemoverUnProyecto() {
		investigador.sumarProyectoALaLista(cubaNegra);
		assertEquals( 1, investigador.getProyectos().size() );
		investigador.darDeBajaProyecto(cubaNegra);
		assertEquals( 0, investigador.getProyectos().size() );
	}
}
