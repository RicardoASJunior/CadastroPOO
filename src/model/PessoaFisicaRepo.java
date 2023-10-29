package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas;

    public PessoaFisicaRepo() {
        this.pessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {
        this.pessoasFisicas.add(pessoaFisica);
    }

    public void alterar(int id, PessoaFisica novaPessoaFisica) {
        this.pessoasFisicas.set(id, novaPessoaFisica);
    }

    public void excluir(int id) {
        this.pessoasFisicas.remove(id);
    }

    public PessoaFisica obter(int id) {
        PessoaFisica pessoaFisica = this.pessoasFisicas.get(id);
        pessoaFisica.exibir(); // Adicione esta linha para imprimir os detalhes da PessoaFisica
        return pessoaFisica;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return this.pessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this.pessoasFisicas);
        }
    }

    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            this.pessoasFisicas = (ArrayList<PessoaFisica>) in.readObject();

            for (PessoaFisica pessoaFisica : this.pessoasFisicas) {
                pessoaFisica.exibir();
            }
        }
    }
}
