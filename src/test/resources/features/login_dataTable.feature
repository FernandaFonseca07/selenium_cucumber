#language:pt

  Funcionalidade: Teste login BugBank
    Cenario: Login com sucesso
      Dado que esteja na pagina de login: "http://localhost:3000"
      E preencho cadastro com os dados
      | Email              | Nome       | Senha | Confirmacao |
      | teste@teste.com.br | Fe Fonseca | teste | teste |
      Quando preencher email "teste@teste.com.br" e senha "teste"
      E clicar em fazer login
      Entao valido que a pagina de boas vindas foi carregado