import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
;

public class Teste {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        Vestibular v = new Vestibular(new ListaCursos(), null, 0, 0);

        v.lerEntrada("entrada.txt");
        v.calcularClassificacao();
        v.escreverSaida("saida.txt");

        //teste
    }

}
