import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Cliente implements Runnable {

    private Socket clienteSocket;
    private Aplicacion servidor;
    private List<String> nombresPermitidos;
    private PrintWriter salida;

    public Cliente(Socket clienteSocket, Aplicacion servidor, List<String> nombresPermitidos) {
        this.clienteSocket = clienteSocket;
        this.servidor = servidor;
        this.nombresPermitidos = nombresPermitidos;

        try {
            salida = new PrintWriter(clienteSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            String nombreCliente = entrada.readLine();

            if (nombresPermitidos.contains(nombreCliente)) {
                salida.println("Bienvenido al chat, " + nombreCliente + "!");
                System.out.println(nombreCliente + " se ha unido al chat.");
            } else {
                salida.println("Tu nombre no está permitido. Desconectando...");
                clienteSocket.close();
                return;
            }

            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println(nombreCliente + ": " + mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clienteSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            servidor.desconectarCliente(this);
            servidor.enviarMensajeGlobal(nombresPermitidos + " se ha desconectado.");
        }
    }

    public void enviarMensaje(String mensaje) {
        salida.println(mensaje);
    }
}
