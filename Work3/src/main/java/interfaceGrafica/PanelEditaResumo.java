package interfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Enumeracao.Situacao;
import categoria.Resumo;

/**
 * PanelResumo
 */
public class PanelEditaResumo extends PanelResumo{


    @Override
    protected ActionListener actionPerformed(JButton b){
        if (b == b_addAutores) {
            return new ActionListener() { 
                public void actionPerformed(ActionEvent event) {
                    boolean conseguiu = false;
                    boolean avisou = false;
                    for (int i = 0; i < vetor_Autores.length; i++) {
                        if (vetor_Autores[i] == null && !conseguiu) {
                            vetor_Autores[i] = j_Autores.getText();
                            conseguiu = true;
                        } else if(vetor_Autores[vetor_Autores.length -1] != null && !avisou){
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
                        } else if(vetor_Instituicoes[vetor_Instituicoes.length -1] != null && !avisou){
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
                        } else if(vetor_PalavrasC[vetor_PalavrasC.length -1] != null && !avisou){
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
                        if (j_Titulo.getText().equals("")){
                            throw new IllegalArgumentException("Seu resumo necessita de um Titulo");
                        }else if (vetor_Autores[0] == null) {
                            throw new IllegalArgumentException("E necess�rio informar ao menos um autor"); 
                        }else if(vetor_Instituicoes[0] == null){
                            throw new IllegalArgumentException("E necess�rio informar uma instituicao ligada ao trabalho"); 
                        }else if (vetor_PalavrasC[0] == null){
                            throw new IllegalArgumentException("Coloque ao menos uma palavra chave relacionada ao seu resumo"); 
                        }else {
                            Situacao[] options = {Situacao.APROVADO,Situacao.SOB_AVALIACAO,Situacao.REPROVADO};
                            int x = JOptionPane.showOptionDialog(null, "Situacao da Submissao", "Informe", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, options, null);
                            submissao = new Resumo(j_Titulo.getText(), options[x], vetor_Autores, vetor_Instituicoes, vetor_PalavrasC);
                           // listaSubmissao.(submissao);
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