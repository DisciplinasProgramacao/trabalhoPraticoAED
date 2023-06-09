public class ListaCursos {

    private CelulaCurso primeiro;
    private CelulaCurso ultimo;

    public ListaCursos() {
    }

    public void inserirFim(Curso c) {
        ultimo.prox = new CelulaCurso(c);
        ultimo = ultimo.prox;

    }

    public String mostrar() {
    }

    public Curso pesquisar(int codCurso) {

    }

}
