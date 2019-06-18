package estadosDeLaEncuesta;

import preguntas.Pregunta;

public class Cerrada extends Estado {
	
	public void agregarPregunta(Pregunta pregunta) {}

	public void eliminarPregunta(Pregunta pregunta) {}

	public void siguienteEstado() {}
    
	//como hago para que se conozcan?
	//public void EmpezarEncuesta(Encuestado encuestado) {}
	
	public Boolean encuestaDisponible() {
		return false;
	}

	public Estado getEstado() {
		return null;
	}

}
