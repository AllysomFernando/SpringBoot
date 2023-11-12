package br.fag.services;

public class Cos {
    public static double calcularCos(double anguloGraus) {
        // Converter graus para radianos
        double anguloRadianos = Math.toRadians(anguloGraus);

        // Calcular o cosseno
        return Math.cos(anguloRadianos);
    }
}
