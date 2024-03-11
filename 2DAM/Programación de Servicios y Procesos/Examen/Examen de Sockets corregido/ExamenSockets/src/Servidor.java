import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) {
		// el indicador de numero de cliente
		int numCliente = 1;
		try (ServerSocket ss = new ServerSocket(4444)) {
			// todos los clientes
			ArrayList<Socket> clientes = new ArrayList<Socket>();
			// los que cuentan
			ArrayList<Socket> activos = new ArrayList<Socket>();
			do {
				// aceptamos un cliente
				Socket cliente = ss.accept();
				// se añade a todos los clientes
				clientes.add(cliente);
				System.out.println("Se ha conectado el cliente " + numCliente);
				// se obtiene su writer y reader
				ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
				// se le otorga un nombre
				oos.writeObject("Cliente " + numCliente);
				numCliente++;
				// si el numero de clientes activos es menor que tres se contará
				if (activos.size() < 3) {
					// se añaden
					activos.add(cliente);

					// thread de escritura/lectura
					// por cada cliente se le escucha y se escribe
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {
								//variables locales para que no bloqueen el thread principal
								ObjectOutputStream out = oos;
								ObjectInputStream in = ois;
								
								// contador
								int i = 1;
								// se utilizara para leer los mensajes del cliente
								Message lectura = new Message();
								// se utilizara para escribir al cliente
								Message escritura = new Message("Servidor", String.valueOf(i));
								System.out.println(escritura);
								// primera escritura
								out.writeObject(escritura);
								do {
									// aumento el contador
									i += 2;
									// leo al cliente
									lectura = (Message) in.readObject();
									System.out.println(lectura);
									escritura = new Message("Servidor", String.valueOf(i));
									// escribo, en caso de no ser necesario (hemos llegado al final) no se imprimirá
									if (!lectura.getMsj().equals("10")) {
										System.out.println(escritura);
									}
									try {
										Thread.sleep(1000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									// escribo la escritura (la ultima será con 11)
									out.writeObject(escritura);
									// esto lo hace hasta que el cliente le envíe 10
								} while (!lectura.getMsj().equals("10"));
								// se eliminan cuando el proceso esta completo
								activos.remove(cliente);
							} catch (IOException | ClassNotFoundException e) {
								e.printStackTrace();
							}
						}
					}).start();

				} else {
					// en caso de que ya haya 3 clientes se notifica a los que esperan que se ha
					// alcanzado el máximo.
					oos.writeObject(new Message("Servidor", "Se ha alcanzado el maximo."));
				}
				// este servidor funciona constantemente
			} while (true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
