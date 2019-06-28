package respuestas;

import preguntas.Pregunta;

public class Respuesta {
	private String respuesta;
	private Pregunta pregPertenencia;
	
	public Respuesta(String textoRespuesta) {
		this.respuesta=textoRespuesta;
		
	}

	public void setRespuesta(String contestacion) {
		this.respuesta=contestacion;
		
	}
	public String getRespuesta() {
		return this.respuesta;
	}

	public Pregunta getPreguntaALaQuePertenece() {
		return this.pregPertenencia;
	}
	public void setPreguntaPertenencia(Pregunta preg) {
		this.pregPertenencia=preg;
	}
}
