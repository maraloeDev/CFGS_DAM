import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4444);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();

            while (true) {
                System.out.print("Ingrese su mensaje (o 'fin' para salir): ");
                String mensaje = scanner.nextLine();

                // Enviar el mensaje al servidor
                Mensaje mensajeCliente = new Mensaje(nombre, mensaje);
                outputStream.writeObject(mensajeCliente);

                if ("fin".equalsIgnoreCase(mensaje)) {
                    break;
                }
            }

            socket.close();
            outputStream.close();
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
