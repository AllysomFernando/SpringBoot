package br.fag.services;

/**
 * Classe que fornece a funcionalidade de calcular o seno de um ângulo.
 */
public class Sin {

    /**
     * Calcula o seno de um ângulo em graus.
     *
     * @param graus O valor do ângulo em graus.
     * @return      O seno do ângulo, usando o valor absoluto para garantir um resultado não negativo.
     */
    public static double calcularSeno(double graus) {
        // Converte o ângulo de graus para radianos
        double radianos = graus * Math.PI / 180;

        // Calcula o seno do ângulo em radianos
        double seno = Math.sin(radianos);

        // Se desejar garantir um resultado positivo, utiliza o valor absoluto
        return Math.abs(seno);
    }
}
