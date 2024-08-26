package projetoED;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class Lista {
    Produto inicio;
    Produto fim;

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
        Scanner sc = new Scanner(System.in);

        System.out.println("Nome:");
        String nome = sc.next();

        System.out.println("Codigo:");
        int codigo = sc.nextInt();

        System.out.println("Descrição:");
        String descricao = sc.next();

        System.out.println("Marca:");
        String marca = sc.next();

        System.out.println("Valor de Entrada:");
        float valorEntrada = sc.nextFloat();

        System.out.println("Valor de Saida:");
        float valorSaida = sc.nextFloat();

        System.out.println("Quantidade no Estoque:");
        int qntdEstoque = sc.nextInt();

        inserir(new Produto(nome, codigo, descricao, marca, valorEntrada, valorSaida, qntdEstoque));
    }

    public void ordenarNome() {

    }

    public void venderProduto() {

        LocalDateTime d05 = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println(d05.format(fmt));
        String teste = d05.format(fmt);
        System.out.println(teste);
    }
}
