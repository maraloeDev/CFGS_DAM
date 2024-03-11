import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ProcesoCliente implements Runnable{

    private Socket clientSocket;

    public ProcesoCliente(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());

            while (true) {
                // Leer el mensaje del cliente
                Mensaje mensajeCliente = (Mensaje) inputStream.readObject();

                // Mostrar el mensaje en la consola del servidor
                System.out.println("Mensaje recibido de " + mensajeCliente.getNombre() + ": " + mensajeCliente.getMensaje());

                if ("fin".equalsIgnoreCase(mensajeCliente.getMensaje())) {
                    break;
                }
            }

            inputStream.close();
            clientSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
