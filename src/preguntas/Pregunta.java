package preguntas;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import encuestado.Encuestado;
import investigador.Investigador;
import observer.IInteresado;

public  class Pregunta {
	
	
	
	protected List<IInteresado> interesados;
	protected String pregunta;
	protected Encuestado encuestado;
	protected boolean esPrimerPregunta=false;
	protected boolean esUltimaPregunta=false;
	protected Pregunta siguientePregunta;
	protected Pregunta anteriorPregunta;
    protected Encuesta encuesta;
	 
	public String getPregunta() {
		return this.pregunta;
	}
	public Pregunta(String preg,Pregunta siguientePregunta) {
		this.pregunta=preg;
		this.siguientePregunta= siguientePregunta;
		this.interesados= new ArrayList<IInteresado>();
	}
	public Pregunta getSiguientePregunta() {
		return this.siguientePregunta;
	}
	protected void setPreguntaAnterior(Pregunta preg) {
		this.anteriorPregunta=preg;
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
	public void agregarInteresado(Investigador interesado) {
		this.interesados.add(interesado);
	}

	public void sacarInteresado(Investigador interesado) {
		this.interesados.remove(interesado);
	}
	
	public List<IInteresado> getInteresados(){
		return this.interesados;
	}
	
	public String getNombreDeEncuesta() {
		return this.encuesta.dameTuNombre();
	}
	public Encuesta getEncuesta() {
		return this.encuesta;
	}
	
	//Lo cambie
	public void notificarPregunta( String respuesta) {
		for( IInteresado interesado: interesados ) {
			interesado.notificarmePregunta(this, respuesta);
		}
	}
	 public  void responder(Encuestado e) {} 
	
	
}



















