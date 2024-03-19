package entities;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.List;

public class banco {
    private ArrayList<accounts> listaContas;

    public banco() {
        this.listaContas= new ArrayList<>();
    }

    public void cadastrarConta(accounts accounts) {
    	listaContas.add(accounts);
    	System.out.println("Conta: " + accounts.getNumeroConta() + " do usuario: " + accounts.getNome() + " criada com sucesso!");
    }

    public accounts buscarConta(int numeroConta) {
        for (accounts accounts : listaContas) {
            if (accounts.getNumeroConta() == numeroConta) {
                return accounts;
            }
        }
        return null; 
    }
    
    public void atualizarSaldo(int numeroConta, double novoSaldo) {
        
        accounts contaExistente = buscarConta(numeroConta);
        
        if (contaExistente != null) {
            
            
            contaExistente.setSaldo(novoSaldo);
            
            
            
        } else {
            
            System.out.println("Conta com o número " + numeroConta + " não encontrada.");
        }
    }
    
 public void atualizarLimite(int numeroConta, double novoLimite) {
        
        accounts contaExistente = buscarConta(numeroConta);
        
        if (contaExistente != null) {
            
            
            contaExistente.setLimite(novoLimite);
            
            
            System.out.println("Limite atualizado com sucesso!\n Novo Limite de: " + contaExistente.getLimite());
            
        } else {
            
            System.out.println("Conta com o número " + numeroConta + " não encontrada.");
        }
    }
 
 public void gerarCsv(int numeroConta, String fileName, ArrayList<accounts> accountList) {
	    try (PrintWriter writer = new PrintWriter(new File(fileName))) {
	        writer.println("NumeroConta,Cliente,Saldo,Limite,TipoDaConta,Senha,CPF");
	        
	       
	        for (accounts account : accountList) {
	            if (account.getNumeroConta() == numeroConta) {
	                writer.println(account.getNumeroConta() + "," + 
	                               account.getNome() + "," + 
	                               account.getSaldo() + "," + 
	                               account.getLimite() + "," + 
	                               account.getTipoDaConta() + "," + 
	                               "****" + "," +  
	                               account.getCpf());
	            }
	        }
	        System.out.println("Arquivo CSV gerado com sucesso: " + fileName);
	    } catch (FileNotFoundException e) {
	        System.out.println("Erro ao gerar o arquivo CSV: " + fileName);
	        e.printStackTrace();
	    }
	}

 
    
    
   }



   