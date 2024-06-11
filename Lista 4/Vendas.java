/*Realização de Vendas:
• Selecionar o cliente da compra.
• Selecionar o caixa responsável pela venda.
• Escanear os produtos da compra através do código de barras ou código de produto.
• Exibir o nome, preço unitário e quantidade de cada produto.
• Calcular o valor total da compra (preço unitário x quantidade) para cada produto.
• Apresentar o valor total da compra.
• Permitir diferentes formas de pagamento (dinheiro, cartão de crédito, débito, etc.).
• Gerar um cupom fiscal com as informações da venda. */

import java.util.Scanner;

public class Vendas {
    private Clientes cliente;
    private Atendentes atendente;
    private ListaProdutos listaProdutos;

    // Construtor
    public Vendas(Clientes cliente, Atendentes atendente, ListaProdutos listaProdutos) {
        this.cliente = cliente;
        this.atendente = atendente;
        this.listaProdutos = listaProdutos;
    }

    // Métodos

    // Método de pagamento
    public void pagamento() {
        System.out.println(
                "Por favor, selecione a forma de pagamento. Digite 1, para pagamentos em dinheiro. Digite 2, para pagamentos com cartão de crédito. Digite 3, para pagamentos no débito.");

        Scanner input = new Scanner(System.in);

        int formaPagamento = input.nextInt();

        if (formaPagamento == 1 || formaPagamento == 2 || formaPagamento == 3) {

            switch (formaPagamento) {
                case 1:
                    System.out.println("Selecionado pagamento em dinheiro. O total de sua compra foi: " + totalCompra
                            + ". Por favor, entregue o valor ao atendente.");

                    double pagamento = input.nextDouble();
                    if (pagamento > totalCompra) {
                        double troco = totalCompra - pagamento;

                        System.out.println("Aqui está seu troco, no valor de " + troco
                                + ". Muito obrigado por comprar no Supermercados Guilhermo! Tenha um ótimo dia!");
                    }

                    cupomFiscal();

                    break;

                case 2:
                    System.out.println("Selecionado pagamento com cartão de crédito. O total de sua compra foi: "
                            + totalCompra + ". Por favor, passe seu cartão na maquininha, ou aproxime da tela.");

                    System.out.println(
                            "Compra aprovada! Muito obrigado por comprar no Supermercados Guilhermo! Tenha um ótimo dia!");

                    cupomFiscal();

                    break;

                case 3:
                    System.out.println("Selecionado pagamento no débito. O total de sua compra foi: " + totalCompra
                            + ". Por favor, passe seu cartão na maquininha, ou aproxime da tela.");

                    System.out.println(
                            "Compra aprovada! Muito obrigado por comprar no Supermercados Guilhermo! Tenha um ótimo dia!");

                    cupomFiscal();

                    break;

                default:
                    System.out.println("Obrigado por comprar no Supermercados Guilhermo! Tenha um ótimo dia!");
                    break;
            }
        } else {
            System.out.println("Número inválido digitado! Por favor, digite um número válido.");
            pagamento();
        }

        input.close();
    }

    // Cupom fiscal
    public void cupomFiscal() {

    }

    // Getters & Setters

    // Getters
    public Clientes getCliente() {
        return cliente;
    }

    public Atendentes getAtendente() {
        return atendente;
    }

    public ListaProdutos getListaProdutos() {
        return listaProdutos;
    }

    // Setters
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public void setAtendente(Atendentes atendente) {
        this.atendente = atendente;
    }

    public void setListaProdutos(ListaProdutos listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
}
