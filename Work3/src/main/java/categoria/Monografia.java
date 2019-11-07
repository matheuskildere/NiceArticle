package categoria;

import Enumeracao.Situacao;
import Enumeracao.TipoMonografia;
import classes.SubmissaoCientifica;

/**
 * Monografia
 */
public class Monografia extends SubmissaoCientifica {

    private TipoMonografia tipo;
    private String orientador;
    private String curso;
    private int ano;
    private int numeroDePaginas;
    private String resumo;
    private String abstractt;

    private final int MAX_INSTITUICOES = 1;
    private final int MAX_PALAVRACHAVE = 4;

    public Monografia(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[],
            String instituicao[], String palavraChave[], TipoMonografia tipo, String orientador, String curso, int ano,
            int numeroDePaginas, String resumo, String abstractt) {
        super(tituloSubmissao, situacaoSubmissao, autoresSubmissao, 1,instituicao, palavraChave);
        this.tipo = tipo;
        this.orientador = orientador;
        this.curso = curso;
        this.ano = ano;
        this.numeroDePaginas = numeroDePaginas;
        this.resumo = resumo;
        this.abstractt = abstractt;
    }

    /**
     * @return the tipo
     */
    public TipoMonografia getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoMonografia tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the orientador
     */
    public String getOrientador() {
        return orientador;
    }

    /**
     * @param orientador the orientador to set
     */
    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
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

}