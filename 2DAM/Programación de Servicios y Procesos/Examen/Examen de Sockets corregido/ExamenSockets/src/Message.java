import java.io.Serializable;

public class Message implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String msj;
	
	public Message(String nombre, String msj) {
		super();
		this.nombre = nombre;
		this.msj = msj;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMsj() {
		return msj;
	}
	public void setMsj(String msj) {
		this.msj = msj;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre + " : " +  msj;
	}
	public Message() {
		super();
	}
	
	
	
	
}
