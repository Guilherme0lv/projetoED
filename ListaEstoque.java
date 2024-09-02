package projetoED;

public class ListaEstoque {
    Estoque inicio;
    Estoque fim;


    public boolean taVazio() {
        return inicio==null;
    }

    public void inserir (Estoque novo) {
        if (taVazio()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProx(novo);
            fim = novo;
        }
    }

    public void mostrar() {
        if (taVazio()) {
            System.out.println("Estoque vazio!");
        } else {
            Estoque auxiliar = inicio;
            System.out.println("Estoque:");
            while (auxiliar!= null) {
                System.out.println(auxiliar);
                auxiliar = auxiliar.getProx();
            }
        }
    }
}
