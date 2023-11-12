package br.fag.services;

public class Sin {
    public static double calcularSeno(double graus) {
        double radianos = graus * Math.PI / 180;
        double seno = Math.sin(radianos);

        // Se quiser garantir um resultado positivo, use o valor absoluto
        return Math.abs(seno);
    }
}
