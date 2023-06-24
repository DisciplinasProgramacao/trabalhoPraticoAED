import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Teste {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        ListaCursos lc = new ListaCursos();
        // Candidato cand = new Candidato(null, 0, 0, 0, 0, 0);
        Vestibular v = new Vestibular(lc, null, 0, 0);

        v.mostrarVetor();
    }

}
