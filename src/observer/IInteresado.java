package observer;

import java.util.List;

import respuestas.Respuesta;

public interface IInteresado {

	public void meInteresa(Respuesta respuesta); 
    
	public void noMeInteresa(Respuesta respuesta);
	
	

	public List<Respuesta> getSuscripciones();
	
}
