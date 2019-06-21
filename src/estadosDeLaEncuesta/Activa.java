package estadosDeLaEncuesta;

import encuestado.Encuestado;
import preguntas.Pregunta;

public class Activa extends Estado {
	
	public void agregarPregunta(Pregunta pregunta) {}

	public void eliminarPregunta(Pregunta pregunta) {}

	
	//
	public void siguienteEstado() {
		Estado cerrada = new Estado();
		this.encuesta.setEstado(cerrada);
	}
    
	public void comenzarEncuesta(Encuestado encuestado) {
		encuestado.setPreguntaActual(  this.encuesta.getProtocoloDePreguntas().get(0) );
	}
	

	public Estado getEstado() {
		return this;
	}

	public Boolean encuestaDisponible() {
		return true;
	}
}
