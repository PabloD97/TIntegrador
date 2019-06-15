package preguntas;

import java.util.ArrayList;
import java.util.List;

import respuestas.Respondible;

public class MultiplesOpciones extends Pregunta {
	
	protected List<Respondible> respuestas;

	

	public MultiplesOpciones(String pregunta2) {
		this.pregunta= pregunta2;
		
	}

	public List<String> getRespuestas(){
	List<String> stringDeRespuestas = new ArrayList<String>();
		for( Respondible respuesta: respuestas ) {
			stringDeRespuestas.add(respuesta.getRespuesta() );
		}
		
		return stringDeRespuestas ;
	}
}
