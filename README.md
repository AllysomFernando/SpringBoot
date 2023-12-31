Calculadora Spring Boot

Esta aplicação é uma calculadora desenvolvida em Java usando o framework Spring Boot. Ela fornece duas categorias principais de funcionalidades: operações básicas de calculadora e operações matemáticas mais avançadas.
Funcionalidades Básicas
1. Operações Básicas de Calculadora

   Endpoint: /calculate
   Método HTTP: GET
   Parâmetros:
   first: O primeiro operando.
   second: O segundo operando.
   operator: O operador da operação (+, -, *, /).

Exemplo de uso:

bash

curl "http://localhost:8080/calculate?first=5&second=3&operator=+"

2. Operações Científicas

   Endpoint: /scientific
   Método HTTP: GET
   Parâmetros:
   value: O valor sobre o qual a operação científica será realizada.
   operation: A operação científica a ser executada (sin, cos, sqrt, tan, ^).

Exemplo de uso:

bash

curl "http://localhost:8080/scientific?value=45&operation=sin"

Funcionalidades Adicionais

A aplicação também oferece suporte a operações avançadas, como seno, cosseno, raiz quadrada e tangente.
Como Executar a Aplicação

    Clone este repositório: git clone https://github.com/seu-usuario/calculadora-spring-boot.git
    Navegue até o diretório da aplicação: cd calculadora-spring-boot
    Execute a aplicação Spring Boot: ./mvnw spring-boot:run
    Acesse a aplicação através do navegador ou ferramenta como o cURL.

Requisitos

    Java 11 ou superior.
    Maven (para facilitar, o projeto inclui o Maven Wrapper mvnw).

Esta calculadora oferece uma interface simples para realizar cálculos básicos e avançados. Sinta-se à vontade para explorar e contribuir!
