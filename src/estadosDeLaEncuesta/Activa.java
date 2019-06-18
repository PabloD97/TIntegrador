package estadosDeLaEncuesta;

import encuesta.Encuesta;
import preguntas.Pregunta;

public class Activa extends Estado {
	
	public void agregarPregunta(Pregunta pregunta) {}

	public void eliminarPregunta(Pregunta pregunta) {}

	
	//
	public void siguienteEstado() {
		Estado cerrada = new Estado();
		encuesta.setEstado(cerrada);
	}
    
	//como hago para que se conozcan?
	//Pregunta pregunta = new Pregunta();
	//public void EmpezarEncuesta(Encuestado encuestado) {
	//  encuestado.setPreguntaActual(pregunta.primerPregunta());
	//}
	
	public Boolean encuestaDisponible() {
		return true;
	}

	public Estado getEstado() {
		Estado activa = new Estado();
		return activa;
	}


}
