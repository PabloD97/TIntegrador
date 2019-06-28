package preguntas;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaAbierta extends Pregunta {
	
		
	public PreguntaAbierta(String preg, Pregunta siguientePregunta) {
		super(preg);
		this.siguientePregunta= siguientePregunta;
	}



	public void escribirRespuesta(String s, Encuestado e) {
		Respuesta res=new Respuesta(s);
		e.elegirRespuesta(res);
	}

	@Override
	public Pregunta getSiguientePregunta() {
		return this.siguientePregunta;
	}

	
	@Override 
	public void responder(Encuestado encuestado) {
		encuestado.agregarRespuesta(encuestado.getRespuestasElegidas().get(0));
		this.notificarPregunta(encuestado.getRespuestasElegidas().get(0).getRespuesta());
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		this.siSoyUltima();
		this.getSiguientePregunta().setPreguntaAnterior(this);
		
	}
	
/*	@Override
	public void responder(Encuestado encuestado) {
		this.siSoyUltima();
		for(Respuesta r: encuestado.getRespuestasElegidas()) {
			this.notificarPregunta(r.getRespuesta());
			encuestado.agregarRespuesta(r);
			//e.getRespuestasDelEncuestado().remove(r);
		}
		//encuestado.setPreguntaActual(this.getSiguientePregunta());

		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		//this.getSiguientePregunta().setPreguntaAnterior(this);
		
	}
	
*/	
}
