package projetoED;

public class ListaVendas {
    Venda inicio;
    Venda fim;

    public  void inserirVenda(Venda novo) {
        if (taVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.prox = novo;
            fim = novo;
        }
    }

    public void mostrar() {
        if (taVazia()) {
            System.out.println("Lista de Vendas vazia");
        } else {
            Venda auxiliar = inicio;
            System.out.println("Lista de Vendas:");
            while (auxiliar!=null) {
                System.out.println(auxiliar);
                auxiliar = auxiliar.prox;

            }
            System.out.println(" ");
        }
    }

    public boolean taVazia() {
        return inicio == null;
    }
}