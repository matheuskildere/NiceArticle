package classes;

import java.util.ArrayList;
import java.util.List;

import Enumeracao.Situacao;
import categoria.Artigo;
import categoria.Minicurso;
import categoria.Monografia;
import categoria.Palestra;
import categoria.RelatorioTecnico;
import categoria.Resumo;
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

    public ArrayList<Submissao> getLista() {
        ArrayList<Submissao> submissoes = new ArrayList<>();
        
        for (Submissao submissao : listaSubmi) {
               submissoes.add(submissao);
        }

        return submissoes;
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
            String autores[] = submissao.getAutoresSubmissao();
            for (int i = 0; i < autores.length; i++) {
                if (autores[i].equals(autor)) {
                    submissoesAutor.add(submissao);    
                }
            } 
        }

        return submissoesAutor;
    }

    
    public List<Submissao> consultarCategoria(String categoriaName) {
        List<Submissao> submissoesCategoria = new ArrayList<>();

        for (Submissao submissao : listaSubmi) {
            if (submissao.getClass().getSimpleName().equals(categoriaName)){
               submissoesCategoria.add(submissao);
            }
        }

        return submissoesCategoria;
    }

    public List<Submissao> consultarSituacao(Situacao situacao) {
        List<Submissao> submissoesSituacao = new ArrayList<>();
        
        for (Submissao submissao : listaSubmi) {
            if (submissao.getSituacaoSubmissao().equals(situacao)){
               submissoesSituacao.add(submissao);
            }
        }

        return submissoesSituacao;
    }

    public List<Submissao> consultaSituCat(String categoriaName, Situacao situacao) {
        List<Submissao> submissoesSituCat = new ArrayList<>();
        
        for (Submissao submissaoSitu : consultarSituacao(situacao)) {
            for (Submissao submissaoCat : consultarCategoria(categoriaName)) {
                if (submissaoSitu.equals(submissaoCat)) {
                    submissoesSituCat.add(submissaoCat);
                }
            }
        }

        return submissoesSituCat;
    }



    @Override
    public boolean excluir(String titulo) {
        for (Submissao submissao : listaSubmi) {
            if (submissao.getTituloSubmissao().equals(titulo)) {
                listaSubmi.remove(submissao);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String lista= "";
        for (Submissao submissao : listaSubmi) {
            lista += submissao.tituloSubmissao+ "\n";
        }
        return lista;
    }
}