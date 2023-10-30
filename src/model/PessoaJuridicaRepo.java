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

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas;
    Scanner scanner = new Scanner(System.in);
    int id;
    String nome;
    String cpf;
    int idade;
    String cnpj;

    public PessoaJuridicaRepo() {
        this.pessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
    
        this.pessoasJuridicas.add(pessoaJuridica);

        System.out.println("Cadastrado com Sucesso!" + "\n");
    }

    public void alterar(int id) {
        boolean encontrado = false;

        for (int i = 0; i < this.pessoasJuridicas.size(); i++) {
            PessoaJuridica pessoaJuridica = this.pessoasJuridicas.get(i); // obtém o objeto na posição i
            if (pessoaJuridica.getId() == id) { // verifica se o id do objeto é igual ao id desejado
                PessoaJuridica p = new PessoaJuridica();

                // Lê o ID do terminal e atribui ao atributo nome do objeto p
                p.setId(id);
                // Lê o nome do terminal e atribui ao atributo nome do objeto p
                System.out.print("Digite o nome: ");
                nome = scanner.next();
                p.setNome(nome);

                scanner.nextLine();
                // Lê o CNPJ do terminal e atribui ao atributo nome do objeto p
                System.out.print("Digite o CNPJ: ");
                cnpj = scanner.nextLine();
                p.setCnpj(cnpj);

                this.pessoasJuridicas.set(i, p); // substitui o objeto pelo novo objeto
                System.out.println("Aterado com sucesso!" + "\n"); // imprime uma mensagem de confirmação
                encontrado = true;
            }
        }
        if (!encontrado) { 
            System.out.println("ID não encontrado para alteração" + "\n");
        }

    }

    public void excluir(int id) {
        Iterator<PessoaJuridica> iterator = this.pessoasJuridicas.iterator(); // cria um Iterator para a lista
        while (iterator.hasNext()) { // enquanto houver elementos na lista
            PessoaJuridica pessoaJuridica = iterator.next(); // obtém o próximo elemento
            if (pessoaJuridica.getId() == id) { // verifica se o id do elemento é igual ao id desejado
                iterator.remove(); // remove o elemento da lista usando o Iterator
                System.out.println("ID: " + id + ". Removido com sucesso!" + "\n"); // imprime uma mensagem de
                                                                                    // confirmação
                return; // sai do método
            }
        }
        System.out.println("ID não encontrado para exclusão" + "\n"); // imprime uma mensagem de erro se não encontrar o
                                                                      // objeto com o id desejado
    }

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoaJuridica : this.pessoasJuridicas) { // loop para percorrer o array
            if (pessoaJuridica.getId() == id) { // compara o id do objeto com o id desejado
                System.out.println("============="+"BUSCA"+"=============");
                System.out.println("Id: " + pessoaJuridica.getId());
                System.out.println("Nome: " + pessoaJuridica.getNome());
                System.out.println("CNPJ: " + pessoaJuridica.getCnpj());
                System.out.println("==============================");
                return pessoaJuridica; // retorna o objeto encontrado
            }
        }

        System.out.println("Não foi encontrado este id: " + id + "\n");
        return null; // retorna null se não encontrar nenhum objeto com o id desejado
    }

    public PessoaJuridica obterTodos() {
        // Verifica se o array está vazio
        if (this.pessoasJuridicas.isEmpty()) {
            // Imprime uma mensagem de erro e retorna
            System.out.println("Não há pessoas jurídicas cadastradas" + "\n");
            return null;
        }
        // Se o array não estiver vazio, percorre os elementos normalmente
        System.out.println("============"+"TODOS"+"=============");
        for (PessoaJuridica pessoaJuridica : this.pessoasJuridicas) {
            System.out.println("-----------------------------");
            System.out.println("Id: " + pessoaJuridica.getId());
            System.out.println("Nome: " + pessoaJuridica.getNome());
            System.out.println("CNPJ: " + pessoaJuridica.getCnpj() + "\n");
        }
        System.out.println("==============================" + "\n");
        return null;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this.pessoasJuridicas);
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
            ArrayList<PessoaJuridica> dadosDoArquivo = (ArrayList<PessoaJuridica>) in.readObject(); // Adiciona os dados
                                                                                                    // do arquivo ao
                                                                                                    // final do
                                                                                                    // ArrayList
                                                                                                    // existente
            this.pessoasJuridicas.addAll(dadosDoArquivo);
            System.out.println("====Recuperado com Sucesso====" + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}