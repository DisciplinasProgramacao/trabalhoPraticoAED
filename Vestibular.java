import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Vestibular {

    private ListaCursos cursos;
    private Candidato[] candidatos;
    private int qtdCursos;
    private int qtdCandidatos;

    public Vestibular() {
    }

    public void lerEntrada(String nomeArq) throws FileNotFoundException {

        // Abrir arquivo de entrada
        Scanner arqLeit = new Scanner(new FileInputStream("C:\\Users\\licitacoes\\Desktop\\entrada.txt"), "UTF-8");

        // Ler o número de cursos (N) e o número de candidatos (M)
        int N = arqLeit.nextInt();
        int M = arqLeit.nextInt();
        arqLeit.nextLine(); // mover para a próxima linha

        // Ler as informações dos cursos
        for (int i = 0; i < N; i++) {

            // Ler uma linha contendo código, nome e quantidade de vagas do curso
            String linha = arqLeit.nextLine();
            String[] dadosCurso = linha.split(";"); // criar o vetor dadosCurso do tipo String e dividir a string em
                                                    // várias partes

            int codigoCurso = Integer.parseInt(dadosCurso[0]);
            String nomeCurso = dadosCurso[1];
            int vagasCurso = Integer.parseInt(dadosCurso[2]);

            // Criar objeto Curso com as informações lidas e adicionar à lista de cursos
            Curso curso = new Curso(codigoCurso, nomeCurso, vagasCurso);
            cursos.inserirFim(curso); // inserir curso no fim da lista
        }

        // Ler as informações dos candidatos
        for (int i = 0; i < M; i++) {

            // Ler uma linha contendo nome, notas e opções de curso do candidato
            String linha = arqLeit.nextLine();
            String[] dadosCandidato = linha.split(";"); // criar o vetor dadosCandidato do tipo String e dividir a
                                                        // string em várias partes

            String nomeCandidato = dadosCandidato[0];
            double notaRed = Double.parseDouble(dadosCandidato[1]);
            double notaMat = Double.parseDouble(dadosCandidato[2]);
            double notaLing = Double.parseDouble(dadosCandidato[3]);
            int opcao1 = Integer.parseInt(dadosCandidato[4]);
            int opcao2 = Integer.parseInt(dadosCandidato[5]);

            // Criar objeto Candidato com as informações lidas
            Candidato candidato = new Candidato(nomeCandidato, notaRed, notaMat, notaLing, opcao1, opcao2);
            candidatos[i] = candidato; // adicionar o objeto candidato no vetor de candidatos
        }

        // Fechar o arquivo após a leitura
        arqLeit.close();
    }

    public void escreverSaida(String nomeArq) {
    }

    public void calcularClassificacao() {

        // percorrer a lista de candidatos, pegar acessar as notas de cada matéria e
        // definir a média
        for (int i = 0; i < candidatos.length; i++) {
            Candidato candidato = candidatos[i];
            double media = (candidato.getNotaRed() + candidato.getNotaMat() + candidato.getNotaLing()) / 3.0;
            candidato.setMedia(media);
        }

    }
    // Ordenar candidatos por meio do algoritmo de ordenação quicksort

    public void ordenarCandidatos() {
        quicksort(candidatos, 0, candidatos.length - 1);
    }

    private void quicksort(Candidato[] array, int esq, int dir) {
        int i = esq, j = dir;

        // pivô vai ser com base na média e na nota da redação
        double pivo = (array[(esq + dir) / 2].getMedia() + array[(esq + dir) / 2].getNotaRed()) / 2.0;

        while (i <= j) {

            // se a média for menor que o pivô, incrementa i
            // mas se a média for igual ao pivô, o critério de desempate é a nota da redação
            while (array[i].getMedia() < pivo || (array[i].getMedia() == pivo && array[i].getNotaRed() < pivo)) {
                i++;
            }
            // se a média for maior que o pivô, decrementa j
            // mas se a média for igual ao pivô, o critério de desempate é a nota da redação
            while (array[j].getMedia() > pivo || (array[j].getMedia() == pivo && array[j].getNotaRed() > pivo)) {
                j--;
            }

            // se i e j se cruzarem, faz a troca dos candidatos no vetor
            if (i <= j) {
                Candidato temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // verifica se há elementos na esquerda do pivô. se sim, o método é chamado
        // novamente
        if (esq < j) {
            quicksort(array, esq, j);
        }

        // verifica se há elementos na direita do pivô. se sim, o método é chamado
        // novamente
        if (i < dir) {
            quicksort(array, i, dir);
        }
    }

}
