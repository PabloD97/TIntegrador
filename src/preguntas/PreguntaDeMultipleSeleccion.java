package preguntas;


import java.util.ArrayList;
import java.util.List;

import encuestado.Encuestado;
import respuestas.Respuesta;


public class PreguntaDeMultipleSeleccion extends MultiplesOpciones {

	private Pregunta siguientePregunta;
	private List<Respuesta> respuestas;
	
	public PreguntaDeMultipleSeleccion(String pregunta2,  Pregunta siguientePregunta) {
		super(pregunta2);
		this.respuestas = new ArrayList<Respuesta>();
		this.siguientePregunta=siguientePregunta;
	}

	
	@Override
	public void addRespuesta(Respuesta respuesta) {
		respuestas.add(respuesta);
	}
	@Override
	public List<Respuesta> getOpciones(){
		return this.respuestas;
	}
	@Override
	public void elegirRespuesta(Respuesta respuestaCerrada1, Encuestado e) {
		e.elegirRespuesta(respuestaCerrada1);
	}
	public Pregunta getSiguientePregunta() {
		Pregunta res=null;
		if(!this.esUltimaPregunta) {
		res=this.siguientePregunta;
		}
		return res;
	}
	
	@Override
	public void responder(Encuestado encuestado) {
		for(Respuesta r :encuestado.getRespuestasElegidas()) {
			encuestado.agregarRespuesta(r);
		}
		
		this.getSiguientePregunta().setPreguntaAnterior(this);

		
		encuestado.setPreguntaActual( this.getSiguientePregunta() );
		
		encuestado.getRespuestasElegidas().get(0).notificar();

		
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		
		
	}
 
}