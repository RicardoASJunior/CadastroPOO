import java.io.IOException;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class repo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String arquivoPessoaJuridica = "pessoa.juridica.bin";

        PessoaJuridica xptoLmtd = new PessoaJuridica();
        xptoLmtd.setId(1);
        xptoLmtd.setNome("xpto");
        xptoLmtd.setCnpj("12.234.234/0001-34");
        xptoLmtd.exibir();

        PessoaJuridica wyzLmtd = new PessoaJuridica();
        wyzLmtd.setId(2);
        wyzLmtd.setNome("wyzLmtd");
        wyzLmtd.setCnpj("65.234.186/0001-56");
        // wyzLmtd.exibir();

        PessoaJuridicaRepo novaEmpresa = new PessoaJuridicaRepo();
        novaEmpresa.inserir(xptoLmtd);
        novaEmpresa.inserir(wyzLmtd);
        novaEmpresa.obter(1);
        novaEmpresa.excluir(1);
        novaEmpresa.alterar(2);
        novaEmpresa.obterTodos();
        novaEmpresa.inserir(xptoLmtd);
        novaEmpresa.obterTodos();
        novaEmpresa.persistir(arquivoPessoaJuridica);


    }
}
