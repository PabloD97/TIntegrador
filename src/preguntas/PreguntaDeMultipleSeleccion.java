package preguntas;


import java.util.ArrayList;
import java.util.List;

import encuestado.Encuestado;
import respuestas.Respuesta;


public class PreguntaDeMultipleSeleccion extends MultiplesOpciones {

	
	private List<Respuesta> respuestas;
	
	public PreguntaDeMultipleSeleccion(String pregunta2,  Pregunta siguientePregunta) {
		super(pregunta2);
		this.respuestas = new ArrayList<Respuesta>();
		this.siguientePregunta=siguientePregunta;
	}

	public void addRespuesta(Respuesta respuesta) {
		respuestas.add(respuesta);
	}
	
	public List<Respuesta> getOpciones(){
		return this.respuestas;
	}
	
	public void elegirRespuesta(Respuesta respuestaCerrada1, Encuestado e) {
		e.elegirRespuesta(respuestaCerrada1);
	}
	@Override
	public void responder(Encuestado encuestado) {
		//Lo inicializo en null dado que doy por sentado que si no elije alguna opcion no va a poder responder
		//String res = null;
		
		for(Respuesta r :encuestado.getRespuestasElegidas()) {
			encuestado.agregarRespuesta(r);
			//this.notificarRespuesta(r);//Creo que rompe x esto
		//	res+=r.getRespuesta();
			}
		//this.notificarPregunta(res);
		
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		
		encuestado.setPreguntaActual(this.getSiguientePregunta());

		//this.getSiguientePregunta().setPreguntaAnterior(this);
		this.siSoyUltima();
		
		
		
		
	    
	}
 
 
	

	
}