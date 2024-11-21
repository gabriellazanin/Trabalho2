import java.util.Scanner;

public class CriarPessoa {

    public static Pessoa criarPessoa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento (dd/mm/yyyy): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("Digite o número de telefone: ");
        String numeroTelefone = scanner.nextLine();

        return new Pessoa(nome, dataNascimento, numeroTelefone);
    }
}
