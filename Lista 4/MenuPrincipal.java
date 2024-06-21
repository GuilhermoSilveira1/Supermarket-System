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
        ArrayList<Produtos> listaProdutos = new ArrayList<>();
        ArrayList<Venda> listaVendas = new ArrayList<>();
        ArrayList<Recibo> listaRecibo = new ArrayList<>();

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

            if (action > 0 && action < 8) {

                Scanner input = new Scanner(System.in);

                switch (action) {
                    case 1: // Realizar venda
                        // Implementar funcionalidade de realizar venda
                        Venda venda = new Venda();

                        venda.realizarVenda(listaVendas, ListaClientes, ListaAtendentes, listaProdutos, listaRecibo);

                        break;

                    
                    case 2: // Ir para o menu cliente
                        System.out.println("Olá, qual ação gostaria de realizar?");
                        System.out.println("1 - Cadastrar novo cliente");
                        System.out.println("2 - Consultar cliente existente");
                        System.out.println("3 - Atualizar dados do cliente");
                        System.out.println("4 - Excluir dados do cliente");
                        System.out.println(" ");

                        int resposta = input.nextInt();
                        input.nextLine(); // Consume newline

                        switch (resposta) {

                            
                            case 1: // Cadastrar novo cliente
                                Clientes novoCliente = Clientes.cadastrarClientes();
                                ListaClientes.add(novoCliente);
                                break;

                            
                            case 2: // Consultar cliente existente
                                System.out.println("Digite o CPF do cliente que deseja consultar:");
                                String cpfConsulta = input.nextLine();
                                Clientes clienteConsultado = null;
                                for (Clientes cliente : ListaClientes) {
                                    if (cliente.getCPF().equals(cpfConsulta)) {
                                        clienteConsultado = cliente;
                                        break;
                                    }
                                }
                                if (clienteConsultado != null) {
                                    System.out.println("Cliente encontrado: " + clienteConsultado.getNome());
                                } else {
                                    System.out.println("Cliente não encontrado.");
                                }
                                break;

                            // Atualizar dados do cliente
                            case 3:
                                System.out.println("Digite o CPF do cliente que deseja atualizar:");
                                String cpfAtualizar = input.nextLine();
                                Clientes.atualizarCliente(ListaClientes, cpfAtualizar);
                                break;

                            // Excluir dados do cliente
                            case 4:
                                System.out.println("Digite o CPF do cliente que deseja excluir:");
                                String cpfExcluir = input.nextLine();
                                Clientes.excluirCliente(ListaClientes, cpfExcluir);
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        break;

                    
                    case 3: // Ir para o menu atendente
                        System.out.println("Olá, qual ação gostaria de realizar?");
                        System.out.println("1 - Cadastrar novo atendente");
                        System.out.println("2 - Consultar atendente existente");
                        System.out.println("3 - Atualizar dados do atendente");
                        System.out.println("4 - Excluir dados do atendente");
                        System.out.println(" ");

                        int respostaAtendente = input.nextInt();
                        input.nextLine(); // Consume newline

                        switch (respostaAtendente) {
                            // Cadastrar novo atendente
                            case 1:
                                Atendentes novoAtendente = Atendentes.cadastrarAtendentes();
                                ListaAtendentes.add(novoAtendente);
                                break;

                            // Consultar atendente existente
                            case 2:
                                System.out.println("Digite o ID do atendente que deseja consultar:");
                                int idConsulta = input.nextInt();
                                input.nextLine(); // Consume newline
                                Atendentes atendenteConsultado = null;
                                for (Atendentes atendente : ListaAtendentes) {
                                    if (atendente.getID() == idConsulta) {
                                        atendenteConsultado = atendente;
                                        break;
                                    }
                                }
                                if (atendenteConsultado != null) {
                                    System.out.println("Atendente encontrado: " + atendenteConsultado.getFirstName() + " " + atendenteConsultado.getLastName());
                                } else {
                                    System.out.println("Atendente não encontrado.");
                                }
                                break;

                            // Atualizar dados do atendente
                            case 3:
                                System.out.println("Digite o ID do atendente que deseja atualizar:");
                                int idAtualizar = input.nextInt();
                                input.nextLine(); // Consume newline
                                Atendentes.atualizarAtendente(ListaAtendentes, idAtualizar);
                                break;

                            // Excluir dados do atendente
                            case 4:
                                System.out.println("Digite o ID do atendente que deseja excluir:");
                                int idExcluir = input.nextInt();
                                input.nextLine(); // Consume newline
                                Atendentes.excluirAtendente(ListaAtendentes, idExcluir);
                                break;

                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        break;

                    case 4: // Consultar o histórico de compras e de vendas
    System.out.println("Mostrando as vendas registradas...");
    System.out.println();

    for (Venda venda2 : listaVendas) {
        System.out.println("Cliente: " + venda2.getCliente().getNome() +
                " - Atendente: " + venda2.getAtendente().getFirstName() + " " + venda2.getAtendente().getLastName());
    }

    System.out.println("Deseja ver alguma venda em detalhe? (sim/nao)");

    String answer = input.nextLine();

    if (answer.toLowerCase().equals("sim")) {
        System.out.println("Digite o nome do cliente que deseja ver a venda:");

        String nomeCliente = input.nextLine().toLowerCase();

        boolean vendaEncontrada = false;
        for (Venda venda2 : listaVendas) {
            if (venda2.getCliente().getNome().toLowerCase().equals(nomeCliente)) {
                vendaEncontrada = true;
                System.out.println("Cliente: " + venda2.getCliente().getNome() +
                        " - Atendente: " + venda2.getAtendente().getFirstName() + " " + venda2.getAtendente().getLastName());
                System.out.println("Produtos: ");
                for (Produtos produto : venda2.getListaProdutos()) {
                    System.out.println("Nome: " + produto.getNome() + " - Descrição: " + produto.getDescricao() +
                            " - Quantidade: " + produto.getQtd() + " - Preço: " + produto.getPrice());
                }
                System.out.println("Forma de pagamento: " + venda2.getFormaPagamento());
                System.out.println();
            }
        }
        if (!vendaEncontrada) {
            System.out.println("Venda não encontrada para o cliente: " + nomeCliente);
        }
    }
    break;


                    case 5: // Gerenciamento de Estoque
                    System.out.println("Menu Produtos:");
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Consultar produto existente");
            System.out.println("3 - Atualizar dados de um produto");
            System.out.println("4 - Excluir produto");
            System.out.println("5 - Listar todos os produtos");
            System.out.println("6 - Sair");
            System.out.println();

            System.out.print("Digite sua escolha: ");
            int escolha = input.nextInt();
            input.nextLine(); // Consume newline

            switch (escolha) {
                case 1:
                    Produtos novoProduto = Produtos.cadastrarProdutos();
                    listaProdutos.add(novoProduto);
                    break;
                case 2:
                    System.out.print("Digite o ID do produto que deseja consultar: ");
                    int idConsulta = input.nextInt();
                    input.nextLine(); // Consume newline
                    boolean encontrado = false;
                    for (Produtos produto : listaProdutos) {
                        if (produto.getID() == idConsulta) {
                            System.out.println("Produto encontrado:");
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Descrição: " + produto.getDescricao());
                            System.out.println("Fornecedor: " + produto.getFornecedor());
                            System.out.println("Preço: " + produto.getPrice());
                            System.out.println("Quantidade: " + produto.getQtd());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ID do produto que deseja atualizar: ");
                    int idAtualizar = input.nextInt();
                    input.nextLine(); // Consume newline
                    encontrado = false;
                    for (Produtos produto : listaProdutos) {
                        if (produto.getID() == idAtualizar) {
                            Produtos.atualizarProduto(produto);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do produto que deseja excluir: ");
                    int idExcluir = input.nextInt();
                    input.nextLine(); // Consume newline
                    encontrado = false;
                    for (int i = 0; i < listaProdutos.size(); i++) {
                        if (listaProdutos.get(i).getID() == idExcluir) {
                            System.out.println("Produto removido: " + listaProdutos.get(i).getNome());
                            listaProdutos.remove(i);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 5:
                    if (listaProdutos.isEmpty()) {
                        System.out.println("Não há produtos cadastrados.");
                    } else {
                        System.out.println("Lista de produtos cadastrados:");
                        for (Produtos produto : listaProdutos) {
                            System.out.println("ID: " + produto.getID());
                            System.out.println("Nome: " + produto.getNome());
                            System.out.println("Descrição: " + produto.getDescricao());
                            System.out.println("Fornecedor: " + produto.getFornecedor());
                            System.out.println("Preço: " + produto.getPrice());
                            System.out.println("Quantidade: " + produto.getQtd());
                            System.out.println("-----------------------------");
                        }
                    }
                    break;
                case 6:
                    sistema = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
                        break;

                    case 6: // Pedidos de Compra
                        // Implementar funcionalidade de pedidos de compra
                        break;

                    case 7: // Sair do programa
                        sistema = false;
                        System.out.println("Saindo do programa...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }

                input.close();

            } else {
                System.out.println("Opção inválida.");
                action = opcao.nextInt();
            }

            opcao.close();

        }
    }
}
