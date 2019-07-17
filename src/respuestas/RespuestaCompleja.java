package respuestas;

import preguntas.Pregunta;

public class RespuestaCompleja extends Respuesta {
	
	private Pregunta siguientePregunta;
	private Boolean soyUltima=false;

	public RespuestaCompleja(String textoRespuesta, Pregunta siguientePregunta) {
		super(textoRespuesta);
		this.siguientePregunta=siguientePregunta;
		
	}
	public RespuestaCompleja(String textoRespuesta) {
		super(textoRespuesta);
		this.setSoyUltima();
	}
	public Pregunta getSiguientePregunta() {
		Pregunta res=null;
		if(!this.soyUltimaRespuesta()) {
		res=this.siguientePregunta;
		}
		return res;
	}
	public boolean soyUltimaRespuesta() {
		return this.soyUltima;
	}
	public void setSoyUltima() {
		this.soyUltima=true;
	}
}
