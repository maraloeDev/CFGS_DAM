package Ejemplo015_ConectarSockets.Ejemplo015_ConectarSockets.src;

import java.io.Serializable;

// Serializable es que se puede convertir en texto
public class Usuario implements Serializable {

    private String nombre;

    private static final long serialVersionUID = 1L;
    private int contrasena;

    public Usuario(String nombre, int contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", contrasena=" + contrasena +
                '}';
    }
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
}
