package interfaceGrafica;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import Enumeracao.Situacao;
import Persistencia.Dados;
import categoria.Palestra;

/**
 * PanelResumo
 */
public class PanelPalestra extends PanelPrincipal {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected String[] vetor_Autores = new String[1];
    private JLabel l_Duracao;
    private JLabel l_Curriculo;

    protected void buttonsAdd() {
        b_addAutores = new JButton("add");
        settingsButtons(b_addAutores, 1);
        b_addAutores.addActionListener(actionPerformed(b_addAutores));

        b_submeter = new JButton("Submeter");
        settingsButtons(b_submeter, 2);
        b_submeter.addActionListener(actionPerformed(b_submeter));
    }

    @Override
    protected void labelsAndFields() {
        settingsLabels(l_Titulo, "Título", 1);
        settingsTxt(j_Titulo, 1);
        settingsLabels(l_Duracao, "Duração", 1);
        settingsTxt(j_Duracao, 1);
        settingsLabels(l_Autores, "Autores", 1);
        settingsTxt(j_Autores, 2);
        settingsLabels(l_Curriculo, "Curriculo", 1);
        settingsTxtArea(j_Curriculo, 2);
        settingsLabels(l_Resumo, "Resumo", 2);
        settingsTxtArea(j_Resumo);
        settingsLabels(l_Abstract, "Abstract", 2);
        settingsTxtArea(j_Abstract, 1);

    }

    protected void settingsTxtArea(JTextArea j_, int tipo) {
        if (tipo == 1) {
            if (implementaJtextField > 320) {
                implementaJtextField = 0;
            }
            j_.setBounds(750, 63 + implementaJtextField, 478, 200);

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

    protected void settingsButtons(JButton b_add, int tipo) {
        if (tipo == 1) {
            if (implementaJtextField >= 160) {
                implementaJtextField = 0;
            }
            b_add.setBounds(532, 223 + implementaJtextField, 60, 35);
            b_add.setFont(new Font("Muli", 4, 10));
        } else if (tipo == 2) {
            b_add.setBounds(1120, 373 + implementaJtextField, 110, 35);
            b_add.setFont(new Font("Muli", 4, 15));
        }
        b_add.setFocusPainted(false);
        b_add.setBorderPainted(false);
        b_add.setBackground(cor.branco());
        add(b_add);
        implementaJtextField += 80;
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
                            JOptionPane.showMessageDialog(null, "Voce atingiu o numero maximo de autores (1)!");
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
                            throw new IllegalArgumentException("Sua palestra necessita de um Titulo");
                        } else if (j_Duracao.getText().equals("")) {
                            throw new IllegalArgumentException("Sua Palestra necessita de uma duracao");
                        } else if (vetor_Autores[0] == null) {
                            throw new IllegalArgumentException("E necessário informar ao menos um autor");
                        } else if (j_Curriculo.getText().equals("")) {
                            throw new IllegalArgumentException("Voce precisa informar seu curriculo");
                        } else if (j_Resumo.getText().equals("")) {
                            throw new IllegalArgumentException("Sua Palestra necessita de um resumo");
                        } else if (j_Abstract.getText().equals("")) {
                            throw new IllegalArgumentException("Your talk needs a summary");
                        } else {
                            Situacao[] options = { Situacao.APROVADO, Situacao.SOB_AVALIACAO, Situacao.REPROVADO };
                            int x = JOptionPane.showOptionDialog(null, "Situacao da Submissao", "Informe",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                            int duracao = Integer.parseInt(j_Duracao.getText());
                            submissao = new Palestra(j_Titulo.getText(), options[x], vetor_Autores, j_Resumo.getText(),
                                    j_Abstract.getText(), duracao, j_Curriculo.getText());
                            listaSubmissao.incluir(submissao);
                            persistenciaCSV = new Dados(submissao, "Palestra");
                            clearAllText();
                        }

                        clearAllText();

                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            };
        }
        return null;
    }

}