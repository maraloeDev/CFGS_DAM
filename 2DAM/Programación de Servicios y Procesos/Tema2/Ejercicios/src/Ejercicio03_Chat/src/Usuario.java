public class Usuario {

    private String nombre;
    private int identificador;

    public Usuario(String nombre, int identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return " Lista de usuarios permitidos: "
                + identificador
                + ", " + nombre;
    }
}
