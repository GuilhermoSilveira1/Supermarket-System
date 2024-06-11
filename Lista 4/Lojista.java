public class Lojista extends Empregado {

    public Lojista() {
        this.opcao = new Opcao[] {};
    }

    public Lojista(int ID, String primeiroNome,
            String ultimoNome,
            String email,
            String endereco,
            String telefone,
            double salario) {

        super(ID, primeiroNome, ultimoNome, email, endereco, telefone, salario)
        this.opcao = new Opcao[] {};
    }
}
