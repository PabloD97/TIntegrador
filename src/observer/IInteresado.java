package observer;

import encuesta.Encuesta;
import preguntas.Pregunta;
import respuestas.Respuesta;

public interface IInteresado {

	public void meInteresa(Pregunta pregunta); 
    
	public void noMeInteresa(Pregunta pregunta);
	
	public void notificarmeRespuesta( Pregunta pregunta, Respuesta respuesta);
	public void notificarmePregunta(Pregunta p, String r);
	
}
