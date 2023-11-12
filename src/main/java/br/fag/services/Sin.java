package br.fag.services;

public class Sin {
    public static double calcularSeno(double graus) {
        double radianos = graus * Math.PI / 180;
        return Math.sin(radianos);
    }
}
