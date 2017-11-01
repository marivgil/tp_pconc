import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class BufferTest {

    private Buffer buffer;
    private BigInteger b1;
    private BigInteger b2;
    private BigInteger b3;

    @Before
    public void setUp(){
        buffer = new Buffer(3);
        b1 = BigInteger.ONE;
        b2 = new BigInteger("2");
        b3 = new BigInteger("3");
    }

    @Test
    public void pushTest(){
        Assert.assertEquals(this.buffer.size(),0);
        this.buffer.push(b1);
        Assert.assertEquals(this.buffer.size(),1);
        this.buffer.push(b2);
        this.buffer.push(b3);
        Assert.assertEquals(this.buffer.size(),3);
    }

    @Test
    public void popTest(){
        this.buffer.push(b1);
        this.buffer.push(b2);
        this.buffer.push(b3);
        Assert.assertEquals(this.buffer.size(),3);

        this.buffer.pop();
        this.buffer.pop();
        Assert.assertEquals(this.buffer.size(),1);
    }

    @Test
    public void popOrdenTest(){
        // 3 2 1
        this.buffer.push(b1);
        this.buffer.push(b2);
        this.buffer.push(b3);
        Assert.assertEquals(this.buffer.size(),3);

        BigInteger big1 = this.buffer.pop();
        Assert.assertEquals(big1, new BigInteger("1"));

        BigInteger big2 = this.buffer.pop();
        Assert.assertEquals(big2, new BigInteger("2"));

        BigInteger big3 = this.buffer.pop();
        Assert.assertEquals(big3, new BigInteger("3"));

        Assert.assertEquals(this.buffer.size(),0);
    }

}
