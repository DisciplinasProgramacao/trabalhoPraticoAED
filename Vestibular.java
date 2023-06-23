
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
        this.cursos = cursos;
        this.candidatos = candidatos;
        this.qtdCursos = qtdCursos;
        this.qtdCandidatos = qtdCandidatos;

    }

    public void lerEntrada(String nomeArq) throws FileNotFoundException {
        File arquivo = new File("entrada.txt");
        Scanner arqLeit = new Scanner(new FileInputStream(arquivo), "UTF-8");

        // Lê o número de cursos (N) e o número de candidatos (M)
        qtdCursos = arqLeit.nextInt();
        qtdCandidatos = arqLeit.nextInt();
        arqLeit.nextLine(); // Move para a próxima linha

        // Lê as informações dos cursos
        for (int i = 0; i < qtdCursos; i++) {
            String linha = arqLeit.nextLine();
            String[] dadosCurso = linha.split(";");

            int codigoCurso = Integer.parseInt(dadosCurso[0]);
            String nomeCurso = dadosCurso[1];
            int vagasCurso = Integer.parseInt(dadosCurso[2]);

            Curso curso = new Curso(codigoCurso, nomeCurso, vagasCurso);
            cursos.inserirFim(curso);
        }

        // Lê as informações dos candidatos

        arqLeit.nextLine(); // Move para a próxima linha
        for (int i = 0; i < qtdCandidatos; i++) {
            String linha = arqLeit.nextLine();
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
        for (Candidato candidato : candidatos) {
            // Obtém as opções de curso do candidato
            int opcao1 = candidato.getOp1();
            int opcao2 = candidato.getOp2();

            // Pesquisa os cursos nas opções do candidato
            Curso cursoOpcao1 = cursos.pesquisar(opcao1);
            Curso cursoOpcao2 = cursos.pesquisar(opcao2);

            // Verifica se o candidato foi selecionado para a primeira opção de curso
            boolean selecionadoOpcao1 = cursoOpcao1.inserirListaSelecionados(candidato);

            // Verifica se o candidato foi selecionado para a segunda opção de curso
            boolean selecionadoOpcao2 = false;
            if (!selecionadoOpcao1 && cursoOpcao2 != null) {
                selecionadoOpcao2 = cursoOpcao2.inserirListaSelecionados(candidato);
                cursoOpcao1.inserirFilaEspera(candidato);
            }

            // Caso o candidato não tenha sido selecionado para nenhuma opção,
            // adiciona-o nas filas de espera de ambos os cursos
            if (!selecionadoOpcao1 && !selecionadoOpcao2) {
                if (cursoOpcao1 != null) {
                    cursoOpcao1.inserirFilaEspera(candidato);
                }
                if (cursoOpcao2 != null) {
                    cursoOpcao2.inserirFilaEspera(candidato);
                }
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
        double pivo = (array[(esq + dir) / 2].getMedia() + array[(esq + dir) / 2].getNotaRed()) / 2;

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

    public void escreverSaida(String nomeArq) throws FileNotFoundException, UnsupportedEncodingException {
        Formatter arqEscrita = new Formatter("saida.txt", "UTF-8");
        arqEscrita.format("%s", cursos.mostrar());
        cursos.mostrar();
        arqEscrita.close();
    }

}
