package preguntas;

import java.util.ArrayList;
import java.util.List;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaDeSimpleSeleccion extends MultiplesOpciones  {
	

	protected List<Respuesta> respuestas;

	
	
	public PreguntaDeSimpleSeleccion(String preg) {
		super(preg);
		this.respuestas = new ArrayList<Respuesta>();
		
	}
	

	@Override
	public void addRespuesta(Respuesta respuesta) {
		this.respuestas.add(respuesta);
	}

	@Override
	public List<Respuesta> getOpciones(){
		return this.respuestas;
	}
	
	@Override
	public void elegirRespuesta(Respuesta respuestaCerrada1, Encuestado e) {
		e.elegirRespuesta(respuestaCerrada1);
	}

	@Override
	public void responder( Encuestado encuestado ) {
		
		encuestado.getRespuestasElegidas().get(0).getSiguientePregunta().setPreguntaAnterior(this);

		
		encuestado.agregarRespuesta(encuestado.getRespuestasElegidas().get(0));
		
		encuestado.setPreguntaActual( encuestado.getRespuestasElegidas().get(0).getSiguientePregunta() );
		
		encuestado.getRespuestasElegidas().get(0).notificar();
		
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		
	
		this.siSoyUltima(); 	
	}	
}
