package model;


public class PessoaFisica extends Pessoa{
    private String cpf;
    private int idade;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void exibePessoaFisica() {
        System.out.println("Id: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Cpf: " + cpf);
        System.out.println("Idade: " + idade);
    }

    
}
