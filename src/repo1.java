import java.io.IOException;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;

public class repo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String arquivoPessoaFisica = "pessoa.fisica.bin";

        PessoaFisica novaPessoa = new PessoaFisica();
        novaPessoa.setId(1);
        novaPessoa.setNome("Ricardo");
        novaPessoa.setCpf("123.123.123-32");
        novaPessoa.setIdade(23);
        novaPessoa.exibir();

        PessoaFisica outraPessoa = new PessoaFisica();
        outraPessoa.setId(2);
        outraPessoa.setNome("Luana");
        outraPessoa.setCpf("321.321.321-12");
        outraPessoa.setIdade(22);
        // outraPessoa.exibir();

        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        pessoaFisicaRepo.inserir(novaPessoa);
        pessoaFisicaRepo.inserir(outraPessoa);
        pessoaFisicaRepo.obter(1);
        pessoaFisicaRepo.excluir(1);
        pessoaFisicaRepo.alterar(2);
        pessoaFisicaRepo.obterTodos();
        pessoaFisicaRepo.inserir(novaPessoa);
        pessoaFisicaRepo.obterTodos();
        pessoaFisicaRepo.persistir(arquivoPessoaFisica);
    

      
    }
}
