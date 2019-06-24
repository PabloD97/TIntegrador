package encuestasDisponibles;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import encuesta.Encuesta;
import investigador.Investigador;

public class Las25MasContestadas implements IEstrategia{
	
	private List<Encuesta>lista1= new ArrayList<Encuesta>();
	private List<Encuesta> listaReturn= new ArrayList<Encuesta>();
	
	
	public List<Encuesta> dameLasEncuestasOrdenadosPorCantidadDeRespuesta(List<Encuesta> lista){
		// Ordena los objetos de menor a mayor mediante el valor de un atributo
		Collections.sort(lista, (encuesta1, encuesta2) -> encuesta1.vecesFinalizado().compareTo(encuesta2.vecesFinalizado()));
		return lista;
	}

	@Override
	public List<Encuesta> dameLasEncuestas(Investigador investigador) {
		this.lista1= investigador.getTodasLasEncuestas();
	
		this.dameLasEncuestasOrdenadosPorCantidadDeRespuesta(lista1);
		Collections.reverse(lista1);
		
		for( Encuesta e: lista1 ) {
			if(listaReturn.size() <25) {
				this.listaReturn.add(e);
			}
		}
		
		
		return listaReturn;
	}

}
