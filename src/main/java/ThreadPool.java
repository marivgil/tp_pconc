

public class ThreadPool {

    private int cantidadThreads;

    public ThreadPool(int cantidad){
        this.cantidadThreads=cantidad;
    }


    public void iniciar(Buffer buffer){
        for(int i = 1; i < this.cantidadThreads; i++){
            PerfectWorker hilo = new PerfectWorker(buffer);
            hilo.start();
        }
    }
}
