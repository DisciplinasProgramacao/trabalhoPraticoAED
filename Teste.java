import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Teste {
<<<<<<< HEAD

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
=======
    
    public static void main(String[] args) throws Exception{
        System.out.println("\033[H\033[2J");
        System.out.println("Teste");
>>>>>>> 70ac69041c1fb9b28b8f07625cb4eabf2e2dd749
    }
}
