# Projeto de Gestão de Lista de Pessoas com Java

Este projeto é um sistema de gestão de listas duplamente ligadas para pessoas, com funcionalidades para dividir a lista por gênero, visualizar elementos e realizar operações como adição e remoção. Ele utiliza listas duplamente ligadas para armazenamento dinâmico e eficiente.

## Índice

- [Descrição](#descrição)
- [Funcionalidades](#funcionalidades)
- [Arquitetura do Projeto](#arquitetura-do-projeto)
- [Como Executar](#como-executar)
- [Requisitos](#requisitos)
- [Detalhes Técnicos](#detalhes-técnicos)
- [Exemplo de Uso](#exemplo-de-uso)

---

## Descrição

O sistema gerencia informações sobre pessoas (nome, data de nascimento e telefone) e armazena esses dados em arquivos de texto. As listas são manipuladas por meio de menus interativos, onde o usuário pode adicionar, remover e visualizar elementos, bem como dividir a lista principal em listas separadas por gênero, se baseando numa lista pré-definida dos nomes femininos e dos nomes masculinos que contém os dados dos nomes registados em Portugal. (https://irn.justica.gov.pt/Portals/33/Regras%20Nome%20Proprio/Lista%20Nomes%20Pr%C3%B3prios.pdf?ver=WNDmmwiSO3uacofjmNoxEQ%3D%3D) 

---

## Funcionalidades

1. **Visualizar Lista de Pessoas**:
   - Exibe a lista original de pessoas.
   - Exibe a lista em ordem reversa.
   - Exibe listas separadas por gênero (feminina e masculina)

2. **Manipular Dados na Lista**:
   - Adicionar pessoas ao início ou ao final da lista.
   - Remover pessoas do início ou do final.

3. **Dividir Dados**:
   - Divide a lista principal em duas, com base em arquivos usados de parâmetro contendo nomes femininos e masculinos usados em Portugal.

---


### Classes Principais

1. **`App`**: 
   - A classe principal do programa, onde contém o menu principal e a lógica de interação com o usuário.
   Estrutura e principais métodos 
   - Gerencia operações como visualização, adição e divisão da lista.

2. **`ListaDuplaPessoas`**:
   - Implementa a estrutura de uma lista duplamente ligada.
   - Fornece métodos para adicionar, remover e salvar dados.

3. **`CriarPessoa`**:
   - Facilita a criação de novos objetos do tipo `Pessoa`, solicitando informações ao usuário.

4. **`DivisorPorListas`**:
   - Divide os dados de um arquivo em dois arquivos separados por gênero.
   - Utiliza listas de nomes pré-definidas para classificação.

5. **`Pessoa`**:
   - Representa uma pessoa com nome, data de nascimento e telefone.

### Estrutura de Dados

- **Lista Duplamente Ligada**:
  - Cada elemento (`ELEM`) contém informações de uma pessoa e ponteiros para o próximo e o anterior.

---

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-repositorio/projeto-lista-pessoas.git
   cd projeto-lista-pessoas
https://irn.justica.gov.pt/Portals/33/Regras%20Nome%20Proprio/Lista%20Nomes%20Pr%C3%B3prios.pdf?ver=WNDmmwiSO3uacofjmNoxEQ%3D%3D

## Como Executar

1. Certifique-se que você se encontra no local que os arquivos estão e utilize o terminal para manipular o programa

2. Compile os arquivos .java, executando o seguinte comando para as classes serem criadas:

    javac *.java

3. Execute o programa:

    java App.java [nome_do_arquivo] 
    
    O [nome_do_arquivo] é opcional. Se não for especificado, será solicitado durante a execução.

### Requisitos

- Java: Versão 8 ou superior.
- Um arquivo de entrada com o formato:
    Nome da pessoa
    Data de nascimento (dd/mm/yyyy)
    Telefone

## Detalhes Técnicos

Os arquivos de texto devem conter os dados das pessoas organizados sequencialmente.
Os nomes femininos e masculinos usados como parâmetros para dividir a lista devem estar em arquivos separados.

## Exemplo de Uso
### Entrada

- Arquivo dados.txt:

Maria Silva
01/01/1990
123456789

João Santos
02/02/1985
987654321

- Arquivos de nomes:

nomes_femininos.txt:

Alice
Maria

nomes_masculinos.txt:

João
Carlos

- Execução

Ao dividir a lista, deve-se obter esse resultado:

* Arquivo dadosfem.txt:

Maria Silva
01/01/1990
123456789

* Arquivo dadosmasc.txt:

João Santos
02/02/1985
987654321

