package connection;

import java.rmi.RemoteException;
import java.util.ArrayList;

import model.Encuesta;
import model.EncuestaRespondida;

import org.apache.axis2.AxisFault;

import com.ws.services.IntegracionWSStub;
import com.ws.services.IntegracionWSStub.GuardarDatos;
import com.ws.services.IntegracionWSStub.GuardarDatosResponse;
import com.ws.services.IntegracionWSStub.SeleccionarDatos;
import com.ws.services.IntegracionWSStub.SeleccionarDatosResponse;


public class EncuestaRequester {
	
	public static int MAX_ITEMS_LIST = 10;
	
	private IntegracionWSStub stub;
	private EncuestaParser parser;
	private ArrayList<Encuesta> cacheEncuestas;
	private int indexToReplace;
	private ArrayList<EncuestaRespondida> cacheEncuestasRespondidas;
	private int indexToReplaceRespondidas;
	
	
	public EncuestaRequester() {
		this.parser = new EncuestaParser();
		this.cacheEncuestas = new ArrayList<Encuesta>();
		this.cacheEncuestasRespondidas = new ArrayList<EncuestaRespondida>();
		this.indexToReplace = 0;
		this.indexToReplaceRespondidas = 0;
    	try {
	    	this.stub = new IntegracionWSStub();
    	} catch (AxisFault e) {
            e.printStackTrace();
    	}
	}
	
	public void save(Encuesta encuesta) {
		// Guardo la encuesta
		String encuesta_str = this.parser.serializeEncuesta(encuesta);
    	try {
	    	GuardarDatos guardar = new GuardarDatos();
	    	guardar.setXml(encuesta_str);
	    	GuardarDatosResponse g_resp = this.stub.guardarDatos(guardar);
	    	System.out.println(g_resp.get_return());
    	} catch (AxisFault e) {
            e.printStackTrace();
    	} catch (RemoteException e) {
            e.printStackTrace();
    	}
    	
    	// Agrego al cache de encuestas
    	this.addToCacheEncuestas(encuesta);
	}
	
	public void saveRespondida(EncuestaRespondida respondida) {
		// Guardo la encuesta respondida
		String encuesta_str = this.parser.serializeEncuestaRespondida(respondida);
    	try {
	    	GuardarDatos guardar = new GuardarDatos();
	    	guardar.setXml(encuesta_str);
	    	GuardarDatosResponse g_resp = this.stub.guardarDatos(guardar);
	    	System.out.println(g_resp.get_return());
    	} catch (AxisFault e) {
            e.printStackTrace();
    	} catch (RemoteException e) {
            e.printStackTrace();
    	}
    	
    	// Agrego al cache de encuestas respondidas
    	this.addToCacheEncuestasRespondidas(respondida);
	}
	
	public Encuesta get(int IDAmbiente, int IDEncuesta) {
		// Busco en el cache de encuestas
		Encuesta encuesta = this.searchCachedEncuesta(IDAmbiente, IDEncuesta);
		if (encuesta != null) {
			return encuesta;
		} else {
	    	try {
				// Consulto la encuesta guardada
	    		String xml = this.parser.serializeEncuestaQuery(IDAmbiente, IDEncuesta);
		    	SeleccionarDatos seleccionar_e = new SeleccionarDatos();
		    	seleccionar_e.setXml(xml);
		    	SeleccionarDatosResponse s_resp_e = this.stub.seleccionarDatos(seleccionar_e);
		    	String xml_resp_e = s_resp_e.get_return();
		    	encuesta = this.parser.deserializeEncuesta(xml_resp_e);
		    	
		    	// Agrego al cache de encuestas
		    	this.addToCacheEncuestas(encuesta);
		    	
		    	return encuesta;
	    	} catch (AxisFault e) {
	            e.printStackTrace();
	    	} catch (RemoteException e) {
	            e.printStackTrace();
	    	}
		}
    	return null;
	}
	
	private void addToCacheEncuestas(Encuesta encuesta) {
		if (this.cacheEncuestas.size() < EncuestaRequester.MAX_ITEMS_LIST) {
			this.cacheEncuestas.add(encuesta);
		} else {
			this.cacheEncuestas.set(this.indexToReplace, encuesta);
			if (this.indexToReplace < (EncuestaRequester.MAX_ITEMS_LIST - 1)) {
				this.indexToReplace++;
			} else {
				this.indexToReplace = 0;
			}
		}
	}
	
	private void addToCacheEncuestasRespondidas(EncuestaRespondida respondida) {
		if (this.cacheEncuestasRespondidas.size() < EncuestaRequester.MAX_ITEMS_LIST) {
			this.cacheEncuestasRespondidas.add(respondida);
		} else {
			this.cacheEncuestasRespondidas.set(this.indexToReplaceRespondidas, respondida);
			if (this.indexToReplaceRespondidas < (EncuestaRequester.MAX_ITEMS_LIST - 1)) {
				this.indexToReplaceRespondidas++;
			} else {
				this.indexToReplaceRespondidas = 0;
			}
		}
	}
	
	private Encuesta searchCachedEncuesta(int IDAmbiente, int IDEncuesta) {
		Encuesta encuesta = null;
		int i = 0;
		Boolean found = false;
		while ((!found) && (i<this.cacheEncuestas.size())) {
			if ((this.cacheEncuestas.get(i).getIdAmbiente() == IDAmbiente) && (this.cacheEncuestas.get(i).getIdRecurso() == IDEncuesta)) {
				encuesta = this.cacheEncuestas.get(i);
				found = true;
			}
			i++;
		}
		return encuesta;
	}
	
}