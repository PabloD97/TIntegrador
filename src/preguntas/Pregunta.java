package preguntas;

import java.util.ArrayList;
import java.util.List;

import encuestado.Encuestado;
import investigador.Investigador;

public class Pregunta {
	
	
	
	protected List<Investigador> interesados;
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
		this.interesados= new ArrayList<Investigador>();
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
	// mensajes nuevos
	public void agregarInteresado(Investigador interesado) {
		this.interesados.add(interesado);
	}

	public void sacarInteresado(Investigador interesado) {
		this.interesados.remove(interesado);
	}
	
	public void notificar() {
		for( Investigador interesado: interesados ) {
			interesado.notificarme();
		}
	}
	
}



















