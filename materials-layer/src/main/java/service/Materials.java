package service;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.BindingType;

import model.Encuesta;
import model.EncuestaRespondida;
import model.Link;


@BindingType(value = javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
@WebService
public interface Materials {

	@WebMethod
	String sayHello(String name);
	
	@WebMethod 
	@WebResult(name = "recursos")
	String getRecursos(@WebParam(name = "ambitoId") int ambitoId, @WebParam(name = "recursoId")int usuarioId);
		
	@WebMethod 
	@WebResult(name = "encuesta")
	String getEncuesta(@WebParam(name = "ambitoId")int ambitoId, @WebParam(name = "recursoId")int recursoId);
	
	@WebMethod
	@WebResult(name = "encuestaRespondida")
	String getEncuestaRespondida(@WebParam(name = "ambitoId")int ambitoId, @WebParam(name = "recursoId") int recursoId,@WebParam(name="usuarioId") int usuarioId);
	
	@WebMethod
	@WebResult(name = "encuestaRespondida")
	String getEncuestaRespondida(@WebParam(name = "parametros")String parametros);

	@WebMethod
	void agregarEncuestaRespondida(@WebParam(name = "encuestaRespondida") EncuestaRespondida respondida, @WebParam(name = "ambitoId") int ambitoId);

	@WebMethod
	@WebResult(name = "agregarLink")
	String agregarLink(@WebParam(name = "link") Link link, @WebParam(name = "usuarioId") int usuarioId);

	@WebMethod
	void agregarEncuesta(@WebParam(name = "encuesta") Encuesta encuesta, @WebParam(name = "usuarioId") int usuarioId);
	
	@WebMethod
	@WebResult(name = "successString")
	String setArchivo(@WebParam(name = "ambitoId")int ambitoId, @WebParam(name = "nombre")String name, @WebParam(name = "extension")String ext, @WebParam(name = "archivo") @XmlMimeType("application/octet-stream") DataHandler data);

	@WebMethod
	@WebResult(name = "borrado")
	String borrarRecurso(@WebParam(name = "ambitoId") int ambitoId, @WebParam(name = "recursoId") int recursoId, @WebParam(name = "usuarioId") int usuarioId);

	@WebMethod
	@WebResult(name = "archivo")
	String getArchivo(@WebParam(name = "ambitoId") int ambitoId, @WebParam(name = "recursoId") int recursoId);
}