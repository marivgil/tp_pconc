import java.math.BigInteger;

public class PerfectWorker extends Thread{

    private Buffer buffer;
    private BigInteger suma = BigInteger.ZERO;
    private BigInteger datoActual;
    private ThreadPool miPool;

    public PerfectWorker(Buffer buffer, ThreadPool miPool){
        this.buffer=buffer;
        this.miPool=miPool;
    }

    public int tamanioBuffer(){
        return buffer.size();
    }


    public synchronized void bloquear(){

        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void despertarATodos(){
        this.notifyAll();

    }

    private Barrier miBarrier(){
        return this.miPool.getBarrier();
    }

    private boolean soyUltimoThread(){
        return miBarrier().getTotalDeHilosQueFaltanTerminar()==0;
    }

    public void run(){

        ///!this.buffer.isEmpty() te reemplo esto por que los hilos para mi siemrpe estan vivos es ma facil de monitorear cuantos hilos estan trabajado
        while(true){
            this.miBarrier().barrera(this);

            this.datoActual = this.buffer.pop();
            suma = BigInteger.ZERO;

            if (this.datoActual.compareTo(BigInteger.ZERO) >= 0) {

                for (BigInteger i = BigInteger.ONE; i.compareTo(this.datoActual) < 0; i=i.add(BigInteger.ONE)) {

                        if (this.datoActual.mod(i).equals(BigInteger.ZERO)) {
                            suma = suma.add(i);
                        }
                }

                if (suma.equals(this.datoActual)) {
                    System.out.println(this.datoActual.toString() + " es número perfecto");
                }

            }
            miBarrier().terminoUnThread();
            System.out.println(miBarrier().getTotalDeHilosQueFaltanTerminar());

            if (soyUltimoThread()) {
                buffer.desbloquear();
                System.out.println("desbloquee el buffer");
            }
        }

    }
}
