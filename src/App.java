import java.io.IOException;
import java.util.Scanner;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class App {
    // public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
//         PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
//         int opcao = 0;

//         while (opcao != 0) {
//             System.out.println("Insira a opção desejada:");
//             System.out.println("1 - Incluir");
//             System.out.println("2 - Alterar");
//             System.out.println("3 - Excluir");
//             System.out.println("4 - Obter pelo ID");
//             System.out.println("5 - Obter todos");
//             System.out.println("6 - Salvar dados");
//             System.out.println("7 - Recuperar dados");
//             System.out.println("0 - Finalizar execução");
//             opcao = scanner.nextInt();

//             switch (opcao) {
//                 case 1:
//                     System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
//                     String tipo = scanner.next();

//                     if (tipo.charAt(0) == 'F') {
//                     // código para incluir PessoaFisica
//                     } else if (tipo.charAt(0) == 'J') {
//                     // código para incluir PessoaJuridica
//                     } else {
//                     System.out.println("Tipo inválido");
//                     }
//                     break;
//                 case 2:
//                     // código para alterar
//                     break;
//                 case 3:
//                     // código para excluir
//                     break;
//                 case 4:
//                     // código para obter pelo ID
//                     break;
//                 case 5:
//                     // código para obter todos
//                     break;
//                 case 6:
//                     // código para salvar dados
//                     break;
//                 case 7:
//                     // código para recuperar dados
//                     break;
//                 case 0:
//                     System.out.println("Finalizando execução...");
//                     break;
//                 default:
//                     System.out.println("Opção inválida");
//                     break;
//             }
//         }
//         scanner.close();
//     }
// }




    public static void main(String[] args) throws IOException, ClassNotFoundException{
        PessoaFisica nova = new PessoaFisica();
        nova.setId(4);
        nova.setNome("Ricardo");
        nova.setCpf("123.123.123.32");
        nova.setIdade(20);
        nova.exibir();

        PessoaFisica outraPessoa = new PessoaFisica();
        outraPessoa.setId(5);
        outraPessoa.setNome("Luana");
        outraPessoa.setCpf("321.321.321.12");
        outraPessoa.setIdade(22);
        outraPessoa.exibir();

        PessoaJuridica xptoLmtd = new PessoaJuridica();
        xptoLmtd.setId(1);
        xptoLmtd.setNome("xpto");
        xptoLmtd.setCnpj("12312-12312-123");
        xptoLmtd.exibir();

        PessoaFisicaRepo novaUm = new PessoaFisicaRepo();
        novaUm.inserir(nova);
        novaUm.inserir(outraPessoa);
        novaUm.persistir("pessoa.fisica.bin");
        novaUm.recuperar("pessoa.fisica.bin");
        novaUm.obter(1);
        
       

    }
}

 