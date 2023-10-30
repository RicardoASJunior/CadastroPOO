package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas;
    Scanner scanner = new Scanner(System.in);
    int id;
    String nome;
    String cpf;
    int idade;

    public PessoaFisicaRepo() {
        this.pessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {
        this.pessoasFisicas.add(pessoaFisica);
        System.out.println("Cadastrado com Sucesso!" + "\n");
    }

    public void alterar(int id) {
        boolean valido = false;
        boolean encontrado = false;

        for (int i = 0; i < this.pessoasFisicas.size(); i++) {
            PessoaFisica pessoaFisica = this.pessoasFisicas.get(i); // obtém a pessoa na posição i
            if (pessoaFisica.getId() == id) { // verifica se o id do objeto é igual ao id desejado
                System.out.println("Nova Pessoa" + "\n");
                PessoaFisica p = new PessoaFisica();

                // Lê o ID do terminal e atribui ao atributo nome do objeto p
                p.setId(id);
                // Lê o nome do terminal e atribui ao atributo nome do objeto p
                System.out.print("Digite o nome: ");
                nome = scanner.next();
                p.setNome(nome);
                // Lê o nome do terminal e atribui ao atributo nome do objeto p

                valido = false;
                while (!valido) {
                    try {
                        System.out.println("Digite a Idade: ");
                        idade = scanner.nextInt();
                        p.setIdade(idade);
                        valido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: você deve digitar um inteiro.");
                        scanner.nextLine();
                    }
                    
                }
                // Lê o CPF do terminal e atribui ao atributo nome do objeto p
                System.out.print("Digite o CPF: ");
                cpf = scanner.next();
                p.setCpf(cpf);

                this.pessoasFisicas.set(i, p); // substitui o objeto pelo novo objeto
                System.out.println("Alterado com sucesso!" + "\n");
                encontrado = true;
            }
        }
        if (!encontrado) { 
            System.out.println("ID não encontrado para alteração" + "\n");
        }
                                           

    }

    public void excluir(int id) {
        Iterator<PessoaFisica> iterator = this.pessoasFisicas.iterator(); // cria um Iterator para a lista
        while (iterator.hasNext()) { // enquanto houver elementos na lista
            PessoaFisica pessoaFisica = iterator.next(); // obtém o próximo elemento
            if (pessoaFisica.getId() == id) {
                iterator.remove(); // remove o elemento da lista usando o Iterator
                System.out.println("ID: " + id + ". Removido com sucesso!" + "\n");
                return; // sai do método
            }
        }
        System.out.println("ID não encontrado para exclusão" + "\n");

    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : this.pessoasFisicas) { // loop para percorrer o array
            if (pessoaFisica.getId() == id) { // compara o id do objeto com o id desejado
                System.out.println("============="+"BUSCA"+"============");
                System.out.println("ID: " + pessoaFisica.getId());
                System.out.println("Nome: " + pessoaFisica.getNome());
                System.out.println("Idade: " + pessoaFisica.getIdade());
                System.out.println("CPF: " + pessoaFisica.getCpf());
                System.out.println("==============================");
                return pessoaFisica; // retorna o objeto encontrado
            }
        }

        System.out.println("Não foi encontrado este id: " + id + "\n");
        return null; // retorna null se não encontrar nenhum objeto com o id desejado
    }

    public PessoaFisica obterTodos() {
        // Verifica se o array está vazio
        if (this.pessoasFisicas.isEmpty()) {
            // Imprime uma mensagem de erro e retorna
            System.out.println("Não há pessoas físicas cadastradas" + "\n");
            return null;
        }
        // Se o array não estiver vazio, percorre os elementos normalmente
        System.out.println("============"+"TODOS"+"=============");
        for (PessoaFisica pessoaFisica : this.pessoasFisicas) {
            System.out.println("-----------------------------");
            System.out.println("ID: " + pessoaFisica.getId());
            System.out.println("Nome: " + pessoaFisica.getNome());
            System.out.println("Idade: " + pessoaFisica.getIdade());
            System.out.println("CPF: " + pessoaFisica.getCpf() + "\n");
        }
        System.out.println("==============================" + "\n");
        return null;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this.pessoasFisicas);
            System.out.println("====Gravado com Sucesso====" + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo);
                ObjectInputStream in = new ObjectInputStream(fileIn)) { // Cria um novo ArrayList para armazenar os
                                                                        // dados do arquivo
            ArrayList<PessoaFisica> dadosDoArquivo = (ArrayList<PessoaFisica>) in.readObject(); // Adiciona os dados do
                                                                                                // arquivo ao final do
                                                                                                // ArrayList existente
            this.pessoasFisicas.addAll(dadosDoArquivo);
            System.out.println("====Recuperado com Sucesso====" + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}