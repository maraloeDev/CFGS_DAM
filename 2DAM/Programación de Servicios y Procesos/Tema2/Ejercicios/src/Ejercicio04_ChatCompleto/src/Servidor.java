import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ProcesoCliente(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
