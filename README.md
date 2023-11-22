
# Simple Jakarta ConsultaCEP API
O projeto simple-jakarta-consultacep é uma aplicação web Java desenvolvida utilizando Jakarta EE 10 e MicroProfile 6.0.
O principal objetivo desta aplicação é fornecer uma API REST que consulta informações de CEPs através da API externa [BrasilAPI](https://brasilapi.com.br/). Este serviço é encapsulado em um ambiente Jakarta EE e exposto através de um endpoint REST.

## Tecnologias Utilizadas
- Jakarta EE 10: Para fornecer os recursos de aplicativos web baseados em Java.
- MicroProfile 6.0: Para otimizar a aplicação empresarial Java para uma arquitetura de microserviços.
- Maven: Para gerenciamento de dependências e build do projeto.
- Java 17: Como linguagem de programação e versão da plataforma Java.

## Estrutura do Projeto
O projeto é dividido em duas partes principais:

1. Controller (CEPConsultaController): Responsável por lidar com solicitações HTTP, mapeando a URL /cep/{cep} e retornando os dados do CEP consultado em formato JSON.
2. Service (CEPConsultaService): Realiza a lógica de negócio para consultar o CEP na API externa, tratando a resposta e convertendo-a em um JsonObject.
   Configuração
3. O arquivo pom.xml define as dependências necessárias e a configuração para o build do projeto. As principais dependências são Jakarta EE e MicroProfile, que são providas pelo servidor (por exemplo, OpenLiberty).

## Endpoints
O serviço disponibiliza o seguinte endpoint:

* GET /cep/{cep}: Retorna informações do CEP fornecido. Substitua {cep} pelo número do CEP que deseja consultar.

## Execução do Projeto
Para executar o projeto, você precisará de um servidor que suporte Jakarta EE 10 e MicroProfile 6.0, como o OpenLiberty. Após configurar o servidor, você pode realizar o build e o deploy do projeto utilizando o Maven:

* ### Build
``` 
mvn clean package
```
Em seguida, deploy o arquivo WAR gerado no servidor de sua escolha

* ### Executar o OpenLiberty plugin:
``` 
mvn io.openliberty.tools:liberty-maven-plugin:dev -f "CAMINHO_ATE_O_SEU_POM/pom.xml"
```
Você pode rodar o openliberty via terminal ou utilize as ferramentas do [OpenLiberty Tools](https://openliberty.io/start/#_develop_with_liberty_tools)

## Configuração do Servidor OpenLiberty
Para utilizar este projeto com o servidor OpenLiberty, é importante notar que ele está configurado para usar credenciais específicas. As credenciais padrão definidas são:

**Usuário: dev**

**Senha: dev**

Essas credenciais são usadas para autenticação básica no servidor. Recomenda-se fortemente alterar essas credenciais em ambientes de produção para garantir a segurança.

## Alterando as Credenciais
Para modificar essas credenciais, siga os passos abaixo:

1. Acesse o arquivo de configuração do servidor OpenLiberty (server.xml).
2. Localize a seção de segurança ou autenticação.
3. Altere os valores de usuário e senha conforme necessário.

## Tratamento de Erros
A aplicação trata respostas não bem-sucedidas da API externa e responde com uma mensagem de erro apropriada.


## Licença

[MIT](https://choosealicense.com/licenses/mit/)

