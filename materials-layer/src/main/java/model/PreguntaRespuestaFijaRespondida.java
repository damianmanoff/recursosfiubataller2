package model;

import java.util.List;

public class PreguntaRespuestaFijaRespondida extends PreguntaRespondida{

  public PreguntaRespuestaFijaRespondida(Integer idPregunta) {
		super(idPregunta);
	}

public List<Integer> respuestas;

  public void responder(List<Integer> respuestas) {
	  this.respuestas=respuestas;
  }

public List<Integer> getRespuestas() {
	return respuestas;
}

//andy.. hay que usar polimorfismo...
//@Override
//public Integer evaluar(PreguntaRespuestaACompletar pregunta) {
//	return null;
//}
//
//@Override
//public Integer evaluar(PreguntaRespuestaFija preguntaFija) {
//	if(preguntaFija.getRespuestasCorrectas().size()!=this.getRespuestas().size())
//		return 0;
//	for(int i=0;i<preguntaFija.getRespuestasCorrectas().size();i++){
//		//Chequeo una por una que las respuestas sean las mismas
//		if(preguntaFija.getRespuestasCorrectas().get(i).compareTo(this.getRespuestas().elementAt(i))!=0){
//			return 0;
//		}
//	}
//		return 1;
//}

@Override
public Integer evaluar(Pregunta pregunta) {
	//andy.. simplificate la vida...
	for (Integer respuesta: respuestas) {
		if (! pregunta.isCorrect(respuesta)){
			return 0;
		}
	}
	return 1;
}
}