
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Scanner;

public class Vestibular {

    private ListaCursos cursos;
    private Candidato[] candidatos;
    private int qtdCursos;
    private int qtdCandidatos;

    public Vestibular(ListaCursos cursos, Candidato[] candidatos, int qtdCursos, int qtdCandidatos) {
        this.cursos = new ListaCursos();
        this.candidatos = candidatos;
        this.qtdCursos = qtdCursos;
        this.qtdCandidatos = qtdCandidatos;

    }

    public void lerEntrada(String nomeArq) throws FileNotFoundException {
        File arquivo = new File("entrada.txt");
        FileInputStream is = new FileInputStream(arquivo);
        Scanner arqLeit = new Scanner(is, "UTF-8");

        // Lê o número de cursos (N) e o número de candidatos (M)
        String linha = arqLeit.nextLine();
        String[] cursoAluno = linha.split(";");
        qtdCursos = Integer.parseInt(cursoAluno[0]);
        qtdCandidatos = Integer.parseInt(cursoAluno[1]);
        // arqLeit.nextLine(); // Move para a próxima linha

        // Lê as informações dos cursos
        for (int i = 0; i < qtdCursos; i++) {
            linha = arqLeit.nextLine();
            String[] dadosCurso = linha.split(";");

            int codigoCurso = Integer.parseInt(dadosCurso[0]);
            String nomeCurso = dadosCurso[1];
            int vagasCurso = Integer.parseInt(dadosCurso[2]);

            Curso curso = new Curso(codigoCurso, nomeCurso, vagasCurso);
            cursos.inserirFim(curso);
        }

        // Lê as informações dos candidatos
        this.candidatos = new Candidato[qtdCandidatos];
        // arqLeit.nextLine(); // Move para a próxima linha
        for (int i = 0; i < qtdCandidatos; i++) {
            linha = arqLeit.nextLine();
            String[] dadosCandidato = linha.split(";");

            String nomeCandidato = dadosCandidato[0];
            double notaRed = Double.parseDouble(dadosCandidato[1]);
            double notaMat = Double.parseDouble(dadosCandidato[2]);
            double notaLing = Double.parseDouble(dadosCandidato[3]);
            int opcao1 = Integer.parseInt(dadosCandidato[4]);
            int opcao2 = Integer.parseInt(dadosCandidato[5]);

            Candidato candidato = new Candidato(nomeCandidato, notaRed, notaMat, notaLing, opcao1, opcao2);
            candidatos[i] = candidato;
        }

        arqLeit.close(); // Fecha o arquivo após a leitura
    }

    public void calcularClassificacao() {

        // Ordena os candidatos pelo critério definido no quicksort
        ordenarCandidatos();

        // Percorre a lista de candidatos
        for (int i = 0; i < candidatos.length; i++) {

            // Pesquisa os cursos nas opções do candidato
            Curso cursoOpcao1 = cursos.pesquisar(candidatos[i].getOp1());
            Curso cursoOpcao2 = cursos.pesquisar(candidatos[i].getOp2());

            // Verifica se o candidato foi selecionado para a primeira opção de curso

            boolean selecionadoOpcao1 = cursoOpcao1.inserirListaSelecionados(candidatos[i]);

            // Verifica se o candidato foi selecionado para a segunda opção de curso
            if (!selecionadoOpcao1 && cursoOpcao2 != null) {
                boolean selecionadoOpcao2 = cursoOpcao2.inserirListaSelecionados(candidatos[i]);
                if (!selecionadoOpcao2) {
                    cursoOpcao1.inserirFilaEspera(candidatos[i]);
                    cursoOpcao2.inserirFilaEspera(candidatos[i]);
                }
                cursoOpcao1.inserirFilaEspera(candidatos[i]);
            }
        }
    }

    // Ordena candidatos por meio do algoritmo de ordenação mergesort
    public void ordenarCandidatos() {
        mergesort(candidatos, 0, candidatos.length - 1);

    }

    public void mergesort(Candidato[] array, int esq, int dir) {
        if (esq < dir) {
            // Calcula o índice do meio do array
            int meio = (esq + dir) / 2;

            // Chama recursivamente o mergesort para a metade esquerda do array
            mergesort(array, esq, meio);

            // Chama recursivamente o mergesort para a metade direita do array
            mergesort(array, meio + 1, dir);

            // Combina as duas metades ordenadas
            intercalar(array, esq, meio, dir);
        }
    }

    public void intercalar(Candidato[] array, int esq, int meio, int dir) {
        // Calcula o tamanho dos subarrays
        int nEsq = meio - esq + 1;
        int nDir = dir - meio;

        // Cria os subarrays temporários
        Candidato[] arrayEsq = new Candidato[nEsq];
        Candidato[] arrayDir = new Candidato[nDir];

        // Copia os elementos da metade esquerda para o subarray esquerdo
        for (int i = 0; i < nEsq; i++) {
            arrayEsq[i] = array[esq + i];
        }

        // Copia os elementos da metade direita para o subarray direito
        for (int i = 0; i < nDir; i++) {
            arrayDir[i] = array[meio + 1 + i];
        }

        // Índices para percorrer os subarrays
        int iEsq = 0;
        int iDir = 0;
        int i = esq;

        // Combina os elementos dos subarrays de forma ordenada
        while (iEsq < nEsq && iDir < nDir) {
            if (arrayEsq[iEsq].getMedia() > arrayDir[iDir].getMedia()) {
                // O elemento do subarray esquerdo é maior, coloca no array final
                array[i] = arrayEsq[iEsq];
                iEsq++;
            } else if (arrayEsq[iEsq].getMedia() < arrayDir[iDir].getMedia()) {
                // O elemento do subarray direito é maior, coloca no array final
                array[i] = arrayDir[iDir];
                iDir++;
            } else {
                // Empate na média, usar nota de redação como critério de desempate
                if (arrayEsq[iEsq].getNotaRed() >= arrayDir[iDir].getNotaRed()) {
                    // A nota de redação do subarray esquerdo é maior ou igual, coloca no array
                    // final
                    array[i] = arrayEsq[iEsq];
                    iEsq++;
                } else {
                    // A nota de redação do subarray direito é maior, coloca no array final
                    array[i] = arrayDir[iDir];
                    iDir++;
                }
            }
            i++;
        }

        // Copia os elementos restantes do subarray esquerdo, se houver
        while (iEsq < nEsq) {
            array[i] = arrayEsq[iEsq];
            iEsq++;
            i++;
        }

        // Copia os elementos restantes do subarray direito, se houver
        while (iDir < nDir) {
            array[i] = arrayDir[iDir];
            iDir++;
            i++;
        }
    }

    public void escreverSaida(String nomeArq) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter arqEscrita = new Formatter("saida.txt", "UTF-8");
        arqEscrita.format("%s", cursos.mostrar());
        arqEscrita.close();
    }

}
