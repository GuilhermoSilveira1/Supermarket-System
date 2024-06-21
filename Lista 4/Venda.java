/*Realização de Vendas:
Selecionar o cliente da compra.
Selecionar o caixa responsável pela venda.
Escanear os produtos da compra através do código de barras ou código de produto.
Exibir o nome, preço unitário e quantidade de cada produto.
Calcular o valor total da compra (preço unitário x quantidade) para cada produto.
Apresentar o valor total da compra.
Permitir diferentes formas de pagamento (dinheiro, cartão de crédito, débito, etc.).
Gerar um cupom fiscal com as informações da venda.
*/

 

import java.util.ArrayList;
import java.util.Scanner;

public class Venda {

    private Clientes cliente;
    private Atendentes atendente;
    private ArrayList<Produtos> listaProdutos;
    private String formaPagamento;

    // Construtor vazio
    public Venda() {
    }

    // Construtor parametrizado
    public Venda(Clientes cliente, Atendentes atendente, ArrayList<Produtos> listaProdutos, String formaPagamento) {
        this.cliente = cliente;
        this.atendente = atendente;
        this.listaProdutos = listaProdutos;
        this.formaPagamento = formaPagamento;
    }

    // Métodos

    // Método realizarVenda, que cria um objeto venda para armazenar na lista de vendas
    public void realizarVenda(ArrayList<Venda> listaVendas, ArrayList<Clientes> listaClientes,
                                     ArrayList<Atendentes> listaAtendentes, ArrayList<Produtos> listaProdutos,
                                     ArrayList<Recibo> listaRecibos) {
        Scanner input = new Scanner(System.in);

        // Cliente da venda
        System.out.println("Escreva o CPF do cliente: ");
        String cpfCliente = input.nextLine();
        Clientes cliente = null;
        for (Clientes c : listaClientes) {
            if (c.getCPF().equals(cpfCliente)) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            input.close();
            return;
        }

        // Atendente da venda
        System.out.println("Escreva o ID do atendente: ");
        int idAtendente = input.nextInt();
        input.nextLine(); // Consume newline
        Atendentes atendente = null;
        for (Atendentes a : listaAtendentes) {
            if (a.getID() == idAtendente) {
                atendente = a;
                break;
            }
        }
        if (atendente == null) {
            System.out.println("Atendente não encontrado.");
            input.close();
            return;
        }

        // Produtos que o cliente vai comprar
        boolean compras = true;
        ArrayList<Produtos> listaCarrinho = new ArrayList<>();
        while (compras) {
            System.out.println("Escreva o nome do produto, com letras minúsculas, " +
                    "que será adicionado, ou escreva 'sair', para prosseguir para o pagamento.");
            String nomeProduto = input.nextLine();
            if (nomeProduto.toLowerCase().equals("sair")) {
                compras = false;
            } else {
                boolean produtoEncontrado = false;
                for (Produtos p : listaProdutos) {
                    if (p.getNome().toLowerCase().equals(nomeProduto.toLowerCase())) {
                        System.out.println("Digite a quantidade:");
                        int qtdProduto = input.nextInt();
                        input.nextLine(); // Consume newline
                        if (qtdProduto <= p.getQtd()) {
                            p.setQtd(p.getQtd() - qtdProduto); // Update stock quantity
                            Produtos produtoCarrinho = new Produtos(p.getNome(), p.getDescricao(), p.getFornecedor(), p.getPrice(), qtdProduto);
                            listaCarrinho.add(produtoCarrinho);
                            System.out.println("Produto adicionado no carrinho.");
                        } else {
                            System.out.println("Quantidade indisponível em estoque.");
                        }
                        produtoEncontrado = true;
                        break;
                    }
                }
                if (!produtoEncontrado) {
                    System.out.println("Produto não cadastrado!");
                }
            }
        }

        // Exibir o nome, preço unitário e quantidade de cada produto
        System.out.println("Os seguintes produtos estão no carrinho:");
        double valorTotal = 0;
        for (Produtos p : listaCarrinho) {
            double totalProduto = p.getQtd() * p.getPrice();
            valorTotal += totalProduto;
            System.out.println(p.getNome() + " - Preço unitário: " + p.getPrice() + " - Quantidade: " + p.getQtd() + " - Valor total: " + totalProduto);
        }
        System.out.println("Valor total da compra: " + valorTotal);

        // Escolher forma de pagamento
        System.out.println("Escolha a forma de pagamento (cartão, dinheiro, pix): ");
        String formaPagamento = input.nextLine();

        // Criar objeto Venda e adicionar à lista de vendas
        Venda venda = new Venda(cliente, atendente, listaCarrinho, formaPagamento);
        listaVendas.add(venda);

        System.out.println("Venda realizada com sucesso!");

         // Criar o recibo
         Recibo recibo = new Recibo(venda);
         listaRecibos.add(recibo);

         System.out.println("Recibo criado!");

        input.close();
    }

    // Getters & Setters
    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Atendentes getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendentes atendente) {
        this.atendente = atendente;
    }

    public ArrayList<Produtos> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produtos> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
