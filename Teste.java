import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Teste {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        Vestibular v = new Vestibular(null, null, 0, 0);

        v.lerEntrada("entrada.txt");
        v.escreverSaida("saida.txt");
    }

}
