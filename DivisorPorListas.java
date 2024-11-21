import java.io.*;
import java.util.*;

public class DivisorPorListas {

    // Função para carregar os nomes de um arquivo para um Set
    private static Set<String> carregarNomes(String nomeArquivo) {
        Set<String> nomes = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String nome;
            while ((nome = br.readLine()) != null) {
                nomes.add(nome.trim().toLowerCase()); // Armazena o nome em minúsculas
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os nomes de " + nomeArquivo + ": " + e.getMessage());
        }
        return nomes;
    }

    public static void dividirDados(
            String ficheiroDados, 
            String ficheiroFem, 
            String ficheiroMasc, 
            String nomesFemininos, 
            String nomesMasculinos
    ) {
        Set<String> listaFemininos = carregarNomes(nomesFemininos);
        Set<String> listaMasculinos = carregarNomes(nomesMasculinos);

        try (
            BufferedReader br = new BufferedReader(new FileReader(ficheiroDados));
            BufferedWriter bwFem = new BufferedWriter(new FileWriter(ficheiroFem));
            BufferedWriter bwMasc = new BufferedWriter(new FileWriter(ficheiroMasc))
        ) {
            String linha;
            String nomeCompleto = null;
            String nome = null;
            String dataNascimento = null;
            String telefone = null;
            
            // Processar cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                if (nomeCompleto == null) {
                    // Lê o nome completo e o primeiro nome para comparação
                    nomeCompleto = linha.trim(); // Nome completo (sem alteração)
                    nome = nomeCompleto.split(" ")[0].toLowerCase(); // Primeiro nome para comparação (minúsculo)
                } else if (dataNascimento == null) {
                    dataNascimento = linha.trim(); // Lê a data de nascimento
                } else if (telefone == null) {
                    telefone = linha.trim(); // Lê o telefone

                    // Verifica se o primeiro nome está na lista masculina ou feminina
                    if (listaMasculinos.contains(nome)) {
                        bwMasc.write(nomeCompleto); // Adiciona o nome completo (sem modificação)
                        bwMasc.newLine();
                        bwMasc.write(dataNascimento);
                        bwMasc.newLine();
                        bwMasc.write(telefone);
                        bwMasc.newLine();
                    } else if (listaFemininos.contains(nome)) {
                        bwFem.write(nomeCompleto); // Adiciona o nome completo (sem modificação)
                        bwFem.newLine();
                        bwFem.write(dataNascimento);
                        bwFem.newLine();
                        bwFem.write(telefone);
                        bwFem.newLine();
                    } else {
                        System.out.println("Nome não identificado: " + nomeCompleto);
                    }

                    // Reinicia as variáveis para o próximo bloco
                    nomeCompleto = null;
                    nome = null;
                    dataNascimento = null;
                    telefone = null;
                }
            }

            System.out.println("Divisão concluída. Dados salvos em: " + ficheiroFem + " e " + ficheiroMasc);
        } catch (IOException e) {
            System.out.println("Erro ao processar os dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String ficheiroDados = "dados.txt";
        String ficheiroFem = "dadosfem.txt";
        String ficheiroMasc = "dadosmasc.txt";
        String nomesFemininos = "nomes_femininos.txt";
        String nomesMasculinos = "nomes_masculinos.txt";
        
        dividirDados(ficheiroDados, ficheiroFem, ficheiroMasc, nomesFemininos, nomesMasculinos);
    }
}
