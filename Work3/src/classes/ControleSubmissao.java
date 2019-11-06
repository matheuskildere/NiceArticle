package classes;

import java.util.ArrayList;
import java.util.List;

import interfaces.ISubmissoes;

/**
 * SubmissionController
 */
public class ControleSubmissao implements ISubmissoes {
    private ArrayList<Submissao> listaSubmi = new ArrayList<>();

    @Override
    public boolean incluir(Submissao submission) {
        if (!listaSubmi.add(submission)) {
            return false;
        } else{
            return true;
        }
    }

    @Override
    public Submissao consultarTitulo(String titulo) {
        for (Submissao submission : listaSubmi) {
            //if (submission.getTitle().equals(titulo)) {
            //    return submission;
            //}
        }
        return null;
    }

    @Override
    public List<Submissao> consultarAutor(String autor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean excluir(String titulo) {
        // TODO Auto-generated method stub
        return false;
    }

    
}