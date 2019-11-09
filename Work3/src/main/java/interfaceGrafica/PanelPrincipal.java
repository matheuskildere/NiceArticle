package interfaceGrafica;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Color.Colors;
import Enumeracao.Situacao;
import categoria.Artigo;
import classes.Submissao;
import classes.SubmissionController;

/**
 * PanelPrincipal
 */
public class PanelPrincipal extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int implementaJtextField = 0;
    private int implementaJlabels = 0;
    protected JPanel panel = new JPanel();
    private Colors cor = new Colors();
    
    protected JTextField j_Titulo = new JTextField();
    protected JTextField j_Autores = new JTextField();
    protected JTextField j_Instituicoes = new JTextField();
    protected JTextField j_PalavrasC = new JTextField();
    protected JTextArea j_Resumo = new JTextArea();
    protected JTextArea j_Abstract = new JTextArea();

    protected JButton b_addAutores;
    protected JButton b_addInstituicoes;
    protected JButton b_addPalavrasC;
    protected JButton b_submeter;
    
    protected JLabel l_Titulo;
    protected JLabel l_Autores;
    protected JLabel l_Instituicoeseld;
    protected JLabel l_PalavrasC;
    protected JLabel l_Resumo;
    protected JLabel l_Abstract;

    protected SubmissionController listaSubmissao = new SubmissionController();
    private Submissao submissao;
    protected String [] vetor_Autores= new String[8];
    protected String [] vetor_Instituicoes= new String[8];
    protected String [] vetor_PalavrasC= new String[4];

    public PanelPrincipal(){
        configuraPanel();
        labelsAndFields();
        buttonsAdd();
    }

    private void configuraPanel(){
        setBounds(131, 175, 1100, 420);
        setBackground(cor.preto_Claro());
        getComponentPopupMenu();
        setLayout(null);
        setVisible(true);
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
        b_addInstituicoes = new JButton("add");
        settingsButtons(b_addInstituicoes,1);
        b_addInstituicoes.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent event) {
                boolean conseguiu = false;
                boolean avisou = false;
                for (int i = 0; i < vetor_Instituicoes.length; i++) {
                    if (vetor_Instituicoes[i] == null && !conseguiu) {
                        vetor_Instituicoes[i] = j_Instituicoes.getText();
                        conseguiu = true;
                    } else if(vetor_Instituicoes[vetor_Instituicoes.length -1] != null && !avisou){
                        JOptionPane.showMessageDialog(null, "Você atingiu o número máximo de instituições (8)!");
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
                    if (vetor_Autores == null) {
                        throw new IllegalArgumentException("Adicione ao menos um autor ao artigo"); 
                    }
                    if (vetor_Instituicoes == null) {
                        throw new IllegalArgumentException("Adicione ao menos uma instituição ao artigo"); 
                    }if (vetor_PalavrasC == null) {
                        throw new IllegalArgumentException("Adicione ao menos uma palavra chave ao artigo"); 
                    }
                    submissao = new Artigo(j_Titulo.getText(), Situacao.APROVADO, vetor_Autores, vetor_Instituicoes, vetor_PalavrasC, j_Resumo.getText(), j_Abstract.getText());
                    listaSubmissao.incluir(submissao);
                } catch (Exception e) {
                    
                }
            } 
        });
    }

    protected void labelsAndFields(){
        settingsLabels(l_Titulo, "Título",1);
        settingsTxt(j_Titulo, 1);
        settingsLabels(l_Autores, "Autores",1);
        settingsTxt(j_Autores, 2);
        settingsLabels(l_Instituicoeseld, "Instituições",1);
        settingsTxt(j_Instituicoes, 2);
        settingsLabels(l_PalavrasC, "Palavras Chaves",1);
        settingsTxt(j_PalavrasC, 2);
        settingsLabels(l_Resumo, "Resumo",2);
        settingsTxtArea(j_Resumo);
        settingsLabels(l_Abstract, "Abstract",2);
        settingsTxtArea(j_Abstract);
    }

    protected void settingsButtons(JButton b_add, int tipo){
        if (tipo == 1) {
            if (implementaJtextField > 240) {
                implementaJtextField = 0;
            }
            b_add.setBounds(470 ,143 +implementaJtextField, 60, 35);
            b_add.setFont(new Font("Muli", 4, 10));
        } else if (tipo == 2){
            b_add.setBounds(935 ,123 +implementaJtextField, 110, 35);
            b_add.setFont(new Font("Muli", 4, 15));
        }
        b_add.setFocusPainted(false);
        b_add.setBorderPainted(false);
        b_add.setBackground(cor.branco());
        add(b_add);
        implementaJtextField += 80;
    }

    /**
     * Metodo para configurar os JTextfields
     * @param txt
     */
    protected void settingsTxt(JTextField j_, int tipo){
        if (tipo == 1) {
            j_.setBounds(54, 63 + implementaJtextField, 478, 35);
        }else if (tipo == 2) {
            j_.setBounds(54, 63 + implementaJtextField, 412, 35);
        }
        j_.setFont(new Font("Muli", Font.PLAIN, 19));
        j_.setBorder(null);
        add(j_);
        implementaJtextField += 80;
    }

    protected void settingsTxtArea(JTextArea j_){
    if(implementaJtextField > 195){
        implementaJtextField = 0;
    }
    j_.setBounds(568, 63 + implementaJtextField, 478, 115);
    j_.setFont(new Font("Muli", Font.PLAIN, 19));
    j_.setBorder(null);
    j_.setLineWrap(true);
    j_.setWrapStyleWord(true);
    add(j_);
    implementaJtextField += 160;

    }

    /**
     * Metodo para configurar as JLabels
     * @param label
     * @param name
     * @param panel
     */
    protected void settingsLabels(JLabel l_, String nome, int tipo){ 
        l_ = new JLabel(nome);
        if (tipo == 1) {
            l_.setBounds(54, 33 + implementaJlabels, 250, 30);
        }else if (tipo == 2) {
            if (implementaJlabels > 162) {
                implementaJlabels = 0;
            }
            l_.setBounds(568, 33 + implementaJlabels, 250, 30);
            implementaJlabels += 81;
        }
        l_.setFont(new Font("Muli", 4, 23));
        l_.setForeground(cor.branco());
        add(l_);
        implementaJlabels += 81;
    }
}