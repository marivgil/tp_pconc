import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class TpTest {

    @Test
    public void mainTest(){

        int cantidadThreads = 10;
        List<BigInteger> listaBigInteger=new ArrayList<BigInteger>();

        for(int i=1;i<=(cantidadThreads-6);i++){
            listaBigInteger.add(new BigInteger(""+i+""));
        }

        //listaBigInteger.add(new BigInteger("6"));
        //listaBigInteger.add(new BigInteger("28"));
        listaBigInteger.add(new BigInteger("496"));
        listaBigInteger.add(new BigInteger("8128"));
        listaBigInteger.add(new BigInteger("33550336"));
        listaBigInteger.add(new BigInteger("8589869056"));
        listaBigInteger.add(new BigInteger("137438691328"));
        listaBigInteger.add(new BigInteger("2305843008139952128"));


        long inicio = System.currentTimeMillis();

        int cantidadBuffer = 100;
        Buffer buffer = new Buffer(cantidadBuffer);
        ThreadPool threadPool = new ThreadPool(cantidadThreads);


        for(BigInteger num : listaBigInteger){
            buffer.push(num);
        }

        threadPool.iniciar(buffer);

        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);

        System.out.println(tiempo +" segundos");
    }


}
