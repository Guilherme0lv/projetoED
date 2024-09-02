package projetoED;

public class Venda {

    private Produto vendido;
    private int qntd;
    private String dataHora;
    private Venda prox;

    public Venda(Produto vendido, int qntd, String dataHora) {
        this.vendido = vendido;
        this.qntd = qntd;
        this.dataHora = dataHora;
        this.prox = null;
    }

    public Produto getVendido() {
        return vendido;
    }

    public void setVendido(Produto vendido) {
        this.vendido = vendido;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Venda getProx() {
        return prox;
    }

    public void setProx(Venda prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return " Horário: " + getDataHora()  +
                        " | Descrição do produto vendido: " + getVendido().getDescricao() +
                        " | Código: " + getVendido().getCodigo() +
                        " | Valor de Saida: " + getVendido().getValorSaida() +
                        " | Quantidade vendida: " + getQntd();
    }

}
