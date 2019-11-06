package interfaces;

import java.util.List;

import classes.Submissao;


/**
 * Interface que especifica a assinatura os m�todos que devem ser implementados para manipular um conjunto de submissoes. 
 * @author Aline
 */
public interface ISubmissoes {
    
    /**
     * Inclui uma submiss�o a lista de submiss�es.
     * @param submissao Submiss�o a ser inclu�da.
     * @return True se a inclus�o foi bem sucedida ou False em caso contr�rio. 
     */
    public boolean incluir(Submissao submissalistao);
    
    /**
     * Consulta a submiss�o com o t�tulo informado.
     * @param titulo T�tulo a ser consultado.
     * @return Submiss�o com o t�tulo informado ou null em caso de n�o existir submiss�o com o t�tulo informado. 
     */
    public Submissao consultarTitulo(String titulo);
    
    /**
     * Consulta a lista de submiss�es com o autor informado.
     * @param autor Autor a ser consultado.
     * @return Lista de submiss�es do autor informado. 
     */
    public List<Submissao> consultarAutor(String autor);
    
	/**
     * Exclui a submiss�o com o t�tulo informado.
     * @param titulo T�tulo da submiss�o a ser exclu�da.
     * @return True se a submiss�o com o t�tulo informado 
	 * for exclu�da e False caso nenhuma submiss�o com o 
	 * t�tulo infornado for encontrada.
     */
    public boolean excluir(String titulo);
}
