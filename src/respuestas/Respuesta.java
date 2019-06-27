package respuestas;

import preguntas.Pregunta;

public class Respuesta {
	private String respuesta;
	private Pregunta pregPertenencia;
	
	public Respuesta(String textoRespuesta ) {
		this.respuesta=textoRespuesta;
	}

	public void setRespuesta(String contestacion) {
		this.respuesta=contestacion;
		
	}
	public String getRespuesta() {
		return this.respuesta;
	}
	public void setPregunta(Pregunta preg) {
		this.pregPertenencia=preg;
	}
	public Pregunta getPreguntaALaQuePertenece() {
		return this.pregPertenencia;
	}
}
