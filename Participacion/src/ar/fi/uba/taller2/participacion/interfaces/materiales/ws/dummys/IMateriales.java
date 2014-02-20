
package ar.fi.uba.taller2.participacion.interfaces.materiales.ws.dummys;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import ar.fi.uba.taller2.participacion.interfaces.materiales.ws.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IMateriales", targetNamespace = "http://ws.materiales.interfaces.participacion.taller2.uba.fi.ar/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IMateriales {


    /**
     * 
     * @param ambitoId
     * @param usuarioId
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "puedeEditar", targetNamespace = "http://ws.materiales.interfaces.participacion.taller2.uba.fi.ar/", className = "ar.fi.uba.taller2.participacion.interfaces.materiales.ws.PuedeEditar")
    @ResponseWrapper(localName = "puedeEditarResponse", targetNamespace = "http://ws.materiales.interfaces.participacion.taller2.uba.fi.ar/", className = "ar.fi.uba.taller2.participacion.interfaces.materiales.ws.PuedeEditarResponse")
    @Action(input = "http://ws.materiales.interfaces.participacion.taller2.uba.fi.ar/IMateriales/puedeEditarRequest", output = "http://ws.materiales.interfaces.participacion.taller2.uba.fi.ar/IMateriales/puedeEditarResponse")
    public boolean puedeEditar(
        @WebParam(name = "usuarioId", targetNamespace = "")
        String usuarioId,
        @WebParam(name = "ambitoId", targetNamespace = "")
        long ambitoId);

}
