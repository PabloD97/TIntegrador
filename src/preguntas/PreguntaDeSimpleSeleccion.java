package preguntas;

import java.util.ArrayList;
import java.util.List;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaDeSimpleSeleccion extends Pregunta  {
	
	
	private Respuesta respuestaElegida;
	private Respuesta respuestaQueRedirige;
	private Pregunta  preguntaARedirigir;
	private List<Respuesta> respuestas;

	public PreguntaDeSimpleSeleccion(String preg, Pregunta siguientePregunta) {
		super(preg, siguientePregunta);
	}
	
	@Override
	public Pregunta getSiguientePregunta() {
		Pregunta res;
		if(this.respuestaElegida==this.respuestaQueRedirige) {
			res=this.preguntaARedirigir;
		}
		else {
			res= super.getSiguientePregunta();
		}
		return res;
	}
	
	public void addRespuesta(Respuesta respuesta) {
		respuestas.add(respuesta);
	}

	

	public void setRespuestaElegida(Respuesta respuesta) {
		this.respuestaElegida=respuesta;
	}
	
	
	public String getRespuesta() {
		return respuestaElegida.getRespuesta();
	}
	private void setRespuestaRedirige(Respuesta res) {
		this.respuestaElegida=res;
	}
	private void setPreguntaARediregir(Pregunta preg) {
		this.preguntaARedirigir=preg;
	}
	
	public void elegirRespuesta(Respuesta respuesta, Encuestado e) {
		e.elegirRespuesta(respuesta);
	}
	/*public void responder(Encuestado e) {
		//Lo inicializo en null dado que doy por sentado que si no elije alguna opcion no va a poder responder
		String res = null;
		
		for(Respuesta r :e.getRespuestasElegidas()) {
			e.agregarRespuesta(r);
			this.notificarRespuesta(r);
			res+=r.getRespuesta();
			}
		this.notificarPregunta(res);
		
		e.getRespuestasElegidas().removeAll(e.getRespuestasElegidas());
		this.getSiguientePregunta().setPreguntaAnterior(this);
		this.siSoyUltima();
		*/
	@Override
	public void responder( Encuestado encuestado ) {
		this.setRespuestaElegida(encuestado.getRespuestasElegidas().get(0));
		
		encuestado.agregarRespuesta(encuestado.getRespuestasElegidas().get(0));
		
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		
		this.notificarPregunta(encuestado.getRespuestasElegidas().get(0).getRespuesta());
		
		this.siSoyUltima(); 
		//this.getSiguientePregunta().setPreguntaAnterior(this);
		
		 
	}

	
	

}
