package Ejemplo013_Callable;

import java.util.concurrent.Callable;

// Callable sirve para ejecutar un hilo para devolver informacion
public class ProcesoAsincrono implements Callable<Integer> {

    // El call funciona como el run
    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub

        System.err.println("Se inicio el proceso ");


        if (count > 0) {
            Thread.sleep(15000);
            return count * 2;
        } else {
            Thread.sleep(5000);
            return 1;
        }
    }

    private int count;

    public ProcesoAsincrono() {
        super();
        // TODO Auto-generated constructor stub
        this.count = -1;
    }

    public ProcesoAsincrono(Integer n) {
        super();
        // TODO Auto-generated constructor stub
        this.count = n;
    }


}