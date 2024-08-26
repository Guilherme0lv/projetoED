package projetoED;

public class Produto {

    int codigo;
    String descricao;
    String marca;
    float valorEntrada;
    float valorSaida;
    int qntdEstoque;
    Produto prox;

    public Produto(int codigo, String descricao, String marca, float valorEntrada, float valorSaida, int qntdEstoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.marca = marca;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
        this.qntdEstoque = qntdEstoque;
        this.prox = null;
    }

    @Override
    public String toString() {
        return
                " Código: " + codigo +
                " | Descrição: " + descricao +
                " | Marca: " + marca +
                " | Valor da Entrada: R$" + String.format("%.2f", valorEntrada)+
                " | Valor de Saida:  " +  String.format("%.2f", valorSaida)+
                " | Quantidade de estoque: " + qntdEstoque;
    }
}
