package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorChuletas {

	public static void main(String[] args) {
		ArrayList<Socket> sockets = new ArrayList<Socket>();
		ArrayList<ObjectOutputStream> ooss = new ArrayList<ObjectOutputStream>();
		try (ServerSocket servSocket = new ServerSocket(4444)) {
			System.out.println("Servidor iniciado.");
			for (int i = 0; i < 5; i++) {
				sockets.add(servSocket.accept());
				System.out.println("Alumno " + (i + 1) + " conectado.");
			}
			writeAllOutputs(sockets, "Chuleta de cerdo");
			readAllInputs(sockets);
			writeAllOutputs(sockets, "Soy el profesor y os he pillado. SUSPENSO");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readAllInputs(ArrayList<Socket> sockets) throws IOException, ClassNotFoundException {
		for (Socket socket : sockets) {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			System.out.println(ois.readObject());
		}
		
	}

	private static void writeAllOutputs(ArrayList<Socket> sockets, String message) throws IOException {
		for (Socket socket : sockets) {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(message);
			oos.flush();
		}
		
	}

}
