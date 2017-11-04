import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private int cantidadThreads;
    private List<PerfectWorker> hilosAguardar = new ArrayList<PerfectWorker>();

    public ThreadPool(int cantidad){
        this.cantidadThreads=cantidad;
    }


    public void iniciar(Buffer buffer, Barrier barrier){

        for(int i = 1; i < this.cantidadThreads; i++){
            PerfectWorker hilo = new PerfectWorker(buffer, barrier);
            hilosAguardar.add(hilo);
            hilo.start();

        }
    }

}
