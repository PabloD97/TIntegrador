package encuesta;

import java.util.ArrayList;
import estadosDeLaEncuesta.Estado;

import respuestas.Respuesta;

import java.util.List;

import encuestado.Encuestado;
import preguntas.Pregunta;

public class Encuesta {

	private List<Encuestado> encuestados;
	private List<Pregunta> protocoloDePreguntas;
	//private int vecesFinalizado=0;
	private ArrayList<Respuesta> respuestas;
	private Estado estado;
	
	private String nombreDeLaEncuesta;
	
	
	public Encuesta(String nombre) {
		this.nombreDeLaEncuesta= nombre;
		this.encuestados= new ArrayList<Encuestado>();
		this.protocoloDePreguntas= new ArrayList<Pregunta>();
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
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
	}

	public void eliminarFormulario(Encuestado formulario) {
		this.encuestados.remove(formulario);
		
	}
	public int vecesFinalizado() {// queda mejor asi, sino teniamos una variable de mas alpedo
		return this.encuestados.size();
	}
	public ArrayList<Respuesta> getTodasLasRespuestas(){
		for(Encuestado f:encuestados) {
			respuestas.addAll(f.getRespuestasDelEncuestado());
		}
		return respuestas;
	}
	public ArrayList<Encuestado>getEncuestados(){// mas lendo este nombre uwu
		return (ArrayList<Encuestado>) this.encuestados;
	}
	public void comenzarEncuesta(Encuestado encuestado) {
		encuestado.setPreguntaActual(this.protocoloDePreguntas.get(1));
	}

	public String dameTuNombre(){
		return this.nombreDeLaEncuesta;
	}	
	
}



