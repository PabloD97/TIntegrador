package investigador;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import encuestasDisponibles.IEstrategia;
import encuestasDisponibles.Las25MasContestadas;
import encuestasDisponibles.OrdenadasPorProyecto;
import encuestasDisponibles.Ultimas20Creadas;
import observer.Iinteresado;
import preguntas.Pregunta;
import proyecto.Proyecto;
import respuestas.Respuesta;


public class Investigador implements Iinteresado{
	
	private ArrayList<Proyecto> proyectos;
	private ArrayList<String>subscripcionRespuestas=new ArrayList<String>();
	private Las25MasContestadas masContestadas = new Las25MasContestadas();
	private OrdenadasPorProyecto ordenadas = new OrdenadasPorProyecto();
	private Ultimas20Creadas ultimasCreadas = new Ultimas20Creadas();
	
	
	

	public Investigador() {
		this.proyectos = new ArrayList<Proyecto>();
	}
	
	public Investigador( ArrayList<Proyecto> proyecto) {
		this.proyectos = proyecto;
	}

	public ArrayList<Proyecto> getProyectos() {
		return proyectos;	
	}

	public void sumarProyectoALaLista(Proyecto proyecto) {
		this.proyectos.add(proyecto);
	}
	
	public void darDeBajaProyecto(Proyecto proyecto) {
		this.proyectos.remove(proyecto);
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
		System.out.println("La pregunta" + pregunta.getPregunta() + "de la encuesta" + pregunta.getPregunta() + "Tuvo la siguiente respuesta" + respuesta);
		
	}
	
	public List<Encuesta> getTodasLasEncuestas() {
		List<Encuesta> ls = new ArrayList<Encuesta>();
		for(Proyecto p : proyectos) {
		 for(Encuesta e : p.getEncuestas()) {
			 ls.add(e);
		 }
		}
		return ls;
	}
	//Sobre entendiendo que solamente se va a poder suscribir si la respuesta esta en la pregunta
	public void subscribirseRespuesta(Respuesta res) {
		this.subscripcionRespuestas.add(res.getRespuesta());
	}
	public ArrayList<String> getSuscripciones(){
		return this.subscripcionRespuestas;
	}
	
}








