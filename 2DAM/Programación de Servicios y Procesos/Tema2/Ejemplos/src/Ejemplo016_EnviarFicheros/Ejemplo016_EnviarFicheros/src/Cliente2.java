import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Socket socket=new Socket("localhost",4444);){
			File fichero=new File("datos2.txt");
			FileOutputStream fos=new FileOutputStream(fichero);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			byte datos[];
			
			InputStream is=socket.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(is);
			datos=(byte[]) ois.readObject();
			
			System.out.println(datos);
			bos.write(datos);
			bos.close();
			
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

}
