package proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import encuesta.Encuesta;


public class Proyecto {
	
	protected List<Encuesta> encuestas;
	protected List<Proyecto> subProyectos;
	private String descripcion;
	private String proposito;
	
	
	
	
	
	public Proyecto(String descripcion, String proposito) {
		super();
		this.descripcion = descripcion;
		this.proposito = proposito;
		this.encuestas = new ArrayList<Encuesta>();
		this.subProyectos= new ArrayList<Proyecto>();
	}

	public String getProposito() {
		return proposito;
		
	}

	public String getDescripcion() {
		return descripcion;
		
	}

	public List<Encuesta> getEncuestas() {
		return encuestas;
		
	}
	public void agregarUnaEncuesta(Encuesta encuesta) {
		encuestas.add(encuesta);
	}
	public Encuesta encuestaMasContestada() {
		List<Encuesta> encuestas= this.getEncuestas();
		Collections.sort(encuestas, (encuesta1, encuesta2) -> encuesta1.vecesFinalizado().compareTo(encuesta2.vecesFinalizado()));
		Collections.reverse(encuestas);
		return encuestas.get(0);
	}
	
	public void agregarSubProyecto(Proyecto subProyecto) {		
		if(this.puedoAgregarProyecto(subProyecto)) {
			this.subProyectos.add(subProyecto);
		}
	}
	
	public void removerSubProyecto(Proyecto subProyecto) {
		this.subProyectos.remove(subProyecto);
	}
    
	public boolean puedoAgregarProyecto(Proyecto subProyecto) {
		return !this.getSubProyectos().contains(subProyecto);
	}

	public List<Proyecto> getSubProyectos() {
		return this.subProyectos;
	}
	
	public List<Encuesta> encuestasPorOrdenAlfabetico(){// Esto daria las encuestas ordenadas alfabeticamente
		List<Encuesta> ordenadas = this.getEncuestas();
		 
		Collections.sort(ordenadas, (encuesta1, encuesta2) -> encuesta1.dameTuNombre() .compareTo(encuesta2.dameTuNombre() ));
		
		return ordenadas;
	} 
	
	
}










