import java.math.BigInteger;

public class Buffer {

    private BigInteger[] colaNumerosEsperando;
    private int inicio;
    private int fin;
    private int capacidad;
    private int totalnum;

    public Buffer(int capacidad){
        this.capacidad=capacidad+1;
        this.colaNumerosEsperando = new BigInteger[this.capacidad];
        this.inicio=0;
        this.fin=0;
        this.totalnum=0;
    }

    public synchronized void bloquear(){
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void numerosPerfectos(int cantDeThreadsDeseados) throws InterruptedException {
        ThreadPool myPool= new ThreadPool(cantDeThreadsDeseados);
        myPool.iniciarPerfectWorkers(this);

        if(!myPool.finalizo()){
            System.out.println("buffer bloqueado");
            wait();
        }
    }

    public synchronized void desbloquear(){
        notify();
    }

    public synchronized void push (BigInteger num) {
        //si el buffer esta lleno, espero hasta que haya lugar para agregar
        this.totalnum ++;
        while( siguiente(this.inicio)==this.fin)
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        this.colaNumerosEsperando[this.inicio] = num;
        this.inicio = siguiente(this.inicio);
        notifyAll ();
    }

    public synchronized BigInteger pop() {
        //Si el buffer esta vacio, espero hasta que haya algo por sacar
        while (isEmpty())
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        //si no esta vacio, tomo el ultimo
        BigInteger result = this.colaNumerosEsperando[this.fin];
        this.fin = siguiente(this.fin);
        totalnum --;
        notifyAll();
        return result;
    }

    private synchronized int siguiente(int actual){
        return (actual +1) %( this.capacidad);
    }

    public synchronized int size(){
        return this.inicio-this.fin;
    }

    public synchronized boolean isEmpty() {
        return this.inicio == this.fin;
    }

    public synchronized int getTotalnum(){return totalnum;}
}
