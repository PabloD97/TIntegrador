package encuestasDisponibles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import encuesta.Encuesta;
import investigador.Investigador;

public class Las25MasContestadas implements IEstrategia{
	
	
	public List<Encuesta> dameLasEncuestasOrdenadosPorCantidadDeRespuesta(List<Encuesta> lista){
		// Ordena los objetos de menor a mayor mediante el valor de un atributo
		Collections.sort(lista, (encuesta1, encuesta2) -> encuesta1.vecesFinalizado().compareTo(encuesta2.vecesFinalizado()));
		// Collections.reverse(pibitos); Devuelve la lista ordenada de mayor a menor
		return lista;
	}

	@Override
	public List<Encuesta> dameLasEncuestas(Investigador investigador) {
		
		List<Encuesta>lista1= investigador.getTodasLasEncuestas();
		this.dameLasEncuestasOrdenadosPorCantidadDeRespuesta(lista1);
		
		Collections.reverse(lista1);
		
		List<Encuesta> listaReturn= new ArrayList<Encuesta>();
		for(int index = -1 ;  index >= 24 || lista1.isEmpty(); index++ ) {
			listaReturn.add(lista1.get(index));
			lista1.remove(index);
		}
		return listaReturn;
	}

}
