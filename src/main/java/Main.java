import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main (String [ ] args) {

        int cantidadThreads = 10;
        List<BigInteger> listaBigInteger=new ArrayList<BigInteger>();

        for(int i=1;i<=(cantidadThreads-6);i++){
            listaBigInteger.add(new BigInteger(""+i+""));
        }

        listaBigInteger.add(new BigInteger("496"));
        listaBigInteger.add(new BigInteger("8128"));
        listaBigInteger.add(new BigInteger("33550336"));
        listaBigInteger.add(new BigInteger("8589869056"));
        listaBigInteger.add(new BigInteger("137438691328"));
        listaBigInteger.add(new BigInteger("2305843008139952128"));
        listaBigInteger.add(new BigInteger("1").negate());
        listaBigInteger.add(new BigInteger("1").negate());
        listaBigInteger.add(new BigInteger("1").negate());


        long inicio = System.currentTimeMillis();

        int cantidadBuffer = 100;
        Buffer buffer = new Buffer(cantidadBuffer);
        ThreadPool threadPool = new ThreadPool(cantidadThreads);

        Barrier barrier= new Barrier(cantidadThreads);
        threadPool.iniciar(buffer, barrier);

        for(BigInteger num : listaBigInteger){
            buffer.push(num);
        }

        barrier.esperar();
        System.out.println(" termine main");

        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
        System.out.println(tiempo +" segundos");
    }

}
