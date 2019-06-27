package preguntas;

import respuestas.Respuesta;

public class PreguntaAbierta extends Pregunta {
	
	private Respuesta respuestaAbierta;
		
	
	
	
	public PreguntaAbierta(String pregunta,Pregunta siguientePregunta) {
		super(pregunta, siguientePregunta);
	}

	public void responder(String contestacion) {
		respuestaAbierta.setRespuesta(contestacion);
		this.siSoyUltima();
		this.getSiguientePregunta().setPreguntaAnterior(this);
		this.notificar(contestacion);
	}
	
	
}
