import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class ThreadPoolTest {

    private ThreadPool threadPool;
    private Buffer buffer;
    private Barrier barrier;

    @Before
    public void setUp(){
        this.threadPool = new ThreadPool(2);
        this.buffer = new Buffer(4);
        this.buffer.push(new BigInteger("6")); // perfecto
        this.buffer.push(new BigInteger("27")); // no perfecto
        this.buffer.push(new BigInteger("28")); // perfecto
        this.buffer.push(new BigInteger("137438691328")); // perfecto
        this.barrier= new Barrier(2 );
    }

    @Test
    public void lanzarDosThreads(){
        this.threadPool.iniciar(this.buffer, barrier);
    }

}
