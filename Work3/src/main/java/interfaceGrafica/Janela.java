package interfaceGrafica;

import java.awt.*;
import javax.swing.*;

import Color.Colors;

import java.awt.event.*;

import interfaceGrafica.PanelPrincipal;

/**
 * Tela de ínicio
 */
public class Janela implements ActionListener {

    public JFrame frame;

    private JLabel lTitulo;

    private JTextField tPesquisa;
    private JButton iconPesquisa;

    private JButton bArtigo;
    private JButton bResumo;
    private JButton bPalestra;
    private JButton bMiniCurso;
    private JButton bMonografia;
    private JButton bRelatorioTecnico;

    private Colors cor = new Colors();

    public PanelInicial panel = new PanelInicial();
    public PanelPrincipal panelPrinc = new PanelPrincipal();

    public Janela() {

        frame = new JFrame("NiceArticle");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setSize(1366, 768);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lTitulo = new JLabel("NiceArticle");
        lTitulo.setBounds(600, 30, 200, 60);
        lTitulo.setFont(new Font("Helvetica", Font.PLAIN, 35));
        lTitulo.setForeground(new Color(10, 10, 10));
        frame.getContentPane().add(lTitulo);

        tPesquisa = new JTextField("");
        tPesquisa.setBounds(900, 30, 350, 50);
        tPesquisa.setFont(new Font("Helvetica", Font.PLAIN, 15));
        frame.getContentPane().add(tPesquisa);

        iconPesquisa = new JButton("");
        iconPesquisa.setBounds(1260, 30, 50, 50);
        iconPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/search.png")));
        iconPesquisa.setFont(new Font("Arial", Font.PLAIN, 15));
        iconPesquisa.setBackground(cor.branco());
        frame.getContentPane().add(iconPesquisa);

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

        //panelInicio = new JPanel();
        //panelInicio.setBounds(0, 175, 1366, 593);
        //panelInicio.setBackground(cor.preto());
        //rpanelInicio.setVisible(true);
        frame.getContentPane().add(panel);
        
        
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bArtigo) {
            panel.setVisible(false);
            frame.getContentPane().add(panelPrinc);



        }

        if (ae.getSource() == bResumo) {

        }

        if (ae.getSource() == bPalestra) {

        }

    }

    public void panelInicio (JPanel panel) {
        frame.add(panel);
        panel.setVisible(false);
    }
    

}
