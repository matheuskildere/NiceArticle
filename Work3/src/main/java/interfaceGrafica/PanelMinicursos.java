package interfaceGrafica;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * PanelResumo
 */
public class PanelMinicursos extends PanelPrincipal{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected String [] vetor_Autores= new String[3];
    private JLabel l_Duracao;
    private JLabel l_Metodologia;

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
        b_submeter = new JButton("Submeter");
        settingsButtons(b_submeter, 2);
        b_submeter.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                try {
                    if (j_Titulo.getText().equals("")){
                        throw new IllegalArgumentException("Seu trabalho necessita de um Título");
                    }else if (vetor_Autores[0] == null) {
                        throw new IllegalArgumentException("É necessário informar ao menos um autor"); 
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


    @Override
    protected void labelsAndFields(){
        settingsLabels(l_Titulo, "Título",1);
        settingsTxt(j_Titulo, 1);
        settingsLabels(l_Autores, "Autores",1);
        settingsTxt(j_Autores, 2);
        settingsLabels(l_Duracao, "Duração",1);
        settingsTxt(j_Duracao, 1);
        settingsLabels(l_Metodologia, "Metodologia",1);
        settingsTxt(j_Metodologia, 1);
        settingsLabels(l_Resumo, "Resumo",2);
        settingsTxtArea(j_Resumo);
        settingsLabels(l_Abstract, "Abstract",2);
        settingsTxtArea(j_Abstract,1);
        
    }

    protected void settingsTxtArea(JTextArea j_, int tipo){
        if (tipo == 1) {
            if(implementaJtextField > 320){
                implementaJtextField = 0;
            }
            j_.setBounds(750, 63 + implementaJtextField, 478, 115);
            
            implementaJtextField += 160;
        }
        if (tipo == 2) {
            j_.setBounds(114, 63 + implementaJtextField, 478, 115);
            
            implementaJtextField += 160;
        }
        j_.setFont(new Font("Muli", Font.PLAIN, 19));
        j_.setBorder(null);
        j_.setLineWrap(true);
        j_.setWrapStyleWord(true);
        add(j_);
    }

    protected void settingsButtons(JButton b_add, int tipo){
        if (tipo == 1) {
            if (implementaJtextField >= 160) {
                implementaJtextField = 0;
            }
            b_add.setBounds(532 ,143 +implementaJtextField, 60, 35);
            b_add.setFont(new Font("Muli", 4, 10));
        } else if (tipo == 2){
            b_add.setBounds(1120 ,283 +implementaJtextField, 110, 35);
            b_add.setFont(new Font("Muli", 4, 15));
        }
        b_add.setFocusPainted(false);
        b_add.setBorderPainted(false);
        b_add.setBackground(cor.branco());
        add(b_add);
        implementaJtextField += 80;
    }

}