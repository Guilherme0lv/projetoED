package projetoED;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        Scanner sc = new Scanner(System.in);

        Menu.getMenu();

        System.out.println("Escolha uma opção");
        int opcao = sc.nextInt();

        while (opcao!=9) {
            switch (opcao) {
                case 1:
                    lista.adicionarProduto();
                    break;
                case 2:
                    lista.mostrar();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;

            }
            System.out.println("Escolha uma opção");
            opcao = sc.nextInt();
        }

    }
}
