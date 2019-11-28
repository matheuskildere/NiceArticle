package interfaceGrafica;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Enumeracao.Situacao;
import categoria.Artigo;
import categoria.Minicurso;
import categoria.Monografia;
import categoria.Palestra;
import categoria.RelatorioTecnico;
import categoria.Resumo;
import classes.Submissao;

import java.awt.Font;

/**
 * PanelInicial
 */
public class PanelInicial extends PanelPrincipal {

    JPanel panelResultados;

    private JLabel labelAll;
    private JComboBox cbFiltroTipo;
    private JComboBox cbFiltroSituacao;

    private JLabel lTitulo;
    private JLabel lAutor;
    private JLabel lSituacao;

    private JButton bEditar;
    private JButton bFiltrar;
    private JButton bExcluir;

    private JLabel init_Titulo;
    private JLabel init_Autor;
    private JLabel init_Categoria;
    private int lab = 0;
    private int labB = 0;

    public PanelResumo panelResumo = new PanelResumo();

    private static final long serialVersionUID = 1L;

    public PanelInicial() {
        removeAll();

        labelAll = new JLabel(" Filtros");
        labelAll.setBounds(50, 10, 200, 60);
        labelAll.setFont(new Font("Muli", Font.PLAIN, 20));
        labelAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/funnel.png")));
        labelAll.setForeground(cor.branco());
        add(labelAll);

        cbFiltroTipo = new JComboBox<>();
        cbFiltroTipo.setBounds(140, 10, 100, 40);
        cbFiltroTipo.setFont(new Font("Muli", Font.PLAIN, 15));
        cbFiltroTipo.addItem("Todos");
        cbFiltroTipo.addItem(Artigo.class.getSimpleName());
        cbFiltroTipo.addItem(Resumo.class.getSimpleName());
        cbFiltroTipo.addItem(Palestra.class.getSimpleName());
        cbFiltroTipo.addItem(Minicurso.class.getSimpleName());
        cbFiltroTipo.addItem(Monografia.class.getSimpleName());
        cbFiltroTipo.addItem(RelatorioTecnico.class.getSimpleName());
        add(cbFiltroTipo);

        cbFiltroSituacao = new JComboBox<>();
        cbFiltroSituacao.setBounds(250, 10, 100, 40);
        cbFiltroSituacao.setFont(new Font("Muli", Font.PLAIN, 15));
        cbFiltroSituacao.addItem("Todos");
        cbFiltroSituacao.addItem(Situacao.APROVADO);
        cbFiltroSituacao.addItem(Situacao.SOB_AVALIACAO);
        cbFiltroSituacao.addItem(Situacao.REPROVADO);
        add(cbFiltroSituacao);

        bFiltrar = new JButton("Filtrar");
        bFiltrar.setBounds(360, 10, 100, 40);
        bFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                resultados();
            }
        });
        add(bFiltrar);

        lTitulo = new JLabel(" Titulo");
        lTitulo.setBounds(50, 100, 200, 60);
        lTitulo.setFont(new Font("Muli", Font.PLAIN, 23));
        lTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/folder.png")));
        lTitulo.setForeground(cor.branco());
        add(lTitulo);

        lAutor = new JLabel(" Autor(es)");
        lAutor.setBounds(500, 100, 200, 60);
        lAutor.setFont(new Font("Muli", Font.PLAIN, 23));
        lAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/users.png")));
        lAutor.setForeground(cor.branco());
        add(lAutor);

        lSituacao = new JLabel(" Situação");
        lSituacao.setBounds(950, 100, 200, 60);
        lSituacao.setFont(new Font("Muli", Font.PLAIN, 23));
        lSituacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/situation.png")));
        lSituacao.setForeground(cor.branco());
        add(lSituacao);

        add(panelResultados());
        resultados();
    }

    protected void resultados(){
        lab = 0;
        labB = 0;
        Object situacao = cbFiltroSituacao.getSelectedItem();
        Object categoria = cbFiltroTipo.getSelectedItem();
        if (situacao == "Todos" && categoria == "Todos") {
            panelResultados.removeAll();
            for (Submissao submissao : listaSubmissao.getLista()) {
                configuraResultado(submissao.getTituloSubmissao(), submissao.getAutoresSubmissao()[0],
                        submissao.getSituacaoSubmissao().name());
                buttons(submissao);
            }
            panelResultados.repaint();
        } else if (situacao != "Todos" && categoria == "Todos") {
            panelResultados.removeAll();
            for (Submissao submissao : listaSubmissao.consultarSituacao((Situacao) situacao)) {
                configuraResultado(submissao.getTituloSubmissao(), submissao.getAutoresSubmissao()[0],
                        submissao.getSituacaoSubmissao().name());
                buttons(submissao);
            }
            panelResultados.repaint();
        } else if (situacao == "Todos" && categoria != "Todos") {
            panelResultados.removeAll();
            for (Submissao submissao : listaSubmissao.consultarCategoria((String) categoria)) {
                configuraResultado(submissao.getTituloSubmissao(), submissao.getAutoresSubmissao()[0],
                        submissao.getSituacaoSubmissao().name());
                buttons(submissao);
            }
            panelResultados.repaint();
        } else {
            panelResultados.removeAll();
            for (Submissao submissao : listaSubmissao.consultaSituCat((String) categoria, (Situacao) situacao)) {
                configuraResultado(submissao.getTituloSubmissao(), submissao.getAutoresSubmissao()[0],
                        submissao.getSituacaoSubmissao().name());
                buttons(submissao);
            }
            panelResultados.repaint();
        }
    }

    private void buttons(Submissao sub) {
        final Submissao teste = sub;

        bEditar = new JButton("  |");
        bEditar.setBounds(1215, 5 + labB, 85, 40);
        bEditar.setFont(new Font("Muli", Font.PLAIN, 26));
        bEditar.setBackground(cor.preto_Claro());
        bEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/edit.png")));
        bEditar.setBorderPainted(false);
        bEditar.setFocusPainted(false);
        // b_add.setBackground(cor.branco());

        bEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                Object[] options = { "Editar", "Cancelar" };
                int escolha = JOptionPane.showOptionDialog(null,
                        "Deseja mesmo editar " + teste.getTituloSubmissao() + " ?", "Confirmação",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                String editar = teste.getTituloSubmissao();

                if (escolha == 0) {

                    if (teste instanceof Artigo) {
                        System.out.println("Isso é um artigo");

                    }

                    if (teste instanceof Palestra) {
                        System.out.println("Isso é um palestra");

                    }

                    if (teste instanceof Resumo) {
                        System.out.println("Isso é um resumo");

                        String titulo = teste.getTituloSubmissao();
                        j_Titulo.setText(titulo);

                        setVisible(false);
                        add(panelResumo);
                        panelResumo.setVisible(true);


                        repaint();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "A edição foi cancelada");
                }

            }
        });
        panelResultados.add(bEditar);

        bExcluir = new JButton("");
        bExcluir.setBounds(1290, 5 + labB, 40, 40);
        bExcluir.setBackground(cor.preto_Claro());
        bExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("icons/garbage.png")));
        bExcluir.setBorderPainted(false);
        bExcluir.setBorderPainted(false);

        bExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                Object[] options = { "Confirmar exclusão", "Cancelar" };
                int escolha = JOptionPane.showOptionDialog(null,
                        "Deseja mesmo excluir " + teste.getTituloSubmissao() + " ?", "Confirmação",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                String excluir = teste.getTituloSubmissao();

                if (escolha == 0) {
                    listaSubmissao.excluir(excluir);
                    JOptionPane.showMessageDialog(null, excluir + " foi excluído com sucesso");

                } else {
                    JOptionPane.showMessageDialog(null, "A exclusão foi cancelada");
                }

            }
        });
        panelResultados.add(bExcluir);

        labB += 50;
    }

    private JPanel panelResultados() {
        panelResultados = new JPanel();
        panelResultados.setBounds(0, 175, 1366, 600);
        panelResultados.setBackground(cor.preto_Claro());
        panelResultados.getComponentPopupMenu();
        panelResultados.setLayout(null);
        panelResultados.setVisible(true);

        return panelResultados;
    }

    private void configuraResultado(String titulo, String autor, String situacao) {
        System.out.println("configurando");
        settingsLabels(init_Titulo, titulo, 1, panelResultados);
        settingsLabels(init_Autor, autor, 2, panelResultados);
        settingsLabels(init_Categoria, situacao, 3, panelResultados);
    }

    private void botao() {

    }

    // @Override
    protected void settingsLabels(JLabel l_, String nome, int tipo, JPanel panel) {
        l_ = new JLabel(nome);
        l_.setFont(new Font("Muli", 4, 20));
        l_.setForeground(cor.branco());
        if (tipo == 1) {
            l_.setBounds(50, lab + 10, 400, 30);
        } else if (tipo == 2) {
            l_.setBounds(500, lab + 10, 400, 30);
        } else if (tipo == 3) {
            l_.setBounds(950, 10 + lab, 400, 30);
            lab += 50;
        }
        panel.add(l_);
    }

}