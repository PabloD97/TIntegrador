package estadosDeLaEncuesta;

import encuesta.Encuesta;
import preguntas.Pregunta;

public class Estado {
	
	public Encuesta encuesta;
	
	
	public void siguienteEstado() {}
	
	public void agregarPregunta(Pregunta pregunta) {}
	
	public void eliminarPregunta(Pregunta pregunta) {}
	
	public void setearEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}
	
	//como hago para que se conozcan?
	//public void EmpezarEncuesta(Encuestado encuestado) {}
	
	public Estado getEstado() {
		return null;
		}
	
    public Estado encuestaDisponible() {
    	return null;
    }
}
