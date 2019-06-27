package estrategiasParaResponder;

import java.util.ArrayList;
import java.util.List;

import respuestas.Respuesta;

public class EPreguntaDeMultiplesOpciones extends EstrategiaParaResponder {

	private List<Respuesta>respuestas;
	
	public EPreguntaDeMultiplesOpciones(){
		this.respuestas= new ArrayList<Respuesta>();
	}
	
	public void elegirRespuesta(Respuesta r) {
		this.respuestas.add(r);
	}
	
	public void responder(Respuesta r) {
		
	}
}
