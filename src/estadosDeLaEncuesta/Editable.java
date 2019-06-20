package estadosDeLaEncuesta;

import preguntas.Pregunta;


public class Editable extends Estado {
	

	public void agregarPregunta(Pregunta pregunta) {
		encuesta.getProtocoloDePreguntas().add(pregunta);
	}

	public void eliminarPregunta(Pregunta pregunta) {
		encuesta.getProtocoloDePreguntas().remove(pregunta);
	}

	
	//
	public void siguienteEstado() {
		Estado activa = new Estado();
		encuesta.setEstado(activa);
	}
    
	//como hago para que se conozcan?
	//public void EmpezarEncuesta(Encuestado encuestado) {
	//}

	public Estado getEstado() {
		Estado editable = new Estado();
		return editable;
	}

	public Estado encuestaDisponible() {
		return encuesta.getEstado();
	}

}
