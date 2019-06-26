package investigador;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import encuestasDisponibles.Las25MasContestadas;
import encuestasDisponibles.OrdenadasPorProyecto;
import encuestasDisponibles.Ultimas20Creadas;
import observer.IInteresado;
import preguntas.Pregunta;
import proyecto.Proyecto;
import respuestas.Respuesta;


public class Investigador implements IInteresado{
	
	private List<Proyecto> proyectos;
	private List<String>subscripcionRespuestas=new ArrayList<String>();
	private Las25MasContestadas masContestadas = new Las25MasContestadas();
	private OrdenadasPorProyecto ordenadas = new OrdenadasPorProyecto();
	private Ultimas20Creadas ultimasCreadas = new Ultimas20Creadas();
	
	//
	private List<Encuesta>encuestas;
	
	

	public Investigador() {
		this.encuestas= new ArrayList<Encuesta>();
		this.proyectos = new ArrayList<Proyecto>();
	}
	
	
	

	public List<Proyecto> getProyectos() {
		return proyectos;	
	}

	public void agregarProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
		this.encuestas.addAll(proyecto.getEncuestas());
	}
	
	public void darDeBajaProyecto(Proyecto proyecto) {
		this.proyectos.remove(proyecto);
		this.encuestas.removeAll(proyecto.getEncuestas());
	}
	


	// mensajes nuevos, correspondientes al hito 2
	
	public List<Encuesta> dameLas25MasContestadas() {
		return this.masContestadas.dameLasEncuestas(this);
	}
	
	public List<Encuesta> damelasOrdenadasPorProyectos() {
		return this.ordenadas.dameLasEncuestas(this);
	}

	public List<Encuesta> dameLasUltimas20Creadas() {
		return this.ultimasCreadas.dameLasEncuestas(this);
	}
	
	@Override
	public void meInteresa(Pregunta pregunta) {
		pregunta.agregarInteresado(this);
		
	}

	@Override
	public void noMeInteresa(Pregunta pregunta) {
		pregunta.sacarInteresado(this);		
	}
	@Override
	public void notificarme(Encuesta encuesta, Pregunta pregunta, String respuesta) {
		System.out.println("La pregunta" + pregunta.getPregunta() + "de la encuesta" 
		+ pregunta.getEncuesta()
		+ "Tuvo la siguiente respuesta" + respuesta);
		
	}
	
	public List<Encuesta> getTodasLasEncuestas() {
		return this.encuestas;
	}
	
	
	//Sobre entendiendo que solamente se va a poder suscribir si la respuesta esta en la pregunta
	public void subscribirseRespuesta(Respuesta res) {
		this.subscripcionRespuestas.add(res.getRespuesta());
	}
	public List<String> getSuscripciones(){
		return this.subscripcionRespuestas;
	}


	
}








