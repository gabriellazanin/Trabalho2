public class Pessoa {
    private String nome;
    private String dataNascimento;
    private String numeroTelefone;

    // Construtor
    public Pessoa(String nome, String dataNascimento, String numeroTelefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroTelefone = numeroTelefone;
    }

    // Outros getters e setters, conforme necessário
    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "Data de Nascimento: " + dataNascimento + ", Telefone: " + numeroTelefone;
    }
}
