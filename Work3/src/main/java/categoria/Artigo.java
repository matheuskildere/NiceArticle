package categoria;

import Enumeracao.Situacao;
import classes.SubmissaoCientifica;

/**
 * Artigo
 */
public class Artigo extends SubmissaoCientifica {

    private String resumo;
    private String abstractt;

    private final int MAX_INSTITUICOES = 8;
    private final int MAX_PALAVRACHAVE = 4;

    public Artigo(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[], String instituicao[],
            String palavraChave[], String resumo, String abstractt) {
        super(tituloSubmissao, situacaoSubmissao, autoresSubmissao, 8, instituicao, palavraChave);
        this.resumo = resumo;
        this.abstractt = abstractt;
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

    @Override
    public int getMAX_AUTORES() {
        // TODO Auto-generated method stub
        return super.getMAX_AUTORES();
    }

    /**
     * @return the mAX_INSTITUICOES
     */
    public int getMAX_INSTITUICOES() {
        return MAX_INSTITUICOES;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}