import java.util.ArrayList;
import java.util.List;

public class Barrier {

    private int cantidadT;
    private int totalDeHilosApasar;
    private int totalDeHilosQueFaltanTerminar;

    private int cantBloqueadas = 0;

    public synchronized int getTotalDeHilosApasar(){
        return totalDeHilosApasar;
    }

    public synchronized int getTotalDeHilosQueFaltanTerminar(){
        return totalDeHilosQueFaltanTerminar;
    }

    public Barrier(int cantidadThreads,int totalDeHilosApasar){

        this.cantidadT=cantidadThreads;
        this.totalDeHilosApasar=totalDeHilosApasar;
        this.totalDeHilosQueFaltanTerminar=totalDeHilosApasar;
    }

    public synchronized void terminoUnThread(){
        totalDeHilosQueFaltanTerminar--;
    }

    private synchronized int getCantBloqueadas(){
        return cantBloqueadas;
    }


    private synchronized int getCantidadT(){
        return cantidadT;
    }


    public void barrera(PerfectWorker perfetWorker){

        while((this.getCantBloqueadas() < this.getCantidadT()) && (this.getCantBloqueadas() != this.getTotalDeHilosQueFaltanTerminar())) {
            System.out.println("Me bloquee en barrier");
            cantBloqueadas++;
            perfetWorker.bloquear();
        }
        System.out.println("Me desbloquee de barrier");
        totalDeHilosQueFaltanTerminar-=cantBloqueadas;
        cantBloqueadas=0;
        perfetWorker.despertarATodos();


    }
}
