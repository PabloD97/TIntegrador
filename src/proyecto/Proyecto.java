package proyecto;

import java.awt.List;
import java.util.ArrayList;
import java.util.Optional;

import encuesta.Encuesta;


public class Proyecto {
	
	private String descripcion;
	private String proposito;
	protected ArrayList<Encuesta> encuestas;
	protected ArrayList<Proyecto> subProyectos;
	
	
	
	public Proyecto(String descripcion, String proposito) {
		super();
		this.descripcion = descripcion;
		this.proposito = proposito;
		this.encuestas = new ArrayList<Encuesta>();
	}

	public String getProposito() {
		return proposito;
		
	}

	public String getDescripcion() {
		return descripcion;
		
	}

	public ArrayList<Encuesta> getEncuestas() {
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

	public ArrayList<Proyecto> getSubProyectos() {
		return this.subProyectos;
	}
	
	public ArrayList<Encuesta> encuestasPorOrdenAlfabetico(){		
		//ArrayList<Encuesta> ordenadasAlfabeticamente = new ArrayList<Encuesta>();	
	//	return collecction//
	}
	
	
}










