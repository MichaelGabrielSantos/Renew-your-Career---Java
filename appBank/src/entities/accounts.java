package entities;

import java.util.ArrayList;
import java.util.List;



public class accounts{
    private int numeroConta;
    private String cliente;
    private double saldo;
    private double limite;
    private String tipoDaConta;

    public accounts(int numeroConta, String cliente, double saldo, double limite, String tipoDaConta) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.limite = limite;
        this.tipoDaConta = tipoDaConta;
    }
    
    
    public void depositarSaldo(double saldo) {
		
		this.saldo += saldo;
	}
	
	public String retirarSaldo(double retirada) {
		
		String message;
		
		if(this.saldo < retirada){
		message = "Saldo insuficiente";
		} else
		{
			this.saldo -= retirada;
			message = "retirado com sucesso";
		}
		return "Valor " + message + ": " + retirada;
	}
	
	public void alterarLimite(double limite) {
		this.limite -= limite;
	}


	public static void add(accounts conta) {
		// TODO Auto-generated method stub
		
	}
    
	
	public int getNumeroConta() {
        return numeroConta;
    }
}

	
	
	
	
	

