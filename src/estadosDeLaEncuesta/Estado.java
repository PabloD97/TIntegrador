package estadosDeLaEncuesta;

import encuesta.Encuesta;
import encuestado.Encuestado;
import preguntas.Pregunta;

public  abstract class Estado {
	
	public Encuesta encuesta;
	
	
	public abstract void siguienteEstado(); 
	
	public abstract void agregarPregunta(Pregunta pregunta);
	
	public abstract void eliminarPregunta(Pregunta pregunta);
	
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
