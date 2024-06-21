public class Recibo {

    private static int idCounter = 1;
    private int ID;
    private Venda venda;

    public Recibo() {
        this.ID = idCounter++;
    }

    public Recibo(Venda venda) {
        this.ID = idCounter++;
        this.venda = venda;
    }

    // Getters & Setters
    public int getID() {
        return ID;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}

