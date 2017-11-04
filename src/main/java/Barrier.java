
public class Barrier {

    private int cantidadT;
    private int cantBloqueados;

    public Barrier(int cantidadThreads){
        this.cantidadT=cantidadThreads; // se debe contar el MAIN como  un hilo
        this.cantBloqueados=0;
    }

    public synchronized void esperar(){

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cantBloqueados++;

        if (cantBloqueados==cantidadT){
            notifyAll();
        }

    }

}
