package respuestas;

import java.util.ArrayList;
import java.util.List;

import observer.IInteresado;
import preguntas.Pregunta;

public class Respuesta {
	
	
	private String respuesta;
	private Pregunta pregPertenencia;
	private List<IInteresado> interesados;
	private	Pregunta siguientePregunta;
	private Boolean esUltimaPregunta=false;
	
	
	
	
	
	public Respuesta(String textoRespuesta) {
		this.respuesta=textoRespuesta;
		this.interesados= new ArrayList<IInteresado>();
	}

	public Respuesta(String textoRespuesta,Pregunta siguientePregunta) {
		this.respuesta=textoRespuesta;
		this.interesados= new ArrayList<IInteresado>();
		this.siguientePregunta=siguientePregunta;
	}

	
	public String getRespuesta() {
		return this.respuesta;
	}

	public Pregunta getPreguntaALaQuePertenece() {
		return this.pregPertenencia;
	}
	public void setPreguntaPertenencia(Pregunta preg) {
		this.pregPertenencia=preg;
	}

	// metodos nuevos
	
	public void notificar() {
		for(IInteresado interesado: interesados) {
			interesado.notificar();
		}
	}
	
	public void sacarInteresado(IInteresado investigador) {
		this.interesados.remove(investigador);
	}

	public void agregarInteresado(IInteresado investigador) {
		this.interesados.add(investigador);
	}
	
	public List<IInteresado> getInteresados(){
		return this.interesados;
	}
	
	//Metodos que solo utilizaria pregunta de simpleSeleccion con multiples opciones
	public Pregunta getSiguientePregunta() {
		if(this.esUltimaPregunta) {
			//El comportamiento de la siguiente pregunta tiene que ser definido. 
			//Ya que habiamos utilizado un systemPrintIn pero no pidieron cambiar ese codigo ya que corria por parte de GUI
			return null;
		}
		else {
		return this.siguientePregunta;
		}
	}
	public boolean ultimaPregunta() {
		return this.esUltimaPregunta;
	}
	/*
	public void setSiguientePregunta(Pregunta pregunta) {
		siguientePregunta= pregunta;
	}
	*/
	
	
}
