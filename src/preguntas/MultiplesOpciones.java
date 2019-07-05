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
	


	

	@Override
	public void responder(Encuestado e) {
		// TODO Auto-generated method stub
		
	}


	public abstract void addRespuesta(Respuesta respuesta);


	public abstract List<Respuesta> getOpciones();
	
}