package categoria;

import Enumeracao.Situacao;
import classes.SubmissaoApresentacao;

/**
 * Palestra
 */
public class Palestra extends SubmissaoApresentacao {

    private String curriculo;

    public Palestra(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[], String resumo,
            String abstractt, int duracao, String curriculo) {
        super(tituloSubmissao, situacaoSubmissao, autoresSubmissao, 1, resumo, abstractt, duracao);
        this.curriculo = curriculo;
    }

    /**
     * @return the curriculo
     */
    public String getCurriculo() {
        return curriculo;
    }

    /**
     * @param curriculo the curriculo to set
     */
    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

}