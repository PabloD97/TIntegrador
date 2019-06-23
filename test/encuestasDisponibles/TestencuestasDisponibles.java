package encuestasDisponibles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import encuesta.Encuesta;
import encuestado.Encuestado;
import investigador.Investigador;
import preguntas.PreguntaAbierta;
import preguntas.PreguntaCompleja;
import preguntas.PreguntaDeMultipleSeleccion;
import proyecto.Proyecto;

class TestencuestasDisponibles {

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

	@BeforeEach
	void setUp() throws Exception {
		investigador = new Investigador();
		proyecto1 = new Proyecto("para testear", "nahuel puto");
		proyecto2 = new Proyecto("para testear tambien", "pablo capo");
		encuesta1 = new Encuesta("encuesta1");
		encuesta2 = new Encuesta("encuesta2");
		encuesta3 = new Encuesta("encuesta3");
		encuesta4 = new Encuesta("encuesta4");
		encuesta5 = new Encuesta("encuesta5");
		encuesta6 = new Encuesta("encuesta6");
		encuesta7 = new Encuesta("encuesta7");
		encuesta8 = new Encuesta("encuesta8");
		encuesta9 = new Encuesta("encuesta9");
		encuesta10 = new Encuesta("encuesta10");
		encuesta11 = new Encuesta("encuesta11");
		encuesta12 = new Encuesta("encuesta12");
		encuesta13 = new Encuesta("encuesta13");
		encuesta14 = new Encuesta("encuesta14");
		encuesta15 = new Encuesta("encuesta15");
		encuesta16 = new Encuesta("encuesta16");
		encuesta17 = new Encuesta("encuesta17");
		encuesta18 = new Encuesta("encuesta18");
		encuesta19 = new Encuesta("encuesta19");
		encuesta20 = new Encuesta("encuesta20");
		encuesta21 = new Encuesta("encuesta21");
		encuesta22 = new Encuesta("encuesta22");
		encuesta23 = new Encuesta("encuesta23");
		encuesta24 = new Encuesta("encuesta24");
		encuesta25 = new Encuesta("encuesta25");
		encuesta26 = new Encuesta("encuesta26");
	}

	@Test
	void testEstratetegiaUltimas20() {
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
		
		investigador.sumarProyectoALaLista(proyecto1);
		investigador.sumarProyectoALaLista(proyecto2);
		
		ArrayList<Encuesta> encuesta = new ArrayList<Encuesta>();
		encuesta.add(encuesta26);
		encuesta.add(encuesta25);
		encuesta.add(encuesta24);
		encuesta.add(encuesta23);
		encuesta.add(encuesta22);
		encuesta.add(encuesta21);
		encuesta.add(encuesta20);
		encuesta.add(encuesta19);
		encuesta.add(encuesta18);
		encuesta.add(encuesta17);
		encuesta.add(encuesta16);
		encuesta.add(encuesta15);
		encuesta.add(encuesta14);
		encuesta.add(encuesta13);
		encuesta.add(encuesta12);
		encuesta.add(encuesta11);
		encuesta.add(encuesta10);
		encuesta.add(encuesta9);
		encuesta.add(encuesta8);
		encuesta.add(encuesta7);
		encuesta.add(encuesta6);
		
		assertEquals(investigador.dameLasUltimas20Creadas(), encuesta);
		
	}

}
