package estrategiasParaResponder;

import respuestas.Respuesta;

public class EPreguntaAbierta extends EstrategiaParaResponder {
	private Respuesta respuesta;
	
	public EPreguntaAbierta() {}

	public void escribirRespuesta(String respuesta) {
		this.respuesta = new Respuesta(respuesta);
	}
	
	
}
