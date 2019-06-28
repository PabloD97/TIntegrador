package preguntas;

import java.util.ArrayList;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaDeSimpleSeleccion extends Pregunta  {
	
	
	private Respuesta respuestaElegida;
	private Respuesta respuestaQueRedirige;
	private Pregunta  preguntaARedirigir;
	private ArrayList<Respuesta> respuestas;

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
	public void responder( Respuesta respuesta,Encuestado encuestado ) {
		this.setRespuestaElegida(respuesta);
		encuestado.agregarRespuesta(respuesta);
		this.notificarPregunta(respuesta.getRespuesta());
		
		this.siSoyUltima();
		this.getSiguientePregunta().setPreguntaAnterior(this);
		
		
	}
	@Override
	public void responder(Encuestado e) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	

}
