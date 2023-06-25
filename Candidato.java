public class Candidato {

    private String nome;
    private double notaRed;
    private double notaMat;
    private double notaLing;
    private int op1;
    private int op2;
    private double media;

    // Construtor da classe Candidato
    public Candidato(String nome, double notaRed, double notaMat, double notaLing, int op1, int op2) {
        this.nome = nome;
        this.notaRed = notaRed;
        this.notaMat = notaMat;
        this.notaLing = notaLing;
        this.op1 = op1;
        this.op2 = op2;
    }

    // Sobrescrita do método toString() para retornar uma representação em String do
    // objeto Candidato
    @Override
    public String toString() {
        return "Candidato [nome=" + nome + ", notaRed=" + notaRed + ", notaMat=" + notaMat + ", notaLing=" + notaLing
                + ", op1=" + op1 + ", op2=" + op2 + ", media=" + media + "]";
    }

    // Métodos getters e setters para acessar e modificar os atributos da classe

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaRed() {
        return notaRed;
    }

    public void setNotaRed(double notaRed) {
        this.notaRed = notaRed;
    }

    public double getNotaMat() {
        return notaMat;
    }

    public void setNotaMat(double notaMat) {
        this.notaMat = notaMat;
    }

    public double getNotaLing() {
        return notaLing;
    }

    public void setNotaLing(double notaLing) {
        this.notaLing = notaLing;
    }

    public int getOp1() {
        return op1;
    }

    public void setOp1(int op1) {
        this.op1 = op1;
    }

    public int getOp2() {
        return op2;
    }

    public void setOp2(int op2) {
        this.op2 = op2;
    }

    // Método para calcular a média das notas (média arredondada para duas casas
    // decimais)
    public double getMedia() {
        double media = (notaLing + notaMat + notaRed) / 3;
        double arredondado = Math.round(media * 100.0) / 100.0;
        return arredondado;
    }

    public void setMedia(double media) {
        this.media = media;
    }

}
