package Ejemplo014_IniciandoShokets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {

    /*
     * Comandos cmd:
     *
     * o netstat :te muestra las direcciones ip del equipo, habra varias debido a
     * que hay varias tarjetas en el equipo si pones alguno de los numeros
     * siguientes de la ip (numero del puerto) dara error por uso.
     *
     * o netstat -nao: muestra quien esta utilizando cada puerto por PID.
     *
     * o netstat - nao|findstr _: para filtrar (poner el PID en el "_").
     *
     * o 0.0.0.0: se ve en todas las ip.
     *
     * o ping _: enviar una traza aun equipo y ver que recibe ( poner direccion ip
     * en el "_").
     *
     * o ipconfig: cuales son los interfaces de red de mi equipo
     *
     * o ping _ -t: para poder ver el ping en paralelo, enviando paquetes
     * constantemente.
     *
     * o telnet: (no instalado por defecto, asi que se tiene que instalar) es como
     * el ping pero te permite especificar el ip y el puerto.
     *
     * o fallo de conectividad tipico firewall, en este podemos definir las reglas
     * de entrada y de salida.
     *
     * o Si no puedes abrir un buscador, pero haciendo un ping si que llega, el
     * problema esta en el dns,
     *
     */

    public static void main(String[] args) {

        // Hay que elegir un puerto, en nuestro caso 4444
        try (ServerSocket serverSocket = new ServerSocket(4444)) {

            // Aceptar comunicaciones
            // Socket socket = serverSocket.accept();

            // Con varios clientes
            ArrayList<Socket> sockets = new ArrayList<Socket>();

            for (int i = 0; i < 1; i++) {
                sockets.add(serverSocket.accept());
                System.out.println("Alguien se ha conectado");
            }

            Scanner sc = new Scanner(System.in);

            System.out.print("Inserte un mensaje: ");
            String msj = sc.nextLine();

            for (Socket socket : sockets) {
                OutputStream os = socket.getOutputStream(); //Envia datos del socket
                ObjectOutputStream oos = new ObjectOutputStream(os); //Crea el fujo de envio de datos
                oos.writeObject(msj);
                oos.flush(); //Limpia el flujo
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Cerrar ( no hace falta si se decalra en el try
        // serverSocket.close();

    }
}
