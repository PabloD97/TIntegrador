package investigador;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import encuestasDisponibles.IEstrategia;
import encuestasDisponibles.Las25MasContestadas;
import encuestasDisponibles.OrdenadasPorProyecto;
import encuestasDisponibles.Ultimas20Creadas;
import observer.IInteresado;
import proyecto.Proyecto;
import respuestas.Respuesta;


public class Investigador implements IInteresado{
	
	private List<Proyecto> proyectos;
	private List<Respuesta>subscripcionRespuestas;;
	
	
	private IEstrategia strategy;
	
	//
	private List<Encuesta>encuestas;
	
	

	public Investigador() {
		this.encuestas= new ArrayList<Encuesta>();
		this.proyectos = new ArrayList<Proyecto>();
		this.subscripcionRespuestas=new ArrayList<Respuesta>();
	}
	
	
	
	public void setEstragia(IEstrategia e) {
		this.strategy=e;
	}
	public List<Encuesta> filtrar(){
		return this.strategy.dameLasEncuestas(this);
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
	
	
	
	@Override
	public void meInteresa(Respuesta respuesta) {
		respuesta.agregarInteresado(this);
		this.subscripcionRespuestas.add(respuesta);
	}

	@Override
	public void noMeInteresa(Respuesta respuesta) {
		respuesta.sacarInteresado(this);		
		this.subscripcionRespuestas.remove(respuesta);
	}
	
	
	public List<Encuesta> getTodasLasEncuestas() {
		return this.encuestas;
	}
	
	
	
	public List<Respuesta> getSuscripciones(){
		return this.subscripcionRespuestas;
	}



	@Override
	public void notificar() {}



}








