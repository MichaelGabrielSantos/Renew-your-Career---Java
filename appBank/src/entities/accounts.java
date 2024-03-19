package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class accounts{
    private int numeroConta;
    private String cliente;
    private double saldo;
    private double limite;
    private String tipoDaConta;
    private int senha;
    private String cpf;

    public accounts(int numeroConta, String cliente, double saldo, double limite, String tipoDaConta, int senha, String cpf) {
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.limite = limite;
        this.tipoDaConta = tipoDaConta;
        this.senha = senha;
        this.cpf = cpf;
    }
    
    
 

	public static void add(accounts conta) {
		// TODO Auto-generated method stub
		
	}
	
   
	
	 public int getNumeroConta() {
	        return numeroConta;
	    }

	    public String getNome() {
	        return cliente;
	    }

	    public double getLimite() {
	        return limite;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public String getTipoDaConta() {
	        return tipoDaConta;
	    }
	    
	    public int getSenha() {
	        return senha;
	    }
	    public String getCpf() {
	    	return cpf;
	    }


	    
	    public void setSaldo(double novoSaldo) {
	        this.saldo = novoSaldo;
	    }

	    
	    public void setLimite(double novoLimite) {
	        this.limite = novoLimite;
	    }
}

	
	
	
	
	

