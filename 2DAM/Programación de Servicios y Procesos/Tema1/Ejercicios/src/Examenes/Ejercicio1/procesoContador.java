package Examenes.Ejercicio1;

public class procesoContador implements Runnable {

    private final String nombre;

    public procesoContador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= App.INDIVIDUAL_COUNT; i++) {
            Contador.incrementar();
            System.out.println(nombre + ": Contador = " + Contador.getGlobalCount());

            // Dormir un poco para simular trabajo
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
