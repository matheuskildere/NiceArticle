package classes;

import Enumeracao.Situacao;

/**
 * SubmissaoApresentacao
 */
public abstract class SubmissaoApresentacao extends Submissao {

    protected String resumo;
    protected String abstractt;
    protected int duracao;

    public SubmissaoApresentacao(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[],
            int MAX_AUTORES, String resumo, String abstractt, int duracao) {
        super(tituloSubmissao, situacaoSubmissao, autoresSubmissao, MAX_AUTORES);
        this.resumo = resumo;
        this.abstractt = abstractt;
        this.duracao = duracao;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the abstractt
     */
    public String getAbstractt() {
        return abstractt;
    }

    /**
     * @param abstractt the abstractt to set
     */
    public void setAbstractt(String abstractt) {
        this.abstractt = abstractt;
    }

    /**
     * @return the duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String toString() {
        return this.resumo + " " + this.abstractt + " " + this.duracao;
    }

}