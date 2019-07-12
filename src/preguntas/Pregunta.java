package preguntas;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import encuestado.Encuestado;
import investigador.Investigador;
import observer.IInteresado;
import respuestas.Respuesta;

public abstract class Pregunta {
	
	
	
	
	
	
	protected String pregunta;
	protected Encuestado encuestado;
	protected boolean esPrimerPregunta=false;
	protected boolean esUltimaPregunta=false;
	
	protected Pregunta anteriorPregunta;
    protected Encuesta encuesta;
	 
	public String getPregunta() {
		return this.pregunta;
	}
	public Pregunta(String preg) {
		this.pregunta=preg;
	}
	
	public Pregunta getAnteriorPregunta() {
		Pregunta res=null;
		if(!this.esPrimerPregunta) {
		res= this.anteriorPregunta;}
		return res;
	}
	
	protected void setPreguntaAnterior(Pregunta preg) {
		anteriorPregunta=preg;
	}
	
	public void setEncuesta(Encuesta encuesta ) {
		this.encuesta = encuesta;
	}
	public void esPrimerPregunta() {
		this.esPrimerPregunta=true;
	}
	public void esUltimaPregunta() {
		this.esUltimaPregunta=true;
	}
	public boolean primerPregunta() {
		return this.esPrimerPregunta;
	}
	public boolean ultimaPregunta() {
		return this.esUltimaPregunta;
	}
	public void siSoyUltima( ) {
		if(this.ultimaPregunta()) {
	    	this.encuestado.termineLaEncuesta();
	    }
	}
	
	public String getNombreDeEncuesta() {
		return this.encuesta.dameTuNombre();
	}
	public Encuesta getEncuesta() {
		return this.encuesta;
	}
	

	public  void responder(Encuestado e) {} 
	
	
	//protected abstract void addRespuesta(Respuesta respuesta);

	
	
}



















