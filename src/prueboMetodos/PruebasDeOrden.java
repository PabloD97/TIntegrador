package prueboMetodos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PruebasDeOrden {

		private List<Integer> numeros;
		private List<Pibito> pibitos;
		
		

		public PruebasDeOrden() {
			super();
			this.numeros = new ArrayList<Integer>();
			this.pibitos= new ArrayList<Pibito>();
		}
		
		public void agregarNumeros(int x) {
			this.numeros.add(x);
		}
	
		public List<Integer> dameNumeros(){
			Collections.sort(this.numeros);
			Collections.reverse(numeros);
			return this.numeros;
 		}


		public void agregarPibito(Pibito pibe) {
			pibitos.add(pibe);
		}
		
		public List<Pibito> damePibitosOrdenadosPorNumero(){
			// Ordena los objetos de menor a mayor mediante el valor de un atributo
			Collections.sort(pibitos, (p1, p2) -> p1.dameNumero() .compareTo(p2.dameNumero()));
			// Collections.reverse(pibitos); Devuelve la lista ordenada de mayor a menor
			return this.pibitos;
		}

		public List<Pibito> dameLos25MasGrandes(List<Pibito> lista){// metodo para obtener las 25 mas grande
			List<Pibito>lista1= lista;
			Collections.reverse(lista1);
			List<Pibito> listaReturn= new ArrayList<Pibito>();
			for(int index = 0 ;  index >= 25 || lista1.isEmpty(); index++ ) {
				listaReturn.add(lista1.get(index));
				lista1.remove(index);
			}
			return listaReturn;
		}
}
