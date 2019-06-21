package encuestasDisponibles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import encuesta.Encuesta;
import investigador.Investigador;
import prueboMetodos.Pibito;

public class Las25MasContestadas implements IEstrategia{

	@Override
	public List<Encuesta> dameLasEncuestas(Investigador investigador) {
		
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
