package observer;

import encuesta.Encuesta;
import preguntas.Pregunta;
import respuestas.Respuesta;

public interface IInteresado {

	public void meInteresa(Pregunta pregunta); 
    
	public void noMeInteresa(Pregunta pregunta);
	
	public void notificarme(Encuesta encuesta, Pregunta pregunta, String respuesta);
	
}
