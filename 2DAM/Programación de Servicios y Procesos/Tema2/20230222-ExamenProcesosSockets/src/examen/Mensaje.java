package examen;

import java.io.Serializable;

public class Mensaje implements Serializable {
	
	private static final long serialVersionUID = -8260436778827606302L;
	
	private final String usuario;
	private final String mensaje;
	
	public Mensaje(String usuario, String mensaje) {
		super();
		this.usuario = usuario;
		this.mensaje = mensaje;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getMensaje() {
		return mensaje;
	}	
	
}
