package preguntas;


import java.util.ArrayList;
import java.util.List;

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
}