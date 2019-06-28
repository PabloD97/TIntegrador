package preguntas;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaAbierta extends Pregunta {
	
		
	public PreguntaAbierta(String preg, Pregunta siguientePregunta) {
		super(preg, siguientePregunta);
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
		this.siSoyUltima();
		for(Respuesta r: encuestado.getRespuestasElegidas()) {
			this.notificarPregunta(r.getRespuesta());
			encuestado.agregarRespuesta(r);
			//e.getRespuestasDelEncuestado().remove(r);
		}
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		//this.getSiguientePregunta().setPreguntaAnterior(this); LA PORQUERIA ESTA ROMPE TODO, SALTA EN NULL CUANDO ES INICIALIZADA EN EL CONTRUCTOR
		
	}
	
	
}
