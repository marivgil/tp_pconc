

public class Barrier {

    private int cantidadT;
    private List<PerfectWorker> hilosABloquear = new ArrayList<PerfectWorker>();

    public Barrier(int cantidadThreads){ cantidadT=cantidadThreads; }

    public synchronized void barrera(PerfectWorker perfetWorker){

        while(this.hilosABloquear.length != this.cantidadT )
            try {
                perfetWorker.wait();
                hilosABloquear.add(perfetWorker);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        notifyAll();

    }
}
