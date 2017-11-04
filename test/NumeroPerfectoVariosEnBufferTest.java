import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class NumeroPerfectoVariosEnBufferTest {

    private Buffer buffer3;
    private PerfectWorker t3;
    private ThreadPool threadPool;

    @Before
    public void setUp(){
        this.buffer3 = new Buffer(10);

    }

    @Test
    public void bufferConNumerosPerfectosYNumerosNoPerfectos(){
        this.buffer3.push(new BigInteger("27")); // no perfecto
        this.buffer3.push(new BigInteger("28")); // perfecto
        this.buffer3.push(new BigInteger("29")); // no perfecto
        this.buffer3.push(new BigInteger("8128")); // perfecto
        this.t3 = new PerfectWorker(buffer3, threadPool);

        this.t3.start();
    }

    @Test
    //solo debería imprimir el 6
    public void bufferRecibeNumeroNegativo(){
        this.buffer3.push(new BigInteger("6")); // perfecto
        this.buffer3.push(new BigInteger("27")); // no perfecto
        this.buffer3.push(new BigInteger("28").negate()); // perfecto
        this.buffer3.push(new BigInteger("29")); // no perfecto
        this.buffer3.push(new BigInteger("8128")); // perfecto
        this.t3 = new PerfectWorker(buffer3,  threadPool);

        this.t3.start();
    }

}
