package estadosDeLaEncuesta;

import encuestado.Encuestado;
import preguntas.Pregunta;

public class Activa extends Estado {
	
	public void agregarPregunta(Pregunta pregunta) {}

	public void eliminarPregunta(Pregunta pregunta) {}

	
	//
	public void siguienteEstado() {
		Cerrada estado= new Cerrada();
		this.encuesta.setEstado(estado);
	}
    
	public void comenzarEncuesta(Encuestado encuestado) {
		encuestado.setPreguntaActual(this.encuesta.getProtocoloDePreguntas().get(0));
	}
	


	public Boolean encuestaDisponible() {
		return true;
	}
}
