package gui.splashScreen;



import gui.AuthenticationGUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;


public class SplashScreen {
    JProgressBar progresso;
    public SplashScreen(JProgressBar progreso1){
        super();
        progresso=progreso1;

    }
   public void run (){
     for (int i=1;i<1000;i++)
     {
         progresso.setValue(i);
         pause(100);
         AuthenticationGUI a = new AuthenticationGUI();
         a.setVisible(true);
         a.setLocationRelativeTo(null);

     }
   }
public void pause (int mlSeg){
        try {
            Thread.sleep(mlSeg);
        } catch (InterruptedException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
}

  

}