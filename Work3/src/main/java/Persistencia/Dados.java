package Persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import classes.Submissao;

/**
 * Dados
 */
public class Dados {

    private FileWriter writer;
    private String diretorio;

    public Dados(Submissao sub,String tipo) {
        diretorio = "./Arquivos/" + tipo + ".csv";
        
        if (!verificaExistencia()) {
            System.out.println("qq");
            configuracaoInicial();
            criaArquivo(tipo);
            insereLinha(sub);
        } else {
            configuracaoInicial();
            insereLinha(sub);
            System.out.println("sla");
        }
        configuracaoFinal();        
    }

    private boolean verificaExistencia(){
        File testaFile = new File(diretorio);
        System.out.println(testaFile.exists());
        return testaFile.exists();
    }

    private void configuracaoInicial() {
        try {
            writer = new FileWriter(diretorio, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void insereLinha(Submissao sub){
        String autores = "";
        for(String autor: sub.getAutoresSubmissao()){
            autores += autor +"\n";
        }

        try {
            writer.append("\n"+sub.getTituloSubmissao()+";"+sub.getSituacaoSubmissao()+";"+autores+";");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void configuracaoFinal(){
        
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void criaArquivo(String tipo) {

        try {
            if (tipo == "Artigo") {
                System.out.println("oi");
                writer.write("Titulo;Situacao;Autor;Instituicao;Palavra-chave;Resumo;Abstract");
                //writer.append("maks");
            } else if (tipo == "Resumo") {
                writer.write("Titulo;Situacao;Autor;Instituicao;Palavra-chave");
            } else if (tipo == "Palestra") {
                writer.write("Titulo;Situacao;Palavra-chave;Resumo;Abstract;Duracao;Curriculo");
            } else if (tipo == "Minicurso") {
                writer.write("Titulo;Situacao;Autor;Resumo;Abstract;Duracao;Recursos;Metodologia");
            } else if (tipo == "Monografia") {
                writer.write("Titulo;Situacao;Tipo;Autor;Instituicao;Orientador;Curso;Ano;Numero de Paginas;Palavra-chave;Resumo;Abstract");
            } else if (tipo == "RelatorioTecnico") {
                writer.write("Titulo;Situacao;Autor;Instituicao;Palavra-chave;Resumo;Abstract;Ano;Numero de Paginas");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}