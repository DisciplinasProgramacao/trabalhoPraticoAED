import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Teste {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        // Cria uma instância da classe Vestibular
        Vestibular v = new Vestibular(null, null, 0, 0);

        // Chama o método lerEntrada, passando o nome do arquivo de entrada como
        // argumento ("entrada.txt")
        v.lerEntrada("entrada.txt");

        // Chama o método calcularClassificacao para realizar os cálculos de
        // classificação dos candidatos
        v.calcularClassificacao();

        // Chama o método escreverSaida, passando o nome do arquivo de saída como
        // argumento ("saida.txt")
        v.escreverSaida("saida.txt");

    }

}
