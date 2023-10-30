import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Pessoa;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();
        int opcao = 1;
        int id;
        String nome;
        String cpf;
        int idade;
        String cnpj;
        String arquivoPessoaFisica = "pessoa.fisica.bin";
        String arquivoPessoaJuridica = "pessoa.juridica.bin";

        while (opcao != 0) {
            System.out.println("Insira a opção desejada:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Obter pelo ID");
            System.out.println("5 - Obter todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar execução");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // código para incluir PessoaJuridica
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    String tipo = scanner.next().toUpperCase();

                    if (tipo.charAt(0) == 'F') {
                        PessoaFisica pessoaFisica = new PessoaFisica();
                        boolean valido = false;

                        while (!valido) {
                            try {
                                System.out.println("Digite o ID: ");
                                id = scanner.nextInt();
                                pessoaFisica.setId(id);
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }

                        scanner.nextLine();

                        System.out.println("Digite o Nome: ");
                        nome = scanner.nextLine();
                        pessoaFisica.setNome(nome);

                        valido = false;
                        while (!valido) {
                            try {
                                System.out.println("Digite a Idade: ");
                                idade = scanner.nextInt();
                                pessoaFisica.setIdade(idade);
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }

                        scanner.nextLine();

                        System.out.println("Digite o CPF: ");
                        cpf = scanner.next();
                        pessoaFisica.setCpf(cpf);

                        pessoaFisicaRepo.inserir(pessoaFisica);
                    } else if (tipo.charAt(0) == 'J') {
                        PessoaJuridica pessoaJuridica = new PessoaJuridica();
                        boolean valido = false;

                        while (!valido) {
                            try {
                                System.out.println("Digite o ID: ");
                                id = scanner.nextInt();
                                pessoaJuridica.setId(id);
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }

                        scanner.nextLine();

                        System.out.println("Digite o Nome: ");
                        nome = scanner.nextLine();
                        pessoaJuridica.setNome(nome);

                        System.out.println("Digite o CNPJ: ");
                        cnpj = scanner.next();
                        pessoaJuridica.setCnpj(cnpj);
                        pessoaJuridicaRepo.inserir(pessoaJuridica);
                    } else {
                        System.out.println("Tipo inválido");
                    }
                    break;

                // -----------------------------------------------------------------------
                case 2: // código para alterar
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    tipo = scanner.next().toUpperCase();

                    if (tipo.charAt(0) == 'F') {
                        boolean valido = false;
                        while (!valido) {
                            try {
                                System.out.println("Digite o ID que deseja alterar: ");
                                id = scanner.nextInt();
                                pessoaFisicaRepo.alterar(id);
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }

                    } else if (tipo.charAt(0) == 'J') {
                        boolean valido = false;
                        while (!valido) {
                            try {
                                System.out.println("Digite o ID que deseja alterar: ");
                                id = scanner.nextInt();
                                pessoaJuridicaRepo.alterar(id);
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("Tipo inválido");
                    }
                    break;

                // -----------------------------------------------------------------------
                case 3: // código para excluir
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    tipo = scanner.next().toUpperCase();

                    if (tipo.charAt(0) == 'F') {
                        boolean valido = false;
                        while (!valido) {
                            try {
                                System.out.println("Digite o ID que deseja excluir: ");
                                id = scanner.nextInt();
                                pessoaFisicaRepo.excluir(id);
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }

                    } else if (tipo.charAt(0) == 'J') {
                        boolean valido = false;
                        while (!valido) {
                            try {
                                System.out.println("Digite o ID que deseja excluir: ");
                                id = scanner.nextInt();
                                pessoaJuridicaRepo.excluir(id);
                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("Tipo inválido");
                    }
                    break;

                // -----------------------------------------------------------------------
                case 4: // código para obter pelo ID
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    tipo = scanner.next().toUpperCase();

                    if (tipo.charAt(0) == 'F') {
                        boolean valido = false;
                        while (!valido) {
                            try {
                                System.out.println("Digite o ID que deseja obter: ");
                                id = scanner.nextInt();
                                pessoaFisicaRepo.obter(id);

                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }

                    } else if (tipo.charAt(0) == 'J') {
                        boolean valido = false;
                        while (!valido) {
                            try {
                                System.out.println("Digite o ID que deseja obter: ");
                                id = scanner.nextInt();
                                pessoaJuridicaRepo.obter(id);

                                valido = true;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: você deve digitar um inteiro.");
                                scanner.nextLine();
                            }
                        }
                    } else {
                        System.out.println("Tipo inválido");
                    }
                    break;

                // -----------------------------------------------------------------------
                case 5: // código para obter todos
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    tipo = scanner.next().toUpperCase();

                    if (tipo.charAt(0) == 'F') {
                        pessoaFisicaRepo.obterTodos();
                    } else if (tipo.charAt(0) == 'J') {
                        pessoaJuridicaRepo.obterTodos();
                    } else {
                        System.out.println("Tipo inválido");
                    }
                    break;

                // -----------------------------------------------------------------------
                case 6: // código para salvar dados
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    tipo = scanner.next().toUpperCase();

                    if (tipo.charAt(0) == 'F') {
                        pessoaFisicaRepo.persistir(arquivoPessoaFisica);
                    } else if (tipo.charAt(0) == 'J') {
                        pessoaJuridicaRepo.persistir(arquivoPessoaJuridica);
                    } else {
                        System.out.println("Tipo inválido");
                    }
                    break;

                // -----------------------------------------------------------------------
                case 7: // código para recuperar dados
                    System.out.println("F - Pessoa Física | J - Pessoa Jurídica");
                    tipo = scanner.next().toUpperCase();

                    if (tipo.charAt(0) == 'F') {
                        pessoaFisicaRepo.recuperar(arquivoPessoaFisica);
                    } else if (tipo.charAt(0) == 'J') {
                        pessoaJuridicaRepo.recuperar(arquivoPessoaJuridica);
                    } else {
                        System.out.println("Tipo inválido");
                    }
                    break;

                // -----------------------------------------------------------------------
                case 0:
                    System.out.println("Finalizando execução...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        scanner.close();
    }
}
