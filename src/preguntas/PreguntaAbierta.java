package preguntas;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaAbierta extends Pregunta {
	
		
	public PreguntaAbierta(String preg) {
		super(preg);
	}



	public void escribirRespuesta(String s, Encuestado e) {
		Respuesta res=new Respuesta(s, null);
		e.elegirRespuesta(res);
	}

	@Override 
	public void responder(Encuestado encuestado) {
		encuestado.agregarRespuesta(encuestado.getRespuestasElegidas().get(0));
		
		encuestado.setPreguntaActual( encuestado.getRespuestasElegidas().get(0).getSiguientePregunta() );

		
		encuestado.getRespuestasElegidas().get(0).notificar();

		
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		

		
		this.siSoyUltima();
		
		
	}
	
	
}
