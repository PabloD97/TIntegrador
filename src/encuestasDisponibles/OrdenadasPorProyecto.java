package encuestasDisponibles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import encuesta.Encuesta;
import investigador.Investigador;
import proyecto.Proyecto;

public class OrdenadasPorProyecto implements IEstrategia {
	
	public List<Encuesta> encuestasPorOrdenAlfabetico(Proyecto proyecto){
		List<Encuesta> ordenadas = proyecto.getEncuestas();
		 
		Collections.sort(ordenadas, (encuesta1, encuesta2) -> encuesta1.dameTuNombre() .compareTo(encuesta2.dameTuNombre() ));
		
		return ordenadas;
	} 

	
	@Override
	public List<Encuesta> dameLasEncuestas(Investigador investigador) {

		List<Proyecto>proyectos= investigador.getProyectos();
		List<Encuesta> listaEncuestas= new ArrayList<Encuesta>();
		
		for(Proyecto proyecto : proyectos) {
			 for(Encuesta encuestas : this.encuestasPorOrdenAlfabetico(proyecto) ) {
				 listaEncuestas.add(encuestas);
			 }
			}
			return listaEncuestas;
	}

}
