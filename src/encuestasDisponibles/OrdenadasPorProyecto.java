package encuestasDisponibles;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import investigador.Investigador;
import proyecto.Proyecto;

public class OrdenadasPorProyecto implements IEstrategia {

	
	// agregado el algoritmo para dar las ncuestas ordenadas por orden alfabetico... espero que este bien
	@Override
	public List<Encuesta> dameLasEncuestas(Investigador investigador) {

		List<Proyecto>lista1= investigador.getProyectos();
		List<Encuesta> listaEncuestas= new ArrayList<Encuesta>();
		
		for(Proyecto proyecto : lista1) {
			 for(Encuesta encuestas : proyecto.encuestasPorOrdenAlfabetico() ) {
				 listaEncuestas.add(encuestas);
			 }
			}
			return listaEncuestas;
	}

}
