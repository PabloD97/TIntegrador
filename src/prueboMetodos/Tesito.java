package prueboMetodos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Tesito {
	
	PruebasDeOrden x;
	Pibito pablo;
	Pibito pablo1;
	Pibito pablo2;
	Pibito pablo3;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		x = new PruebasDeOrden();
		pablo= new Pibito(5);
		pablo2= new Pibito(2);
		pablo3= new Pibito(7);
		pablo1= new Pibito(1);
	
	
	}

	

	@Test
	void test() {
	x.agregarNumeros(1);
	x.agregarNumeros(5);
	x.agregarNumeros(2);
	x.agregarNumeros(8);
	assertEquals( 2, x.dameNumeros() );
	}
	@Test
	void test2() {// Ordena los objetos de menor a mayor mediante el valor de un atributo 
		ArrayList<Pibito> pibites= new ArrayList<Pibito>();
		
		pibites.add(pablo1); 
		pibites.add(pablo2); 
		pibites.add(pablo); 
		pibites.add(pablo3); 
		
		x.agregarPibito(pablo);
		x.agregarPibito(pablo2);
		x.agregarPibito(pablo3);
		x.agregarPibito(pablo1);
		assertEquals( pibites, x.damePibitosOrdenadosPorNumero() );
	}
	

}
