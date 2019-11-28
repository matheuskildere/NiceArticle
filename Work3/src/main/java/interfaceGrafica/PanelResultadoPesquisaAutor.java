package interfaceGrafica;

import java.awt.*;

import java.awt.Font;
import javax.swing.*;

/**
 * PanelInicial
 */
public class PanelResultadoPesquisaAutor extends PanelPrincipal {

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

    private String pesquisa;

    public PanelResultadoPesquisaAutor(String termo) {
        removeAll();

        pesquisa = termo;

        lAll = new JLabel("  Resultado da pesquisa: Matheus Kildere");
        lAll.setBounds(50, 30, 450, 60);
        lAll.setFont(new Font("Muli", Font.PLAIN, 20));
        lAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/search1.png")));
        lAll.setForeground(cor.branco());
        add(lAll);

        lTitulo = new JLabel(" Titulo");
        lTitulo.setBounds(50, 100, 200, 60);
        lTitulo.setFont(new Font("Muli", Font.PLAIN, 23));
        lTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/folder.png")));
        lTitulo.setForeground(cor.branco());
        add(lTitulo);

        lAutor = new JLabel(" Autor");
        lAutor.setBounds(500, 100, 200, 60);
        lAutor.setFont(new Font("Muli", Font.PLAIN, 23));
        lAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/user.png")));
        lAutor.setForeground(cor.branco());
        add(lAutor);

        lSituacao = new JLabel(" Situação");
        lSituacao.setBounds(950, 100, 200, 60);
        lSituacao.setFont(new Font("Muli", Font.PLAIN, 23));
        lSituacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/situation.png")));
        lSituacao.setForeground(cor.branco());
        add(lSituacao);

        bEditar = new JButton("  |");
        bEditar.setBounds(1215, 180, 80, 40);
        bEditar.setFont(new Font("Muli", Font.PLAIN, 26));
        bEditar.setForeground(cor.branco());
        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/edit.png")));
        bEditar.setBorderPainted(false);
        bEditar.setFocusPainted(false);
        add(bEditar);

        bExcluir = new JButton("");
        bExcluir.setBounds(1290, 180, 40, 40);
        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/garbage.png")));
        bExcluir.setBorderPainted(false);
        bExcluir.setBorderPainted(false);
        add(bExcluir);

        labelsAndFields();
    }

    private void jComboBox() {
        /*
         * comboBox = new JComboBox<>(); comboBox.setBounds(50, 450, 100, 100);
         * comboBox.setFont(new Font("Muli", Font.PLAIN, 19)); comboBox.setBorder(null);
         * add(comboBox);
         * 
         */
    }

    @Override
    protected void labelsAndFields() {

        settingsLabels(init_Titulo, "Inteligência Artificial na sociedade", 1);
        settingsLabels(init_Autor, "Matheus Kildere", 2);
        settingsLabels(init_Categoria, "Aprovado", 3);

        settingsLabels(init_Titulo, "Inteligência Artificial", 1);
        settingsLabels(init_Autor, "Matheus Kildere", 2);
        settingsLabels(init_Categoria, "Em análise", 3);

        settingsLabels(init_Titulo, "Inteligência Artificial", 1);
        settingsLabels(init_Autor, "Matheus Kildere", 2);
        settingsLabels(init_Categoria, "Reprovado", 3);

        settingsLabels(init_Titulo, "Inteligência Artificial", 1);
        settingsLabels(init_Autor, "Matheus Kildere", 2);
        settingsLabels(init_Categoria, "Aprovado", 3);
    }

    @Override
    protected void settingsLabels(JLabel l_, String nome, int tipo) {
        l_ = new JLabel(nome);
        l_.setFont(new Font("Muli", 4, 20));
        l_.setForeground(cor.branco());
        if (tipo == 1) {
            l_.setBounds(50, lab + 180, 400, 30);
        } else if (tipo == 2) {
            l_.setBounds(500, lab + 180, 400, 30);
        } else if (tipo == 3) {
            l_.setBounds(950, 180 + lab, 400, 30);
            lab += 50;
        }
        add(l_);
    }

    protected void recebePesquisa(String pesquisa) {

    }

}