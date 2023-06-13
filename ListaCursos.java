public class ListaCursos {

    private CelulaCurso primeiro;
    private CelulaCurso ultimo;

    public ListaCursos() {
        primeiro = new CelulaCurso();
        ultimo = primeiro;
    }

    public void inserirFim(Curso c) {
        ultimo.prox = new CelulaCurso(c);
        ultimo = ultimo.prox;
    }

    public String mostrar() {
        StringBuilder sb = new StringBuilder();

        for (CelulaCurso celula = primeiro.prox; celula != null; celula = celula.prox) {
            Curso curso = celula.elemento;

            sb.append(curso.getNome()).append(" ").append(curso.calcularMenorNotaSelecionados()).append("\n");
            sb.append("Selecionados\n");
            for (Candidato candidato : curso.getListaSelecionados()) {
                sb.append(candidato.getNome()).append(" ").append(candidato.getMedia()).append("\n");
            }
            sb.append("Fila de Espera\n");
            for (Candidato candidato : curso.getFilaEspera()) {
                sb.append(candidato.getNome()).append(" ").append(candidato.getMedia()).append("\n");
            }
        }

        return sb.toString();
    }

    public Curso pesquisar(int codCurso) {
        for (CelulaCurso i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento.getCod() == codCurso) {
                return i.elemento;
            }
        }
        return null;
    }

}
