# Sistema Bancario
**Sistema realizado em paralelo à realização da academia da Gama Academy**
## Sobre
O projeto consiste em uma `API REST` que realiza operações bancárias a partir de `requisições HTTP` de um cliente.
_Entenda-se cliente qualquer um que consiga realizar requisições HTTP_.

## Tecnologias principais
- Spring Boot
- Spring Data
- Spring Web
- Spring Security
- Swagger
- JWT

## Swagger
Aqui você pode realizar a consulta da documentação do projeto, bem como realizar requisições por meio de nossos endpoints.

## Funcionalidades

### Para usuários
- Criação de novos usuários
- Realização de login
- Controle de sessão
- Alteração de senha (em desenvolvimento)

> - Ao criar um novo usuário, três contas são associadas a ele: Corrente, Poupança e de Crédito.
> - Também são associados três tipos de planos de conta: Pagamento, Depósito e Transferência

### Para contas
- Consultar extrato por período
- Consultar extrato completo
- Realizar depósitos
- Realizar pagamentos
- Realizar transferências

## Utilização

**Para executar o projeto, você precisará:**
- Ter instalado em sua maquina o Java 8 ou superior.
- Um banco de dados, seja MySql ou PostgreSQL (oficialmente testados)

**Passo a passo**

1. Realize o clone desse repositório
2. Configure o arquivo `application.properties`, que fica dentro da pasta resources. [Exemplo aqui](https://www.baeldung.com/properties-with-spring). Ou utilizando classes caso tenha experiência configurando.
3. Realize o download das dependências que estão no `pom.xml`
4. Execute a classe `SbootApplication`.

> O projeto, por padrão, irá executar no {host}:8080/. (ex.: http://localhost:8080)

## Sobre a estrutura e inteligência do projeto

### Design e código fonte
O projeto segue um padrão de atribuição de responsabilidades às classes seguindo as boas práticas. Todo o código fonte está disponível dentro da pasta `src`.

### Estrutura de pastas e suas responsabilidades

#### Models
Como o nome já diz, são as classes modelo. Elas que definem o domínio de nossa aplicação, além da relação entre as entidades.

#### Resources
Concentramos aqui todos os endpoints relacionados ao projeto. A responsabilidade se limita a receber a requisição e dar o retorno de forma devida ao cliente.

#### Services
Os services são chamados para processar toda a lógica do negócio. Aqui é decidido se devemos persistir ou não os dados, ou se devemos devolver a resposta solicitada pelo cliente - claro, tudo por meio de bastante lógica e abuso de estrutura de dados e suas funcionalidades. Além da análise e permissão do que pode ser devolvido ao solicitante.

#### Repositories
Trata-se da camada de persistência dos dados. As lógicas se limitam às próprias necessidades. Aqui os dados são recebidos, persistidos ou retornados.

#### security
Literalmente a configuração de segurança do projeto. (endpoints públicos, privados, etc.)

#### dto
Abstrações menores das classes modelos, classes utilitárias para transferência dos dados entre o cliente e nossa aplicação. 

Os demais pacotes são autodescritivos.

## Validações e segurança

_Esse tópico poderia ser bem longo, mas será resumido da seguinte forma:_

**Todos os enpoints possuem validações de diversos tipos, tais como:**

- Verificação se todos os dados da requisição foram informados corretamente
- Verificação se as informações do cliente batem com as informações enviadas 
- Controle de rotas autenticadas e públicas
- ... Muitas outras que você poderá ver em `services`.

#### Encriptação da senha e login

Se você pensou nisso... Sim! As senhas estão sendo gravadas encriptadas! Logo o login também está bem seguro :).

## Participantes

Você pode ver os contribuidores **[clicando aqui.](https://github.com/RafaelMarangoni/sistema_bancario/graphs/contributors)**
