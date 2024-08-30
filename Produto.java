package projetoED;

public class Produto {

    private int codigo;
    private String descricao;
    private String marca;
    private double valorEntrada;
    private double valorSaida;
    private int qntdEstoque;
    Produto prox;

    public Produto(String descricao, int codigo, String marca, double valorEntrada, double valorSaida, int qntdEstoque) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.marca = marca;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
        this.qntdEstoque = qntdEstoque;
        this.prox = null;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(double valorSaida) {
        this.valorSaida = valorSaida;
    }

    public int getQntdEstoque() {
        return qntdEstoque;
    }

    public void setQntdEstoque(int qntdEstoque) {
        this.qntdEstoque = qntdEstoque;
    }


    @Override
    public String toString() {
        return
                " Descrição: " + this.descricao +
                        " | Código: " + this.codigo +
                        " | Descrição: " + this.descricao +
                        " | Marca: " + this.marca +
                        " | Valor da Entrada: R$" + this.valorEntrada +
                        " | Valor de Saida:  R$" +  this.valorSaida +
                        " | Quantidade de estoque: " + this.qntdEstoque;
    }
}