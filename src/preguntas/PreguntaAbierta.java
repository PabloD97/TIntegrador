package preguntas;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaAbierta extends Pregunta {
	
	private Respuesta respuestaAbierta;
	private Encuestado contenedorDeRespuestas;
		
	
	
	
	public PreguntaAbierta(String pregunta,Encuestado formulario,Pregunta siguientePregunta) {
		super(pregunta, siguientePregunta);
		this.contenedorDeRespuestas=formulario;
	}


	public void responder(String contestacion) {
		respuestaAbierta.setRespuesta(contestacion);
		contenedorDeRespuestas.addRespuesta( respuestaAbierta );
		this.siSoyUltima();
		this.getSiguientePregunta().setPreguntaAnterior(this);
	}
	
	public String getRespuesta() {
		return respuestaAbierta.getRespuesta();
	}
}
