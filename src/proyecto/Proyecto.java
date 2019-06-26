package proyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
	public Optional<Encuesta> laMasContestada() {
		return(encuestas.stream().max((e1,e2) -> Integer.compare(e1.vecesFinalizado(),e2.vecesFinalizado())));
	}
	
	public void agregarSubProyecto(Proyecto subProyecto) {		
		if(this.puedoAgregarProyecto(subProyecto)) {
			this.subProyectos.add(subProyecto);
		}
		else System.out.println("El proyecto no puede ser agregado");
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










