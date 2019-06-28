package preguntas;


import java.util.ArrayList;

import encuestado.Encuestado;
import respuestas.Respuesta;


public class PreguntaDeMultipleSeleccion extends MultiplesOpciones {

    private	ArrayList<Respuesta>respuestaElegidas;
	
	private Encuestado contenedorDeRespuestas;
	private ArrayList<Respuesta> respuestas= new ArrayList<Respuesta>();
	
	public PreguntaDeMultipleSeleccion(String pregunta2,  Encuestado contenedor, Pregunta sigPreg) {
		super(pregunta2,sigPreg);
		this.contenedorDeRespuestas = contenedor;
		this.respuestas = new ArrayList<Respuesta>();
		this.respuestaElegidas= new ArrayList<Respuesta>();
	}

	public void addRespuesta(Respuesta respuesta) {
		respuestas.add(respuesta);
	}
	
	public ArrayList<Respuesta> getRespuestasElegidas(){
		return this.respuestaElegidas;
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
		this.getSiguientePregunta().setPreguntaAnterior(this);
		this.siSoyUltima();
		
		
		
		/*String 
		for( Respuesta respuesta : respuestaElegidas ) {
			
			contenedorDeRespuestas.agregarRespuesta(respuesta );
			this.getSiguientePregunta().setPreguntaAnterior(this);
		}
		this.notificar(respuestas);
		this.respuestaElegidas.removeAll(respuestaElegidas);
		this.siSoyUltima();*/
	    
	}
 
 
	

	
}