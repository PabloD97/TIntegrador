package encuestasDisponibles;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import encuesta.Encuesta;
import investigador.Investigador;

public class Ultimas20Creadas implements IEstrategia {


	public List<Encuesta> dameLasUltimasEncuestas(List<Encuesta> lista1) {
		// Ordena los objetos de menor a mayor mediante el valor de un atributo
				Collections.sort(lista1, (encuesta1, encuesta2) -> encuesta1.getDate().compareTo(encuesta2.getDate()));
				// Collections.reverse(pibitos); Devuelve la lista ordenada de mayor a menor
				return lista1;
	}

	@Override
	public List<Encuesta> dameLasEncuestas(Investigador investigador) {
		List<Encuesta>lista1= investigador.getTodasLasEncuestas();
		this.dameLasUltimasEncuestas(lista1);
		
		Collections.reverse(lista1);
		
		List<Encuesta> listaReturn= new ArrayList<Encuesta>();
		for(int index = -1 ;  index >= 19 || lista1.isEmpty(); index++ ) {
			listaReturn.add(lista1.get(index));
			lista1.remove(index);
		}
		return listaReturn;
	}
	
	
	
	

}
