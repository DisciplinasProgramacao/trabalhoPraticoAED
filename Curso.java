import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Curso {

    private int cod;
    private String nome;
    private int quantVagas;
    private ArrayList<Candidato> listaSelecionados;
    private Queue<Candidato> filaEspera;

   
    public Curso(int cod, String nome, int quantVagas) {
        this.cod = cod;
        this.nome = nome;
        this.quantVagas = quantVagas;
        this.listaSelecionados = new ArrayList<>();
        this.filaEspera = new LinkedList<>();

    }

    public void inserirFilaEspera(Candidato cand) {
        filaEspera.add(cand);
    }

    public boolean inserirListaSelecionados(Candidato cand) {
        if (listaSelecionados.size() < quantVagas) {
            listaSelecionados.add(cand);
            return true;
        } else if (cand.getMedia() > calcularMenorNotaSelecionados()) {
            //inserirFilaEspera(listaSelecionados.size() - 1);
            listaSelecionados.remove(listaSelecionados.size() - 1);
            listaSelecionados.add(cand);
            return true;
        }
        return false;
    }

    public double calcularMenorNotaSelecionados() {
        double menorNota = Double.MAX_VALUE;

        for (int i = 0; i < listaSelecionados.size(); i++) {
            Candidato candidato = listaSelecionados.get(i);
            double nota = candidato.getMedia();
            if (nota < menorNota) {
                menorNota = nota;
            }
        }

        return menorNota;
    }

    @Override
    public String toString() {
        return "Curso [cod=" + cod + ", nome=" + nome + ", quantVagas=" + quantVagas + ", listaSelecionados="
                + listaSelecionados + ", filaEspera=" + filaEspera + "]";
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

    public ArrayList<Candidato> getListaSelecionados() {
        return listaSelecionados;
    }

    public void setListaSelecionados(ArrayList<Candidato> listaSelecionados) {
        this.listaSelecionados = listaSelecionados;
    }

    public Queue<Candidato> getFilaEspera() {
        return filaEspera;
    }

    public void setFilaEspera(Queue<Candidato> filaEspera) {
        this.filaEspera = filaEspera;
    }

}