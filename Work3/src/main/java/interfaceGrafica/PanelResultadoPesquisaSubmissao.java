package interfaceGrafica;

import java.awt.*;

import java.awt.Font;
import javax.swing.*;

/**
 * PanelInicial
 */
public class PanelResultadoPesquisaSubmissao extends PanelPrincipal {

private JLabel lAll;
    
    private JLabel lTitulo;
    private JLabel lAutor;
    private JLabel lSituacao;

    private JButton bEditar;
    private JButton bExcluir;

    private JLabel init_Titulo;
    private JLabel init_Autor;
    private JLabel init_Categoria;
    private int lab = 0;

   
 
    private static final long serialVersionUID = 1L;

    public PanelResultadoPesquisaSubmissao() {
        removeAll();

        setBounds(0, 175, 1366, 800);
        lAll = new JLabel("  Resultado da pesquisa: Inteligência Artificial");
        lAll.setBounds(50, 10, 450, 60);
        lAll.setFont(new Font("Muli", Font.PLAIN, 20));
        lAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/search1.png")));
        lAll.setForeground(cor.branco());
        add(lAll);

        l_Titulo = new JLabel(" Titulo");
        l_Titulo.setBounds(50, 100, 200, 60);
        l_Titulo.setFont(new Font("Muli", Font.PLAIN, 23));
        l_Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/folder.png")));
        l_Titulo.setForeground(cor.branco());
        add(l_Titulo);

        l_Titulo = new JLabel("Inteligência Artificial");
        l_Titulo.setBounds(50, 170, 400, 30);
        l_Titulo.setFont(new Font("Muli", 4, 20));
        l_Titulo.setForeground(cor.branco());
        add(l_Titulo);

        l_Categoria = new JLabel(" Categoria");
        l_Categoria.setBounds(500, 100, 200, 60);
        l_Categoria.setFont(new Font("Muli", Font.PLAIN, 23));
        l_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/user.png")));
        l_Categoria.setForeground(cor.branco());
        add(l_Categoria);

        lSituacao = new JLabel(" Situação");
        lSituacao.setBounds(1000, 100, 200, 60);
        lSituacao.setFont(new Font("Muli", Font.PLAIN, 23));
        lSituacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/situation.png")));
        lSituacao.setForeground(cor.branco());
        add(lSituacao);

        l_Autores = new JLabel(" Autor(es)");
        l_Autores.setBounds(50, 260, 200, 60);
        l_Autores.setFont(new Font("Muli", Font.PLAIN, 23));
        l_Autores.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/user.png")));
        l_Autores.setForeground(cor.branco());
        add(l_Autores);

        l_Autores = new JLabel ("Matheus Kildere");
        l_Autores.setBounds(50, 330, 400, 30);
        l_Autores.setFont(new Font("Muli", 4, 20));
        l_Autores.setForeground(cor.branco());
        add(l_Autores);

        l_Instituicoeseld = new JLabel(" Instituição");
        l_Instituicoeseld.setBounds(500, 260, 200, 60);
        l_Instituicoeseld.setFont(new Font("Muli", Font.PLAIN, 23));
        l_Instituicoeseld.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/user.png")));
        l_Instituicoeseld.setForeground(cor.branco());
        add(l_Instituicoeseld);

        l_Instituicoeseld = new JLabel ("Universidade Federal do Pampa");
        l_Instituicoeseld.setBounds(500, 330, 400, 30);
        l_Instituicoeseld.setFont(new Font("Muli", 4, 20));
        l_Instituicoeseld.setForeground(cor.branco());
        add(l_Instituicoeseld);

        l_PalavrasC = new JLabel(" Palavras-chave");
        l_PalavrasC.setBounds(1000, 260, 200, 60);
        l_PalavrasC.setFont(new Font("Muli", Font.PLAIN, 23));
        l_PalavrasC.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/user.png")));
        l_PalavrasC.setForeground(cor.branco());
        add(l_PalavrasC);

        l_PalavrasC = new JLabel ("IA, Alexa, Cortana, Google Assistant");
        l_PalavrasC.setBounds(1000, 330, 400, 30);
        l_PalavrasC.setFont(new Font("Muli", 4, 20));
        l_PalavrasC.setForeground(cor.branco());
        add(l_PalavrasC);

        l_Resumo = new JLabel(" Resumo");
        l_Resumo.setBounds(50, 500, 200, 60);
        l_Resumo.setFont(new Font("Muli", Font.PLAIN, 23));
        l_Resumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/user.png")));
        l_Resumo.setForeground(cor.branco());
        add(l_Resumo);

        l_Resumo = new JLabel ("Matheus Kildere");
        l_Resumo.setBounds(50, 570, 400, 30);
        l_Resumo.setFont(new Font("Muli", 4, 20));
        l_Resumo.setForeground(cor.branco());
        add(l_Resumo);

        l_Abstract = new JLabel(" Abstract");
        l_Abstract.setBounds(500, 500, 200, 60);
        l_Abstract.setFont(new Font("Muli", Font.PLAIN, 23));
        l_Abstract.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/user.png")));
        l_Abstract.setForeground(cor.branco());
        add(l_Abstract);

        l_Abstract = new JLabel ("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        l_Abstract.setBounds(500, 570, 400, 30);
        l_Abstract.setFont(new Font("Muli", 4, 20));
        l_Abstract.setForeground(cor.branco());
        add(l_Abstract);

        
        bEditar = new JButton("  |");
        bEditar.setBounds(1215,20,80,40);
        bEditar.setFont(new Font("Muli", Font.PLAIN, 26));
        bEditar.setForeground(cor.branco());
        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/edit.png")));
        bEditar.setBorderPainted(false);
        bEditar.setFocusPainted(false);
        add(bEditar);
        
        bExcluir = new JButton("");
        bExcluir.setBounds(1290,20,40,40);
        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/garbage.png")));
        bExcluir.setBorderPainted(false);
        bExcluir.setBorderPainted(false);
        add(bExcluir);




        labelsAndFields();
    }

    private void jComboBox() {
     /*
        comboBox = new JComboBox<>();
        comboBox.setBounds(50, 450, 100, 100);
        comboBox.setFont(new Font("Muli", Font.PLAIN, 19));
        comboBox.setBorder(null);
        add(comboBox);

        */
    }

    @Override
    protected void labelsAndFields() {

        settingsLabels(init_Autor, "Artigo", 2);
        settingsLabels(init_Categoria, "Aprovado", 3);

      
    }

    @Override
    protected void settingsLabels(JLabel l_, String nome, int tipo) {
        l_ = new JLabel(nome);
        l_.setFont(new Font("Muli", 4, 20));
        l_.setForeground(cor.branco());
        if (tipo == 1) {
            l_.setBounds(50, lab + 170, 400, 30);
        } else if (tipo == 2) {
            l_.setBounds(500, lab + 170, 400, 30);
        } else if (tipo == 3) {
            l_.setBounds(1000, 170 + lab, 400, 30);
            lab += 50;
        }
        add(l_);
    }

}