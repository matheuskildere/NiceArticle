package interfaceGrafica;

import java.awt.*;
import javax.swing.*;
import java.awt.Font;

import Color.Colors;

import java.awt.event.*;

import interfaceGrafica.PanelPrincipal;

/**
 * Tela de ínicio
 */
public class Janela extends PanelPrincipal implements ActionListener {

    public JFrame frame;

    private JButton bTitulo;

    private JTextField tPesquisa;
    private JButton bPesquisa;

    private JButton bArtigo;
    private JButton bResumo;
    private JButton bPalestra;
    private JButton bMiniCurso;
    private JButton bMonografia;
    private JButton bRelatorioTecnico;

    private Colors cor = new Colors();
    public PanelInicial panel = new PanelInicial();
    public PanelMonografia panelMonografia = new PanelMonografia();
    public PanelPrincipal panelPrinc = new PanelPrincipal();
    public PanelResumo panelResumo = new PanelResumo();
    public PanelPalestra panelPalestra = new PanelPalestra();
    public PanelMinicursos panelMinicursos = new PanelMinicursos();
    public PanelRelatorioTecnico panelRelatorioTecnico = new PanelRelatorioTecnico();
    public PanelResultadoPesquisaAutor panelResultadoPesquisaAutor;
    public PanelResultadoPesquisaSubmissao panelResultadoPesquisaSubmissao;

    public Janela() {

        frame = new JFrame("NiceArticle");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setSize(1366, 768);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        bTitulo = new JButton("NiceArticle");
        bTitulo.setBounds(600, 30, 250, 60);
        bTitulo.setFont(new Font("Helvetica", Font.PLAIN, 35));
        bTitulo.setForeground(new Color(10, 10, 10));
        bTitulo.setBorderPainted(false);
        bTitulo.addActionListener(this);
        bTitulo.setFocusPainted(false);
        bTitulo.setBackground(cor.branco());
        frame.getContentPane().add(bTitulo);

        tPesquisa = new JTextField("");
        tPesquisa.setBounds(900, 30, 350, 50);
        tPesquisa.setFont(new Font("Helvetica", Font.PLAIN, 15));
        frame.getContentPane().add(tPesquisa);

        bPesquisa = new JButton("");
        bPesquisa.setBounds(1260, 30, 50, 50);
        bPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/search.png")));
        bPesquisa.setFont(new Font("Arial", Font.PLAIN, 15));
        bPesquisa.setBackground(cor.branco());
        bPesquisa.addActionListener(this);
        frame.getContentPane().add(bPesquisa);

        bArtigo = new JButton("  Artigo");
        bArtigo.setBounds(40, 110, 250, 60);
        bArtigo.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bArtigo.setForeground(new Color(0, 0, 0));
        bArtigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/newspaper.png")));
        bArtigo.addActionListener(this);
        bArtigo.setFocusPainted(false);
        bArtigo.setBorderPainted(false);
        bArtigo.setBackground(cor.branco());
        frame.getContentPane().add(bArtigo);

        bResumo = new JButton("  Resumo");
        bResumo.setBounds(210, 110, 250, 60);
        bResumo.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bResumo.setForeground(new Color(0, 0, 0));
        bResumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/files.png")));
        bResumo.addActionListener(this);
        bResumo.setFocusPainted(false);
        bResumo.setBorderPainted(false);
        bResumo.setBackground(cor.branco());
        frame.getContentPane().add(bResumo);

        bPalestra = new JButton("  Palestra");
        bPalestra.setBounds(380, 110, 250, 60);
        bPalestra.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bPalestra.setForeground(new Color(0, 0, 0));
        bPalestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/presentation.png")));
        bPalestra.addActionListener(this);
        bPalestra.setFocusPainted(false);
        bPalestra.setBorderPainted(false);
        bPalestra.setBackground(cor.branco());
        frame.getContentPane().add(bPalestra);

        bMiniCurso = new JButton("  Mini Curso");
        bMiniCurso.setBounds(570, 110, 250, 60);
        bMiniCurso.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bMiniCurso.setForeground(new Color(0, 0, 0));
        bMiniCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/play-button.png")));
        bMiniCurso.addActionListener(this);
        bMiniCurso.setFocusPainted(false);
        bMiniCurso.setBorderPainted(false);
        bMiniCurso.setBackground(cor.branco());
        frame.getContentPane().add(bMiniCurso);

        bMonografia = new JButton("  Monografia");
        bMonografia.setBounds(770, 110, 250, 60);
        bMonografia.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bMonografia.setForeground(new Color(0, 0, 0));
        bMonografia.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/file.png")));
        bMonografia.addActionListener(this);
        bMonografia.setFocusPainted(false);
        bMonografia.setBorderPainted(false);
        bMonografia.setBackground(cor.branco());
        frame.getContentPane().add(bMonografia);

        bRelatorioTecnico = new JButton("  Relatório Técnico");
        bRelatorioTecnico.setBounds(1000, 110, 250, 60);
        bRelatorioTecnico.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bRelatorioTecnico.setForeground(new Color(0, 0, 0));
        bRelatorioTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/settings.png")));
        bRelatorioTecnico.addActionListener(this);
        bRelatorioTecnico.setFocusPainted(false);
        bRelatorioTecnico.setBorderPainted(false);
        bRelatorioTecnico.setBackground(cor.branco());

        frame.getContentPane().add(bRelatorioTecnico);
        frame.getContentPane().add(panelPrinc);
        frame.getContentPane().add(panelResumo);
        frame.getContentPane().add(panelPalestra);
        frame.getContentPane().add(panelMinicursos);
        frame.getContentPane().add(panelMonografia);
        frame.getContentPane().add(panelRelatorioTecnico);
        frame.getContentPane().add(panel);

        panel.setVisible(true);
        panelPrinc.setVisible(false);
        panelResumo.setVisible(false);
        panelPalestra.setVisible(false);
        panelMinicursos.setVisible(false);
        panelMonografia.setVisible(false);
        panelRelatorioTecnico.setVisible(false);

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bTitulo) {
            panel.resultados();
            panelResumo.setVisible(false);
            panelMinicursos.setVisible(false);
            panelMonografia.setVisible(false);
            panelRelatorioTecnico.setVisible(false);
            panelPrinc.setVisible(false);
            panelPalestra.setVisible(false);
            panel.setVisible(true);
        }

        if (ae.getSource() == bPesquisa) {

            String termo = tPesquisa.getText();

            if (listaSubmissao.consultarTitulo(termo) != null) {
                panel.setVisible(false);
                panelResumo.setVisible(false);
                panelMinicursos.setVisible(false);
                panelMonografia.setVisible(false);
                panelRelatorioTecnico.setVisible(false);
                panelPrinc.setVisible(false);
                panelPalestra.setVisible(false);
                panelResultadoPesquisaSubmissao = new PanelResultadoPesquisaSubmissao(termo);
                panelResultadoPesquisaSubmissao.setVisible(true);
                frame.getContentPane().add(panelResultadoPesquisaSubmissao);

            } else if (listaSubmissao.consultarAutor(termo).size() != 0) {
                panel.setVisible(false);
                panelResumo.setVisible(false);
                panelMinicursos.setVisible(false);
                panelMonografia.setVisible(false);
                panelRelatorioTecnico.setVisible(false);
                panelPrinc.setVisible(false);
                panelPalestra.setVisible(false);
                panelResultadoPesquisaAutor = new PanelResultadoPesquisaAutor(termo);
                panelResultadoPesquisaAutor.setVisible(true);
                frame.getContentPane().add(panelResultadoPesquisaAutor);

            } else {
                JOptionPane.showMessageDialog(null, "Nenhum resultado foi encontrado !");
            }

        }

        if (ae.getSource() == bArtigo) {
            panel.setVisible(false);
            panelResumo.setVisible(false);
            panelMinicursos.setVisible(false);
            panelMonografia.setVisible(false);
            panelRelatorioTecnico.setVisible(false);
            panelPrinc.setVisible(true);

        }

        if (ae.getSource() == bResumo) {
            panel.setVisible(false);
            panelPrinc.setVisible(false);
            panelMinicursos.setVisible(false);
            panelMonografia.setVisible(false);
            panelRelatorioTecnico.setVisible(false);
            panelResumo.setVisible(true);

        }

        if (ae.getSource() == bPalestra) {
            panel.setVisible(false);
            panelPrinc.setVisible(false);
            panelMinicursos.setVisible(false);
            panelResumo.setVisible(false);
            panelMonografia.setVisible(false);
            panelRelatorioTecnico.setVisible(false);
            panelPalestra.setVisible(true);
        }

        if (ae.getSource() == bMiniCurso) {
            panel.setVisible(false);
            panelPrinc.setVisible(false);
            panelResumo.setVisible(false);
            panelPalestra.setVisible(false);
            panelMonografia.setVisible(false);
            panelRelatorioTecnico.setVisible(false);
            panelMinicursos.setVisible(true);
        }

        if (ae.getSource() == bMonografia) {
            panel.setVisible(false);
            panelPrinc.setVisible(false);
            panelResumo.setVisible(false);
            panelPalestra.setVisible(false);
            panelMinicursos.setVisible(false);
            panelRelatorioTecnico.setVisible(false);
            panelMonografia.setVisible(true);
        }

        if (ae.getSource() == bRelatorioTecnico) {
            panel.setVisible(false);
            panelPrinc.setVisible(false);
            panelResumo.setVisible(false);
            panelPalestra.setVisible(false);
            panelMinicursos.setVisible(false);
            panelMonografia.setVisible(false);
            panelRelatorioTecnico.setVisible(true);
        }
    }

    public void panelInicio(JPanel panel) {
        frame.add(panel);
        panel.setVisible(false);
    }

}
