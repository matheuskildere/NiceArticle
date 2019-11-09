package interfaceGrafica;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Tela de ínicio
 */
public class Janela implements ActionListener {

    public static JFrame frame;
    private JLabel lTitulo;

    private JTextField tPesquisa;

    private JButton bGerenciamento;
    private JButton bPrestacaoContas;
    private JButton bRelatorios;

    public Janela() {

        frame = new JFrame("NiceArticle");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setSize(1366, 768);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lTitulo = new JLabel("NiceArticle");
        lTitulo.setBounds(600, 40, 200, 60);
        lTitulo.setFont(new Font("Arial", Font.PLAIN, 40));
        lTitulo.setForeground(new Color(0, 0, 0));
        frame.getContentPane().add(lTitulo);

        tPesquisa = new JTextField("");
        tPesquisa.setBounds(900, 40, 400, 60);
        tPesquisa.setFont(new Font("Arial", Font.PLAIN, 25));
     //   tPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/list.png")));
        frame.getContentPane().add(tPesquisa);

        bGerenciamento = new JButton("  Gerenciamento");
        bGerenciamento.setBounds(0, 300, 300, 60);
        bGerenciamento.setFont(new Font("Arial", Font.PLAIN, 25));
        bGerenciamento.setForeground(new Color(0, 0, 0));
        bGerenciamento.setBorderPainted(false);
        bGerenciamento.addActionListener(this);
        frame.getContentPane().add(bGerenciamento);

        bPrestacaoContas = new JButton("  Prestação de contas");
        bPrestacaoContas.setBounds(0, 400, 360, 60);
        bPrestacaoContas.setFont(new Font("Arial", Font.PLAIN, 25));
        bPrestacaoContas.setForeground(new Color(0, 0, 0));
        bPrestacaoContas.addActionListener(this);
        frame.getContentPane().add(bPrestacaoContas);

        bRelatorios = new JButton("  Central de Relatórios");
        bRelatorios.setBounds(0, 500, 370, 60);
        bRelatorios.setFont(new Font("Arial", Font.PLAIN, 25));
        bRelatorios.setForeground(new Color(0, 0, 0));
        bRelatorios.addActionListener(this);
        bRelatorios.setBorderPainted(false);
        frame.getContentPane().add(bRelatorios);

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == bGerenciamento) {

        }

        if (ae.getSource() == bPrestacaoContas) {

        }

        if (ae.getSource() == bRelatorios) {

        }

    }

    public static void panelInicio(JPanel j) {
        frame.add(j);
        j.setVisible(true);
    }

}
