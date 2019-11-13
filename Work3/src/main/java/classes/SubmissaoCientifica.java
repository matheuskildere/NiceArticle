package classes;

import Enumeracao.Situacao;

/**
 * SubmissaoCientifica
 */
public abstract class SubmissaoCientifica extends Submissao {
    protected String instituicao[];
    protected String palavraChave[];

    public SubmissaoCientifica(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[],
            int MAX_AUTORES, String instituicao[], String palavraChave[]) {
        super(tituloSubmissao, situacaoSubmissao, autoresSubmissao, MAX_AUTORES);
        this.instituicao = instituicao;
        this.palavraChave = palavraChave;
    }

    /**
     * @return the instituicao
     */
    public String[] getInstituicao() {
        return instituicao;
    }   

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String[] instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @return the palavraChave
     */
    public String[] getPalavraChave() {
        return palavraChave;
    }

    /**
     * @param palavraChave the palavraChave to set
     */
    public void setPalavraChave(String[] palavraChave) {
        this.palavraChave = palavraChave;
    }

    public String toString() {
        return this.instituicao + " " + this.palavraChave;
    }

}