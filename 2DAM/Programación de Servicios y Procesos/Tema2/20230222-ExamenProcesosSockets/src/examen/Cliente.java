package examen;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Escribe tu nombre: ");
		String nombre = sc.nextLine();
		
		try (Socket s = new Socket("localhost", 4444);
			 InputStream is = s.getInputStream();
			 ObjectInputStream ois = new ObjectInputStream(is);
			 OutputStream os = s.getOutputStream();
			 ObjectOutputStream oos = new ObjectOutputStream(os)) {	
				
			Mensaje msg = (Mensaje) ois.readObject();
			System.out.printf("[%s] %s\n", msg.getUsuario(), msg.getMensaje());
			
			ClienteThread thread = new ClienteThread(ois, oos);
			thread.start();
			
			do {
				System.out.print("Escribe mensaje: ");
				
				String mensaje = sc.nextLine();
				
				if (!thread.isFinished()) {
					msg = new Mensaje(nombre, mensaje);
					thread.write(msg);
				} else
					System.out.println("Este mensaje ya no puede ser enviado porque se ha cerrado la comunicación con el servidor.");
			
			} while (!thread.isFinished());

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
