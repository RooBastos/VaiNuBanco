package br.com.vainaweb.backendt1.desafio1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, ContaCorrente> cadastradosCorrente = new HashMap<>();
		HashMap<Integer, ContaPoupanca> cadastradosPoupanca = new HashMap<>();
		Gerente gerenteUnico = new Gerente("José Pedro", "1222531", 12523, 1234);

		boolean repetirMenu = true;

		while (repetirMenu) {
			String menuInicial = """
					\n\n|----- Bem vindo ao Nu Banco -----|

					  Escolha a opção para começar:
					1. Criar uma Conta Corrente
					2. Criar uma Conta Poupança
					3. Acessar Conta Corrente
					4. Acessar Conta Poupança
					5. Acesso Gerente
					6. Sair\n
					""";

			int opcaoInicial;

			System.out.println(menuInicial);
			System.out.println("\nOpção selecionada: ");
			opcaoInicial = sc.nextInt();

			switch (opcaoInicial) {

			case 1:

				ContaCorrente contaC = new ContaCorrente();

				System.out.println("\n|----- Criação de Conta Corrente -----|");

				System.out.println("\nEscreva o nome do titular da conta:");
				sc.nextLine();
				contaC.setNome(sc.nextLine());

				System.out.println("\nEscreva o CPF do titular da conta:");
				String cpfNovoCC = sc.next();
				sc.nextLine();

				boolean cpfExistenteCC = false;
				for (ContaCorrente contaCorrente : cadastradosCorrente.values()) {
					if (contaCorrente.getCPF().equals(cpfNovoCC)) {
						cpfExistenteCC = true;

					}
				}

				if (cpfExistenteCC) {
					System.out
							.println("CPF já cadastrado. Não é possível cadastrar outra Conta Corrente com este CPF.");
					break; // Sai do caso 1 e retorna ao menu inicial
				} else {
					contaC.setCPF(cpfNovoCC);

					contaC.setAgencia((int) (Math.random() * 1000));
					contaC.setNumeroConta((int) (Math.random() * 1000000));
					contaC.setSaldo(0);

					cadastradosCorrente.put(contaC.getNumeroConta(), contaC);

					System.out.println("\nConta criada com sucesso.\n");

					contaC.Visualizar();
				}

				break;

			case 2:

				ContaPoupanca contaP = new ContaPoupanca();

				System.out.println("\n|----- Criação de Conta Poupança -----|");

				System.out.println("\nEscreva o nome do titular da conta:");
				sc.nextLine();
				contaP.setNome(sc.nextLine());

				System.out.println("\nEscreva o CPF do titular da conta:");
				String cpfNovoCP = sc.next();
				sc.nextLine();

				boolean cpfExistenteCP = false;
				for (ContaPoupanca contaPoupanca : cadastradosPoupanca.values()) {
					if (contaPoupanca.getCPF().equals(cpfNovoCP)) {
						cpfExistenteCP = true;

					}
				}

				if (cpfExistenteCP) {
					System.out
							.println("CPF já cadastrado. Não é possível cadastrar outra Conta Poupança com este CPF.");
					break; // Sai do caso 1 e retorna ao menu inicial
				} else {
					contaP.setCPF(cpfNovoCP);

					contaP.setAgencia((int) (Math.random() * 1000));
					contaP.setNumeroConta((int) (Math.random() * 1000000));
					contaP.setSaldo(0);
					contaP.setDataCriacao(LocalDate.now());

					cadastradosPoupanca.put(contaP.getNumeroConta(), contaP);

					System.out.println("\nConta criada com sucesso.\n");

					contaP.Visualizar();
				}
				break;

			case 3:

				System.out.println("\n|----- Acesso a Conta Corrente -----|");

				System.out.println("\nEscreva o Número da Conta Corrente:");
				sc.nextLine();
				int numeroRecebidoC = sc.nextInt();
				sc.nextLine();

				ContaCorrente contaEncontradaC = cadastradosCorrente.get(numeroRecebidoC);

				if (contaEncontradaC != null && contaEncontradaC.getcontaAtiva() == true) {
					System.out.println(contaEncontradaC.getNome());

					repetirMenu = false;
					boolean repetirMenuCC = true;

					while (repetirMenuCC) {
						String menuContaCorrente = """
								\n\n|----- Menu da Conta Corrente -----|

									     Escolha a opção:
									1. Informações da Conta
									2. Extrato
									3. Depositar
								    	4. Sacar
									5. Transferir
									6. Verificar Limite de Crédito
									7. Solicitar Liberação de Limite de Crédito.
									8. Alterar Informações do Titular
									9. Cancelar Conta
									10. Encerrar Sessão\n\n
								""";
						System.out.println(menuContaCorrente);

						int escolhaMenuCC;

						System.out.println("\nOpção selecionada: ");
						escolhaMenuCC = sc.nextInt();

						switch (escolhaMenuCC) {
						case 1:
							contaEncontradaC.Visualizar();

							break;

						case 2:
							contaEncontradaC.RetornaSaldo();

							break;

						case 3:
							float deposito;

							System.out.println("Digite o valor que deseja depositar: \n");
							deposito = sc.nextFloat();

							if (deposito < 0) {
								System.out.println("Valor não permitido.");
							} else {
								contaEncontradaC.Depositar(deposito);

								System.out.println("Depósito realizado com sucesso.");
							}

							break;

						case 4:
							float saque;

							System.out.println("Digite o valor que deseja sacar: \n");
							saque = sc.nextFloat();

							if (contaEncontradaC.getSaldo() < saque) {
								System.out.println("O saldo atual é insuficiente para esta transação.");
							} else {
								contaEncontradaC.Sacar(saque);
								contaEncontradaC.RetornaSaldo();
							}

							break;

						case 5:
							float transferencia;

							System.out.println("Digite quanto deseja transferir: \n");
							transferencia = sc.nextFloat();

							if (contaEncontradaC.getSaldo() < transferencia) {
								System.out.println("O saldo atual é insuficiente para esta transação. \n");
							} else {
								contaEncontradaC.Transferir(transferencia);
								contaEncontradaC.RetornaSaldo();
							}

							break;

						case 6:
							contaEncontradaC.VerificaLimiteCredito();

							break;

						case 7:
							contaEncontradaC.SolicitaLimite();

							break;

						case 8:
							contaEncontradaC.Visualizar();

							System.out.println("Digite o novo nome escolhido:");
							String escolhaNome = sc.nextLine();

							contaEncontradaC.setNome(escolhaNome);

							System.out.println("Nome Alterado com Sucesso.");

							contaEncontradaC.Visualizar();

							break;

						case 9:
							System.out.println("Tem certeza que deseja cancelar a conta? \n");
							System.out.println("""
									Digite 1 - Sim
									Digite 2 - Não
									""");
							int confirmacaoFinal = sc.nextInt();

							if (confirmacaoFinal == 1) {
								System.out.println(
										"Conta concelada com sucesso. Esperamos que volte a utilizar nossos serviços! \n - Nu Banco \n\n");

								contaEncontradaC.setcontaAtiva(false);

								repetirMenuCC = false;
								repetirMenu = true;
							} else {
								System.out.println("Operação Cancelada. \n\n");
								repetirMenuCC = true;
							}

							break;

						case 10:
							repetirMenuCC = false;
							repetirMenu = true;

							break;
						}
					}
				} else {
					System.out.println("Conta não encontrada.");
				}

				break;

			case 4:

				System.out.println("\n|----- Acesso a Conta Poupança -----|");

				System.out.println("\nEscreva o Número da Conta Poupança:");
				sc.nextLine();
				int numeroRecebidoP = sc.nextInt();
				sc.nextLine();

				ContaPoupanca contaEncontradaP = cadastradosPoupanca.get(numeroRecebidoP);

				if (contaEncontradaP != null) {
					System.out.println(contaEncontradaP.getNome());

					repetirMenu = false;
					boolean repetirMenuCP = true;

					while (repetirMenuCP) {
						String menuContaPoupanca = """
								\n\n|----- Menu da Conta Poupança -----|

									     Escolha a opção:
									1. Informações da Conta
									2. Extrato
									3. Depositar
								    4. Sacar
									5. Transferir
									6. Verificar ganho mensal
									7. Alterar Informações do Titular
									8. Cancelar Conta
									9. Encerrar Sessão\n\n
								""";

						System.out.println(menuContaPoupanca);

						int escolhaMenuCP;

						System.out.println("\nOpção selecionada: ");
						escolhaMenuCP = sc.nextInt();

						switch (escolhaMenuCP) {
						case 1:
							contaEncontradaP.Visualizar();

							break;

						case 2:
							contaEncontradaP.RetornaSaldo();

							break;

						case 3:
							float deposito;

							System.out.println("Digite o valor que deseja depositar: \n");
							deposito = sc.nextFloat();
							if (deposito < 0) {
								System.out.println("Valor não permitido.");
							} else {
								contaEncontradaP.Depositar(deposito);

								System.out.println("Depósito realizado com sucesso.");
							}

							break;

						case 4:
							float saque;

							System.out.println("Digite o valor que deseja sacar: \n");
							saque = sc.nextFloat();

							if (contaEncontradaP.getSaldo() < saque) {
								System.out.println("O saldo atual é insuficiente para esta transação.");
							} else {
								contaEncontradaP.Sacar(saque);
								contaEncontradaP.RetornaSaldo();
							}

							break;

						case 5:
							float transferencia;

							System.out.println("Digite quanto deseja transferir: \n");
							transferencia = sc.nextFloat();

							if (contaEncontradaP.getSaldo() < transferencia) {
								System.out.println("O saldo atual é insuficiente para esta transação.");
							} else {
								contaEncontradaP.Transferir(transferencia);
								contaEncontradaP.RetornaSaldo();
							}

							break;

						case 6:
							contaEncontradaP.ConfereAniversario();

							break;

						case 7:
							contaEncontradaP.Visualizar();

							System.out.println("Digite o novo nome escolhido:");
							String escolhaNome = sc.nextLine();

							contaEncontradaP.setNome(escolhaNome);

							System.out.println("Nome Alterado com Sucesso.");

							contaEncontradaP.Visualizar();

							break;

						case 8:
							System.out.println("Tem certeza que deseja cancelar a conta? \n");
							System.out.println("""
									Digite 1 - Sim
									Digite 2 - Não
									""");
							int confirmacaoFinal = sc.nextInt();

							if (confirmacaoFinal == 1) {
								System.out.println(
										"Conta concelada com sucesso. Esperamos que volte a utilizar nossos serviços! \n - Nu Banco \n\n");

								contaEncontradaP.setcontaAtiva(false);

								repetirMenuCP = false;
								repetirMenu = true;
							} else {
								System.out.println("Operação Cancelada. \n\n");
								repetirMenuCP = true;
							}

							break;

						case 9:
							repetirMenuCP = false;
							repetirMenu = true;

							break;

						}
					}
				} else {
					System.out.println("Conta não encontrada. Favor entrar em contato com o SAC.\n\n");
				}

				break;

			case 5:
				System.out.println("Digite a matrícula de gerente: ");
				double matriculaGerente = sc.nextDouble();

				System.out.println("Digite a senha: ");
				int senhaGerente = sc.nextInt();
				sc.nextLine();

				if (matriculaGerente == gerenteUnico.getMatricula() && senhaGerente == gerenteUnico.getSenha()) {
					repetirMenu = false;

					boolean repetirMenuGerente = true;

					while (repetirMenuGerente) {

						String menuGerente = """
								\n\n|----- Menu do Gerente -----|
								1. Visualizar todas as Contas Correntes
								2. Visualizar todas as Contas Poupanças
								3. Visualiza Informações do Gerente Ativo
								4. Logout\n
								""";

						System.out.println(menuGerente);
						System.out.println("Escolha a opção: ");
						int escolhaMenuGerente = sc.nextInt();

						switch (escolhaMenuGerente) {
						case 1:

							for (Map.Entry<Integer, ContaCorrente> contaCorrente : cadastradosCorrente.entrySet()) {
								System.out.println("\n");
								contaCorrente.getValue().Visualizar();
								System.out.println("\n");
							}

							repetirMenuGerente = true;
							repetirMenu = true;

							break;

						case 2:
							for (Map.Entry<Integer, ContaPoupanca> contaPoupanca : cadastradosPoupanca.entrySet()) {
								System.out.println("\n");
								contaPoupanca.getValue().Visualizar();
								System.out.println("\n");
							}

							repetirMenuGerente = true;
							repetirMenu = true;

							break;

						case 3:
							gerenteUnico.Visualizar();
							break;

						case 4:
							repetirMenuGerente = false;
							repetirMenu = true;
							break;
						}
					}

				}
				break;

			case 6:
				repetirMenu = false; // Sai do loop e encerra o programa
				System.out.println("Saindo do programa. Obrigado por utilizar o Nu Banco.");
				break;

			default:
				System.out.println("\nA opção Inválida.");
				break;
			}
		}

		sc.close();
	}
}