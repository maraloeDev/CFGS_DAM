package examen;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ServidorListener extends Thread {
	
	private final ObjectInputStream ois;
	private boolean finished;
	
	public ServidorListener(ObjectInputStream ois) {
		this.ois = ois;
	}


	@Override
	public void run() {
		Mensaje msg = null;
		System.out.println("Cliente conectado");
		do {
			try {
				msg = (Mensaje) ois.readObject();
				if (msg.getMensaje().equalsIgnoreCase("FIN"))
					finished = true;
				if (!finished)
					System.out.printf("[%s] %s\n", msg.getUsuario(), msg.getMensaje());
			} catch (ClassNotFoundException | IOException e) {

			}
		} while (!finished);
	}


	public boolean isFinished() {
		return finished;
	}


	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
}
