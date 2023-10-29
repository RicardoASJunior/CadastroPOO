package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaRepo() {
        this.pessoasJuridicas = new ArrayList<>();
    }

    public void inserir(PessoaJuridica pessoaJuridica) {
        this.pessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(int id, PessoaJuridica novaPessoaJuridica) {
        this.pessoasJuridicas.set(id, novaPessoaJuridica);
    }

    public void excluir(int id) {
        this.pessoasJuridicas.remove(id);
    }

    public PessoaJuridica obter(int id) {
        return this.pessoasJuridicas.get(id);
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return this.pessoasJuridicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(this.pessoasJuridicas);
        }
    }

    @SuppressWarnings("unchecked")
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            this.pessoasJuridicas = (ArrayList<PessoaJuridica>) in.readObject();
        }
    }
}