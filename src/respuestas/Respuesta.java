package respuestas;

import java.util.List;

import observer.IInteresado;
import preguntas.Pregunta;

public class Respuesta {
	
	
	private String respuesta;
	private Pregunta pregPertenencia;
	private List<IInteresado> interesados;
	private Pregunta siguientePregunta;
	
	
	public Respuesta(String textoRespuesta,Pregunta siguientePregunta) {
		this.respuesta=textoRespuesta;
		this.siguientePregunta=siguientePregunta;
	}

	public void setRespuesta(String contestacion) {
		this.respuesta=contestacion;
		
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

	public void sacarInteresado(IInteresado investigador) {
		this.interesados.remove(investigador);
	}

	public void agregarInteresado(IInteresado investigador) {
		this.interesados.add(investigador);
	}
	
	
	public Pregunta getSiguientePregunta() {
		return this.siguientePregunta ;
	}
	
}
