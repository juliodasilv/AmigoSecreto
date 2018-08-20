# AmigoSecreto

Trabalho Final de Java na Web. Descrição Básica

## Descrição

Realizar o sorteio de um amigo secreto em que o usuário se cadastrar no sistema e tem acessos aos grupos do sorteio que foram criados.

## Estrutura do banco

![alt tag](https://raw.githubusercontent.com/juliodasilv/AmigoSecreto/master/files/tabela_membro.PNG)
<br/>

![alt tag](https://raw.githubusercontent.com/juliodasilv/AmigoSecreto/master/files/tabela_grupo.PNG)

## Tecnologias Utilizadas

Utilizamos o Spring MVC, JPA e Bootstrap no front-end com o template Zontal Admin.
A escolha do Spring MVC foi devido as tecnologias que são adotadas como injeção de dependência, separação de responsabilidades no MVC.
Além disso, a integração dele com outros recursos, é mais fácil de ser realizada. 
Utilizamos o JPA para persistir os dados no banco e no front-end utilizamos um template free disponível na web com bootstrap chamado Zontal Admin.

## Configuração

Para alterar o usuário e senha do banco de dados:

br.com.fiap.trabalhofinal.conf.JPAConfiguration

dataSource.setUrl("jdbc:mysql://localhost:3306/dbamigosecreto");
dataSource.setUsername("root");
dataSource.setPassword("root");

## Autores

* **Julio Oliveira da Silva** - [juliodasilv](https://github.com/juliodasilv)
* **Helena Strada** - [hstrada](https://github.com/hstrada)