package interfaceGrafica;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
        settingsLabels(l_Orientador, "Orientador",2);
        settingsTxt(j_Orientador, 3);
        settingsLabels(l_NumeroPaginas, "Numero de Páginas",2);
        settingsTxt(j_NumeroPaginas, 3);    
        settingsLabels(l_Curso, "Curso",2);
        settingsTxt(j_Curso, 3);
        settingsLabels(l_Ano, "Ano",2);
        settingsTxt(j_Ano, 3);
    }
    @Override
    protected void settingsTxt(JTextField j_, int tipo) {
        if (tipo == 3) {
            if(implementaJtextField >= 260){
                implementaJtextField = 0;
            }
            j_.setBounds(750, 63 + implementaJtextField, 478, 35);
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
                    }else if (vetor_Autores[0] == null) {
                        throw new IllegalArgumentException("É necessário informar ao menos um autor"); 
                    }else if(vetor_Instituicoes[0] == null){
                        throw new IllegalArgumentException("É necessário informar uma instituição ligada ao trabalho"); 
                    }else if (vetor_PalavrasC[0] == null){
                        throw new IllegalArgumentException("Coloque ao menos uma palavra chave relacionada ao seu trabalho"); 
                    }else if (j_Resumo.getText().equals("")){
                        throw new IllegalArgumentException("Seu trabalho necessita de um Resumo");
                    }else if (j_Abstract.getText().equals("")){
                        throw new IllegalArgumentException("Your work needs an Abstract");
                    }else {
                        //submissao = new Artigo(j_Titulo.getText(), Situacao.APROVADO, vetor_Autores, vetor_Instituicoes, vetor_PalavrasC, j_Resumo.getText(), j_Abstract.getText());
                        //listaSubmissao.incluir(submissao);
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
            b_add.setBounds(532 ,303 +implementaJtextField, 60, 35);
            b_add.setFont(new Font("Muli", 4, 10));
        }else if (tipo == 2){
            b_add.setBounds(1120 ,283 +implementaJtextField, 110, 35);
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
        }
        l_.setFont(new Font("Muli", 4, 23));
        l_.setForeground(cor.branco());
        add(l_);
        implementaJlabels += 81;
    }
}