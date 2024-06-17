/*Cadastro de Atendentes de Caixa:
Incluir novo atendente
Consultar atendente
Atualizar atendente
Excluir atendente */

import java.util.Scanner;

public class CadastrarAtendente {

    public void cadastrarAtendentes() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do atendente:");
        String firstName = input.next();

        System.out.println("Digite o sobrenome do atendente");
        String lastName = input.next();

        System.out.println("Digite o CPF, sem pontos ou traço:");
        String CPF = input.next();

        System.out.println("Digite o número do telefone, sem espaços ou traços:");
        String numTelefone = input.next();

        Atendentes cliente = new Atendentes(firstName, lastName, CPF, numTelefone);

        System.out.println(" ");
        System.out.println("Cliente cadastrado!");
        System.out.println(" ");

        input.close();

        return cliente;
    }
}
