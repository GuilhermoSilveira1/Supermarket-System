public abstract class Empregado {

    protected int ID;
    protected String primeiroNome;
    protected String ultimoNome;
    protected String email;
    protected String endereco;
    protected String telefone;
    protected double salario;
    protected Opcao[] opcao;

    // Construtor
    public Empregado(int ID, String primeiroNome,
            String ultimoNome,
            String email,
            String endereco,
            String telefone,
            double salario) {

        this.ID = ID;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.salario = salario;
    }

    // Getters & setters

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
