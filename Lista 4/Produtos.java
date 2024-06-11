public class Produtos {

    private String descricao;
    private double price;
    private int ID;
    private String nome;
    private int qtd;

    // Construtor
    public Produtos(String descricao, double price, String nome, int ID, int qtd) {
        this.descricao = descricao;
        this.price = price;
        this.nome = nome;
        this.ID = ID;
        this.qtd = qtd;
    }

    // Getters & Setters

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public double getPrice() {
        return price;
    }

    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public int getQtd() {
        return qtd;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
