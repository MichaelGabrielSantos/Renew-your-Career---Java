package entities;
import java.util.ArrayList;
import java.util.List;

public class banco {
    private List<accounts> accounts;

    public banco() {
        this.accounts = new ArrayList<>();
    }

    public void cadastrarConta(accounts accounts) {
        accounts.add(accounts);
    }

    public accounts buscarConta(int numeroConta) {
        for (accounts accounts : accounts) {
            if (accounts.getNumeroConta() == numeroConta) {
                return accounts;
            }
        }
        return null; 
    }
}

   