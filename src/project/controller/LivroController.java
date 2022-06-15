package project.controller;

import de.vandermeer.asciitable.AsciiTable;
import project.Utils.Util;
import project.model.Livro;


import java.util.*;

public class LivroController  {
    AsciiTable at = new AsciiTable();
    Util metodos = new Util();
    private int countBook = 1;
    List<Livro> listaLivros = new ArrayList<>();

    public LivroController() {
        addLivros(new Livro("G Livro", 1 , 2001, "Braga Nunes",10.0, 100));
        addLivros(new Livro("F Livro", 2 , 2002, "Paulo Coelho",10.0, 100));
        addLivros(new Livro("E livro", 3 , 2003, "Karl Marx",10.0, 100));
        addLivros(new Livro("D Livro", 3 , 2003, "Felipe Neto",10.0, 100));
        addLivros(new Livro("C Livro", 3 , 2003, "Max Weber",10.0, 100));
        addLivros(new Livro("B livro", 3 , 2003, "Rick Riordan",10.0, 100));
        addLivros(new Livro("A Livro", 3 , 2003, "Angela Davis",10.0, 100));
    }

    /**
     *
     * @param livro - livro a ser adicionado
     * <br>
     *   Método serve para criar o ID de forma dinâmica para as classes instanciadas no sistema
     */
    public void addLivros(Livro livro){
        livro.setId(countBook++);
        listaLivros.add(livro);
    }

    /**
     * Monta os livros na tabela da ASCII Table
     * <br>
     * É chamado uma nova ascii table para resetar a tabela
     */
    public void montarListagemLivros(){
        at = new AsciiTable();
        at.addRule();
        at.addRow("Identificador", "Nome dos livros", "Edição", "Ano de publicação", "Autor", "Preço", "Quantidade");
        for(Livro livro : listaLivros){
            at.addRule();
            at.addRow(livro.getId(), livro.getNome(), livro.getEdicao(), livro.getAnoPublicacao(), livro.getAutor(), livro.getValorProduto(), livro.getQuantidade());
        }
        at.addRule();
    }

    /**
     * Exibe a tabela na tela
     * <br>
     * Chama a função de montar a tabela para renderizar nessa função de listagem
     */
    public void listagemLivros(){
        montarListagemLivros();
        String rend = at.render();
        System.out.println(rend);
        System.out.println();
    }

    /**
     * Ordena a lista de livros por nome utilizando o sort
     */
    public void ordenarPorNome(){
        List<Livro> listaLivrosOrdenacao = getListaLivros();
        listaLivrosOrdenacao.sort(Comparator.comparing(Livro::getNome));
        setListaLivros(listaLivrosOrdenacao);
        listagemLivros();
    }

    /**
     * Método responsável por criar um livro
     */
    public void cadastrarLivros()  {
        String nome;
        int edicao;
        int anoPublicacao;
        String autor;
        double valor;
        int quantidade;
        /*
         * A função valida String
         * <br>
         *  Pede para o usuário digitar os dados do livro
         * <br>
         *  A função validar string vai validar a string e retornar uma string
         * <br>
         *  Caso contraário, retorna um erro
         * <br>
         *  A função valida int
         * <br>
         *  Pede para o usuário digitar algum dado do livro
         * <br>
         *  A função validar int vai validar o inteiro e retornar um inteiro
         * <br>
         *  Caso contraário, retorna um erro
         */
        nome = metodos.validarString("Digite o nome do livro: ");
        edicao = metodos.validarInt("Digite a edição do livro: ");
        anoPublicacao = metodos.validarInt("Digite o ano de publicação do livro: ");
        autor = metodos.validarString("Digite o autor do livro: ");
        valor = metodos.validarDouble("Digite o valor do livro: ");
        quantidade = metodos.validarInt("Digite a quantidade do livro: ");

        System.out.println("Livro criado com sucesso! Nome do livro: " + nome);
        addLivros(new Livro(nome,edicao,anoPublicacao,autor, valor, quantidade));
        listagemLivros();
        System.out.println("------------------------------");
        System.out.println("Carregando...");
    }

    /**
     * @param id id do livro que será buscado
     *   Com esse ID montamos uma tabela com os dados do livro
     */
    public void imprimirLivroBuscadoID(int id){
        at = new AsciiTable();
        at.addRule();
        at.addRow("Identificador", "Nome dos livros", "Edição", "Ano de publicação", "Autor", "Preço", "Quantidade");
        for (Livro livro : listaLivros){
            if (livro.getId() == id){
                at.addRule();
                at.addRow(livro.getId(), livro.getNome(), livro.getEdicao(), livro.getAnoPublicacao(), livro.getAutor(), livro.getValorProduto(), livro.getQuantidade());
            }
        }
        at.addRule();
        String rend = at.render();
        System.out.println(rend);
    }

    /**
     * @param id id do livro que será buscado
     * @return caso o ID seja igual ao do livro, retorna o livro
     * caso contrário, retorna -1
     */
    public int validadorID(int id){
        for(Livro livro : listaLivros){
            if (livro.getId() == id){
                return livro.getId();
            }
        }
        return -1;
    }

    /**
     * Esse método é responsável por buscar um livro pelo ID
     * <br>
     *  Caso o retorno do validadorID seja -1, o livro não existe
     *  <br>
     *  Caso contrário, o livro existe
     */
    public void buscarBookId(){
        int idBook = metodos.inputMessage("Informe o identificador que deseja buscar: ");
        int retornoValidador = validadorID(idBook);
        if (retornoValidador == -1) {
             System.out.println("Livro não encontrado");
            System.out.println("Voltando ao menu...");
        } else {
            imprimirLivroBuscadoID(retornoValidador);
        }
    }

    /**
     * O método editar livro serve para poder editar um livro com base no ID do livro
     * <br>
     * O looping while serve para poder manter o usuário dentro do menu de edição e ele poder sair caso aperte 7
     * <br>
     *  A função valida String
     *  <br>
     *  Pede para o usuário digitar os dados do livro
     *  <br>
     *  A função validar string vai validar a string e retornar uma string
     *  <br>
     *  Caso contraário, retorna um erro
     *  <br>
     *  A função valida int
     *  <br>
     *  Pede para o usuário digitar algum dado do livro
     *  <br>
     *  A função validar int vai validar o inteiro e retornar um inteiro
     *  <br>
     *  Caso contraário, retorna um erro
     */
    public void editarLivro() {
        Scanner input = new Scanner(System.in);
        boolean repetir = true;
        listagemLivros();

        System.out.print("Escolha o ID do livro que deseja editar: ");
        int idBook = input.nextInt();
        // Essa função vai retonar o ID já filtrado
        int retornoValidador = validadorID(idBook);

        System.out.println("Escolha qual campo deseja editar: ");
        while(repetir){
            metodos.menuSecundario();
            int item = input.nextInt();
            switch (item){
                case 1:
                    String nome = metodos.validarString("Digite o novo nome do livro: ");
                    /*
                     * Aqui estou fazendo a edição do livro com base no ID filtrando
                     * Estou passando o nome que ele quer editar como parametro
                     */
                    editarNome(retornoValidador, nome);
                    listagemLivros();
                    break;
                case 2:
                    int edicao = metodos.validarInt("Digite a nova edição do livro: ");
                    /*
                     * Aqui estou fazendo a edição do livro com base no ID filtrando
                     * Estou passando a edição do livro que ele quer editar como parametro
                     */
                    editarEdicaoLivro(retornoValidador, edicao);
                    listagemLivros();
                    break;
                case 3:
                    String autor = metodos.validarString("Digite o novo autor do livro: ");
                    /*
                     * Aqui estou fazendo a edição do livro com base no ID filtrando
                     * Estou passando o autor que ele quer editar como parametro
                     */
                    editarAutor(retornoValidador, autor);
                    listagemLivros();
                    break;
                case 4:
                    int anoPublicacao = metodos.validarInt("Digite o novo ano de publicação do livro: ");
                    /*
                     * Aqui estou fazendo a edição do livro com base no ID filtrando
                     * Estou passando o ano de publicação que ele quer editar como parametro
                     */
                    editarAnoPublicacao(retornoValidador, anoPublicacao);
                    listagemLivros();
                    break;
                case 5:
                    double valorProduto = metodos.validarDouble("Digite o novo valor do livro: ");
                    /*
                     * Aqui estou fazendo a edição do livro com base no ID filtrando
                     * Estou passando o valor do produto que ele quer editar como parametro
                     */
                    editarValorProduto(retornoValidador, valorProduto);
                    listagemLivros();
                    break;
                case 6:
                    int quantidade = metodos.validarInt("Digite a nova quantidade do livro: ");
                    /*
                     * Aqui estou fazendo a edição do livro com base no ID filtrando
                     * Estou passando a quantidade que ele quer editar como parametro
                     */
                    editarQuantidade(retornoValidador, quantidade);
                    listagemLivros();
                    break;
                case 7:
                    repetir = false;
                    break;
                default:
                    System.out.println("É necessário digitar uma das opções acima");
                    break;
            }
        }
    }

    /**
     * @param id - id do livro que será editado
     * @param name - nome do livro que será editado
     *  Verifica se o ID do livro é igual ao ID do livro que será editado
     *  Se sim, ele edita o nome pelo nome do parametro
     */
    public void editarNome(int id, String name){
        for (Livro livro : listaLivros){
            if(livro.getId() == id){
                livro.setNome(name);
            }
        }
    }

    /**
     * @param id - id do livro que será editado
     * @param edicao - edição do livro que será editado
     * <br>
     * Verifica se o ID do livro é igual ao ID do livro que será editado
     *<br>
     *  Se sim, ele edita a edição pelo parametro
     */
    public void editarEdicaoLivro(int id, int edicao){
        for (Livro livro : listaLivros){
            if(livro.getId() == id){
                livro.setEdicao(edicao);
            }
        }
    }

    /**
     * @param id - id do livro que será editado
     * @param autor - autor do livro que será editado
     * <br>
     *   Verifica se o ID do livro é igual ao ID do livro que será editado
     * <br>
     *    Se sim, ele edita o autor pelo parametro
     */
    public void editarAutor(int id, String autor){
        for (Livro livro : listaLivros){
            if(livro.getId() == id){
                livro.setAutor(autor);
            }
        }
    }

    /**
     * @param id - id do livro que será editado
     * @param AnoPublicacao - ano de publicação do livro que será editado
     *  <br>
     *  Verifica se o ID do livro é igual ao ID do livro que será editado
     *  <br>
     *     Se sim, ele edita o ano de publicação pelo parametro
     */
    public void editarAnoPublicacao(int id, int AnoPublicacao){
        for (Livro livro : listaLivros){
            if(livro.getId() == id){
                livro.setAnoPublicacao(AnoPublicacao);
            }
        }
    }

    /**
     * @param id - id do livro que será editado
     * @param valorProduto - valor do livro que será editado
     * <br>
     *   Verifica se o ID do livro é igual ao ID do livro que será editado
     *  <br>
     *   Se sim, ele edita o valor do livro pelo parametro
     */
    public void editarValorProduto(int id, double valorProduto){
        for (Livro livro : listaLivros){
            if(livro.getId() == id){
                livro.setValorProduto(valorProduto);
            }
        }
    }

    /**
     * @param id - id do livro que será editado
     * @param quantidade - quantidade do livro que será editado
     *   Verifica se o ID do livro é igual ao ID do livro que será editado
     *    Se sim, ele edita a quantidade do livro pelo parametro
     */
    public void editarQuantidade(int id, int quantidade){
        for (Livro livro : listaLivros){
            if(livro.getId() == id){
                livro.setQuantidade(quantidade);
            }
        }
    }

    /**
     * Método que serve para remover um livro da lista de livros<br>
     * Solicita ao usuário escrever o ID do livro que deseja remover<br>
     * Verifica se o livro existe na lista de livros<br>
     * Se existir, remove o livro da lista<br>
     * Se não existir, exibe uma mensagem de erro<br>
     */
    public void removerObjeto(){
        listagemLivros();
        Scanner input = new Scanner(System.in);
        System.out.print("Digite qual o ID do livro a ser excluido: ");
        int idLivro = input.nextInt();
        int retornoValidador = validadorID(idLivro);
        if (retornoValidador == -1) {
            System.out.println("Livro não encontrado");
        } else {
            int numeroEscolha = metodos.validarInt("Você realmente deseja excluir o " +
                    "livro selecionado? Escolha a opção 1 para excluir ou 2 para não excluir: ");
            if (numeroEscolha == 1) {
                listaLivros.removeIf(id -> id.getId().equals(idLivro));
                System.out.println();
                System.out.println("Livro removido com sucesso, lista atualizada: ");
                listagemLivros();
            } else {
                System.out.println("Operação cancelada");
            }
        }

    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }
}
