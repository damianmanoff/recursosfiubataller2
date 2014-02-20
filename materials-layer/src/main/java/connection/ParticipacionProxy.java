package connection;

import com.ws.services.participacion.dummys.IMateriales;
import com.ws.services.participacion.dummys.MaterialesImplService;

import connection.exceptions.ConnectionException;


        
public class ParticipacionProxy {
	private static IMateriales port;
//	private MaterialesImplServiceStub stub;

	
	public ParticipacionProxy() {
//		try {
//			stub = new MaterialesImplServiceStub();
//		} catch (AxisFault e) {
//			System.out.println("Error al intentar contectarse con Participacion");
//		}
		MaterialesImplService service = new MaterialesImplService();
        port = service.getMaterialesImplPort();
	}
	
	public boolean puedeEditar(int ambitoId, int usuarioId) throws ConnectionException {
//		MaterialesImplServiceStub.PuedeEditar editar = new MaterialesImplServiceStub.PuedeEditar();
//		editar.setAmbitoId(ambitoId);
//		editar.setUsuarioId(Integer.toString(usuarioId)); // UsuarioId String??
//		MaterialesImplServiceStub.PuedeEditarE editar_e = new MaterialesImplServiceStub.PuedeEditarE();
//		editar_e.setPuedeEditar(editar);
//		MaterialesImplServiceStub.PuedeEditarResponseE p_resp_e;
//
//		try {
//			p_resp_e = stub.puedeEditar(editar_e);
//			return p_resp_e.getPuedeEditarResponse().get_return();
//		} catch (AxisFault e) {
//			throw new ConnectionException("Fallo en la conexion con Presentacion, reintente luego. ");
//		} catch (RemoteException e) {
//			throw new ConnectionException("No se pudo conectar al servicio Presentacion. ");
//		}
		try {
		return port.puedeEditar(Integer.toString(usuarioId), ambitoId);
		} catch (Exception e){
			throw new ConnectionException("Fallo en la conexion con Presentacion, reintente luego. ");
		}
	}
	
}