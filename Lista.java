package projetoED;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import projetoED.ListaVendas;

    public class Lista {
        Produto inicio;
        Produto fim;
        Scanner sc = new Scanner(System.in);

        ListaVendas listaVenda = new ListaVendas();

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

        public void  ordernarNomes() {
            Produto aux1 = inicio;

            while (aux1!= fim) {
                Produto aux2 = aux1.prox;
                while (aux2 != null) {
                    if (aux1.nome.compareToIgnoreCase(aux2.nome)>0) {
                        troca(aux1, aux2);
                    }
                    aux2 = aux2.prox;
                }
                aux1 = aux1.prox;
            }
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
            a.qntdEstoque = b.qntdEstoque;
            b.qntdEstoque = qntdEstoque;

            float valorSaida = a.valorSaida;
            a.valorSaida = b.valorSaida;
            b.valorSaida = valorSaida;

            /*Produto prox = a.prox;
            a.prox = b.prox;
            b.prox = prox; */

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

        public void venderProduto(ListaVendas listaVenda) {
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

                            LocalDateTime data = LocalDateTime.now();
                            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                            listaVenda.inserirVenda(new Venda(auxiliar, qntdVenda, data.format(fmt)));
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