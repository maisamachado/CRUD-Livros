package project.Utils;

import de.vandermeer.asciitable.AsciiTable;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    // Instanciando a depdendencia da lib para fazermos a montagem da tabela
    AsciiTable at = new AsciiTable();

    /**
     * Método para montar o menu principal<br>
     * @param scanner - Scanner para receber o input do usuário
     * @return - Retorna o número da opção selecionada
     */
    public int menuPrincipal(Scanner scanner) {
            try {
                System.out.print(" 1 - Para listar todos os livros\n");
                System.out.println(" 2 - Para cadastrar um novo livro.");
                System.out.println(" 3 - Buscar livros pelo identificador");
                System.out.println(" 4 - Excluir um livro");
                System.out.println(" 5 - Ordenar livros pelo nome");
                System.out.println(" 6 - Editar Livro");
                System.out.println(" 7 - Sair da tela");
                System.out.print("Digite a opção: ");
               return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Escreva um número");
            }
            return 0;
    }
    /**
     * Método que existe o menu secundário de edição de livros
     *
     */
    public void  menuSecundario() {
        System.out.print(" 1 - Para editar o nome\n");
        System.out.println(" 2 - Para editar a edição.");
        System.out.println(" 3 - Para editar o autor do livro");
        System.out.println(" 4 - Para ano publicação do livro");
        System.out.println(" 5 - Para editar o valor do produto");
        System.out.println(" 6 - Para editar a quantidade de produtos");
        System.out.println(" 7 - Sair desse menu");
        System.out.print("Digite a opção: ");
    }

    /**
     * Método que verifica se o usuário digitou um número inteiro<br>
     * @param scanner - o que usuário vai digitar
     * @return = o número inteiro digitado
     */
    public int inputMessage(String mensagem){
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    /**
     * Método que recebe uma mensagem por parametro e retorna uma String<br>
     * @param mensagem - mensagem a ser exibida
     * @return - retorna uma String
     */
    public String validarString(String mensagem){
        Scanner input = new Scanner(System.in);
        boolean valido = false;
        String retorno = "";
        while(!valido) {
            System.out.print(mensagem);
            String generico = input.nextLine();
            String regex = "^[A-Za-z, ]++$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(generico);
            if (!generico.isEmpty() && matcher.matches()) {
                valido = true;
                retorno = generico;
            } else {
                System.out.println("É necessário utilizar uma string válida.");
            }
        }
        return retorno;
    }

    /**
     * Método que recebe uma mensagem por parametro e retorna um inteiro<br>
     * @param mensagem mensagem a ser exibida
     * @return  retorna um inteiro
     */
    public int validarInt(String mensagem) {
        Scanner input = new Scanner(System.in);
        boolean valido = false;
        int retorno = 0;
        while(!valido){
            try {
                System.out.print(mensagem);
                String generico = input.nextLine();
                retorno = Integer.parseInt(generico);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Necessário informar um número inteiro.");
            }
        }
        return retorno;
    }

    /**
     * Método que recebe uma mensagem por parametro e retorna um double<br>
     * @param mensagem = mensagem a ser exibida
     * @return retorno = valor do double
     */
    public double validarDouble(String mensagem) {
        Scanner input = new Scanner(System.in);
        boolean valido = false;
        double retorno = 0;
        while(!valido){
            try {
                System.out.print(mensagem);
                String generico = input.nextLine();
                retorno = Double.parseDouble(generico);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Necessário informar um número.");
            }
        }
        return retorno;

    }


}
