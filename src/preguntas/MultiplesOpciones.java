package preguntas;


import java.util.List;

import encuestado.Encuestado;
import respuestas.Respuesta;


public abstract class MultiplesOpciones extends Pregunta {
	
	
	public abstract void elegirRespuesta(Respuesta res, Encuestado enc);
	
	protected List<Respuesta> respuestas;

	

	public MultiplesOpciones(String pregunta2) {
		super(pregunta2);
		
	}
	

	public List<Respuesta> getRespuestas(){
		return this.respuestas;
	}
		
	
	/*
	@Override 
	public void agregarInteresado(Investigador interesado) {
		this.interesados.add(interesado);
		for(Respuesta r : respuestas) {
			interesado.subscribirseRespuesta(r);
		}
		
	}
	public boolean estaSuscripto(IInteresado i, Respuesta r) {
		return i.getSuscripciones().contains(r);
	}
	public void notificarRespuesta( Respuesta respuesta) {
		
		for( IInteresado interesado: interesados ) {
			if(this.estaSuscripto(interesado, respuesta)) {
			interesado.notificarmeRespuesta(this, respuesta);
			}
		}
	}

	*/

	@Override
	public void responder(Encuestado e) {
		// TODO Auto-generated method stub
		
	}


	protected abstract void addRespuesta(Respuesta respuesta);


	protected abstract List<Respuesta> getOpciones();
	
}