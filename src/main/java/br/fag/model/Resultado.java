package br.fag.model;

public class Resultado {
    public double valor;
    public String mensagemErro;
    public Resultado(double valor) {
        this.valor = valor;
    }

    public Resultado(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public boolean temErro() {
        return mensagemErro != null;
    }
}
