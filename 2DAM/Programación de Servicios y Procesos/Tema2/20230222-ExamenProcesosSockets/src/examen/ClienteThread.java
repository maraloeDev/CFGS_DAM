package examen;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClienteThread extends Thread {
	
	private final ObjectInputStream ois;
	private final ObjectOutputStream oos;
	
	private boolean finished;
	
	public ClienteThread(ObjectInputStream ois, ObjectOutputStream oos) {
		this.ois = ois;
		this.oos = oos;
	}

	@Override
	public void run() {
		Mensaje msg = null;
		do {
			try {
				msg = (Mensaje) ois.readObject();
				if (msg.getMensaje().equalsIgnoreCase("FIN")) {
					System.out.println("> CERRADA LA CONEXIÓN CON EL SERVIDOR.");
					setFinished();
				}
				if (!finished)
					System.out.printf("[%s] %s\n", msg.getUsuario(), msg.getMensaje());
			} catch (ClassNotFoundException | IOException e) {
				
			}
		} while (!finished);
		
		write(new Mensaje("FIN", "FIN"));
	}


	public boolean isFinished() {
		return finished;
	}

	public void setFinished() {
		this.finished = true;
	}
	
	public void write(Mensaje msg) {
		try {
			oos.writeObject(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
