import java.util.Arrays;
import java.util.Queue;

public class Curso {

    private int cod;
    private String nome;
    private int quantVagas;
    private Candidato[] listaSelecionados;
    private Queue<Candidato> filaEspera;
    ListaCursos listaCursos;

    public Curso() {

    }

    public Curso(int cod, String nome, int quantVagas) {

    }

    public void inserirFilaEspera(Candidato cand) {

    }

    public boolean inserirListaSelecionados(Candidato cand) {
        
    }

    @Override
    public String toString() {
        return "Curso [cod=" + cod + ", nome=" + nome + ", quantVagas=" + quantVagas + ", listaSelecionados="
                + Arrays.toString(listaSelecionados) + "]";
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantVagas() {
        return quantVagas;
    }

    public void setQuantVagas(int quantVagas) {
        this.quantVagas = quantVagas;
    }

    public Candidato[] getListaSelecionados() {
        return listaSelecionados;
    }

    public void setListaSelecionados(Candidato[] listaSelecionados) {
        this.listaSelecionados = listaSelecionados;
    }

}