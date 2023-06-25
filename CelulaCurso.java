public class CelulaCurso {

    public Curso elemento; // Referência para o objeto Curso
    public CelulaCurso prox; // Referência para a próxima célula na lista

    // Construtor vazio
    public CelulaCurso() {
        this(null);
    }

    // Construtor que recebe um objeto Curso
    public CelulaCurso(Curso c) {
        this.elemento = c; // Atribui o objeto Curso à célula
        this.prox = null; // Inicializa a referência para a próxima célula como nula
    }

}
