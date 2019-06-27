package estadosDeLaEncuesta;

import encuesta.Encuesta;
import encuestado.Encuestado;
import preguntas.Pregunta;

public  abstract class Estado {
	
	public Encuesta encuesta;
	
	
	public void siguienteEstado() {}
	
	public void agregarPregunta(Pregunta pregunta) {}
	
	public void eliminarPregunta(Pregunta pregunta) {}
	
	public void setearEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
	
	
	public void comenzarEncuesta(Encuestado encuestado) {}
	
	public Estado getEstado() {
		return this;
	}
	
    public Boolean encuestaDisponible() {
		return false;
	}
}
