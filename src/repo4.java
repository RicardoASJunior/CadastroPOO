import java.io.IOException;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class repo4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String arquivoPessoaJuridica = "pessoa.juridica.bin";

        PessoaJuridica empresa = new PessoaJuridica();
        empresa.setId(3);
        empresa.setNome("kzLmtd");
        empresa.setCnpj("43.643.122/0001-65");
        empresa.exibir();

        PessoaJuridica outraEmpresa = new PessoaJuridica();
        outraEmpresa.setId(4);
        outraEmpresa.setNome("bhLmtd");
        outraEmpresa.setCnpj("34.313.543/0001-98");
        // bhLmtd.exibir();

        PessoaJuridicaRepo novaEmpresa = new PessoaJuridicaRepo();
        novaEmpresa.inserir(empresa);
        novaEmpresa.inserir(outraEmpresa);
        novaEmpresa.recuperar(arquivoPessoaJuridica);
        novaEmpresa.obterTodos();

        novaEmpresa.obter(1);
        novaEmpresa.excluir(1);
        novaEmpresa.alterar(2);
        novaEmpresa.obterTodos();
        novaEmpresa.inserir(empresa);
        novaEmpresa.obterTodos();
        



    }
}
