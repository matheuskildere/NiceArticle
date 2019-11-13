package interfaceGrafica;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * PanelInicial
 */
public class PanelInicial extends PanelPrincipal{

    private JLabel init_Titulo;
    private JLabel init_Autor;
    private JLabel init_Categoria;
    private int lab = 0;

    private JComboBox comboBox;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PanelInicial() {
        removeAll();
        labelsAndFields();
    }

    private void jComboBox(){
        comboBox = new JComboBox<>();
        comboBox.setBounds(50,450 , 100, 100);
        comboBox.setFont(new Font("Muli", Font.PLAIN, 19));
        comboBox.setBorder(null);
        add(comboBox);
    }

    @Override
    protected void labelsAndFields() {
        settingsLabels(init_Titulo, "Título",1);
        settingsLabels(init_Autor, "Autor",2);
        settingsLabels(init_Categoria, "Categoria",3);
        
        settingsLabels(init_Titulo, "Inteligencia artificial",1);
        settingsLabels(init_Autor, "matheus kidere",2);
        settingsLabels(init_Categoria, "aprovado",3);
    }

    @Override
    protected void settingsLabels(JLabel l_, String nome,int tipo) {
        l_ = new JLabel(nome);
        l_.setFont(new Font("Muli", 4, 23));
        l_.setForeground(cor.branco());
        if (tipo == 1) {
            l_.setBounds(76, lab + 75, 250, 30);
        }else if (tipo == 2) {
            l_.setBounds(548, lab +75 , 250, 30);
        }else if (tipo == 3) {
            l_.setBounds(900, 75 + lab , 250, 30);
            lab += 40;
        }
        add(l_);
    }
    
    
}