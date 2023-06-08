public class CelulaCurso {

    public Curso elemento;
    public CelulaCurso prox;

    public CelulaCurso() {
        this(null);
    }

    public CelulaCurso(Curso c) {
        this.elemento = c;
        this.prox = null;
    }

}
