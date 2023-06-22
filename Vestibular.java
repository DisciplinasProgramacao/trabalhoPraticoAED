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

        // Abre arquivo de entrada
        Scanner arqLeit = new Scanner(new FileInputStream("entrada.txt"), "UTF-8");

        // Lê o número de cursos (N) e o número de candidatos (M)
        int N = arqLeit.nextInt();
        int M = arqLeit.nextInt();
        arqLeit.nextLine(); // move para a próxima linha

        // Lê as informações dos cursos
        for (int i = 0; i < N; i++) {

            // Lê uma linha contendo código, nome e quantidade de vagas do curso
            String linha = arqLeit.nextLine();
            String[] dadosCurso = linha.split(";"); // cria o vetor dadosCurso do tipo String e divide a string em
                                                    // várias partes

            int codigoCurso = Integer.parseInt(dadosCurso[0]);
            String nomeCurso = dadosCurso[1];
            int vagasCurso = Integer.parseInt(dadosCurso[2]);

            // Cria o objeto Curso com as informações lidas e adiciona à lista de cursos
            Curso curso = new Curso(codigoCurso, nomeCurso, vagasCurso);
            cursos.inserirFim(curso); // insere o curso no fim da lista
        }

        // Lê as informações dos candidatos
        for (int i = 0; i < M; i++) {

            // Lê uma linha contendo nome, notas e opções de curso do candidato
            String linha = arqLeit.nextLine();
            String[] dadosCandidato = linha.split(";"); // cria o vetor dadosCandidato do tipo String e divide a
                                                        // string em várias partes

            String nomeCandidato = dadosCandidato[0];
            double notaRed = Double.parseDouble(dadosCandidato[1]);
            double notaMat = Double.parseDouble(dadosCandidato[2]);
            double notaLing = Double.parseDouble(dadosCandidato[3]);
            int opcao1 = Integer.parseInt(dadosCandidato[4]);
            int opcao2 = Integer.parseInt(dadosCandidato[5]);

            // Cria o objeto Candidato com as informações lidas
            Candidato candidato = new Candidato(nomeCandidato, notaRed, notaMat, notaLing, opcao1, opcao2);
            candidatos[i] = candidato; // adiciona o objeto candidato no vetor de candidatos
        }

        // Fecha o arquivo após a leitura
        arqLeit.close();
    }

    public void calcularClassificacao() {

        // percorre a lista de candidatos, acessa as notas de cada matéria e
        // define a média
        for (int i = 0; i < candidatos.length; i++) {
            Candidato candidato = candidatos[i];
            double media = (candidato.getNotaRed() + candidato.getNotaMat() + candidato.getNotaLing()) / 3.0;
            candidato.setMedia(media);
        }

        // Percorre a lista de candidatos para inserir na 1ª opção de curso
        for (int i = 0; i < qtdCandidatos; i++) {
            Candidato candidato = candidatos[i];
            int opcao1 = candidato.getOp1();
            int opcao2 = candidato.getOp2();

            // Pesquisa o curso da primeira e segunda opção
            Curso curso1 = cursos.pesquisar(opcao1);
            Curso curso2 = cursos.pesquisar(opcao2);

            // Verifica se há vagas disponíveis no curso da primeira opção
            if (curso1.getQuantVagas() > 0) {
                // Insere o candidato na lista de selecionados do curso
                curso1.inserirListaSelecionados(candidato);

                // Decrementa o número de vagas disponíveis
                curso1.setQuantVagas(curso1.getQuantVagas() - 1);  
            }
            else if(curso1.getQuantVagas() <= 0){

                }else if {
                // Insere o candidato na fila de espera do curso
                curso1.inserirFilaEspera(candidato);

            }
        }
    }

    // Ordena candidatos por meio do algoritmo de ordenação quicksort
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

    public void escreverSaida(String nomeArq) {
    }

}
