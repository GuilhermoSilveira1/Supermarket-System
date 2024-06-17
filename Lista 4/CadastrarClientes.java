/*Cadastro de Clientes:
Incluir novo cliente
Consultar cliente
Atualizar cliente
Excluir cliente 
Depois incluir essa função como método na classe Cliente*/

import java.util.Scanner;

public class CadastrarClientes {

    
    
    public Clientes cadastrarClientes() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        String firstName = input.next();

        System.out.println("Digite o sobrenome do cliente");
        String lastName = input.next();

        System.out.println("Digite o CPF, sem pontos ou traço:");
        String CPF = input.next();

        System.out.println("Digite o número do telefone, sem espaços ou traços:");
        String numTelefone = input.next();

        Clientes cliente = new Clientes(firstName, lastName, CPF, numTelefone);

        System.out.println(" ");
        System.out.println("Cliente cadastrado!");
        System.out.println(" ");

        input.close();

        return cliente;
    }

    public void atualizarCliente(String CPF) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; CPF == ListaClientes.get(i).getCPF(); i++) {
            System.out.println(ListaClientes.get(i).getFirstName() + ListaClientes.get(i).getLastName()); 
            System.out.println("É este o cliente que gostaria de atualizar? ");       
            String reposta = input.next();

            if (reposta.toLowerCase() == "sim") {
                
                System.out.println("Qual dado gostaria de atualizar?");

                String dado = input.next();

                switch (dado) {
                    case "CPF":
                        ListaCliente.setCPF(String )
                        break;
                
                    default:
                        break;
                }

            } else {
                break;
            }
        }
    }

    public void excluirCliente(String CPF) {
        if (ListaClientes.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            for (int i = 0; i ListaClientes.get(i).getCPF(); i++) {
                if (CPF == ListaClientes[i]) {
                    System.out.println("Removido cliente: ");
                    System.out.println(ListaClientes[i].getFirstName + ListaClientes[i].getLastName);
                    ListaClientes.remove(i);
                    break;
                }
            }
        }
    }
}
