package encuestado;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import preguntas.Pregunta;
import preguntas.PreguntaAbierta;
import respuestas.Respuesta;

public class Encuestado {
	
	private String nombre;
	private String apellido;
	private Encuesta encuesta;
	private Pregunta preguntaActual;
	private List<Respuesta>respuestasElegidas;
	
	
	private List<Respuesta> respuestasDelEncuestado;
	
	
	public Encuestado( String nombre, String apellido , Encuesta encuesta){
		this.nombre= nombre;
		this.apellido=apellido;
		this.respuestasDelEncuestado = new ArrayList<Respuesta>();
		this.encuesta=encuesta;
		this.respuestasElegidas=new ArrayList<Respuesta>();
	}
	

	public String getDatosDelEncuestado() {
		return this.nombre+ " " +this.apellido;
	}
	
	public List<Respuesta> getRespuestasDelEncuestado(){
		return  this.respuestasDelEncuestado;
	}

	public void agregarRespuesta(Respuesta res) {
		res.setPreguntaPertenencia(this.preguntaActual);
		this.respuestasDelEncuestado.add(res);
	}
	
	public void termineLaEncuesta() {
		encuesta.encuestaFinalizada(this);
	}
	
	public Pregunta getPreguntaActual() {
		return this.preguntaActual;
	}
	public void setPreguntaActual(Pregunta preg) {
		this.preguntaActual=preg;
	}
	
	public void responder() {
		this.preguntaActual.responder(this);
		//this.setPreguntaActual(preguntaActual.getSiguientePregunta());
	}
	public void elegirRespuesta(Respuesta r) {
		this.respuestasElegidas.add(r);
	}
	public List<Respuesta> getRespuestasElegidas(){
		return this.respuestasElegidas;
	}
	
}
