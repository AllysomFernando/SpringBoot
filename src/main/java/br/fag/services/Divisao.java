package br.fag.services;

import br.fag.model.Resultado;

/**
 * Classe que representa a operação de divisão.
 */
public class Divisao {

    /**
     * Realiza a operação de divisão entre dois números inteiros.
     *
     * @param primeiroValor O numerador da divisão.
     * @param segundoValor  O denominador da divisão.
     * @return              Resultado da operação de divisão encapsulado em um objeto Resultado.
     *                      Se o denominador for zero ou negativo, retorna um objeto Resultado com uma mensagem de erro.
     */
    public Resultado operacao(int primeiroValor, int segundoValor) {
        // Verifica se a divisão por zero é evitada
        if (segundoValor <= 0) {
            return new Resultado("Divisão por zero não permitida");
        }

        // Realiza a divisão e retorna o resultado
        return new Resultado((float) primeiroValor / segundoValor);
    }
}
