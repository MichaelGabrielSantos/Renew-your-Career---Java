Ol�! 
Aqui est� o meu primeiro desafio em Java!
Demorei bastante para reproduzi-lo e coloquei bastante esfor�o nele.
Entendi que a minha maior dificuldade foi de fato a organiza��o do projeto e do c�digo ( estrutura mesmo), al�m de nomenclatura de componentes.
J� estou trabalhando nisso e aguardo ansiosamente o proximo desafio!


Diagrama MermaidJS: 

classDiagram
    class AppBank {
      +string nome
      +string tipoDaConta
      +string cpf
      +boolean cpfValido
      +int randomNumber
      +int senha
      +int numeroConta
      +double saldo
      +double limite
      +double retiradaSaldo
      +double transferenciaSaldo
      +verificarCpf()
      +accounts()
      +banco()
    }

    class Banco {
      +ArrayList listaContas
      +cadastrarConta()
      +buscarConta()
      +atualizarSaldo()
      +atualizarLimite()
      +gerarCsv()
    }

    class Accounts {
      -int numeroConta
      -String cliente
      -double saldo
      -double limite
      -String tipoDaConta
      -int senha
      -String cpf
      +getNome()
      +getNumeroConta()
      +getLimite()
      +getSaldo()
      +getTipoDaConta()
      +getSenha()
      +getCpf()
      +setSaldo(double novoSaldo)
      +setLimite(double novoLimite)
    }

    AppBank --> Banco : usa
    AppBank --> Accounts : usa
    Banco "1" -- "*" Accounts : cont�m

Obs: a imagem se encontra na p�gina do projeto tamb�m!
