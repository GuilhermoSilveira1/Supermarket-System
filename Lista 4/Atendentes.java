/*Cadastro de Atendentes de Caixa:
• Armazenar informações como nome, endereço, telefone, CPF, cargo e data de admissão.
• Permitir consulta e atualização dos dados cadastrais.
• Atribuir um identificador único para cada caixa.
 */

 import java.util.Scanner;
 import java.util.ArrayList;
 
 public class Atendentes {
 
     private static int nextID = 1; // Static variable to keep track of the next available ID
 
     private int ID;
     private String firstName;
     private String lastName;
     private String email;
     private String endereco;
     private String telefone;
     private double salario;
 
     // Construtor vazio
     public Atendentes() {
     }
 
     // Construtor com parâmetros
     public Atendentes(String firstName, String lastName, String email, String endereco, String telefone, double salario) {
         this.ID = nextID++; // Assign the current nextID and then increment it
         this.firstName = firstName;
         this.lastName = lastName;
         this.email = email;
         this.endereco = endereco;
         this.telefone = telefone;
         this.salario = salario;
     }
 
     // Métodos
     public static Atendentes cadastrarAtendentes() {
         Scanner input = new Scanner(System.in);
 
         System.out.println("Digite o nome do atendente:");
         String firstName = input.nextLine();
 
         System.out.println("Digite o sobrenome do atendente:");
         String lastName = input.nextLine();
 
         System.out.println("Digite o email:");
         String email = input.nextLine();
 
         System.out.println("Digite o endereço do atendente:");
         String endereco = input.nextLine();
 
         System.out.println("Digite o número do telefone, sem espaços ou traços:");
         String telefone = input.nextLine();
 
         System.out.println("Digite o salário:");
         double salario = input.nextDouble();
 
         Atendentes atendente = new Atendentes(firstName, lastName, email, endereco, telefone, salario);
 
         System.out.println(" ");
         System.out.println("Atendente cadastrado!");
         System.out.println(" ");

         input.close();
 
         return atendente;
     }
 
     public static void atualizarAtendente(ArrayList<Atendentes> listaAtendentes, int ID) {
         Scanner input = new Scanner(System.in);
 
         for (Atendentes atendente : listaAtendentes) {
             if (atendente.getID() == ID) {
                 System.out.println("Atendente encontrado: " + atendente.getFirstName() + " " + atendente.getLastName());
                 System.out.println("Qual dado gostaria de atualizar?");
                 System.out.println("1 - Nome");
                 System.out.println("2 - Sobrenome");
                 System.out.println("3 - Email");
                 System.out.println("4 - Endereço");
                 System.out.println("5 - Telefone");
                 System.out.println("6 - Salário");
 
                 int opcao = input.nextInt();
                 input.nextLine(); // Consume newline
 
                 switch (opcao) {
                     case 1:
                         System.out.println("Digite o novo nome:");
                         String firstName = input.nextLine();
                         atendente.setFirstName(firstName);
                         break;
                     case 2:
                         System.out.println("Digite o novo sobrenome:");
                         String lastName = input.nextLine();
                         atendente.setLastName(lastName);
                         break;
                     case 3:
                         System.out.println("Digite o novo email:");
                         String email = input.nextLine();
                         atendente.setEmail(email);
                         break;
                     case 4:
                         System.out.println("Digite o novo endereço:");
                         String endereco = input.nextLine();
                         atendente.setEndereco(endereco);
                         break;
                     case 5:
                         System.out.println("Digite o novo telefone:");
                         String telefone = input.nextLine();
                         atendente.setTelefone(telefone);
                         break;
                     case 6:
                         System.out.println("Digite o novo salário:");
                         double salario = input.nextDouble();
                         atendente.setSalario(salario);
                         break;
                     default:
                         System.out.println("Opção inválida.");
                         break;
                 }
                 System.out.println("Dados do atendente atualizados!");
                 break;
             }
         }
         input.close();
     }
 
     public static void excluirAtendente(ArrayList<Atendentes> listaAtendentes, int ID) {
         if (listaAtendentes.isEmpty()) {
             System.out.println("Lista de atendentes vazia!");
         } else {
             for (int i = 0; i < listaAtendentes.size(); i++) {
                 if (listaAtendentes.get(i).getID() == ID) {
                     System.out.println("Removido atendente: " + listaAtendentes.get(i).getFirstName() + " " + listaAtendentes.get(i).getLastName());
                     listaAtendentes.remove(i);
                     break;
                 }
             }
         }
     }
 
     // Getters & Setters
     public int getID() {
         return ID;
     }
 
     public String getFirstName() {
         return firstName;
     }
 
     public void setFirstName(String firstName) {
         this.firstName = firstName;
     }
 
     public String getLastName() {
         return lastName;
     }
 
     public void setLastName(String lastName) {
         this.lastName = lastName;
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
 
