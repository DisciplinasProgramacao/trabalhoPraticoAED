public class FilaEspera {

    private CelulaCurso primeiro;
    private CelulaCurso ultimo;

    public FilaEspera() {
        primeiro = new CelulaCurso();
        ultimo = primeiro;
    }

    public void inserir(Curso c) {
        ultimo.prox = new CelulaCurso(c);
        ultimo = ultimo.prox;
    }

    public void mostrar() {
        System.out.print("[ ");
        for (CelulaCurso i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println("]");
    }
}
