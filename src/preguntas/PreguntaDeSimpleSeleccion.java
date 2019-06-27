package preguntas;

import java.util.ArrayList;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaDeSimpleSeleccion extends Pregunta  {
	
	private Encuestado contenedor;
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

	public void responder( Respuesta respuesta ) {
		this.setRespuestaElegida(respuesta);
		this.contenedor.agregarRespuesta(respuesta);
		this.notificar(respuesta.getRespuesta());
		this.siSoyUltima();
		this.getSiguientePregunta().setPreguntaAnterior(this);
		
		
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
	
	

	
	

}
