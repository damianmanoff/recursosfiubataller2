
package ar.fi.uba.taller2.participacion.interfaces.materiales.ws.dummys;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MaterialesImplService", targetNamespace = "http://dummys.ws.materiales.interfaces.participacion.taller2.uba.fi.ar/", wsdlLocation = "http://200.68.65.249:58080/participacion/materiales?wsdl")
public class MaterialesImplService
    extends Service
{

    private final static URL MATERIALESIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException MATERIALESIMPLSERVICE_EXCEPTION;
    private final static QName MATERIALESIMPLSERVICE_QNAME = new QName("http://dummys.ws.materiales.interfaces.participacion.taller2.uba.fi.ar/", "MaterialesImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://200.68.65.249:58080/participacion/materiales?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MATERIALESIMPLSERVICE_WSDL_LOCATION = url;
        MATERIALESIMPLSERVICE_EXCEPTION = e;
    }

    public MaterialesImplService() {
        super(__getWsdlLocation(), MATERIALESIMPLSERVICE_QNAME);
    }

    public MaterialesImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MATERIALESIMPLSERVICE_QNAME, features);
    }

    public MaterialesImplService(URL wsdlLocation) {
        super(wsdlLocation, MATERIALESIMPLSERVICE_QNAME);
    }

    public MaterialesImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MATERIALESIMPLSERVICE_QNAME, features);
    }

    public MaterialesImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MaterialesImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IMateriales
     */
    @WebEndpoint(name = "MaterialesImplPort")
    public IMateriales getMaterialesImplPort() {
        return super.getPort(new QName("http://dummys.ws.materiales.interfaces.participacion.taller2.uba.fi.ar/", "MaterialesImplPort"), IMateriales.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IMateriales
     */
    @WebEndpoint(name = "MaterialesImplPort")
    public IMateriales getMaterialesImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://dummys.ws.materiales.interfaces.participacion.taller2.uba.fi.ar/", "MaterialesImplPort"), IMateriales.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MATERIALESIMPLSERVICE_EXCEPTION!= null) {
            throw MATERIALESIMPLSERVICE_EXCEPTION;
        }
        return MATERIALESIMPLSERVICE_WSDL_LOCATION;
    }

}
