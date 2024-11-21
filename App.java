import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Forneça o nome do ficheiro como argumento.");
            return;
        }

        String nomeFicheiro = args[0];
        ListaSimplesPessoas listaOriginal = new ListaSimplesPessoas(nomeFicheiro); // Carrega a lista do arquivo

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Visualização dos elementos da lista");
            System.out.println("2. Introdução de novos elementos na lista");
            System.out.println("3. Dividir lista em feminino e masculino");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    visualizarElementos(scanner, listaOriginal);
                    break;

                case 2:
                    introduzirElementos(scanner, listaOriginal, nomeFicheiro);
                    break;
                case 3:
                    dividirDados(scanner);
                    break;
                case 0:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void visualizarElementos(Scanner scanner, ListaSimplesPessoas listaOriginal) {
        char opcaoSubmenu;
        do {
            System.out.println("\n--- Visualização dos Elementos da Lista ---");
            System.out.println("a) Visualizar a lista original de pessoas");
            System.out.println("0) Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoSubmenu = scanner.next().toLowerCase().charAt(0);

            switch (opcaoSubmenu) {
                case 'a':
                    System.out.println("\n--- Lista de Pessoas ---");
                    listaOriginal.mostra(); // Exibe a lista original
                    break;

                case '0':
                    System.out.println("Voltando ao menu principal.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoSubmenu != '0');
    }

    private static void introduzirElementos(Scanner scanner, ListaSimplesPessoas listaOriginal, String nomeFicheiro) {
        char opcaoSubmenu;
        do {
            System.out.println("\n--- Introdução de Novos Elementos na Lista ---");
            System.out.println("a) Adicionar nova pessoa no início");
            System.out.println("b) Adicionar nova pessoa no final");
            System.out.println("c) Remover pessoa do início");
            System.out.println("d) Remover pessoa do final");
            System.out.println("0) Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcaoSubmenu = scanner.next().toLowerCase().charAt(0);

            switch (opcaoSubmenu) {
                case 'a':
                    Pessoa novaPessoaInicio = CriarPessoa.criarPessoa();
                    listaOriginal.ColocaElementoCabecaLista(novaPessoaInicio);
                    System.out.println("Pessoa adicionada no início da lista.");
                    listaOriginal.salvarLista(nomeFicheiro);
                    break;

                case 'b':
                    Pessoa novaPessoaFim = CriarPessoa.criarPessoa();
                    listaOriginal.ColocaElementoCaudaLista(novaPessoaFim);
                    System.out.println("Pessoa adicionada no final da lista.");
                    listaOriginal.salvarLista(nomeFicheiro);
                    break;

                case 'c':
                    Pessoa removidaInicio = listaOriginal.RetiraElementoCabecaLista();
                    if (removidaInicio != null) {
                        System.out.println("Pessoa removida do início: " + removidaInicio);
                        listaOriginal.salvarLista(nomeFicheiro);
                    } else {
                        System.out.println("A lista está vazia.");
                    }
                    break;

                case 'd':
                    Pessoa removidaFim = listaOriginal.RetiraElementoCaudaLista();
                    if (removidaFim != null) {
                        System.out.println("Pessoa removida do final: " + removidaFim);
                        listaOriginal.salvarLista(nomeFicheiro);
                    } else {
                        System.out.println("A lista está vazia.");
                    }
                    break;

                case '0':
                    System.out.println("Voltando ao menu principal.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcaoSubmenu != '0');
    }

    public static void salvarLista(Scanner scanner, ListaSimplesPessoas listaOriginal, String nomeFicheiro) {
        System.out.print("Digite o nome do arquivo para salvar a lista: ");
        String nomeArquivo = scanner.nextLine();
        listaOriginal.salvarLista(nomeArquivo);
        System.out.println("Lista salva no arquivo: " + nomeArquivo);
    }

    private static void dividirDados(Scanner scanner) {
        // Solicita o nome dos arquivos para os dados e listas de nomes
        System.out.print("Digite o nome do arquivo com os dados (ex: dados.txt): ");
        String ficheiroDados = scanner.nextLine();
        
        System.out.print("Digite o nome do arquivo para os dados femininos (ex: dadosfem.txt): ");
        String ficheiroFem = scanner.nextLine();
        
        System.out.print("Digite o nome do arquivo para os dados masculinos (ex: dadosmasc.txt): ");
        String ficheiroMasc = scanner.nextLine();
        
        System.out.print("Digite o nome do arquivo com os nomes femininos (ex: nomes_femininos.txt): ");
        String nomesFemininos = scanner.nextLine();
        
        System.out.print("Digite o nome do arquivo com os nomes masculinos (ex: nomes_masculinos.txt): ");
        String nomesMasculinos = scanner.nextLine();

        // Chama o método dividirDados do DivisorPorListas
        DivisorPorListas.dividirDados(ficheiroDados, ficheiroFem, ficheiroMasc, nomesFemininos, nomesMasculinos);
    }
}