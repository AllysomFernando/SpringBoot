package br.fag.services;

/**
 * Classe que fornece a funcionalidade de calcular a raiz quadrada de um número.
 */
public class Sqrt {

    /**
     * Calcula a raiz quadrada de um número.
     *
     * @param numero O número do qual se deseja calcular a raiz quadrada.
     * @return       A raiz quadrada do número. Se o número for negativo, retorna NaN (Not a Number).
     */
    public static double calcularRaizQuadrada(double numero) {
        // Verifica se o número é negativo
        if (numero < 0) {
            // Se o número é negativo, retorna NaN (Not a Number)
            return Double.NaN;
        }

        // Calcula a raiz quadrada do número
        return Math.sqrt(numero);
    }
}
