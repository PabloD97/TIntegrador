package encuesta;

import java.util.ArrayList;

import contenedor.Encuestado;
import proyecto.Proyecto;
import respuestas.Respuesta;

import java.util.List;
import preguntas.Pregunta;

public class Encuesta {

	private List<Encuestado> encuestados;
	private List<Pregunta> protocoloDePreguntas;
	private int vecesFinalizado=0;
	private ArrayList<Respuesta> respuestas;
	
	
	
	public Encuesta() {
		this.encuestados= new ArrayList<Encuestado>();
		this.protocoloDePreguntas= new ArrayList<Pregunta>();
	}
	
	public void addPregunta(Pregunta pregunta) {
		this.protocoloDePreguntas.add(pregunta);
	}
	
	public void eliminarPregunta(Pregunta pregunta) {
		this.protocoloDePreguntas.remove(pregunta);
	}

	
	// Cree este metodo para saber si las preguntas fueron agregadas o eliminada en los test
	public List<Pregunta> getProtocoloDePreguntas(){
		return this.protocoloDePreguntas;
	}
	
	public void encuestaFinalizada(Encuestado formulario) {
            this.encuestados.add(formulario);
            this.vecesFinalizado +=1;
	}

	public void eliminarFormulario(Encuestado formulario) {
		this.encuestados.remove(formulario);
		
	}
	public int vecesFinalizado() {
		return this.vecesFinalizado;
	}
	public ArrayList<Respuesta> getTodasLasRespuestas(){
		for(Encuestado f:encuestados) {
			respuestas.addAll(f.getRespuestasDelEncuestado());
		}
		return respuestas;
	}
	public ArrayList<Encuestado>getFormularios(){
		return (ArrayList<Encuestado>) this.encuestados;
	}
	public void comenzarEncuesta(Encuestado e) {
		e.setPreguntaActual(this.protocoloDePreguntas.get(1));
	}

	
	
	
}
