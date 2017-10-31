import java.math.BigInteger;
import java.util.List;

public class Main {

    private int cantidadThreads; // harcodear valor
    private List<BigInteger> listaNumeros; //harcodear valores
    private ThreadPool threadPool = new ThreadPool(cantidadThreads);
    private int cantidadBuffer; //harcodear valor
    private Buffer buffer = new Buffer(cantidadBuffer);

    // listaNumeros debe tener 100 numeros de los cuales 8 deben ser perfectos
    // son perfectos segun la wiki: 6, 28, 496, 8128, 33550336, 8589869056, 137438691328, 2305843008139952128


    // el main debe imprimir finalmente el tiempo que demoró el programa
}
