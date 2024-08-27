package projetoED;

import java.util.Scanner;

public class Lista {
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
            System.out.print("Lista vazia");
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

    public void adicionarProduto(){

        System.out.println("Nome:");
        String nome = sc.next();

        System.out.println("Codigo:");
        int codigo = sc.nextInt();

       /* System.out.println("Descrição:");
        String descricao = sc.next();

        System.out.println("Marca:");
        String marca = sc.next();

        System.out.println("Valor de Entrada:");
        float valorEntrada = sc.nextFloat(); */

        System.out.println("Valor de Saida:");
        float valorSaida = sc.nextFloat();

        System.out.println("Quantidade no Estoque:");
        int qntdEstoque = sc.nextInt();

        // inserir(new Produto(nome, codigo, descricao, marca, valorEntrada, valorSaida, qntdEstoque));
        inserir(new Produto(nome, codigo, qntdEstoque, valorSaida));
    }

    public static Lista ordernarNomes(Lista lista) {
        Lista ordernada = new Lista();



        boolean trocar;
        do {
            trocar = false;
            Produto auxiliar = lista.inicio;

            while (auxiliar.prox!=null) {
                if (auxiliar.nome.compareToIgnoreCase(auxiliar.prox.nome)<0) {
                    troca(auxiliar, auxiliar.prox);
                    trocar = true;
                }
                auxiliar = auxiliar.prox;
            }

        } while (trocar);

        return ordernada;
    }
    public static void troca(Produto a, Produto b) {
        int codigo = a.codigo;
        a.codigo = b.codigo;
        b.codigo = codigo;

        String nome = a.nome;
        a.nome = b.nome;
        b.nome = nome;

        /*String descricao;
        String marca;
        float valorEntrada;
        float valorSaida; */
        int qntdEstoque = a.qntdEstoque;
        a.qntdEstoque = qntdEstoque;

    }

    public void repor() {
        if(taVazia()) {
            System.out.println("Lista vazia!");
            return;
        } else {
            Produto auxiliar = inicio;
            System.out.println("Nome do produto a ser reposto:");
            String produtoRepor = sc.next();
            while (auxiliar!=null) {
                if (auxiliar.nome.equalsIgnoreCase(produtoRepor)) {
                    System.out.println("Produto encontrado. Quantos produtos a adicionar no estoque?");
                    int qntdRepor = sc.nextInt();
                    auxiliar.qntdEstoque = auxiliar.qntdEstoque + qntdRepor;
                    break;
                }
                auxiliar = auxiliar.prox;
            }
            if(auxiliar==null) {
                System.out.println("Produto não encontrado");
            }
        }

    }

    public void venderProduto() {
        if(taVazia()) {
            System.out.println("Lista vazia!");
            return;
        } else {
            Produto auxiliar = inicio;
            System.out.println("Nome do produto a ser vendido:");
            String produtoVender = sc.next();
            while (auxiliar!=null) {
                if (auxiliar.nome.equalsIgnoreCase(produtoVender)) {
                    System.out.println("Produto encontrado. Quantos unidades a serem vendidas?");
                    int qntdVenda = sc.nextInt();
                    if (qntdVenda > auxiliar.qntdEstoque || qntdVenda<=0) {
                        System.out.println("Quantidade Invalida");
                        break;
                    } else {
                        auxiliar.qntdEstoque = auxiliar.qntdEstoque - qntdVenda;
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
            return;
        } else {
            Produto auxiliar = inicio;
            while (auxiliar!=null) {
                System.out.println(auxiliar + "\n Novo preço:");
                auxiliar.valorSaida = sc.nextFloat();

                auxiliar = auxiliar.prox;
            }
        }
    }




}
