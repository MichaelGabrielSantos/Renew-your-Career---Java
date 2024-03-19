Olá! 
Aqui está o meu primeiro desafio em Java!
Demorei bastante para reproduzi-lo e coloquei bastante esforço nele.
Entendi que a minha maior dificuldade foi de fato a organização do projeto e do código ( estrutura mesmo), além de nomenclatura de componentes.
Já estou trabalhando nisso e aguardo ansiosamente o proximo desafio!


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
    Banco "1" -- "*" Accounts : contém

Obs: a imagem se encontra na página do projeto também!
