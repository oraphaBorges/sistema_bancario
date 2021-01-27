# Sistema Bancario


## Configuração
No  diretório `target/classes/META-INF` há um arquivo chamado `persistence.example.xml` que deve ser usado de modelo para criar o `persistence.xml` e subistiuíndo para as cofigurações locais do nome do banco de dado e usuário e senha de acesso ao banco de dados, que no projeto é utilizado o MySQL, por isso o arquivo já está pré-configurado com o Drive do MySQL.

## CASE PROJETO 

**SISTEMA BANCARIO**

* Intenção do projeto é ao fim dele termos uma API rest de um basico sistema bancário, onde conseguiremos emitir um extrato de todos lançamentos, com a data do efetivo. 

## CLASSES SERVICES 

**CONTA SERVICE**
* responsavel pela regra de negocio da conta para transafarencias, depositos, pagamentos, assossiacao do usuario a conta

**USUARIO SERVICE**
* responsavel pelo crud do usuario. 

**LANCAMENTO SERVICE**
* responsavel por associar a conta do usuario, e fazer um log de todas as atividades da conta, desde depositos, pagamentos e transferencias 

**PLANO DE CONTA**
* contem o cadastro do tipo da conta


### Repository

**GENERICS**
temos um repositorio generico contendo todo crud, onde não precisamos reescrever essa lógica, apenas herdala nos proximos repository

**REPOSITORY**
* Os demais repositorios temos em cada um deles os metodos necessarios para cada afinidade da conta


### MODELS
* Tendo as nossas entidades, relacionamentos: 

#### MODEL CONTA
* Modelo de entidade, onde fica os dados da conta

#### MODEL USUARIO
* Modelo de entidade, Dados do usuario 

####MODEL LANCAMENTO
* Tendo uma forengkey das tabelas conta e Plano conta, recebe em log, toda movimentação da conta

####PLANO CONTA
* Recebe a finalidade da conta  
