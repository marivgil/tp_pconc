

public class ThreadPool {

    private int cantidadThreads;

    public ThreadPool(int cantidad){
        this.cantidadThreads=cantidad;
    }


     /*
      * FIXME: de esta manera crea hilos con el mismo  nombre, ¿Esta bien?
      * hay que pensar que nombre ponerle a los hilos que creamos
      */
    public void iniciar(Buffer buffer){
        for(int i = 1; i < this.cantidadThreads; i++){
            PerfectWorker hilo = new PerfectWorker(buffer);
            hilo.start();
        }
    }
}
