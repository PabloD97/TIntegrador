package investigador;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import encuestasDisponibles.IEstrategia;
import proyecto.Proyecto;


public class Investigador {
	
	
	private IEstrategia estrategia;
	private ArrayList<Proyecto> proyectos;
	
	

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
	
	public void notificar() {}
	
	public void setEstrategia(IEstrategia estrategia) {
		this.estrategia = estrategia;
	}
	
	public List<Encuesta> dameLasEncuestas(Investigador this){
		return estrategia.dameLasEncuestas(this);
	}
	
	
}








