import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class NumeroPerfectoTest{

    private Buffer buffer1;
    private Buffer buffer2;
    private Buffer buffer3;
    private PerfectWorker t1;
    private PerfectWorker t2;
    private PerfectWorker t3;

    @Before
    public void setUp(){
        this.buffer1 = new Buffer(1);
        this.buffer2 = new Buffer(1);
        this.buffer3 = new Buffer(3);

        this.buffer1.push(new BigInteger("6"));
        this.buffer2.push(new BigInteger("1"));
        this.buffer3.push(new BigInteger("33550336")); // perfecto
        this.buffer3.push(new BigInteger("11")); //no perfecto
        this.buffer3.push(new BigInteger("8128")); // perfecto

        this.t1 = new PerfectWorker(buffer1);
        this.t2 = new PerfectWorker(buffer2);
        this.t3 = new PerfectWorker(buffer3);

    }

    @Test
    public void esNumeroPerfecto(){
        this.t1.start();
    }

    @Test
    public void noEsNumeroPerfecto(){
        this.t2.start();
    }

    @Test
    public void bufferConNumerosPerfectosYNumerosNoPerfectos(){
        this.t3.start();
    }
}
