package preguntas;


import java.util.ArrayList;
import java.util.List;

import encuestado.Encuestado;
import investigador.Investigador;
import respuestas.Respuesta;


public class MultiplesOpciones extends Pregunta {
	
	protected List<Respuesta> respuestas;

	

	public MultiplesOpciones(String pregunta2, Pregunta sigPregunta) {
		super(pregunta2,sigPregunta);
		
	}
	

	public List<String> getRespuestas(){
	List<String> stringDeRespuestas = new ArrayList<String>();
		for( Respuesta respuesta: respuestas ) {
			stringDeRespuestas.add(respuesta.getRespuesta() );
		}
		
		return stringDeRespuestas ;
	}
	
	@Override 
	public void agregarInteresado(Investigador interesado) {
		this.interesados.add(interesado);
		for(Respuesta r : respuestas) {
			interesado.subscribirseRespuesta(r);
		}
		
	}
	public boolean estaSuscripto(Investigador i, Respuesta r) {
		return i.getSuscripciones().contains(r);
	}
	public void notificarRespuesta( Respuesta respuesta) {
		
		for( Investigador interesado: interesados ) {
			if(this.estaSuscripto(interesado, respuesta)) {
			interesado.notificarmeRespuesta(this, respuesta);
			}
		}
	}


	@Override
	public void responder(Encuestado e) {
		// TODO Auto-generated method stub
		
	}
	
}