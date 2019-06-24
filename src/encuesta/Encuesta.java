package encuesta;

import java.util.ArrayList;
import java.util.Date;

import estadosDeLaEncuesta.Estado;

import respuestas.Respuesta;

import java.util.List;

import encuestado.Encuestado;
import preguntas.Pregunta;

public class Encuesta {
 
	
	// cambie tdas a list ya que hay que pensar en interfaces
	private List<Encuestado> encuestados;
	private List<Pregunta> protocoloDePreguntas;
	private List<Respuesta> respuestas;
	private Estado estado;
	private Date fechaDeCreacion;
	private String nombreDeLaEncuesta;
	
	
	@SuppressWarnings("deprecation")
	public Encuesta(String nombre,int anio,int mes, int dia) {
		this.nombreDeLaEncuesta= nombre;
		this.encuestados= new ArrayList<Encuestado>();
		this.protocoloDePreguntas= new ArrayList<Pregunta>();
		this.fechaDeCreacion= new Date(anio,mes,dia);
	}
	
	
	
	public Estado getEstado() {
		return this.estado.getEstado();//queda bien asi?
	}
	
	// modifique este metodo para que los state conozcan a la encuesta
	public void setEstado(Estado estado) {
		this.estado = estado;
		estado.setearEncuesta(this);
	}
	
	public Date getDate() {
		return this.fechaDeCreacion;
	}
	
	public void addPregunta(Pregunta pregunta) {
		this.estado.agregarPregunta(pregunta);
	}
	
	public void eliminarPregunta(Pregunta pregunta) {
		this.estado.eliminarPregunta(pregunta);
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
	public Integer vecesFinalizado() {// queda mejor asi, sino teniamos una variable de mas alpedo
		return this.encuestados.size();
	}
	public List<Respuesta> getTodasLasRespuestas(){
		for(Encuestado f:encuestados) {
			respuestas.addAll(f.getRespuestasDelEncuestado());
		}
		return respuestas;
	}
	public ArrayList<Encuestado>getEncuestados(){// mas lendo este nombre uwu
		return (ArrayList<Encuestado>) this.encuestados;
	}
	public void comenzarEncuesta(Encuestado encuestado) {
		encuestado.setPreguntaActual(this.protocoloDePreguntas.get(0));
	}

	
	
	public String dameTuNombre(){
		return this.nombreDeLaEncuesta;
	}	
	
	
	
	
	
	
	
	
	
	
}



