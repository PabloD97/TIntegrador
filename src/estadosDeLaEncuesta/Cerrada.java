package estadosDeLaEncuesta;

import encuestado.Encuestado;
import preguntas.Pregunta;

public class Cerrada extends Estado {
	
	public void agregarPregunta(Pregunta pregunta) {}

	public void eliminarPregunta(Pregunta pregunta) {}

	public void siguienteEstado() {}
    

	public void EmpezarEncuesta(Encuestado encuestado) {}
	
	public Estado encuestaDisponible() {
		return encuesta.getEstado();
	}

	public Estado getEstado() {
		return this;
	}

}
