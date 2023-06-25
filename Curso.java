import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Curso {

    private int cod; // Código do curso
    private String nome; // Nome do curso
    private int quantVagas; // Quantidade de vagas disponíveis
    private ArrayList<Candidato> listaSelecionados; // Lista de candidatos selecionados
    private Queue<Candidato> filaEspera; // Fila de espera de candidatos

    public Curso(int cod, String nome, int quantVagas) {
        this.cod = cod;
        this.nome = nome;
        this.quantVagas = quantVagas;
        this.listaSelecionados = new ArrayList<>(); // Inicializa a lista de selecionados como uma ArrayList vazio
        this.filaEspera = new LinkedList<>(); // Inicializa a fila de espera como uma LinkedList vazia
    }

    public void inserirFilaEspera(Candidato cand) {
        filaEspera.add(cand); // Adiciona o candidato à fila de espera
    }

    public boolean inserirListaSelecionados(Candidato cand) {
        if (listaSelecionados.size() < quantVagas) {
            // Se ainda há vagas disponíveis, adiciona o candidato à lista de selecionados
            listaSelecionados.add(cand);
            return true;
        } else if (cand.getMedia() > calcularMenorNotaSelecionados()) {
            // Se o candidato possui uma média maior que a menor nota dos selecionados,
            // substitui o candidato de menor nota pela nova seleção
            listaSelecionados.remove(listaSelecionados.size() - 1); // Remove o último candidato (menor nota)
            listaSelecionados.add(cand); // Adiciona o novo candidato
            return true;
        }
        return false;
    }

    public double calcularMenorNotaSelecionados() {
        double menorNota = Double.MAX_VALUE;

        // Itera sobre a lista de selecionados para encontrar a menor nota
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

    // Getters e setters

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
