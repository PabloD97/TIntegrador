package preguntas;

import java.util.ArrayList;
import java.util.List;

import encuestado.Encuestado;
import respuestas.Respuesta;

public class PreguntaDeSimpleSeleccion extends MultiplesOpciones  {
	
	/*
	private Respuesta respuestaElegida;
	private Respuesta respuestaQueRedirige;
	private Pregunta  preguntaARedirigir;
*/
	protected List<Respuesta> respuestas;

	
	public PreguntaDeSimpleSeleccion(String preg/*-Pregunta siguientePregunta*/) {
		super(preg);
		this.respuestas = new ArrayList<Respuesta>();
		//this.siguientePregunta= siguientePregunta;
	}
	
	public void addRespuesta(Respuesta respuesta) {
		respuestas.add(respuesta);
	}
	
	public List<Respuesta> getOpciones(){
		return this.respuestas;
	}
	
	
	public void elegirRespuesta(Respuesta respuestaCerrada1, Encuestado e) {
		e.elegirRespuesta(respuestaCerrada1);
	}
	/*
	public void setRespuestaElegida(Respuesta respuesta) {
		this.respuestaElegida=respuesta;
	}
/*
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
	public void setRedireccion(Respuesta r,Pregunta p) {
		this.respuestaElegida=r;
		this.preguntaARedirigir=p;
	}*/
	@Override
	public void responder( Encuestado encuestado ) {
		
		//this.setRespuestaElegida(encuestado.getRespuestasElegidas().get(0));
		
		encuestado.agregarRespuesta(encuestado.getRespuestasElegidas().get(0));
		encuestado.setPreguntaActual( encuestado.getRespuestasElegidas().get(0).getSiguientePregunta() );
		
		
		encuestado.getRespuestasElegidas().removeAll(encuestado.getRespuestasElegidas());
		
	
		this.siSoyUltima(); 
		
		//this.getSiguientePregunta().setPreguntaAnterior(this);
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