package projetoED;

public class Venda {

    Produto vendido;
    int qntd;
    Venda prox;
    String hora;

    public Venda(Produto vendido, int qntd, String hora) {
        this.vendido = vendido;
        this.qntd = qntd;
        this.hora = hora;
        this.prox = null;
    }
    @Override
    public String toString() {
        return
                " Produto vendido: " + vendido.nome +
                        " | Códiguin:" + vendido.codigo +
                        " | Quantidade vendida: " + qntd +
                        " | Horário: " + hora;
    }

}
