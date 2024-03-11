package Examenes.Ejercicio1;

public class App {

    public static final int TARGET_COUNT = 20000;
    public static final int INDIVIDUAL_COUNT = 5000;
    private static volatile int globalCount = 0;

    public static void main(String[] args) {
        // Crear el cronómetro
        Thread cronometro = new Thread(() -> {
            int segundos = 0;
            try {
                while (!Thread.interrupted()) {
                    Thread.sleep(1000);
                    segundos++;
                }
            } catch (InterruptedException e) {
                // Se interrumpió el cronómetro
            }
            System.out.println("Han transcurrido " + segundos + " segundos.");
        });

        // Iniciar el cronómetro
        cronometro.start();

        // Crear y arrancar los procesos de conteo
        for (int i = 1; i <= 4; i++) {
            String nombreProceso = "Proceso " + i;
            new Thread(new procesoContador(nombreProceso)).start();
        }

        // Esperar a que cada proceso individual alcance su cuenta objetivo
        while (globalCount < 4 * INDIVIDUAL_COUNT) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Detener el cronómetro
        cronometro.interrupt();

        // Mostrar el tiempo total
        try {
            cronometro.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void contar() {
        globalCount++;
    }
}
