package projetoED;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void getMenu() {
        System.out.println("***************************"
                + "\n"
                + "****   MOACYR'S TECH   ****"
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
    public static void getFuncoes(ListaProdutos listaProdutos, ListaVendas listaVendas, ListaEstoque listaEstoque) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha uma opção");
        int opcao = sc.nextInt();

        if (!(opcao>0 && opcao<10)) {
            System.out.println("Opção invalida!");
        }

        while (opcao!=9) {
            switch (opcao) {
                case 1:
                    listaProdutos.adicionarProduto(listaEstoque);
                    break;
                case 2:
                    listaProdutos.mostrar();
                    break;
                case 3:
                    listaProdutos.ordernarNomes();
                    break;
                case 4:
                    listaProdutos.repor(listaEstoque);
                    break;
                case 5:
                    listaProdutos.venderProduto(listaVendas, listaEstoque);
                    break;
                case 6:
                    listaProdutos.alterarPrecos(listaEstoque);
                    break;
                case 7:
                    listaVendas.mostrar();
                    break;
                case 8:
                    listaEstoque.mostrar();
                    break;

            }
            System.out.println("Escolha uma opção");
            opcao = sc.nextInt();

            if (!(opcao>0 && opcao<10)) {
                System.out.println("Opção invalida!");
            }
        }
        sc.close();
    }
}