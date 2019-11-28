package categoria;

import Enumeracao.Situacao;
import classes.SubmissaoApresentacao;

/**
 * Minicurso
 */
public class Minicurso extends SubmissaoApresentacao {

    private String recursos;
    private String metodologia;

    public Minicurso(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[], String resumo,
            String abstractt, int duracao, String recursos, String metodologia) {
        super(tituloSubmissao, situacaoSubmissao, autoresSubmissao, 3, resumo, abstractt, duracao);
        this.recursos = recursos;
        this.metodologia = metodologia;
    }

    /**
     * @return the recursos
     */
    public String getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    /**
     * @return the metodologia
     */
    public String getMetodologia() {
        return metodologia;
    }

    /**
     * @param metodologia the metodologia to set
     */
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }
}