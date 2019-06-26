package encuestasDisponibles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import investigador.Investigador;
import proyecto.Proyecto;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


class TestLas25EncuestasMasCompletadas {
	
	
	Investigador investigador;
	Proyecto proyecto1;
	Proyecto proyecto2;
	Encuesta encuesta1;
	Encuesta encuesta2;
	Encuesta encuesta3;
	Encuesta encuesta4;
	Encuesta encuesta5;
	Encuesta encuesta6;
	Encuesta encuesta7;
	Encuesta encuesta8;
	Encuesta encuesta9;
	Encuesta encuesta10;
	Encuesta encuesta11;
	Encuesta encuesta12;
	Encuesta encuesta13;
	Encuesta encuesta14;
	Encuesta encuesta15;
	Encuesta encuesta16;
	Encuesta encuesta17;
	Encuesta encuesta18;
	Encuesta encuesta19;
	Encuesta encuesta20;
	Encuesta encuesta21;
	Encuesta encuesta22;
	Encuesta encuesta23;
	Encuesta encuesta24;
	Encuesta encuesta25;
	Encuesta encuesta26;
	Encuesta encuesta27;

	@BeforeEach
	void setUp() throws Exception {
		
		proyecto1 = new Proyecto("d", "d");
		proyecto2 = new Proyecto("d", "d");
		
		encuesta1= mock(Encuesta.class);
		encuesta2= mock(Encuesta.class);
		encuesta3= mock(Encuesta.class);
		encuesta4= mock(Encuesta.class);
		encuesta5= mock(Encuesta.class);
		encuesta6= mock(Encuesta.class);
		encuesta7= mock(Encuesta.class);
		encuesta8= mock(Encuesta.class);
		encuesta9= mock(Encuesta.class);
		encuesta10= mock(Encuesta.class);
		encuesta11= mock(Encuesta.class);
		encuesta12= mock(Encuesta.class);
		encuesta13= mock(Encuesta.class);
		encuesta14= mock(Encuesta.class);
		encuesta15= mock(Encuesta.class);
		encuesta16= mock(Encuesta.class);
		encuesta17= mock(Encuesta.class);
		encuesta18= mock(Encuesta.class);
		encuesta19= mock(Encuesta.class);
		encuesta20= mock(Encuesta.class);
		encuesta21= mock(Encuesta.class);
		encuesta22= mock(Encuesta.class);
		encuesta23= mock(Encuesta.class);
		encuesta24= mock(Encuesta.class);
		encuesta25= mock(Encuesta.class);
		encuesta26= mock(Encuesta.class);
		
		
		investigador = new Investigador();
		
		
	}

	@Test
	void testLasMasContestadas() {
		
		when(encuesta1.vecesFinalizado()).thenReturn(1);	
		when(encuesta2.vecesFinalizado()).thenReturn(2);
		when(encuesta3.vecesFinalizado()).thenReturn(3);
		when(encuesta4.vecesFinalizado()).thenReturn(4);
		when(encuesta5.vecesFinalizado()).thenReturn(5);
		when(encuesta6.vecesFinalizado()).thenReturn(6);
		when(encuesta7.vecesFinalizado()).thenReturn(7);
		when(encuesta8.vecesFinalizado()).thenReturn(8);
		when(encuesta9.vecesFinalizado()).thenReturn(9);
		when(encuesta10.vecesFinalizado()).thenReturn(10);
		when(encuesta11.vecesFinalizado()).thenReturn(11);
		when(encuesta12.vecesFinalizado()).thenReturn(12);
		when(encuesta13.vecesFinalizado()).thenReturn(13);
		when(encuesta14.vecesFinalizado()).thenReturn(14);
		when(encuesta15.vecesFinalizado()).thenReturn(15);
		when(encuesta16.vecesFinalizado()).thenReturn(16);
		when(encuesta17.vecesFinalizado()).thenReturn(17);
		when(encuesta18.vecesFinalizado()).thenReturn(18);
		when(encuesta19.vecesFinalizado()).thenReturn(19);
		when(encuesta20.vecesFinalizado()).thenReturn(20);
		when(encuesta21.vecesFinalizado()).thenReturn(21);
		when(encuesta22.vecesFinalizado()).thenReturn(22);
		when(encuesta23.vecesFinalizado()).thenReturn(23);
		when(encuesta24.vecesFinalizado()).thenReturn(24);
		when(encuesta25.vecesFinalizado()).thenReturn(25);
		when(encuesta26.vecesFinalizado()).thenReturn(58);
		
		proyecto1.agregarUnaEncuesta(encuesta1);
		proyecto1.agregarUnaEncuesta(encuesta2);
		proyecto1.agregarUnaEncuesta(encuesta3);
		proyecto1.agregarUnaEncuesta(encuesta4);
		proyecto1.agregarUnaEncuesta(encuesta5);
		proyecto1.agregarUnaEncuesta(encuesta6);
		proyecto1.agregarUnaEncuesta(encuesta7);
		proyecto1.agregarUnaEncuesta(encuesta8);
		proyecto1.agregarUnaEncuesta(encuesta9);
		proyecto1.agregarUnaEncuesta(encuesta10);
		proyecto1.agregarUnaEncuesta(encuesta11);
		proyecto1.agregarUnaEncuesta(encuesta12);
		proyecto1.agregarUnaEncuesta(encuesta13);
		
		proyecto2.agregarUnaEncuesta(encuesta14);
		proyecto2.agregarUnaEncuesta(encuesta15);
		proyecto2.agregarUnaEncuesta(encuesta16);
		proyecto2.agregarUnaEncuesta(encuesta17);
		proyecto2.agregarUnaEncuesta(encuesta18);
		proyecto2.agregarUnaEncuesta(encuesta19);
		proyecto2.agregarUnaEncuesta(encuesta20);
		proyecto2.agregarUnaEncuesta(encuesta21);
		proyecto2.agregarUnaEncuesta(encuesta22);
		proyecto2.agregarUnaEncuesta(encuesta23);
		proyecto2.agregarUnaEncuesta(encuesta24);
		proyecto2.agregarUnaEncuesta(encuesta25);
		proyecto2.agregarUnaEncuesta(encuesta26);
		
		
		
		investigador.agregarProyecto(proyecto1);
		investigador.agregarProyecto(proyecto2);
		
		List<Encuesta>e= new ArrayList<Encuesta>();	
		e.add(encuesta26);
		e.add(encuesta25);
		e.add(encuesta24);
		e.add(encuesta23);
		e.add(encuesta22);
		e.add(encuesta21);
		e.add(encuesta20);
		e.add(encuesta19);
		e.add(encuesta18);
		e.add(encuesta17);
		e.add(encuesta16);
		e.add(encuesta15);
		e.add(encuesta14);
		e.add(encuesta13);
		e.add(encuesta12);
		e.add(encuesta11);
		e.add(encuesta10);
		e.add(encuesta9);
		e.add(encuesta8);
		e.add(encuesta7);
		e.add(encuesta6);
		e.add(encuesta5);
		e.add(encuesta4);
		e.add(encuesta3);
		e.add(encuesta2);
		
		assertEquals( e , investigador.dameLas25MasContestadas() );
		
		
	}

}




















