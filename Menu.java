package projetoED;

import java.util.Scanner;

public class Menu {

    public static void getMenu() {
        System.out.println("***************************"
                + "\n"
                + "***************************"
                + "\n"
                + "********   MENU   *********"
                + "\n"
                + "***************************"
                + "\n"
                + "***************************"
                + "\n"
                + "\n"
                + "* 1. Adicionar Produto"
                + "\n"
                + "* 2. Mostrar produtos"
                + "\n"
                + "* 3. Ordernar produtos por nome"
                + "\n"
                + "* 4. Repor estoque do produto"
                + "\n"
                + "* 5. Vender produto"
                + "\n"
                + "* 6. Aplicar alteração de preços em todos os produtos"
                + "\n"
                + "* 7. Mostrar relatorio de vendas"
                + "\n"
                + "* 8. Mostrar relatorio de estoque"
                + "\n"
                + "* 9. Sair"
                + "\n"
                + "***************************"
                + "\n"
                + "***************************");

    }
    public static void getFuncoes(Lista lista, ListaVendas listaVendas) {
        Scanner sc = new Scanner(System.in);

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
                    lista.ordernarNomes();
                    break;
                case 4:
                    lista.repor();
                    break;
                case 5:
                    lista.venderProduto(listaVendas);
                    break;
                case 6:
                    lista.alterarPrecos();
                    break;
                case 7:
                    listaVendas.mostrar();
                    break;
                case 8:
                    System.out.println("Mostrar relatorio de estoque");
                    break;

            }
            System.out.println("Escolha uma opção");
            opcao = sc.nextInt();

        }
    }
}