package observer;

import java.util.List;

import respuestas.Respuesta;

public interface IInteresado {

	public void meInteresa(Respuesta respuesta); 
    
	public void noMeInteresa(Respuesta respuesta);
	//Funcionaria como update. No confundir por el nombre 
	public void notificar();

	public List<Respuesta> getSuscripciones();
	
}
