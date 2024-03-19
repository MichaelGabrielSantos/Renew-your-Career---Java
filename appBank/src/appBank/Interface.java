package appBank;

import java.util.Scanner;
import entities.accounts;
import java.util.ArrayList;
import entities.banco;
import entities.verificarCpf;

public class Interface {

    public static void main(String[] args) {

        // Iniciação e instanciação das Variáveis que serão utilizadas na interface
    	
    	Scanner sc = new Scanner(System.in);
        String nome, tipoDaConta, cpf;
        boolean cpfValido;
        int randomNumber, senha, numeroConta;
        double saldo, limite, retiradaSaldo, transferenciaSaldo;
        banco banco = new banco();
        accounts conta, conta2;
        verificarCpf veriricarCpf= new verificarCpf();
        ArrayList<accounts> accountList = new ArrayList<>();

        while (true) {
            System.out.println("\nEscolha a opção desejada:");
            System.out.println("1 - Cadastrar nova conta");
            System.out.println("2 - Retirada/Saque");
            System.out.println("3 - Alterar Limite");
            System.out.println("4 - Transferência");
            System.out.println("5 - Histórico de transações");
            System.out.println("6 - Depositar");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Digite o seu Nome Completo: ");
                    sc.nextLine(); 
                    nome = sc.nextLine();
                    cpfValido = false;
                    System.out.println("Digite o seu CPF");
                	cpf = sc.next();
                	cpfValido = verificarCpf.verificarCPF(cpf);
                    
                	// looping para garantir a inserção de um cpf válido
                    while(!cpfValido) {
                    	System.out.println("Digite o seu CPF");
                    	cpf = sc.next();
                    	cpfValido = verificarCpf.verificarCPF(cpf);
                    	if(!cpfValido) {
                    		System.out.println("Digite um cpf válido");
                    	} 
                    } 
                    System.out.println("Limite desejado (sujeito a aprovação): ");
                    limite = sc.nextDouble();
                    
                    System.out.print("Tipo da conta: ");
                    System.out.println("\nEscolha a opção desejada:");
                    System.out.println("1 - Corrente");
                    System.out.println("2 - Poupança");
                    
                    if(sc.nextInt() == 1) {
                    	tipoDaConta = "corrente";
                    } else {
                    	tipoDaConta = "poupanca";
                    }

                    // o número da conta sempre será escolhido de forma automática. No código ele vai até o número 100, pensando numa expansão desse app, esse numero aleatorio necessitará de um range maior
                    randomNumber = (int) (Math.random() * 101);
                    
                    System.out.println("Escolha uma senha de 6 digitos");
                    senha = sc.nextInt();
                    
                    System.out.println("Número da conta: " + randomNumber);

                    saldo = 0;

                    accounts accounts = new accounts(randomNumber, nome, saldo, limite, tipoDaConta, senha, cpf);
                    banco.cadastrarConta(accounts);
                    
                    break;
                case 2:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = sc.nextInt();

                    conta = banco.buscarConta(numeroConta);

                    if (conta != null) {
                        System.out.println("Conta encontrada: " + conta.getNome());
                        
                        System.out.println("Digite se sua senha de 6 digitos:");
                        senha = sc.nextInt();
                        
                        if( senha == conta.getSenha()) {
                        	System.out.println("Quanto desejar retirar?");
                        	retiradaSaldo = sc.nextDouble();
                        	
                        	if(retiradaSaldo > conta.getSaldo() ) {
                        		System.out.println("Saldo Insuficiente");
                        	}
                        	else {
                        	saldo = conta.getSaldo() - retiradaSaldo;
                        	banco.atualizarSaldo(conta.getNumeroConta(), saldo);
                        	
                        	// toda transação após concluida é lançada para o accountList. Dessa forma todas serão registradas
                        	accountList.add(new accounts(conta.getNumeroConta(), conta.getNome(), saldo, conta.getLimite(),
                        	conta.getTipoDaConta(), 000000, conta.getCpf()));
                        	} 
                        }
                        else{
                        	System.out.println("senha inválida!");
                        }
                    }
                    else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da conta: ");
                    numeroConta = sc.nextInt();

                    conta = banco.buscarConta(numeroConta);
                    if (conta != null) {
                        System.out.println("Conta encontrada: " + conta.getNome());
                        
                        System.out.println("Digite se sua senha de 6 digitos:");
                        senha = sc.nextInt();
                        
                        if( senha == conta.getSenha()) {
                        	
                        // numero aleatório criado para simular um crédito pre aprovado
                        randomNumber = (int )(Math.random() * 10000);
                        System.out.println("Deseja alterar o limite para quanto? ( Limite pré aprovado de até :" 
                        + randomNumber + " )");
                        limite = sc.nextDouble();
                        	if(limite > randomNumber ) {
                        		System.out.println("Limite não aprovado");
                        	}
                        	else {
                        		banco.atualizarLimite(conta.getNumeroConta(), limite);
                        		accountList.add(new accounts(conta.getNumeroConta(), conta.getNome(), conta.getSaldo(),
                        		limite,
                        		conta.getTipoDaConta(), 000000, conta.getCpf()));
                        	}
                        }
                        else {
                        	System.out.println("senha inválida!");
                        }
                    } 
                    else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                	System.out.print("Digite o número da conta: ");
                    numeroConta = sc.nextInt();

                    conta = banco.buscarConta(numeroConta);
                    if (conta != null) {
                        System.out.println("Conta encontrada: " + conta.getNome());
                        
                        System.out.println("Digite se sua senha de 6 digitos:");
                        senha = sc.nextInt();
                        
                        if( senha == conta.getSenha()) {
                        	System.out.println("Digite o numero da conta para qual deseja transferir");
                        	numeroConta = sc.nextInt();

                            conta2 = banco.buscarConta(numeroConta);
                            System.out.println("Conta encontrada: " + conta2.getNome());
                            
                            System.out.println("Quanto deseja transferir? ( Saldo disponivel: " + conta.getSaldo() + " )" );
                            retiradaSaldo = sc.nextDouble();
                            
                            if(retiradaSaldo <= conta.getSaldo()) {
                            	saldo = conta.getSaldo() - retiradaSaldo;
                            	banco.atualizarSaldo(conta.getNumeroConta(), saldo);
                            	
                            	transferenciaSaldo = conta2.getSaldo() + retiradaSaldo;
                            	banco.atualizarSaldo(conta2.getNumeroConta(), transferenciaSaldo);
                            	
                            	accountList.add(new accounts(conta.getNumeroConta(), conta.getNome(), saldo,
                            	conta.getLimite(),conta.getTipoDaConta(), 000000, conta.getCpf()));
                            	
                            	System.out.println("Transferencia realizada com sucesso!");
                            	
                            } else {
                            	System.out.println("Saldo Insuficiente!");
                            }
                            
                        }
                        else {
                        	System.out.println("senha inválida!");
                        }
                    } 
                    else {
                        System.out.println("Conta não encontrada.");
                    }
                	break;
                case 5:
                     
                    String fileName = "C:/historico_transacoes.csv";

                    
                    System.out.print("Digite o número da conta: ");
                    numeroConta = sc.nextInt();

                    conta = banco.buscarConta(numeroConta);

                    
                    banco.gerarCsv(numeroConta, fileName, accountList);
                	break;
                case 6:
                	System.out.print("Digite o número da conta: ");
                    numeroConta = sc.nextInt();

                    conta = banco.buscarConta(numeroConta);

                    if (conta != null) {
                        System.out.println("Conta encontrada: " + conta.getNome());
                        
                        System.out.println("Digite se sua senha de 6 digitos:");
                        senha = sc.nextInt();
                        
                        if( senha == conta.getSenha()) {
                        	System.out.println("Quanto desejar depositar?");
                        	saldo = sc.nextDouble() + conta.getSaldo();
                        	
                        	banco.atualizarSaldo(conta.getNumeroConta(), saldo);
                        	accountList.add(new accounts(conta.getNumeroConta(), conta.getNome(), conta.getSaldo(), conta.getLimite(),
                        	conta.getTipoDaConta(), 000000, conta.getCpf()));
                        	} 
                        else{
                        	System.out.println("senha inválida!");
                        }
                    }
                    else {
                        System.out.println("Conta não encontrada.");
                    }
                	break;
                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return; 
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
