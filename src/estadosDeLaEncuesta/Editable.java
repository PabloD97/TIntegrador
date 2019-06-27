package estadosDeLaEncuesta;

import preguntas.Pregunta;


public class Editable extends Estado {
	

	public void agregarPregunta(Pregunta pregunta) {
		encuesta.getProtocoloDePreguntas().add(pregunta);
		pregunta.setEncuesta(encuesta);
	}

	public void eliminarPregunta(Pregunta pregunta) {
		encuesta.getProtocoloDePreguntas().remove(pregunta);
	}

	
	//
	public void siguienteEstado() {
		Activa estado= new Activa();
		this.encuesta.setEstado(estado);
	}
    

	

}
