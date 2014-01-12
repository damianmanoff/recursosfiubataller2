package connection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "parametro")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({EncuestaParameter.class})
public class Parameter {

	public static Parameter createParameter(String xml) {
		Parser parser = new Parser();
		Parameter p = (Parameter)parser.unmarshal(xml, Parameter.class);
		if (p != null) {
			return p;
		}
		return new Parameter();
		
	}
	
	public Parameter() {
		
	}

	@XmlElement (nillable = true)
	private Integer ambitoId;
	
	@XmlElement (nillable = true)
	private Integer usuarioId;
	
	@XmlElement (nillable = true)
	private Integer recursoId;
	
	public Integer getAmbitoId() {
		return ambitoId;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public Integer getRecursoId() {
		return recursoId;
	}

	public void setAmbitoId(Integer ambitoId) {
		this.ambitoId = ambitoId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public void setRecursoId(Integer recursoId) {
		this.recursoId = recursoId;
	}

	
	
}
