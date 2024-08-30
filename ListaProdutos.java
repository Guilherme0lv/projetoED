package projetoED;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ListaProdutos {
    Produto inicio;
    Produto fim;
    Scanner sc = new Scanner(System.in);

    public boolean taVazia() {
        return inicio == null;
    }

    public void inserir(Produto novo) {
        if (taVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.prox = novo;
            fim = novo;
        }
    }

    public void mostrar () {
        if (taVazia()) {
            System.out.println("Lista vazia!");
        } else {
            Produto auxiliar = inicio;
            System.out.println("Lista: ");
            while (auxiliar != null) {
                System.out.println(auxiliar);
                auxiliar = auxiliar.prox;
            }
            System.out.println(" ");
        }
    }

    public void adicionarProduto(ListaEstoque listaEstoque){

        System.out.println("Codigo:");
        int codigo = sc.nextInt();

        if (!taVazia()) {
            Produto auxiliar = inicio;
            boolean existe = false;
            while (auxiliar!=null) {
                if(auxiliar.getCodigo()==codigo) {
                    System.out.println("Código inválido!");
                    existe = true;
                    break;
                }
                auxiliar = auxiliar.prox;
            }
            if (existe) {
             return;
            }
        }

        System.out.println("Descrição:");
        String descricao = sc.next();

        System.out.println("Marca:");
        String marca = sc.next();

        System.out.println("Valor de Entrada:");
        double valorEntrada = sc.nextFloat();

        System.out.println("Valor de Saida:");
        double valorSaida = sc.nextFloat();

        System.out.println("Quantidade no Estoque:");
        int qntdEstoque = sc.nextInt();

        inserir(new Produto(descricao, codigo, marca, valorEntrada, valorSaida, qntdEstoque));

        listaEstoque.inserir(new Estoque("Entrada(Cadastro)",
                new Produto(descricao, codigo, marca, valorEntrada, valorSaida, qntdEstoque), qntdEstoque));
    }

    public void  ordernarNomes() {
        Produto aux1 = inicio;

        if (taVazia()) {
            System.out.println("Lista vazia!");
        } else {
            while (aux1!= fim) {
                Produto aux2 = aux1.prox;
                while (aux2 != null) {
                    if (aux1.getDescricao().compareToIgnoreCase(aux2.getDescricao())>0) {
                        troca(aux1, aux2);
                    }
                    aux2 = aux2.prox;
                }
                aux1 = aux1.prox;
            }
        }
    }

    public static void troca(Produto a, Produto b) {
        int codigo = a.getCodigo();
        a.setCodigo(b.getCodigo());
        b.setCodigo(codigo);

        String nome = a.getDescricao();
        a.setDescricao(b.getDescricao());
        b.setDescricao(nome);

        String marca = a.getMarca();
        a.setMarca(b.getMarca());
        b.setMarca(marca);

        double valorEntrada = a.getValorEntrada();
        a.setValorEntrada(b.getValorEntrada());
        b.setValorEntrada(valorEntrada);

        int qntdEstoque = a.getQntdEstoque();
        a.setQntdEstoque(b.getQntdEstoque());
        b.setQntdEstoque(qntdEstoque);

        double valorSaida = a.getValorSaida();
        a.setValorSaida(b.getValorSaida());
        b.setValorSaida(valorSaida);
    }

    public void repor(ListaEstoque listaEstoque) {
        if(taVazia()) {
            System.out.println("Lista vazia!");
        } else {
            Produto auxiliar = inicio;
            System.out.println("Codigo do produto a ser reposto:");
            int produtoRepor = sc.nextInt();

            while (auxiliar!=null) {
                if (auxiliar.getCodigo()==produtoRepor) {
                    System.out.println("Produto encontrado. Quantos produtos a adicionar no estoque?");
                    int qntdRepor = sc.nextInt();
                    auxiliar.setQntdEstoque(auxiliar.getQntdEstoque()+qntdRepor);

                    listaEstoque.inserir(new Estoque("Entrada(Repor)", new Produto(auxiliar.getDescricao(),
                            auxiliar.getCodigo(), auxiliar.getMarca(), auxiliar.getValorEntrada(), auxiliar.getValorSaida(),
                            auxiliar.getQntdEstoque()), qntdRepor));
                    break;
                }
                auxiliar = auxiliar.prox;
            }
            if(auxiliar==null) {
                System.out.println("Produto não encontrado");
            }
        }
    }

    public void venderProduto(ListaVendas listaVenda, ListaEstoque listaEstoque) {
        if(taVazia()) {
            System.out.println("Lista vazia!");
        } else {
            Produto auxiliar = inicio;
            System.out.println("Código do produto a ser vendido:");
            int produtoVender = sc.nextInt();

            while (auxiliar!=null) {
                if (auxiliar.getCodigo()==produtoVender) {
                    System.out.println("Produto encontrado. Quantos unidades a serem vendidas?");
                    int qntdVenda = sc.nextInt();
                    if (qntdVenda > auxiliar.getQntdEstoque() || qntdVenda<=0) {
                        System.out.println("Quantidade Invalida");
                        break;
                    } else {
                        auxiliar.setQntdEstoque(auxiliar.getQntdEstoque()-qntdVenda);

                        LocalDateTime dataHora = LocalDateTime.now();
                        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                        listaEstoque.inserir(new Estoque("Saida(Venda)", new Produto(auxiliar.getDescricao(), auxiliar.getCodigo(), auxiliar.getMarca(), auxiliar.getValorEntrada(), auxiliar.getValorSaida(), auxiliar.getQntdEstoque()), qntdVenda));

                        listaVenda.inserirVenda(new Venda(auxiliar, qntdVenda, dataHora.format(fmt)));

                        break;
                    }
                }
                auxiliar = auxiliar.prox;
            }
            if(auxiliar==null) {
                System.out.println("Produto não encontrado");
            }
        }
    }

    public void alterarPrecos() {
        if(taVazia()) {
            System.out.println("Lista vazia!");
        } else {
            System.out.println("Porcentagem a ser alterada: ");
            double taxa = sc.nextDouble();

            Produto auxiliar = inicio;
            while (auxiliar!=null) {
                auxiliar.setValorSaida(taxa * auxiliar.getValorSaida());
                auxiliar = auxiliar.prox;
            }
        }
    }
}