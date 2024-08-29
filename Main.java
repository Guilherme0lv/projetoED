package projetoED;

public class Main {
    public static void main(String[] args) {
        Lista listaProduto = new Lista();
        ListaVendas listaVenda = new ListaVendas();

        Menu.getMenu();
        Menu.getFuncoes(listaProduto, listaVenda);


    }
}