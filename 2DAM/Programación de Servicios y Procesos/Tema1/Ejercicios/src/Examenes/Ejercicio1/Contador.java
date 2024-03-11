package Examenes.Ejercicio1;

public class Contador {

    private static volatile int globalCount = 0;

    public static synchronized void incrementar() {
        globalCount++;
    }

    public static int getGlobalCount() {
        return globalCount;
    }
}
