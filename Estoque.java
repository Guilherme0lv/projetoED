package projetoED;

public class Estoque {

    private String movimento;
    Produto produto;
    Estoque prox;
    private int qntdAlterada;

    public Estoque(String movimento, Produto produto, int qntdAlterada) {
        this.movimento = movimento;
        this.produto = produto;
        this.qntdAlterada = qntdAlterada;
        this.prox = null;
    }

    public String getMovimento() {
        return movimento;
    }

    public void setMovimento(String movimento) {
        this.movimento = movimento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQntdAlterada() {
        return qntdAlterada;
    }

    public void setQntdAlterada(int qntdAlterada) {
        this.qntdAlterada = qntdAlterada;
    }

    public String toString() {
        return "Movimento: " + getMovimento() + " - Produto: " + getProduto().getDescricao() +
                " | Cod: " + getProduto().getCodigo() + " | Ent. R$"  + getProduto().getValorEntrada() +
                " | Sda. R$"  + getProduto().getValorSaida() + " | QntdEstoque: " + getProduto().getQntdEstoque() +
                " | Quantidade Alterada: " + getQntdAlterada() ;
    }

}
