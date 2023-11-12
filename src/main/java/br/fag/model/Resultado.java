package br.fag.model;

/**
 * Classe que representa o resultado de uma operação, seja bem-sucedida ou com erro.
 */
public class Resultado {

    /**
     * O valor resultante da operação.
     */
    public double valor;

    /**
     * Mensagem de erro, se a operação não for bem-sucedida.
     */
    public String mensagemErro;

    /**
     * Construtor que inicializa o resultado com um valor específico.
     *
     * @param valor O valor resultante da operação.
     */
    public Resultado(double valor) {
        this.valor = valor;
    }

    /**
     * Construtor que inicializa o resultado com uma mensagem de erro.
     *
     * @param mensagemErro A mensagem de erro associada à operação.
     */
    public Resultado(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    /**
     * Verifica se o resultado possui um erro.
     *
     * @return true se houver um erro, false caso contrário.
     */
    public boolean temErro() {
        return mensagemErro != null;
    }
}
