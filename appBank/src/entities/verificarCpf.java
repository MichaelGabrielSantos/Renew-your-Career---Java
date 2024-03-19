package entities;

public class verificarCpf {

	public static boolean verificarCPF(String cpf) {
		
		int digito1, digito2;
        int soma1 = 0, soma2 = 0;
        int resto1, resto2;

        
        for (int i = 0; i < 9; i++) {
            soma1 += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
        }
        resto1 = 11 - (soma1 % 11);
        digito1 = (resto1 >= 10) ? 0 : resto1;

       
        for (int i = 0; i < 10; i++) {
            soma2 += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
        }
        resto2 = 11 - (soma2 % 11);
        digito2 = (resto2 >= 10) ? 0 : resto2;

       
        return digito1 == Integer.parseInt(cpf.substring(9, 10)) && digito2 == Integer.parseInt(cpf.substring(10, 11));
		
		
	}
}
