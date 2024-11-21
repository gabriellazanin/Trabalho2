# Projeto de Gestão de Lista de Pessoas com Java

Este projeto é um sistema de gestão de listas duplamente ligadas para pessoas, com funcionalidades para dividir a lista por gênero, visualizar elementos e realizar operações como adição e remoção. Ele utiliza listas duplamente ligadas para armazenamento dinâmico e eficiente.

## Índice

- [Descrição](#descrição)
- [Funcionalidades](#funcionalidades)
- [Estruturas das Classes](#estruturas-das-classes)
- [Como Executar](#como-executar)
- [Requisitos](#requisitos)
- [Detalhes Técnicos](#detalhes-técnicos)
- [Exemplo de Uso](#exemplo-de-uso)

---

## Descrição

O sistema gerencia informações sobre pessoas (nome, data de nascimento e telefone) e armazena esses dados em arquivos de texto. As listas são manipuladas por meio de menus interativos, onde o usuário pode adicionar, remover e visualizar elementos, bem como dividir a lista principal em listas separadas por gênero, se baseando numa lista pré-definida dos nomes femininos e dos nomes masculinos que contém os dados dos nomes registados em Portugal. [Clique aqui para aceder o link do governo.](https://irn.justica.gov.pt/Portals/33/Regras%20Nome%20Proprio/Lista%20Nomes%20Pr%C3%B3prios.pdf?ver=WNDmmwiSO3uacofjmNoxEQ%3D%3D)

---

## Funcionalidades

O programa apresenta um menu principal e alguns submenus.

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


### Estruturas das Classes

1. **`App`**: 
   - A classe principal do programa, onde contém o menu principal e a lógica de interação com o usuário.
   Estrutura e principais métodos:
* main:
  - Executa o programa principal
  - Solicita o nome do arquivo para carregar a lista de pessoas
  - Inicializa as listas de pessoas como `listaOriginal`, `listaFeminino` e `listaMasculino`.
  - Exibe um menu principal para selecionar as operações desejadas:
     1. Visualizar elementos das listas;
     2. Introduzir novos elementos na lista;
     3. Dividir a lista por gênero;
     4. Sair do programa.

* Métodos auxiliares:
  - `solicitarNomeFicheiro`: solicita o nome do arquivo fornecido pelo usuário.
  - `visualizarElementos`: exibe um submenu para visualizar as diferentes listas (original, reversa, femninina e masculina)
  - `introduzirElementos`: oferece as opções de adicionar pessoas no início ou no fim da lista, remover pessoas do início e do fim da lista. Todas as alterações feitas já são salvas por defeito.
  - `dividirDados`: um dos métodos mais importantes do programa, uma vez que solicita os arquivos de dados e listas dos nomes para assim separar as pessoas pelo gênero. Usa a classe DivisorPorListas para executar essa função.
     
2. **`ListaDuplaPessoas`**:
   - Implementa a estrutura de uma lista duplamente ligada para armazenar e manipular objetos.
     Estrutura e principais métodos:
   * Atributos principais: head (aponta para o primerio elemento da lista) e tail (aponta para o último elemento da lista).
   * Construtores:
     - Sem parâmetros: Inicializa uma lista vazia.
     - Com parâmetro (String ficheiro): Carrega uma lista de pessoas de um arquivo. Cada pessoa é criada e adicionada ao final da lista.
   * Manipulação da lista:
     - `ColocaElementoCabecaLista`: Adiciona uma pessoa no início da lista.
     - `ColocaElementoCaudaLista`: Adiciona uma pessoa no final da lista.
     - `RetiraElementoCabecaLista`: Remove e retorna a pessoa no início da lista.
     - `RetiraElementoCaudaLista`: Remove e retorna a pessoa no final da lista.
     - `mostra`: Exibe todas as pessoas da lista na ordem normal.
     - `mostraReversa`: Exibe todas as pessoas na ordem reversa.
     - `salvarLista`: Salva as informações da lista em um arquivo.

### Classe Auxiliar ELEM
   Uma classe auxiliar usada pela ListaDuplaPessoas para armazenar cada elemento que se encontra na lista. 
   * Atributos:
     - `info`: Objeto Pessoa que contém os dados.
     - `next`: referência ao próximo elemento na lista.
     - `prev`: refêrencia ao elemento anterior.
   * Construtor: inicializa um elemento com uma instância de Pessoa. 

3. **`CriarPessoa`**:
   - Um método para criar uma nova pessoa com base nas entradas do usuário.
   - Utiliza o Scanner para solicitar ao usuário os dados de entrada e retorna um objeto Pessoa com esses dados.

4. **`DivisorPorListas`**:
   - Classe que é responsável por dividir um arquivo de dados em dois novos arquivos, baseando-se nas listas de nomes femininos e masculinos fornecidas.
     Estrutura e principais métodos:
   * `carregarNomes`:
     - Lê os nomes de um arquivo e armazena em um Set (conjunto).
     - Converte os nomes para letras mínusculas para facilitar a comparação.
   * `dividirDados`:
     - Lê o arquivo de dados linha a linha, identifica se o nome está na lista masculina ou feminina e salva as informações no arquivo apropriado.
     - Se o nome não se encontrar em alguma lista, exibe um aviso de erro.

5. **`Pessoa`**:
   - Representa uma pessoa com nome, data de nascimento e telefone. Esses são seus atributos.
   - O Construtor recebe esses dados e inicializa os atributos.
   * Métodos:
     - `getNome`, `getDataNascimento` e `getNumeroTelefone` são métodos de acesso.
     - `toString` retorna uma representação em string da pessoa.


## Como Executar

1. Certifique-se que você se encontra no local que os arquivos estão e utilize o terminal para manipular o programa

2. Compile os arquivos .java, executando o seguinte comando para as classes serem criadas:

    `javac *.java`

3. Execute o programa:

    `java App.java [nome_do_arquivo]`
    
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

   - Arquivo nomes_femininos.txt:

Alice

Maria

   - Arquivo nomes_masculinos.txt:

João 

Carlos

### Execução

Ao selecionar para dividir a lista, deve-se obter esse resultado:

* Arquivo dadosfem.txt:


Maria Silva


01/01/1990


123456789


* Arquivo dadosmasc.txt:

João Santos


02/02/1985


987654321

