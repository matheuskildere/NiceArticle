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
public class PanelRelatorioTecnico extends PanelPrincipal{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JLabel l_Ano;
    
    protected JLabel l_NumeroPaginas;

    protected String [] vetor_Autores= new String[3];
    protected String [] vetor_PalavrasC= new String[4];

    @Override
    protected void labelsAndFields(){
        settingsLabels(l_Titulo, "Título",1);
        settingsTxt(j_Titulo, 1);
        settingsLabels(l_Autores, "Autores",1);
        settingsTxt(j_Autores, 2);
        settingsLabels(l_Instituicoeseld, "Instituição",1);
        settingsTxt(j_Instituicoes, 1);
        settingsLabels(l_PalavrasC, "Palavras Chaves",1);
        settingsTxt(j_PalavrasC, 2);
        settingsLabels(l_Ano, "Ano",1);
        settingsTxt(j_Ano, 1);
        settingsLabels(l_Resumo, "Resumo",2);
        settingsTxtArea(j_Resumo);
        settingsLabels(l_Abstract, "Abstract",2);
        settingsTxtArea(j_Abstract);
        settingsLabels(l_NumeroPaginas, "Numero de Páginas",3);
        settingsTxt(j_NumeroPaginas, 3);
    }
    @Override
    protected void settingsTxt(JTextField j_, int tipo) {
        if (tipo == 3) {
            j_.setBounds(750, 63 + implementaJtextField, 478, 35);
        }
        super.settingsTxt(j_, tipo);
    }

    protected void buttonsAdd(){
        b_addAutores = new JButton("add");
        settingsButtons(b_addAutores,1);
        b_addAutores.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                boolean conseguiu = false;
                boolean avisou = false;
                for (int i = 0; i < vetor_Autores.length; i++) {
                    if (vetor_Autores[i] == null && !conseguiu) {
                        vetor_Autores[i] = j_Autores.getText();
                        conseguiu = true;
                    } else if(vetor_Autores[vetor_Autores.length -1] != null && !avisou){
                        JOptionPane.showMessageDialog(null, "Você atingiu o número máximo de autores (8)!");
                        avisou = true;
                    }
                }
            } 
        });
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
            if (implementaJtextField > 360) {
                implementaJtextField = 0;
            }
            b_add.setBounds(532 ,143 +implementaJtextField, 60, 35);
            b_add.setFont(new Font("Muli", 4, 10));
            implementaJtextField += 80;
        }else if (tipo == 2){
            if (implementaJtextField > 160) {
                implementaJtextField = 80;
            }
            b_add.setBounds(1120 ,363 +implementaJtextField, 110, 35);
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
            if (implementaJlabels > 162) {
                implementaJlabels = 0;
            }
            l_.setBounds(750, 33 + implementaJlabels, 250, 30);
            implementaJlabels += 81;
        }else if (tipo == 3) {
            l_.setBounds(750, 33 + implementaJlabels, 250, 30);
        }
        l_.setFont(new Font("Muli", 4, 23));
        l_.setForeground(cor.branco());
        add(l_);
        implementaJlabels += 81;
    }
}