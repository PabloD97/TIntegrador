package preguntas;


import java.util.ArrayList;
import java.util.List;

import encuestado.Encuestado;
import respuestas.Respuesta;


public class PreguntaDeMultipleSeleccion extends MultiplesOpciones {

	
	private List<Respuesta> respuestas;
	
	public PreguntaDeMultipleSeleccion(String pregunta2,  Pregunta sigPreg) {
		super(pregunta2,sigPreg);
		this.respuestas = new ArrayList<Respuesta>();
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
	public void responder(Encuestado e) {
		//Lo inicializo en null dado que doy por sentado que si no elije alguna opcion no va a poder responder
		String res = null;
		
		for(Respuesta r :e.getRespuestasElegidas()) {
			e.agregarRespuesta(r);
			this.notificarRespuesta(r);
			res+=r.getRespuesta();
			}
		this.notificarPregunta(res);
		
		e.getRespuestasElegidas().removeAll(e.getRespuestasElegidas());
		//this.getSiguientePregunta().setPreguntaAnterior(this);
		this.siSoyUltima();
		
		
		
		
	    
	}
 
 
	

	
}