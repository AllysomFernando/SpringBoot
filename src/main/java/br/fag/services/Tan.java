package br.fag.services;

public class Tan {
    public static double calcularTangente(double anguloGraus) {
        double anguloRadianos = Math.toRadians(anguloGraus);
        double tangente = Math.tan(anguloRadianos);

        // Se quiser garantir um resultado positivo, use o valor absoluto
        return Math.abs(tangente);
    }
}
