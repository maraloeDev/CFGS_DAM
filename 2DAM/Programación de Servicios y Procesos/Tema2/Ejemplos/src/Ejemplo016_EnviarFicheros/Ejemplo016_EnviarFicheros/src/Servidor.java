package Ejemplo016_EnviarFicheros.Ejemplo016_EnviarFicheros.src;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (ServerSocket serverSocket=new ServerSocket(4444);
			Socket socket=serverSocket.accept();)
		{
			File fichero=new File("datos.txt");
			FileInputStream fis=new FileInputStream(fichero); //Carga el fichero para enviarlo
			BufferedInputStream bis=new BufferedInputStream(fis); // Lector de fichero
			byte datos[]=bis.readAllBytes(); //Lees todos los bytes del fichero y los guardas en un array de bytes
			
			OutputStream os=socket.getOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(datos);
			
			System.out.println("el cliente se ha conectado y se le ha enviado la informacion");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}
