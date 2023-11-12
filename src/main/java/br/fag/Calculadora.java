package br.fag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal que inicia a aplicação Spring Boot para a calculadora.
 */
@SpringBootApplication
public class Calculadora {

    /**
     * Método principal que inicia a aplicação Spring Boot.
     *
     * @param args Argumentos de linha de comando fornecidos durante a execução da aplicação.
     */
    public static void main(String[] args) {
        SpringApplication.run(Calculadora.class, args);
    }

}
