package projetoED;

public class Main {
    public static void main(String[] args) {
        ListaProdutos listaProdutos = new ListaProdutos();
        ListaVendas listaVendas = new ListaVendas();
        ListaEstoque listaEstoque = new ListaEstoque();

        Menu.getMenu();
        Menu.getFuncoes(listaProdutos, listaVendas, listaEstoque);

    }
}