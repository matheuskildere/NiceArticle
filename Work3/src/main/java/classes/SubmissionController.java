package classes;

import java.util.ArrayList;
import java.util.List;

import interfaces.ISubmissoes;

/**
 * SubmissionController
 */
public class SubmissionController implements ISubmissoes {
    private ArrayList<Submissao> listaSubmi = new ArrayList<>();

    @Override
    public boolean incluir(Submissao submission) {
        return listaSubmi.add(submission);
    }

    @Override
    public Submissao consultarTitulo(String titulo) {
        for (Submissao submissao: listaSubmi) {
            if (submissao.getTituloSubmissao().equals(titulo)) {
                return submissao;
            }
        }
        return null;
    }

    @Override
    public List<Submissao> consultarAutor(String autor) {
        List<Submissao> submissoesAutor = new ArrayList<>();
        for (Submissao submissao : listaSubmi) {
            if (submissao.getAutor().equals(autor)) {
                submissoesAutor.add(submissao);
            }
        }
        return submissoesAutor;
    }

    @Override
    public boolean excluir(String titulo) {
        for (Submissao submissao : listaSubmi) {
            return listaSubmi.remove(summissao.getTituloSubmissao().equals(titulo));
        }
    }

    
}