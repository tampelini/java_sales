/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/**
 *
 * @author Tampelini
 */
public class Utilitarios {

    //metodo limparCampos
    public void LimpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JSplitPane) {
                System.out.println("-> " + ((JTextField) ((JSplitPane) component).getLeftComponent()).getText());
                ((JTextField) ((JSplitPane) component).getLeftComponent()).setText(null);
            }
            
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
        }
    }
    
    // metodo para verificar se os campos estão limpos
    public boolean verificaLimpo(JPanel container) {
        boolean bool = true;
        Component components[] = container.getComponents();
        for (Component component : components) {
            System.out.println("->" + component.getName());
            if (component instanceof JTextField && component.getName() != null && (component.getName().equals("cod"))) {
                if (((JTextField) component).getText().isEmpty()) {
                    bool = false;
                    break;
                }
            }
        }
        return bool;
    }

    //Metodo para adicionar imagem de fundo JDesktopPane
//    public void adicionaImagem() {
//
//        ImageIcon icon = new ImageIcon(Frmmenu.class.getResource("br.com.projeto.images/fundo.jpg"));
//        Image img = icon.getImage();
//
//        JDesktopPane painel = new JDesktopPane() {
//            public void paintComponent(Graphics g) {
//                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
//            }
//
//        }
                
                }
