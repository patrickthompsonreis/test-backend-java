# Samples backend java

Este projeto tem o intuito de avaliar dos candidatos a ingressarem na Itix.

As tecnologias envolvidas desejáveis são:
 - JAVA 10 (open jdk);
 - JEE 8.0;
 - JUnit;
 - Maven;
 - Docker;
 - Servidores de Aplicação  sugestão Jboss, Wildfly, TomEE  (fica a seu gosto);
 - Banco de dados sugestão mysql, postgreSQL (fica a seu gosto);

*A utilização de qualquer outra biblioteca fica a gosto.
  
## Requisitos Funcionais
O projeto deve prover endpoint para consultar um determinado cep. O sistema vai verificar se o cep já consta em sua base de dados e se ainda é um registro valido. Caso o registro tenha excedido o prazo de validade então o sistema vai consultar o site [http://viacep.com.br/](http://viacep.com.br/) e atualizar o registro na base de dados renovando o prazo de validade do mesmo. Caso não tenha o cep pesquisado na base já efetua a consulta no site [http://viacep.com.br/](http://viacep.com.br/) e salva um novo registro na base de dados. Toda vez que consultar o site [http://viacep.com.br/](http://viacep.com.br/) deve gerar um registro de log com data e hora da execução o valor da request e o retorno.

A regra de validação do registro é se a diferença da dataIncl comparado com a data e hora atual for menor que 5 minutos é um registro valido. 

## Orientações Gerais
Você deve fazer um fork deste projeto e efetuar um PR com as suas implementações.
É obrigatório ter o Docker-compose para a execução do projeto.