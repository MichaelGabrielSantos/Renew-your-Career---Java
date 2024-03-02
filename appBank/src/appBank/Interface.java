package appBank;

import java.util.Scanner;

import entities.accounts;
import entities.banco;

public class Interface {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String nome, tipoDaConta;
		int randomNumber;
		double saldo, limite;
		banco banco;
		banco = new banco();
		
		
		int choice;
		
		System.out.println("Escolha a opção desejada:");
		System.out.println("Cadastrar nova conta: 1");
		System.out.println("Retirada/Saque: 2");
		System.out.println("Alterar Limite: 3");
		System.out.println("Transferencia: 4");
		System.out.println("Histórico de transações: 5");
		
		choice = sc.nextInt();
		
		
		switch(choice){
			case 1:
				System.out.println("Digite o seu Nome Completo");
				nome = sc.next();
				System.out.println("Limite desejado ( sujeito a aprovação)");
				limite = sc.nextDouble();
				System.out.println("Tipo da conta");
				tipoDaConta = sc.next();
				
				randomNumber = (int) (Math.random() * 101);
				
				
				
				accounts accounts = new accounts(randomNumber,nome,limite,saldo,tipoDaConta);
				banco.cadastrarConta(accounts);
				
			break;
				
		}
		
		

	}

}
