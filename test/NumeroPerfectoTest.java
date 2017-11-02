import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class NumeroPerfectoTest{

    private Buffer buffer1;
    private Buffer buffer2;

    private PerfectWorker t1;
    private PerfectWorker t2;

    @Before
    public void setUp(){
        this.buffer1 = new Buffer(1);
        this.buffer2 = new Buffer(1);

        this.buffer1.push(new BigInteger("6"));
        this.buffer2.push(new BigInteger("1"));

        this.t1 = new PerfectWorker(buffer1);
        this.t2 = new PerfectWorker(buffer2);

    }

    @Test
    public void esNumeroPerfecto(){
        this.t1.start();
    }

    @Test
    public void noEsNumeroPerfecto(){
        this.t2.start();
    }

}
