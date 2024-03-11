package examen;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	public static final ArrayList<ServidorListener> LISTENERS = new ArrayList<>();
	public static final ArrayList<ObjectOutputStream> WRITERS = new ArrayList<>();

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(4444)) {
			// Espera a que se conecten todos sus clientes
			do {				
				Socket s = ss.accept();
				
				OutputStream os = s.getOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(os);
				
				InputStream is = s.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
				
				LISTENERS.add(new ServidorListener(ois));
				WRITERS.add(oos);
			} while (LISTENERS.size() < 4);
			
			// Inicia los listeners para que pueda recibir los mensajes de los clientes
			for(ServidorListener listener : LISTENERS)
				listener.start();
			
			// Envía un mensaje de conexión correcta a todos los clientes
			for(ObjectOutputStream oos : WRITERS)
				oos.writeObject(new Mensaje("Servidor", "Conectado correctamente."));
			
			// Hace ping a los clientes durante 60 segundos
			int timesPinged = 0;
			
			while (timesPinged < 12) {
				Thread.sleep(5000);
				for(ObjectOutputStream oos : WRITERS)
					oos.writeObject(new Mensaje("Servidor", "Ping."));
				timesPinged++;
			}
			
			// Una vez ha pasado ese tiempo, envía mensaje de fin, cerrando los usuarios
			for (ObjectOutputStream oos : WRITERS)
				oos.writeObject(new Mensaje("Servidor", "FIN"));
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
