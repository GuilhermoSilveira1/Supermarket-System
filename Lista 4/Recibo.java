import java.util.ArrayList;

public class Recibo {
    private int ID;
    private Empregado atendente;
    private ArrayList<Produtos> produtos;
    private double total;
    private String pagamento;
    private double valorPago;
    private double troco;

    public Recibo() {

    }

    public Recibo(int ID,
            Empregado atendente,
            ArrayList<Produtos> produtos,
            double total,
            String pagamento,
            double valorPago,
            double troco) {
        this.ID = ID;
        this.atendente = atendente;
        this.produtos = produtos;
        this.total = total;
        this.pagamento = pagamento;
        this.valorPago = valorPago;
        this.troco = troco;
    }

    // Getters & Setters
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Empregado getAtendente() {
        return atendente;
    }

    public void setAtendente(Empregado atendente) {
        this.atendente = atendente;
    }

    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }
}
