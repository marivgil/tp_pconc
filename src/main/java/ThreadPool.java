import java.util.ArrayList;
import java.util.List;

public class ThreadPool {

    private int cantidadThreads;
    private List<PerfectWorker> hilosAguardar = new ArrayList<PerfectWorker>();
    private Barrier barrier; //= new Barrier(4,0);


    public Barrier getBarrier() {
        return barrier;
    }

    public ThreadPool(int cantidad){
        this.cantidadThreads=cantidad;
    }



    public void iniciar(Buffer buffer){

        this.barrier= new Barrier(4,buffer.size());
        for(int i = 0; i < this.cantidadThreads; i++){

            PerfectWorker hilo = new PerfectWorker(buffer,this);
            hilosAguardar.add(hilo);
            hilo.start();

        }
    }
}
