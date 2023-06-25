public class ListaCursos {

    private CelulaCurso primeiro; // Referência para a primeira célula da lista
    private CelulaCurso ultimo; // Referência para a última célula da lista

    public ListaCursos() {
        primeiro = new CelulaCurso(); // Cria a primeira célula vazia
        ultimo = primeiro; // Inicialmente, a primeira célula também é a última
    }

    public void inserirFim(Curso c) {
        // Insere um novo curso no final da lista
        ultimo.prox = new CelulaCurso(c); // Cria uma nova célula com o curso
        ultimo = ultimo.prox; // Atualiza a referência para a última célula
    }

    public String mostrar() {
        StringBuilder sb = new StringBuilder();

        sb.append("Processo seletivo da Universidade Stark\n\n");

        // Percorre a lista de cursos
        for (CelulaCurso celula = primeiro.prox; celula != null; celula = celula.prox) {
            Curso curso = celula.elemento; // Obtém o curso da célula atual

            sb.append("Curso: ").append(curso.getNome()).append(" - Nota de corte: ")
                    .append(curso.calcularMenorNotaSelecionados()).append("\n");
            sb.append("Selecionados:\n");
            // Percorre a lista de candidatos selecionados do curso
            for (Candidato candidato : curso.getListaSelecionados()) {
                sb.append("🟩").append(candidato.getNome()).append(" ").append(candidato.getMedia()).append("\n");
            }
            sb.append("Fila de Espera:\n");
            // Percorre a fila de espera do curso
            for (Candidato candidato : curso.getFilaEspera()) {
                sb.append("🟨").append(candidato.getNome()).append(" ").append(candidato.getMedia()).append("\n");
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public Curso pesquisar(int codCurso) {
        // Pesquisa um curso na lista pelo código
        for (CelulaCurso i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento.getCod() == codCurso) {
                return i.elemento; // Retorna o curso encontrado
            }
        }
        return null; // Retorna null se o curso não for encontrado
    }

}
