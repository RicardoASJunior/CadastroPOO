import java.io.IOException;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;

public class repo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String arquivoPessoaFisica = "pessoa.fisica.bin";

        PessoaFisica novaPessoa = new PessoaFisica();
        novaPessoa.setId(3);
        novaPessoa.setNome("Galvao Bueno");
        novaPessoa.setCpf("453.345.635-56");
        novaPessoa.setIdade(45);
        novaPessoa.exibir();

        PessoaFisica outraPessoa = new PessoaFisica();
        outraPessoa.setId(4);
        outraPessoa.setNome("Severina");
        outraPessoa.setCpf("867.243.525-56");
        outraPessoa.setIdade(76);
        // outraPessoa.exibir();

        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        pessoaFisicaRepo.inserir(novaPessoa);
        pessoaFisicaRepo.inserir(outraPessoa);
        pessoaFisicaRepo.recuperar(arquivoPessoaFisica);
        pessoaFisicaRepo.obterTodos();
        
        pessoaFisicaRepo.obter(1);
        pessoaFisicaRepo.excluir(1);
        pessoaFisicaRepo.alterar(2);
        pessoaFisicaRepo.obterTodos();
        pessoaFisicaRepo.inserir(novaPessoa);
        pessoaFisicaRepo.obterTodos();
        



    }
}
