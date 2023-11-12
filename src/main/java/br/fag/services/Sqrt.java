package br.fag.services;

public class Sqrt {
    public static double calcularRaizQuadrada(double numero) {
        if (numero < 0) {
            // Se o número é negativo, retorna NaN (Not a Number)
            return Double.NaN;
        }
        return Math.sqrt(numero);
    }
}
