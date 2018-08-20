# AmigoSecreto

Sistema para cadastro de membros para posterior sorteio em um amigo secreto.

## Descrição

Os requisitos do sistema apontados pelo são:
1. Permissão de cadastro de pessoas participantes no amigo secreto.
2. Cada pessoa cadastrada deverá ter um meio de acesso ao sistema. Ela poderá utilizar, por
exemplo, seu CPF e uma senha (poderão ser usados outros meios de acesso; esta é uma
sugestão)
3. Depois que todos os membros se cadastrarem, o administrador do sistema executa uma ação
para realizar o sorteio.
4. Após o sorteio, ao entrar no sistema, o usuário poderá visualizar quem é seu amigo secreto.
5. A pessoa sorteada não poderá ser sorteada novamente.
6. A pessoa não poderá sortear a si mesma. 

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
