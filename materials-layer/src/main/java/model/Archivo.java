package model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.istack.ByteArrayDataSource;

//@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Archivo extends Recurso {

	public Archivo(Integer idRecurso, Integer idAmbiente, String descripcion) {
		super(idRecurso, idAmbiente, descripcion);
		this.tipo="Archivo";
		// TODO Auto-generated constructor stub
	}

	public Archivo() {
		this.tipo="Archivo";
	}

//	private String path;
	@XmlTransient
	private Integer tamanio;
	
	@XmlElement
	private String tipoArchivo;
	@XmlElement
	private String nombreArchivo;
	
//	@XmlTransient
	@XmlElement
	@XmlMimeType("application/octet-stream")
	private DataHandler rawFile;
//	@XmlElement
	@XmlTransient
	private byte[] fileBinary;
//	@XmlElement
	@XmlTransient
	private String contentType;
//	@XmlElement
	@XmlTransient
	private String stringFile;
	
    public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTipoArchivo() {
        return tipoArchivo;
    }
 
    public void setTipoArchivo(String fileType) {
        this.tipoArchivo = fileType;
    }
 
    public DataHandler getRawFile() {
        return rawFile;
    }
 
    public void setRawFile(DataHandler file)  {
    	
        this.rawFile = file;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
   	 	try {
			this.rawFile.writeTo(output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 	this.setContentType(this.rawFile.getContentType());
   	 	this.fileBinary = output.toByteArray();
   	 	try {
			this.stringFile =  new String(this.fileBinary,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public byte[] getByteArray() throws IOException{
    	
    	//return new String(this.fileBinary, "UTF-8");
    	 return this.fileBinary;
    }
    public String getStringFile(){
    	try {
			return new String(this.fileBinary,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Codificacion de archivo erronea");
			e.printStackTrace();
			return "ERROR";
		}
    }
    public void setStringFile(String stringFile){
    	this.fileBinary = stringFile.getBytes();
    	DataSource dataSource = new ByteArrayDataSource(this.fileBinary, "UTF-8");
    	this.rawFile = new DataHandler(dataSource);
    }
	public Integer getSize() {
		return this.fileBinary.length;
	}

	public void setSize(Integer size) {
		this.tamanio = size;
	}

	public void setByteArray(byte[] byteArray) {
		this.fileBinary =byteArray;
		
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}