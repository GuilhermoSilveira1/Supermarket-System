import java.io.Serializable;
import java.util.Scanner;

public class Produtos implements Serializable{

    private static int nextID = 1; // Static variable to track next available ID
    private int ID;
    private String descricao;
    private double price;
    private String nome;
    private int qtd;
    private String fornecedor;

    // Construtor vazio
    public Produtos() {
    }

    // Construtor com parâmetros
    public Produtos(String nome, String descricao, String fornecedor, double price, int qtd) {
        this.ID = nextID++; // Assign ID and then increment nextID
        this.nome = nome;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.price = price;
        this.qtd = qtd;
    }

    // Métodos
    public static Produtos cadastrarProdutos(Scanner input) {

        System.out.println("Digite o nome do produto:");
        String nome = input.nextLine();

        System.out.println("Digite a descrição do produto:");
        String descricao = input.nextLine();

        System.out.println("Digite o fornecedor do produto:");
        String fornecedor = input.nextLine();

        System.out.println("Digite o preço do produto:");
        double price = input.nextDouble();

        System.out.println("Digite a quantidade do produto:");
        int qtd = input.nextInt();

        Produtos produto = new Produtos(nome, descricao, fornecedor, price, qtd);

        System.out.println("Produto cadastrado!");
        System.out.println();

        return produto;
    }

    public static void atualizarProduto(Produtos produto, Scanner input) {

        System.out.println("Qual dado gostaria de atualizar?");
        System.out.println("1 - Nome");
        System.out.println("2 - Descrição");
        System.out.println("3 - Fornecedor");
        System.out.println("4 - Preço");
        System.out.println("5 - Quantidade");

        int opcao = input.nextInt();
        input.nextLine(); // Consume newline

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo nome:");
                String novoNome = input.nextLine();
                produto.setNome(novoNome);
                break;
            case 2:
                System.out.println("Digite a nova descrição:");
                String novaDescricao = input.nextLine();
                produto.setDescricao(novaDescricao);
                break;
            case 3:
                System.out.println("Digite o novo fornecedor:");
                String novoFornecedor = input.nextLine();
                produto.setFornecedor(novoFornecedor);
                break;
            case 4:
                System.out.println("Digite o novo preço:");
                double novoPreco = input.nextDouble();
                produto.setPrice(novoPreco);
                break;
            case 5:
                System.out.println("Digite a nova quantidade:");
                int novaQuantidade = input.nextInt();
                produto.setQtd(novaQuantidade);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        System.out.println("Dados do produto atualizados!");

    }

    // Getters & Setters
    public int getID() {
        return ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}