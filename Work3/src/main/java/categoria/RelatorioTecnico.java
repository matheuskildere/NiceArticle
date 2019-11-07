package categoria;

import Enumeracao.Situacao;
import classes.SubmissaoCientifica;

/**
 * RelatorioTecnico
 */
public class RelatorioTecnico extends SubmissaoCientifica {

    private String resumo;
    private String abstractt;
    private int ano;
    private int numeroDePaginas;

    private final int MAX_INSTITUICOES = 1;
    private final int MAX_PALAVRACHAVE = 4;

    public RelatorioTecnico(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[],
            String instituicao[], String palavraChave[], String resumo, String abstractt, int ano,
            int numeroDePaginas) {
        super(tituloSubmissao, situacaoSubmissao, autoresSubmissao, 4, instituicao, palavraChave);
        this.resumo = resumo;
        this.abstractt = abstractt;
        this.ano = ano;
        this.numeroDePaginas = numeroDePaginas;
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
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the numeroDePaginas
     */
    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    /**
     * @param numeroDePaginas the numeroDePaginas to set
     */
    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

}