package encuestasDisponibles;

import java.util.List;

import encuesta.Encuesta;
import investigador.Investigador;

public interface IEncuesta {
	public List<Encuesta>dameLasEncuestas(Investigador investigador);
 }
