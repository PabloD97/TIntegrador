package encuestasDisponibles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import investigador.Investigador;
import proyecto.Proyecto;

class TestEncuestasOrdenadasPorProyecto {

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
	IEstrategia ordenadas;

	@BeforeEach
	void setUp() throws Exception {
		investigador = new Investigador();
		proyecto1 = new Proyecto("para testear", "nahuel ");
		proyecto2 = new Proyecto("para testear tambien", "pablo ");
		encuesta1 = new Encuesta("a", 119, 6, 1);
		encuesta2 = new Encuesta("b", 119, 6, 2);
		encuesta3 = new Encuesta("c", 119, 6, 3);
		encuesta4 = new Encuesta("d", 119, 6, 4);
		encuesta5 = new Encuesta("e", 119, 6, 5);
		encuesta6 = new Encuesta("f", 119, 6, 6);
		encuesta7 = new Encuesta("g", 119, 6, 7);
		encuesta8 = new Encuesta("h", 119, 6, 8);
		encuesta9 = new Encuesta("i", 119, 6, 9);
		encuesta10 = new Encuesta("j", 119, 6, 10);
		encuesta11 = new Encuesta("k", 119, 6, 11);
		encuesta12 = new Encuesta("l", 119, 6, 12);
		encuesta13 = new Encuesta("n", 119, 6, 13);
		encuesta14 = new Encuesta("m", 119, 6, 14);
		encuesta15 = new Encuesta("o", 119, 6, 15);
		encuesta16 = new Encuesta("p", 119, 6, 16);
		encuesta17 = new Encuesta("q", 119, 6, 17);
		encuesta18 = new Encuesta("r", 119, 6, 18);
		encuesta19 = new Encuesta("s", 119, 6, 19);
		encuesta20 = new Encuesta("t", 119, 6, 20);
		encuesta21 = new Encuesta("u", 119, 6, 21);
		encuesta22 = new Encuesta("v", 119, 6, 22);
		encuesta23 = new Encuesta("w", 119, 6, 23);
		encuesta24 = new Encuesta("x", 119, 6, 24);
		encuesta25 = new Encuesta("y", 119, 6, 25);
		encuesta26 = new Encuesta("z", 119, 6, 26);
		ordenadas = new OrdenadasPorProyecto();
	}

	@Test
	void testOrdenadasPorProyecto() {
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

		ArrayList<Encuesta> encuesta = new ArrayList<Encuesta>();
		encuesta.add(encuesta1);
		encuesta.add(encuesta2);
		encuesta.add(encuesta3);
		encuesta.add(encuesta4);
		encuesta.add(encuesta5);
		encuesta.add(encuesta6);
		
		encuesta.add(encuesta7);
		encuesta.add(encuesta8);
		encuesta.add(encuesta9);
		encuesta.add(encuesta10);
		encuesta.add(encuesta11);
		encuesta.add(encuesta12);
		encuesta.add(encuesta13);
		encuesta.add(encuesta14);
		encuesta.add(encuesta15);
		encuesta.add(encuesta16);
		encuesta.add(encuesta17);
		encuesta.add(encuesta18);
		encuesta.add(encuesta19);
		encuesta.add(encuesta20);
		encuesta.add(encuesta21);
		encuesta.add(encuesta22);
		encuesta.add(encuesta23);
		encuesta.add(encuesta24);
		encuesta.add(encuesta25);
		encuesta.add(encuesta26);
		
		investigador.setEstragia(ordenadas);
		
		
		assertEquals(encuesta, investigador.filtrar());
	}

}






















