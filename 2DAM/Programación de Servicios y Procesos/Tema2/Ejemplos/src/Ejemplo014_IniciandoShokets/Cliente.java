package Ejemplo014_IniciandoShokets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        // EL 127.0.0.1 lo tienen todos
        // localhost es el que esta puesto por defecto
        try (Socket socket = new Socket("localhost", 4444);){
            // Flujo de entrada de datos en bytes
            InputStream is = socket.getInputStream(); // Recibir datos

            // Leer en objetos
            ObjectInputStream ois = new ObjectInputStream(is); // Leer los datos

            System.out.println(ois.readObject()); // Se muestra

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}