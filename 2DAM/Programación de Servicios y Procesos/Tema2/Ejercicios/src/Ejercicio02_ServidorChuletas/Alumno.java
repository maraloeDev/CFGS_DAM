package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Alumno {

	public static void main(String[] args) {
		try (Socket socket = new Socket("127.0.0.1", 4444)) {
			readInput(socket);
			writeOutput(socket, "Gracias desde el puerto ");
			readInput(socket);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void readInput(Socket socket) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		System.out.println(ois.readObject());
	}
	
	private static void writeOutput(Socket socket, String message) throws IOException, ClassNotFoundException {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(message + socket.getLocalPort());
	}
	
}
