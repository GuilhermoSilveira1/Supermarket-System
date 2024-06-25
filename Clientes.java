/*Cadastro de Clientes:
• Armazenar informações como nome, endereço, telefone, CPF e data de nascimento.
• Permitir consulta e atualização dos dados cadastrais. */

import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

public class Clientes implements Serializable{

    private static int nextID = 1; // Static variable to keep track of the next available ID

    private int ID;
    private String nome;
    private String endereco;
    private String telefone;
    private String CPF;
    private String dataNascimento;

    // Construtor vazio
    public Clientes() {
    }

    // Construtor com parâmetros
    public Clientes(String nome, String endereco, String telefone, String CPF, String dataNascimento) {
        this.ID = nextID++; // Assign the current nextID and then increment it
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
    }

    // Métodos
    public static Clientes cadastrarClientes(Scanner input) {

        System.out.println("Digite o nome do cliente:");
        String nome = input.nextLine();

        System.out.println("Digite o endereço do cliente:");
        String endereco = input.nextLine();

        System.out.println("Digite o telefone do cliente:");
        String telefone = input.nextLine();

        System.out.println("Digite o CPF do cliente (sem pontos ou traços):");
        String CPF = input.nextLine();

        System.out.println("Digite a data de nascimento do cliente:");
        String dataNascimento = input.nextLine();

        Clientes cliente = new Clientes(nome, endereco, telefone, CPF, dataNascimento);

        System.out.println("Cliente cadastrado!");
        System.out.println();

        return cliente;
    }

    public static void atualizarCliente(ArrayList<Clientes> listaClientes, String CPF, Scanner input) {

        for (Clientes cliente : listaClientes) {
            if (cliente.getCPF().equals(CPF)) {
                System.out.println("Cliente encontrado: " + cliente.getNome());
                System.out.println("Qual dado gostaria de atualizar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Endereço");
                System.out.println("3 - Telefone");
                System.out.println("4 - Data de Nascimento");

                int opcao = input.nextInt();
                input.nextLine(); // Consume newline

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o novo nome:");
                        String novoNome = input.nextLine();
                        cliente.setNome(novoNome);
                        break;
                    case 2:
                        System.out.println("Digite o novo endereço:");
                        String novoEndereco = input.nextLine();
                        cliente.setEndereco(novoEndereco);
                        break;
                    case 3:
                        System.out.println("Digite o novo telefone:");
                        String novoTelefone = input.nextLine();
                        cliente.setTelefone(novoTelefone);
                        break;
                    case 4:
                        System.out.println("Digite a nova data de nascimento:");
                        String novaDataNascimento = input.nextLine();
                        cliente.setDataNascimento(novaDataNascimento);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                System.out.println("Dados do cliente atualizados!");
                break;
            }
        }
    }

    public static void excluirCliente(ArrayList<Clientes> listaClientes, String CPF) {
        if (listaClientes.isEmpty()) {
            System.out.println("Lista de clientes vazia!");
        } else {
            for (int i = 0; i < listaClientes.size(); i++) {
                if (listaClientes.get(i).getCPF().equals(CPF)) {
                    System.out.println("Removido cliente: " + listaClientes.get(i).getNome());
                    listaClientes.remove(i);
                    break;
                }
            }
        }
    }

    // Getters & Setters
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
