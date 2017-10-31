import java.math.BigInteger;

public class PerfectWorker extends Thread{

    private Buffer buffer;

    public PerfectWorker(Buffer buffer){
        this.buffer=buffer;
    }

    //FiXME: falta contemplar la opción de recibir nulos
    public void run(){

        BigInteger suma = BigInteger.ZERO;
        BigInteger datoActual;

        while(true){
            datoActual = this.buffer.pop();

            for( BigInteger i = BigInteger.ONE;
                 i.compareTo(datoActual) <= 0 ;  //x.compareTo(y) <= 0 si x <= y
                 i=i.add( BigInteger.ONE)){

                if(datoActual.mod(i).equals(BigInteger.ZERO)){
                    suma = suma.add(i);
                }
            }

            if(suma.equals(datoActual)){
                System.out.println (datoActual.toString() + " es número perfecto");
            }

        }



    }

}
