package preguntas;

import java.util.ArrayList;
import java.util.List;

import contenedor.Encuestado;
import respuestas.Respuesta;

public class PreguntaDeMultipleSeleccion extends MultiplesOpciones {

    private	ArrayList<Respuesta>respuestaElegidas;
	
	private Encuestado contenedorDeRespuestas;
	private ArrayList<Respuesta> respuestas= new ArrayList<Respuesta>();
	
	public PreguntaDeMultipleSeleccion(String pregunta2,  Encuestado contenedor) {
		super(pregunta2);
		this.contenedorDeRespuestas = contenedor;
		this.respuestas = new ArrayList<Respuesta>();
		this.respuestaElegidas= new ArrayList<Respuesta>();
	}

	public void addRespuesta(Respuesta respuesta) {
		respuestas.add(respuesta);
	}
	
	public ArrayList<Respuesta> getRespuestasElegidas(){
		return this.respuestaElegidas;
	}
	
	public void elegirRespuesta(Respuesta respuestaCerrada1) {
		respuestaElegidas.add(respuestaCerrada1);
	}
	
	public void responder(   ) {
		for( Respuesta respuesta : respuestaElegidas ) {
			contenedorDeRespuestas.addRespuesta(respuesta );
			this.getSiguientePregunta().setPreguntaAnterior(this);
		}
		this.respuestaElegidas.removeAll(respuestaElegidas);
		this.siSoyUltima();
	    
	}

	

	
}
