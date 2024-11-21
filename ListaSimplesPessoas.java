import java.io.*;

// Classe auxiliar que representa um nó da lista ligada
class ELEM {
    Pessoa info;
    ELEM next;

    public ELEM(Pessoa pessoa) {
        info = pessoa;
        next = null;
    }
}

public class ListaSimplesPessoas {
    ELEM Lista;

    public ListaSimplesPessoas() {
        Lista = null;
    }

    // Construtor que carrega a lista a partir de um ficheiro
    public ListaSimplesPessoas(String ficheiro) {
        try (BufferedReader in = new BufferedReader(new FileReader(ficheiro))) {
            String linha;
            while ((linha = in.readLine()) != null) {
                String nome = linha;
                String dataNascimento = in.readLine();
                String numeroTelefone = in.readLine();

                Pessoa pessoa = new Pessoa(nome, dataNascimento, numeroTelefone);
                ColocaElementoCabecaLista(pessoa);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
        }
    }

    // Método para adicionar uma pessoa no início da lista
    public void ColocaElementoCabecaLista(Pessoa pessoa) {
        ELEM aux = new ELEM(pessoa);
        aux.next = Lista;
        Lista = aux;
    }

    // Método para adicionar uma pessoa no final da lista
    public void ColocaElementoCaudaLista(Pessoa pessoa) {
        ELEM aux = new ELEM(pessoa);
        if (Lista == null) {
            Lista = aux;
        } else {
            ELEM w = Lista;
            while (w.next != null) {
                w = w.next;
            }
            w.next = aux;
        }
    }

    // Método para remover uma pessoa do início da lista
    public Pessoa RetiraElementoCabecaLista() {
        if (Lista == null) return null;
        Pessoa tmp = Lista.info;
        Lista = Lista.next;
        return tmp;
    }

    // Método para remover uma pessoa do final da lista
    public Pessoa RetiraElementoCaudaLista() {
        if (Lista == null) return null;

        if (Lista.next == null) {
            Pessoa tmp = Lista.info;
            Lista = null;
            return tmp;
        }

        ELEM w = Lista;
        while (w.next.next != null) {
            w = w.next;
        }
        Pessoa tmp = w.next.info;
        w.next = null;
        return tmp;
    }

    // Método para mostrar todas as pessoas na lista
    public void mostra() {
        ELEM w = Lista;
        while (w != null) {
            System.out.println(w.info);
            w = w.next;
        }
    }

    // Método para salvar a lista de volta ao ficheiro (opcional)
    public void salvarLista(String ficheiro) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(ficheiro))) {
            ELEM w = Lista;
            while (w != null) {
                out.write(w.info.getNome());
                out.newLine();
                out.write(w.info.getDataNascimento());
                out.newLine();
                out.write(w.info.getNumeroTelefone());
                out.newLine();
                w = w.next;
            }
            System.out.println("Lista salva com sucesso em " + ficheiro);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

}
