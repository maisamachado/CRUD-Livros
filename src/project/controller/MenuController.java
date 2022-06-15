package project.controller;

import project.Utils.Util;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MenuController {
    LivroController livraria = new LivroController();
    Util metodos = new Util();
    Scanner input = new Scanner(System.in);

    /**
     * Método que mostra o menu principal do sistema
     */
    public void menu(){
        boolean repetir = true;
        while(repetir){
            try{
                int item = metodos.menuPrincipal(input);
                switch (item){
                    case 1:
                        livraria.listagemLivros();
                        break;
                    case 2:
                        livraria.cadastrarLivros();
                        //Cria um delay de 2 após cadastro do livro para voltar ao menu
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    case 3:
                        livraria.buscarBookId();
                        break;
                    case 4:
                        livraria.removerObjeto();
                        break;
                    case 5:
                        livraria.ordenarPorNome();
                        break;
                    case 6:
                        livraria.editarLivro();
                        break;
                    case 7:
                        System.out.print("Saindo...");
                        repetir = false;
                        break;
                    default:
                        System.out.println("Precisa estar listada a opção selecionada");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
