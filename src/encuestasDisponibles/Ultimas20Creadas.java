package encuestasDisponibles;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import encuesta.Encuesta;
import investigador.Investigador;

public class Ultimas20Creadas implements IEstrategia {

	private List<Encuesta>lista1= new ArrayList<Encuesta>();
	private List<Encuesta> listaReturn= new ArrayList<Encuesta>();

	public List<Encuesta> dameLasUltimasEncuestas(List<Encuesta> lista1) {
				Collections.sort(lista1, (encuesta1, encuesta2) -> encuesta1.getFechaDeCreacion().compareTo(encuesta2.getFechaDeCreacion()));
				return lista1;
	}

	@Override
	public List<Encuesta> dameLasEncuestas(Investigador investigador) {
		this.lista1= investigador.getTodasLasEncuestas();
		this.dameLasUltimasEncuestas(lista1);
		
		Collections.reverse(lista1);
		
		for( Encuesta e: lista1 ) {
			if(listaReturn.size() <20) {
				this.listaReturn.add(e);
			}
		}
		return listaReturn;
		//lista1.subList(0, 20);
	}
		
}
	
	
	
	


