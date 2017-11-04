import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class NumeroPerfectoVariosEnBufferTest {

    private Buffer buffer;
    private PerfectWorker t3;
    private Barrier barrier;

    @Before
    public void setUp(){
        this.buffer = new Buffer(10);
        this.barrier= new Barrier(2 );

    }

    @Test
    public void bufferConNumerosPerfectosYNumerosNoPerfectos(){
        this.buffer.push(new BigInteger("27")); // no perfecto
        this.buffer.push(new BigInteger("28")); // perfecto
        this.buffer.push(new BigInteger("29")); // no perfecto
        this.buffer.push(new BigInteger("8128")); // perfecto
        this.t3 = new PerfectWorker(buffer, barrier);

        this.t3.start();
    }

    @Test
    //solo debería imprimir el 6
    public void bufferRecibeNumeroNegativo(){
        this.buffer.push(new BigInteger("6")); // perfecto
        this.buffer.push(new BigInteger("27")); // no perfecto
        this.buffer.push(new BigInteger("28").negate()); // perfecto
        this.buffer.push(new BigInteger("29")); // no perfecto
        this.buffer.push(new BigInteger("8128")); // perfecto
        this.t3 = new PerfectWorker(buffer, barrier);

        this.t3.start();
    }

}
