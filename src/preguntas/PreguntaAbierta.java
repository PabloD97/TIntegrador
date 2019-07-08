package preguntas;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaAbierta extends Pregunta {
	
	private Pregunta siguientePregunta;
		
	public PreguntaAbierta(String preg,Pregunta siguientePregunta) {
		super(preg);
		this.siguientePregunta=siguientePregunta;
	}



	public void escribirRespuesta(String respuesta, Encuestado encuestado) {
		Respuesta res=new Respuesta(respuesta);
		encuestado.elegirRespuesta(res);
	}

	public Pregunta getSiguientePregunta() {
		return this.siguientePregunta;
	}
	
	
	@Override 
	public void responder(Encuestado encuestado) {
		encuestado.agregarRespuesta(encuestado.getRespuestasElegidas().get(0));
		
		encuestado.setPreguntaActual( this.getSiguientePregunta() );

		
		encuestado.getRespuestasElegidas().get(0).notificar();

		
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		

		
		this.siSoyUltima();
		
		
	}
	
	
}
