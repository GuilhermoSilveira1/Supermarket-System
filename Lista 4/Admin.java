public class Admin extends Empregado {

    public Admin() {
        this.opcao = new Opcao[] {};
    }

    public Admin(int ID, String primeiroNome,
            String ultimoNome,
            String email,
            String endereco,
            String telefone,
            double salario) {

        super(ID, primeiroNome, ultimoNome, email, endereco, telefone, salario)
        this.opcao = new Opcao[] {};
    }
}
