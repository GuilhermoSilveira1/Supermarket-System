/*Cadastro de Atendentes de Caixa:
• Armazenar informações como nome, endereço, telefone, CPF, cargo e data de admissão.
• Permitir consulta e atualização dos dados cadastrais.
• Atribuir um identificador único para cada caixa.
 */

public class Atendentes extends Empregado {

    public Atendentes() {
        this.opcao = new Opcao[] {};
    }

    public Atendentes(int ID, String primeiroNome,
            String ultimoNome,
            String email,
            String endereco,
            String telefone,
            double salario) {

        super(ID, primeiroNome, ultimoNome, email, endereco, telefone, salario)
        this.opcao = new Opcao[] {};
    }
}
