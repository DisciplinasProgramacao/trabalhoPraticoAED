import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Teste {

    public static void main(String[] args) {
        Vestibular vestibular = new Vestibular();

        try {
            vestibular.lerEntrada("entrada.txt");
            vestibular.calcularClassificacao();
            vestibular.escreverSaida("saida.txt");
            System.out.println("Arquivo de saída criado com sucesso.");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
}
