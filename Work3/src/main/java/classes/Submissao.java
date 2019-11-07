package classes;

import Enumeracao.Situacao;

/**
 * Submissao
 */
public abstract class Submissao {
    protected String tituloSubmissao;
    protected Situacao situacaoSubmissao;
    protected String autoresSubmissao[];
    protected int MAX_AUTORES;

    public Submissao(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[], int MAX_AUTORES) {
        this.tituloSubmissao = tituloSubmissao;
        this.situacaoSubmissao = situacaoSubmissao;
        this.autoresSubmissao = autoresSubmissao;
        this.MAX_AUTORES = MAX_AUTORES;
    }

    /**
     * @return the tituloSubmissao
     */
    public String getTituloSubmissao() {
        return tituloSubmissao;
    }

    /**
     * @param tituloSubmissao the tituloSubmissao to set
     */
    public void setTituloSubmissao(String tituloSubmissao) {
        this.tituloSubmissao = tituloSubmissao;
    }

    /**
     * @return the situacaoSubmissao
     */
    public Situacao getSituacaoSubmissao() {
        return situacaoSubmissao;
    }

    /**
     * @param situacaoSubmissao the situacaoSubmissao to set
     */
    public void setSituacaoSubmissao(Situacao situacaoSubmissao) {
        this.situacaoSubmissao = situacaoSubmissao;
    }

    /**
     * @return the autoresSubmissao
     */
    public String[] getAutoresSubmissao() {
        return autoresSubmissao;
    }

    /**
     * @param autoresSubmissao the autoresSubmissao to set
     */
    public void setAutoresSubmissao(String[] autoresSubmissao) {
        this.autoresSubmissao = autoresSubmissao;
    }

    /**
     * @return the mAX_AUTORES
     */
    public int getMAX_AUTORES() {
        return MAX_AUTORES;
    }

    /**
     * @param mAX_AUTORES the mAX_AUTORES to set
     */
    public void setMAX_AUTORES(int mAX_AUTORES) {
        MAX_AUTORES = mAX_AUTORES;
    }

    public String toString() {
        return this.tituloSubmissao +" "+ this.situacaoSubmissao +" "+ this.autoresSubmissao + " " + this.MAX_AUTORES;
    }

}