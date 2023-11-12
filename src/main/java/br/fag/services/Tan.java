package br.fag.services;

/**
 * Classe que fornece a funcionalidade de calcular a tangente de um ângulo.
 */
public class Tan {

    /**
     * Calcula a tangente de um ângulo em graus.
     *
     * @param anguloGraus O valor do ângulo em graus.
     * @return            A tangente do ângulo, usando o valor absoluto para garantir um resultado não negativo.
     */
    public static double calcularTangente(double anguloGraus) {
        // Converte o ângulo de graus para radianos
        double anguloRadianos = Math.toRadians(anguloGraus);

        // Calcula a tangente do ângulo em radianos
        double tangente = Math.tan(anguloRadianos);

        // Se desejar garantir um resultado positivo, utiliza o valor absoluto
        return Math.abs(tangente);
    }
}
