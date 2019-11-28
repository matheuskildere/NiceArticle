package interfaceGrafica;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Enumeracao.Situacao;
import Enumeracao.TipoMonografia;
import Persistencia.Dados;
import categoria.Monografia;

/**
 * PanelResumo
 */
public class PanelMonografia extends PanelPrincipal{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel l_Orientador;
    private JLabel l_Curso;
    private JLabel l_Ano;
    private JLabel l_NumeroPaginas;

    protected String [] vetor_Autores= new String[1];
    protected String [] vetor_Instituicoes= new String[1];
    protected String [] vetor_PalavrasC= new String[4];

    @Override
    protected void labelsAndFields(){
        settingsLabels(l_Titulo, "Título",1);
        settingsTxt(j_Titulo, 1);
        settingsLabels(l_Autores, "Autores",1);
        settingsTxt(j_Autores, 1);
        settingsLabels(l_Instituicoeseld, "Instituições",1);
        settingsTxt(j_Instituicoes, 1);
        settingsLabels(l_PalavrasC, "Palavras Chaves",1);
        settingsTxt(j_PalavrasC, 2);
        settingsLabels(l_Orientador, "Orientador",1);
        settingsTxt(j_Orientador, 1);
        settingsLabels(l_NumeroPaginas, "Nº de Páginas",2);
        settingsTxt(j_NumeroPaginas, 4);    
        settingsLabels(l_Ano, "Ano",3);
        settingsTxt(j_Ano, 5);
        settingsLabels(l_Curso, "Curso",2);
        settingsTxt(j_Curso, 3);
        settingsLabels(l_Resumo, "Resumo",2);
        settingsTxtArea(j_Resumo,1);
        settingsLabels(l_Abstract, "Abstract",2);
        settingsTxtArea(j_Abstract,2);
    }
    @Override
    protected void settingsTxt(JTextField j_, int tipo) {
        if (tipo == 3) {
            if(implementaJtextField >= 160){
                implementaJtextField = 81;
            }
            j_.setBounds(750, 63 + implementaJtextField, 478, 35);
        }
        if (tipo == 4) {
            if(implementaJtextField >= 260){
                implementaJtextField = 0;
            }
            j_.setBounds(750, 63 + implementaJtextField, 200, 35);
        }
        if (tipo == 5) {
            j_.setBounds(1028, implementaJtextField - 18, 200, 35);
            implementaJtextField = 81;
        }
        super.settingsTxt(j_, tipo);
    }

    protected void buttonsAdd(){
        b_addPalavrasC = new JButton("add");
        settingsButtons(b_addPalavrasC,1);
        b_addPalavrasC.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                boolean conseguiu = false;
                boolean avisou = false;
                for (int i = 0; i < vetor_PalavrasC.length; i++) {
                    if (vetor_PalavrasC[i] == null && !conseguiu) {
                        vetor_PalavrasC[i] = j_PalavrasC.getText();
                        conseguiu = true;
                    } else if(vetor_PalavrasC[vetor_PalavrasC.length -1] != null && !avisou){
                        JOptionPane.showMessageDialog(null, "Você atingiu o número máximo de Palavras Chaves (8)!");
                        avisou = true;
                    }
                }
            } 
        });
        b_submeter = new JButton("Submeter");
        settingsButtons(b_submeter, 2);
        b_submeter.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                try {
                    if (j_Titulo.getText().equals("")){
                        throw new IllegalArgumentException("Seu trabalho necessita de um Título");
                    }else if (j_Autores.getText().equals("")){
                        throw new IllegalArgumentException("Sua monografia necessita de um autor");
                    }else if (j_Instituicoes.getText().equals("")){
                        throw new IllegalArgumentException("Sua monografia necessita de um instituicao");
                    }else if (vetor_PalavrasC[0] == null){
                        throw new IllegalArgumentException("Coloque ao menos uma palavra chave relacionada a sua monografia"); 
                    }else if (j_Orientador.getText().equals("")){
                        throw new IllegalArgumentException("Sua monografia necessita de um orientador");
                    }else if (j_NumeroPaginas.getText().equals("")){
                        throw new IllegalArgumentException("Qual o numero de paginas da sua monografia?");
                    }else if (j_Curso.getText().equals("")){
                        throw new IllegalArgumentException("Qual o curso referente ao seu trabalho?");
                    }else {
                        TipoMonografia[] options2 = {TipoMonografia.MONOGRAFIA_CIENTIFICA,TipoMonografia.MONOGRAFIA_DE_COMPILACAO,TipoMonografia.MONOGRAFIA_DE_PESQUISA_DE_CAMPO};
                        int y = JOptionPane.showOptionDialog(null, "Tipo da Monografia", "Informe", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, options2, null);
                        Situacao[] options = {Situacao.APROVADO,Situacao.SOB_AVALIACAO,Situacao.REPROVADO};
                        int x = JOptionPane.showOptionDialog(null, "Situação da Submissão", "Informe", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, options, null);
                        vetor_Autores[0] = j_Autores.getText();
                        vetor_Instituicoes[0] = j_Instituicoes.getText();
                        int ano =  Integer.parseInt(j_Ano.getText()); 
                        int numeroPaginas = Integer.parseInt(j_NumeroPaginas.getText());
                        submissao = new Monografia(j_Titulo.getText(), options[x], vetor_Autores, vetor_Instituicoes, vetor_PalavrasC, options2[y],j_Orientador.getText(), j_Curso.getText(),ano, numeroPaginas, j_Resumo.getText(), j_Abstract.getText());
                        listaSubmissao.incluir(submissao);
                        persistenciaCSV = new Dados(submissao, "Monografia");
                        clearAllText();
                    }
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } 
        });
    }
    
    protected void settingsButtons(JButton b_add, int tipo){
        if (tipo == 1) {
            if (implementaJtextField > 260) {
                implementaJtextField = 0;
            }
            b_add.setBounds(532 ,142+ implementaJtextField, 60, 35);
            b_add.setFont(new Font("Muli", 4, 10));
        }else if (tipo == 2){
            b_add.setBounds(1120 ,200+implementaJtextField, 110, 35);
            b_add.setFont(new Font("Muli", 4, 15));
        }
        b_add.setFocusPainted(false);
        b_add.setBorderPainted(false);
        b_add.setBackground(cor.branco());
        add(b_add);
        implementaJtextField += 80;
    }
    protected void settingsLabels(JLabel l_, String nome, int tipo){ 
        l_ = new JLabel(nome);
        if (tipo == 1) {
            l_.setBounds(114, 33 + implementaJlabels, 250, 30);
        }else if (tipo == 2) {
            if (implementaJlabels > 320) {
                implementaJlabels = 0;
            }
            l_.setBounds(750, 33 + implementaJlabels, 250, 30);
            //implementaJlabels += 81;
        }else if (tipo == 4) {
            l_.setBounds(750, 33 + implementaJlabels, 250, 30);
        }else if (tipo == 3) {
            l_.setBounds(1028,implementaJlabels - 45, 250, 30);
            implementaJlabels -=81;
        }        
        l_.setFont(new Font("Muli", 4, 23));
        l_.setForeground(cor.branco());
        add(l_);
        implementaJlabels += 81;
    }

    protected void settingsTxtArea(JTextArea j_, int tipo){
        if(implementaJtextField > 160){
            implementaJtextField = 0;
        }
        if (tipo ==1) {
            j_.setBounds(750, 223 + implementaJtextField, 478, 35);
        }else if (tipo == 2) {
            j_.setBounds(750, 223 + implementaJtextField, 478, 115);
        }
        j_.setFont(new Font("Muli", Font.PLAIN, 19));
        j_.setBorder(null);
        j_.setLineWrap(true);
        j_.setWrapStyleWord(true);
        add(j_);
        implementaJtextField += 81;
    }
    
}