package preguntas;

import encuestado.Encuestado;
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
		this.notificarPregunta(contestacion);
	}
	public void escribirRespuesta(String s, Encuestado e) {
		Respuesta res=new Respuesta(s);
		e.elegirRespuesta(res);
	}

	

	@Override
	public void responder(Encuestado e) {
		this.siSoyUltima();
		this.getSiguientePregunta().setPreguntaAnterior(this);
		for(Respuesta r:e.getRespuestasElegidas()) {
			this.notificarPregunta(r.getRespuesta());
			e.agregarRespuesta(r);
		}
		e.getRespuestasElegidas().removeAll(e.getRespuestasElegidas());
	}
	
	
}
