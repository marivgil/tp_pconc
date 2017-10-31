import java.math.BigInteger;

public class Buffer {

    private BigInteger[] colaNumerosEsperando;
    private int inicio;
    private int fin;
    private int capacidad;

    public Buffer(int capacidad){
        this.capacidad=capacidad+1;
        this.colaNumerosEsperando = new BigInteger[this.capacidad];
        this.inicio=0;
        this.fin=0;
    }

    public synchronized void push (BigInteger num) {
        //si el buffer esta lleno, espero hasta que haya lugar para agregar
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
        while (this.inicio==this.fin)
            try {
                wait();
            } catch (InterruptedException e) {
                e.getMessage();
            }
        //si no esta vacio, tomo el ultimo
        BigInteger result = this.colaNumerosEsperando[this.fin];
        this.fin = siguiente(this.fin);
        notifyAll ();
        return result;
    }

    private int siguiente(int actual){
        return (actual +1) %( this.capacidad);
    }
}
