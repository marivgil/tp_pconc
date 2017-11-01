import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class NumeroPerfectoVariosEnBufferTest {

    private Buffer buffer3;
    private PerfectWorker t3;

    @Before
    public void setUp(){
        this.buffer3 = new Buffer(5);

        this.buffer3.push(new BigInteger("27")); // no perfecto
        this.buffer3.push(new BigInteger("28")); // perfecto
        this.buffer3.push(new BigInteger("29")); // no perfecto
        this.buffer3.push(new BigInteger("8128")); // perfecto

        this.t3 = new PerfectWorker(buffer3);

    }

    @Test
    public void bufferConNumerosPerfectosYNumerosNoPerfectos(){
        this.t3.start();
    }

}
