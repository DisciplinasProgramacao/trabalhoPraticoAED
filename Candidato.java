public class Candidato {

    private String nome;
    private double notaRed;
    private double notaMat;
    private double notaLing;
    private int op1;
    private int op2;
    private double media;

    public Candidato() {
        this(null, 0, 0, 0, 0, 0);
    }
    // teste
    public Candidato(String nome, double notaRed, double notaMat, double notaLing, int op1, int op2) {
        this.nome = nome;
        this.notaRed = notaRed;
        this.notaMat = notaMat;
        this.notaLing = notaLing;
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public String toString() {
        return "Candidato [nome=" + nome + ", notaRed=" + notaRed + ", notaMat=" + notaMat + ", notaLing=" + notaLing
                + ", op1=" + op1 + ", op2=" + op2 + ", media=" + media + "]";
    }

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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

}
