/*Menu Principal: O menu principal deve apresentar as seguintes opções:
2-Cadastro de Clientes
3-Cadastro de Atendentes de Caixa
1-Realização de Vendas
4-Histórico de Compras e Histórico de Vendas
5-Gerenciamento de Estoque
6-Pedidos de Compra
7-Sair */

import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

public class MenuPrincipal implements Serializable {

    public static void main(String[] args) {

        ArrayList<Clientes> ListaClientes = new ArrayList<>();
        ArrayList<Atendentes> ListaAtendentes = new ArrayList<>();
        Serializador serializador = new Serializador();
        boolean sistema = true;

        while (sistema) {

            System.out.println("Olá, qual ação gostaria de realizar?");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Ir para o menu cliente");
            System.out.println("3 - Ir para o menu atendente");
            System.out.println("4 - Consultar o histórico de compras e de vendas");
            System.out.println("5 - Gerenciamento de Estoque");
            System.out.println("6 - Pedidos de Compra");
            System.out.println("7 - Sair do programa");
            System.out.println(" ");

            Scanner opcao = new Scanner(System.in);
            int action = opcao.nextInt();

            if (action > 0 && action < 5) {
                switch (action) {
                    case 1: //Realizar venda
                        Produtos produto = new Produtos();
                        produto = produto.criarProdutos();
                        ListaProdutos.add(produto);
                        System.out.println("A agenda agora possui " + ListaProdutos.size() + " contatos.");
                        break;

                    case 2: //Ir para o menu cliente
                        if (ListaProdutos.isEmpty()) {
                            System.out.println("A lista está vazia!");
                            System.out.println(" ");
                        } else {
                            System.out.println("Contatos cadastrados:");
                            for (int i = 0; i < ListaProdutos.size(); i++) {
                                System.out
                                        .println(ListaProdutos.get(i).getFirstName()
                                                + ListaProdutos.get(i).getLastName());
                            }
                        }

                        break;

                    case 3:
                        System.out.println("Qual o nome do contato que gostaria de deletar?");
                        Scanner input = new Scanner(System.in);
                        String nome = input.nextLine();
                        for (int i = 0; nome == ListaProdutos.get(i).getFullName(); i++) {
                            System.out
                                    .println(ListaProdutos.get(i).getFirstName() + ListaProdutos.get(i).getLastName());
                            ListaProdutos.remove(i);
                        }

                        System.out.println("A agenda agora possui " + ListaProdutos.size() + " contatos.");
                        break;

                    case 4:
                        serializador.gravar("agenda.dat", ListaProdutos);
                        agenda = false;
                        break;

                        case 5:
                        serializador.gravar("agenda.dat", ListaProdutos);
                        agenda = false;
                        break;

                    case 6:
                        serializador.gravar("agenda.dat", ListaProdutos);
                        agenda = false;
                        break;

                    case 7:
                        serializador.gravar("agenda.dat", ListaProdutos);
                        agenda = false;
                        break;

                    default:
                        break;
                }
            } else {
                System.out.println("Número inválido, favor inserir um número válido!");

                opcao.close();
            }

        }
    }
}
