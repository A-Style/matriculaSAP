
package controlador.secundario;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class Splash extends Thread{
    
    private JProgressBar bar;
   
    
    @Override
    public void run(){
        
        for (int i = 0; i <= 100; i++) {        
            try {
                this.bar.setValue(i);
                sleep(20);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }         
        stop();
        destroy();
     
    }  
    

    
    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }
    
}
