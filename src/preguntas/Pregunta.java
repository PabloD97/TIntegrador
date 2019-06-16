package preguntas;

import encuestado.Encuestado;

public class Pregunta {
	
	
	

	protected String pregunta;
	private Encuestado contenedor;
	private boolean esPrimerPregunta=false;
	private boolean esUltimaPregunta=false;
	private Pregunta siguientePregunta;
	private Pregunta anteriorPregunta;

	public String getPregunta() {
		return this.pregunta;
	}
	public Pregunta(String preg,Pregunta siguientePregunta) {
		this.pregunta=preg;
		this.siguientePregunta=siguientePregunta;
	}
	public Pregunta getSiguientePregunta() {
		return this.siguientePregunta;
	}
	protected void setPreguntaAnterior(Pregunta preg) {
		this.anteriorPregunta=preg;
	}
	public void setEncuestado(Encuestado contenedor2) {
		this.contenedor=contenedor2;
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
	    	this.contenedor.fin();
	    }
	}
}
