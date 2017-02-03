/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.secundario;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author GF
 */
public class Validacion {
     public void SoloLetras(JTextField txt){
        txt.addKeyListener(new KeyAdapter() {
            public void KeyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(Character.isDigit(c)){
                e.consume();
                }
            }
        });
    }
    
    public void SoloNumeros(JTextField txt){
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isDigit(c)){
                   
                e.consume();
                }
            }
        });
    }
}
