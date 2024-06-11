/*Cadastro de Clientes:
• Armazenar informações como nome, endereço, telefone, CPF e data de nascimento.
• Permitir consulta e atualização dos dados cadastrais. */

public class Clientes {

    private String nome;
    private String endereco;
    private String telefone;
    private String CPF;
    private String dataNascimento;

    // Construtor
    public Clientes() {

    }

    // Getters & Setters

    // Getters
    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    // Setters
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}