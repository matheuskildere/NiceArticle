package interfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Enumeracao.Situacao;
import Persistencia.Dados;
import categoria.Resumo;

/**
 * PanelResumo
 */
public class PanelResumo extends PanelPrincipal {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected String[] vetor_Autores = new String[8];
    protected String[] vetor_Instituicoes = new String[8];
    protected String[] vetor_PalavrasC = new String[4];

    @Override
    protected void labelsAndFields() {
        settingsLabels(l_Titulo, "Título", 1);
        settingsTxt(j_Titulo, 1);
        settingsLabels(l_Autores, "Autores", 1);
        settingsTxt(j_Autores, 2);
        settingsLabels(l_Instituicoeseld, "Instituições", 1);
        settingsTxt(j_Instituicoes, 2);
        settingsLabels(l_PalavrasC, "Palavras Chaves", 1);
        settingsTxt(j_PalavrasC, 2);
    }

    protected void settingsButtons(JButton b_add, int tipo) {
        if (tipo == 1) {
            if (implementaJtextField > 240) {
                implementaJtextField = 0;
            }
            b_add.setBounds(870, 153 + implementaJtextField, 70, 35);
            b_add.setFont(new Font("Muli", 4, 10));
        } else if (tipo == 2) {
            b_add.setBounds(650, 153 + implementaJtextField, 110, 35);
            b_add.setFont(new Font("Muli", 4, 15));
        }
        b_add.setFocusPainted(false);
        b_add.setBorderPainted(false);
        b_add.setBackground(cor.branco());
        add(b_add);
        implementaJtextField += 90;
    }

    @Override
    protected void settingsTxt(JTextField j_, int tipo) {
        if (tipo == 1) {
            j_.setBounds(430, 63 + implementaJtextField, 510, 35);
        } else if (tipo == 2) {
            j_.setBounds(430, 63 + implementaJtextField, 434, 35);
        }

        j_.setFont(new Font("Muli", Font.PLAIN, 19));
        j_.setBorder(null);
        add(j_);
        implementaJtextField += 90;
    }

    @Override
    protected void settingsLabels(JLabel l_, String nome, int tipo) {
        l_ = new JLabel(nome);
        if (tipo == 1) {
            l_.setBounds(430, 28 + implementaJlabels, 250, 30);
        }
        l_.setFont(new Font("Muli", 4, 23));
        l_.setForeground(cor.branco());
        add(l_);
        implementaJlabels += 91;
    }

    @Override
    protected ActionListener actionPerformed(JButton b) {
        if (b == b_addAutores) {
            return new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    boolean conseguiu = false;
                    boolean avisou = false;
                    for (int i = 0; i < vetor_Autores.length; i++) {
                        if (vetor_Autores[i] == null && !conseguiu) {
                            vetor_Autores[i] = j_Autores.getText();
                            conseguiu = true;
                            JOptionPane.showMessageDialog(null, "Autor " + j_Autores.getText() + " adicionado !");
                            j_Autores.setText("");

                        } else if (vetor_Autores[vetor_Autores.length - 1] != null && !avisou) {
                            JOptionPane.showMessageDialog(null, "Voce atingiu o numero maximo de autores (8)!");
                            avisou = true;
                        }
                    }
                }
            };
        }
        if (b == b_addInstituicoes) {
            return new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    boolean conseguiu = false;
                    boolean avisou = false;
                    for (int i = 0; i < vetor_Instituicoes.length; i++) {
                        if (vetor_Instituicoes[i] == null && !conseguiu) {
                            vetor_Instituicoes[i] = j_Instituicoes.getText();
                            conseguiu = true;

                            JOptionPane.showMessageDialog(null,
                                    "Instituição " + j_Instituicoes.getText() + " adicionada !");
                            j_Instituicoes.setText("");

                        } else if (vetor_Instituicoes[vetor_Instituicoes.length - 1] != null && !avisou) {
                            JOptionPane.showMessageDialog(null, "Voce atingiu o numero maximo de instituicoes (8)!");
                            avisou = true;
                        }
                    }
                }
            };
        }
        if (b == b_addPalavrasC) {
            return new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    boolean conseguiu = false;
                    boolean avisou = false;
                    for (int i = 0; i < vetor_PalavrasC.length; i++) {
                        if (vetor_PalavrasC[i] == null && !conseguiu) {
                            vetor_PalavrasC[i] = j_PalavrasC.getText();
                            conseguiu = true;

                            JOptionPane.showMessageDialog(null,
                                    "Palavra chave " + j_PalavrasC.getText() + " adicionada !");
                            j_PalavrasC.setText("");

                        } else if (vetor_PalavrasC[vetor_PalavrasC.length - 1] != null && !avisou) {
                            JOptionPane.showMessageDialog(null, "Voce atingiu o numero maximo de Palavras Chaves (8)!");
                            avisou = true;
                        }
                    }
                }
            };
        }
        if (b == b_submeter) {
            return new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    try {
                        if (j_Titulo.getText().equals("")) {
                            throw new IllegalArgumentException("Seu resumo necessita de um Titulo");
                        } else if (vetor_Autores[0] == null) {
                            throw new IllegalArgumentException("E necess�rio informar ao menos um autor");
                        } else if (vetor_Instituicoes[0] == null) {
                            throw new IllegalArgumentException(
                                    "E necess�rio informar uma instituicao ligada ao trabalho");
                        } else if (vetor_PalavrasC[0] == null) {
                            throw new IllegalArgumentException(
                                    "Coloque ao menos uma palavra chave relacionada ao seu resumo");
                        } else {
                            Situacao[] options = { Situacao.APROVADO, Situacao.SOB_AVALIACAO, Situacao.REPROVADO };
                            int x = JOptionPane.showOptionDialog(null, "Situacao da Submissao", "Informe",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                            submissao = new Resumo(j_Titulo.getText(), options[x], vetor_Autores, vetor_Instituicoes,
                                    vetor_PalavrasC);
                            listaSubmissao.incluir(submissao);
                            persistenciaCSV = new Dados(submissao, "Resumo");
                            clearAllText();

                        }
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            };
        }
        return null;
    }
}