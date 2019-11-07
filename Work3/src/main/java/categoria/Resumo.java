package categoria;

import Enumeracao.Situacao;
import classes.SubmissaoCientifica;

/**
 * Resumo
 */
public class Resumo extends SubmissaoCientifica {

    private final int MAX_INSTITUICOES = 8;
    private final int MAX_PALAVRACHAVE = 4;

    public Resumo(String tituloSubmissao, Situacao situacaoSubmissao, String autoresSubmissao[], String instituicao[],
            String palavraChave[]) {
        super(tituloSubmissao, situacaoSubmissao, autoresSubmissao, 8, instituicao, palavraChave);
    }

}