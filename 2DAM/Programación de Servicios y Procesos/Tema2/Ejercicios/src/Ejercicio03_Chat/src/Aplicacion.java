import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingresa tu nombre: ");
            String nombreCliente = teclado.readLine();
            salida.println(nombreCliente);

            new Thread(() -> {
                String mensaje;
                try {
                    while ((mensaje = entrada.readLine()) != null) {
                        System.out.println(mensaje);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String mensajeUsuario;
            while ((mensajeUsuario = teclado.readLine()) != null) {
                salida.println(mensajeUsuario);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}