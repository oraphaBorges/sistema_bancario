# Sistema Bancario


## Configuração
No  diretório `target/classes/META-INF` há um arquivo chamado `persistence.example.xml` que deve ser usado de modelo para criar o `persistence.xml` e subistiuíndo para as cofigurações locais do nome do banco de dado e usuário e senha de acesso ao banco de dados, que no projeto é utilizado o MySQL, por isso o arquivo já está pré-configurado com o Drive do MySQL.

##CLASSES SERVICES 
Reponsaveis por alocarem a nossa regra de negocios 

##Repository
Repository generic, com todo nosso CRUD 

##MODELS
Tendo as nossas entidades, relacionamentos: 

####MODEL CONTA####
Modelo de entidade, onde fica os dados da conta

####MODEL USUARIO####
Modelo de entidade, Dados do usuario 

####MODEL LANCAMENTO####
Tendo uma forengkey das tabelas conta e Plano conta, recebe em log, toda movimentação da conta

####PLANO CONTA###
Recebe a finalidade da conta  
