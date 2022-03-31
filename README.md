# DBC Company
Projeto criado como prova técnica para a [DBC Company](https://www.dbccompany.com.br/)

## Objetivos
Criar um programa que analise um lote de arquivos com extensão `.dat`, localizados no diretório `%HOMEPATH%/data/in`, e após o processamento
gerar um relatório com o nome `{flat_file_name}.done.dat`, no diretório `%HOMEPATH%/data/out`, com os seguintes dados:
- Quantidade de clientes no arquivo de entrada
- Quantidade de vendedor no arquivo de entrada
- ID da venda mais cara
- O pior vendedor

## Ferramentas de Desenvolvimento
O projeto foi criado utilizando [Java 8](https://www.oracle.com/java/technologies/java8.html) e [Maven](https://maven.apache.org/)
como controle de dependências.

## Biblotecas utilizadas
No desenvolvimento desse programa foram utilizadas as seguinte bibliotecas
- [Apache Commons IO](https://commons.apache.org/proper/commons-io/): Utilizada para facilitar a manipulação de arquivos e pastas
- [JUnit 5](https://junit.org): Utilizado para implementar testes de funcionalidades