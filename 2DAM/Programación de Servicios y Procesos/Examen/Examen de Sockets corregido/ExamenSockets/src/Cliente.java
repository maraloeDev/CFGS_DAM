import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String conectar = "";
		do {
			try (Socket sk = new Socket("localhost", 4444)) {
				conectar = "";
				ObjectOutputStream oos = new ObjectOutputStream(sk.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(sk.getInputStream());

				// NOMBRE DEL CLIENTE
				String nombre = (String) ois.readObject();

				//PRIMERA LECTURA (si es 1 empieza la cuenta, si no lo es no se admiten mas clientes)
				Message lectura = (Message) ois.readObject();
				if (lectura.getMsj().equals("1")) {
					//imprimo la lectura
					System.out.println(lectura);
					//contador (de 2 en 2s)
					int i = 2;
					do {
						//escribo un nuevo mensaje con el nombre y el valor del contador
						Message msg = new Message(nombre, String.valueOf(i));
						System.out.println(msg);
						oos.writeObject(msg);
						i += 2;
						//leo lo que escribe el servidor
						lectura = (Message) ois.readObject();
						//si se ha pasado no lo escribo
						if (!lectura.getMsj().equals("11")) {
							System.out.println(lectura);
						}
						//este bucle de lectura y escritura lo hace hasta que se ha superado el 9
						//(el cliente tiene que hacer una iteracion "extra" porque tiene que escribir el 10)
					} while (!lectura.getMsj().equals("11"));
				} else {
					System.out.println(lectura);
					//si el servidor no ha escrito un 1 significa que no hay mas puestos
					//se le pregunta al usuario si desea volver a conectarse
					System.out.print("Quieres conectarte otra vez ? (S/N) >> ");
					conectar = sc.nextLine();
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//se intentará conectar mientras el usuario quiera
		} while (conectar.equals("S"));
		sc.close();
	}
}
