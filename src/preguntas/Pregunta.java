package preguntas;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import encuestado.Encuestado;
import investigador.Investigador;
import observer.IInteresado;

public abstract class Pregunta {
	
	
	
	//protected List<IInteresado> interesados;
	protected String pregunta;
	protected Encuestado encuestado;
	protected boolean esPrimerPregunta=false;
	protected boolean esUltimaPregunta=false;
	//protected Pregunta siguientePregunta;
	protected Pregunta anteriorPregunta;
    protected Encuesta encuesta;
	 
	public String getPregunta() {
		return this.pregunta;
	}
	public Pregunta(String preg) {
		this.pregunta=preg;
	}
	/*
	public Pregunta getSiguientePregunta() {
		return this.siguientePregunta;
	}
	*/
	public Pregunta getAnteriorPregunta() {
		return anteriorPregunta;
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
	// mensajes nuevos
	/*public void agregarInteresado(Investigador interesado) {
		this.interesados.add(interesado);
	}

	public void sacarInteresado(Investigador interesado) {
		this.interesados.remove(interesado);
	}
	
	public List<IInteresado> getInteresados(){
		return this.interesados;
	}
	*/
	public String getNombreDeEncuesta() {
		return this.encuesta.dameTuNombre();
	}
	public Encuesta getEncuesta() {
		return this.encuesta;
	}
	

	public  void responder(Encuestado e) {} 
	
	
}



















