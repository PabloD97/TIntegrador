package observer;

import java.util.List;

import preguntas.Pregunta;
import respuestas.Respuesta;

public interface IInteresado {

	public void meInteresa(Pregunta pregunta); 
    
	public void noMeInteresa(Pregunta pregunta);
	// nnotificar no hace nada
	public void notificarmeRespuesta( Pregunta pregunta, Respuesta respuesta);
	public void notificarmePregunta(Pregunta p, String r);

	public List<Respuesta> getSuscripciones();
	
}
