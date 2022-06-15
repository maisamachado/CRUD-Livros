package project;

import project.controller.MenuController;

public class Principal {
    public static void main(String[] args) {
        MenuController menu = new MenuController();
        System.out.println("#### Boas vindas a unilove Library! ####");
        System.out.print("\n========== Escolha uma opção ==========\n");
        menu.menu();
    }
}
