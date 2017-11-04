import java.util.ArrayList;
import java.util.List;

public class Barrier {

    private int cantidadT;
    private int totalDeHilosApasar;
    private int totalDeHilosQueFaltanTerminar;

    private int cantBloqueadas = 0;

    public int getTotalDeHilosApasar(){
        return totalDeHilosApasar;
    }

    public int getTotalDeHilosQueFaltanTerminar(){
        return totalDeHilosQueFaltanTerminar;
    }

    public Barrier(int cantidadThreads,int totalDeHilosApasar){

        this.cantidadT=cantidadThreads;
        this.totalDeHilosApasar=totalDeHilosApasar;
    }

    public synchronized void terminoUnThread(){
        totalDeHilosQueFaltanTerminar--;
    }

    public void barrera(PerfectWorker perfetWorker){


        while(this.cantBloqueadas < this.cantidadT){// && this.cantBloqueadas != totalDeHilosApasar) {
            System.out.println("Me bloquee en barrier");
            cantBloqueadas++;
            perfetWorker.bloquear();
        }
        System.out.println("Me desbloquee de barrier");
        perfetWorker.despertarATodos();
        totalDeHilosApasar-=cantBloqueadas;
        cantBloqueadas=0;

    }
}
