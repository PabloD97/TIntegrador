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
		
		encuestado.agregarRespuesta(encuestado.getRespuestasElegidas().get(0));
		
		encuestado.setPreguntaActual( encuestado.getRespuestasElegidas().get(0).getSiguientePregunta() );
		
		
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		
	
		this.siSoyUltima(); 
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	/*
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void setRespuestaElegida(Respuesta respuesta) {
		this.respuestaElegida=respuesta;
	}
	
	
	
	
	
	
	
	
	
	
	
	public Respuesta getRespuestaElegida() {
		return this.respuestaElegida;
	}
	private void setRespuestaRedirige(Respuesta res) {
		this.respuestaElegida=res;
	}
	private void setPreguntaARediregir(Pregunta preg) {
		this.preguntaARedirigir=preg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void responder( Encuestado encuestado ) {
		this.setRespuestaElegida(encuestado.getRespuestasElegidas().get(0));
		encuestado.agregarRespuesta(encuestado.getRespuestasElegidas().get(0));
		this.notificarPregunta(encuestado.getRespuestasElegidas().get(0).getRespuesta());
		this.notificarRespuesta(encuestado.getRespuestasElegidas().get(0));
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		this.siSoyUltima(); 
		this.getSiguientePregunta().setPreguntaAnterior(this);
		}

	

}
*/