
import java.util.ArrayList;

public class Secao {

    private String nome;

    private int ID;
    private ArrayList<Produtos> produtos;
    private String descricao;

    public Secao(String nome, int ID, ArrayList<Produtos> produtos, String descricao) {
        this.nome = nome;
        this.ID = ID;
        this.produtos = produtos;
        this.descricao = descricao;
    }

    // Getters & Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
