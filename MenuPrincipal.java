import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal implements Serializable {

    public static void main(String[] args) {
        
        Serializador serializador = new Serializador();

        ArrayList<Clientes> ListaClientes = new ArrayList<>();
        ArrayList<Atendentes> ListaAtendentes = new ArrayList<>();
        ArrayList<Produtos> listaProdutos = new ArrayList<>();
        ArrayList<Venda> listaVendas = new ArrayList<>();
        ArrayList<Recibo> listaRecibo = new ArrayList<>();

        List<?>[] loadedData = serializador.ler("dados.dat");
        if (loadedData != null && loadedData.length == 5) {
            ListaClientes = castList(loadedData[0], Clientes.class);
            ListaAtendentes = castList(loadedData[1], Atendentes.class);
            listaProdutos = castList(loadedData[2], Produtos.class);
            listaVendas = castList(loadedData[3], Venda.class);
            listaRecibo = castList(loadedData[4], Recibo.class);
        }

        boolean sistema = true;
        Scanner input = new Scanner(System.in);

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

            int action = input.nextInt();
            input.nextLine(); // Consume newline

            if (action > 0 && action < 8) {
                switch (action) {
                    case 1: // Realizar venda
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
                                Clientes novoCliente = Clientes.cadastrarClientes(input);
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

                            case 3: // Atualizar dados do cliente
                                System.out.println("Digite o CPF do cliente que deseja atualizar:");
                                String cpfAtualizar = input.nextLine();
                                Clientes.atualizarCliente(ListaClientes, cpfAtualizar, input);
                                break;

                            case 4: // Excluir dados do cliente
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
                            case 1: // Cadastrar novo atendente
                                Atendentes novoAtendente = Atendentes.cadastrarAtendentes(input);
                                ListaAtendentes.add(novoAtendente);
                                break;

                            case 2: // Consultar atendente existente
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

                            case 3: // Atualizar dados do atendente
                                System.out.println("Digite o ID do atendente que deseja atualizar:");
                                int idAtualizar = input.nextInt();
                                input.nextLine(); // Consume newline
                                Atendentes.atualizarAtendente(ListaAtendentes, idAtualizar, input);
                                break;

                            case 4: // Excluir dados do atendente
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

                        if (answer.equalsIgnoreCase("sim")) {
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
                                Produtos novoProduto = Produtos.cadastrarProdutos(input);
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
                                        Produtos.atualizarProduto(produto, input);
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
                        System.out.println("Pedidos de Compra");
                        System.out.println("Qual produto você gostaria de consultar a situação no estoque?");

                        String situacao = input.nextLine();

                        for (Produtos produto : listaProdutos) {
                            if (produto.getNome().equalsIgnoreCase(situacao)) {
                                System.out.println("O produto " + situacao + " possui " + produto.getQtd() + " unidades.");
                                if (produto.getQtd() < 30) {
                                    System.out.println("O produto " + situacao + " está com uma quantidade abaixo do mínimo necessário para o estoque. Deseja enviar uma mensagem para o time de compras?");
                                    String compra = input.nextLine();
                                    if (compra.equalsIgnoreCase("sim")) {
                                        System.out.println("Enviando mensagem para o time de compras...");
                                        System.out.println("Mensagem enviada!");
                                    }
                                }
                            }
                        }
                        break;

                    case 7: // Sair do programa
                        sistema = false;
                        System.out.println("Saindo do programa...");

                        // Salvando as listas do programa
                        try {
                            serializador.gravar("dados.dat", ListaClientes, ListaAtendentes, listaProdutos, listaVendas, listaRecibo);
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar os dados: " + e.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } else {
                System.out.println("Opção inválida.");
            }
        }
        input.close();
    }

    private static <T> ArrayList<T> castList(Object obj, Class<T> clazz) {
        ArrayList<T> result = new ArrayList<>();
        if (obj instanceof List<?>) {
            for (Object o : (List<?>) obj) {
                result.add(clazz.cast(o));
            }
        }
        return result;
    }
}
