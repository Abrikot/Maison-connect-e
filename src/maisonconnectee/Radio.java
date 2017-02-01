/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisonconnectee;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Maxence
 */
public class Radio {
    private float frequence;
    private boolean etat;
    Process proc;
    Process proc1;
    
    public void setFrequence(float frequence) {
        this.frequence = frequence;
    }

    public float getFrequence() {
        return frequence;
    }
    
    public void allumer()
    {
        etat = true;
        try {
            if (this.getFrequence()<=91.0 && this.getFrequence()>=87.5)
                proc = Runtime.getRuntime().exec("omxplayer /mnt/cle/Musique/Radio/Scoop.mp3 ");
            else if (this.getFrequence()<=94.5 && this.getFrequence()>91.0)
                proc = Runtime.getRuntime().exec("omxplayer /mnt/cle/Musique/Radio/Fun.mp3 ");
            else if (this.getFrequence()<=98.0 && this.getFrequence()>94.5)
                proc = Runtime.getRuntime().exec("omxplayer /mnt/cle/Musique/Radio/Virgin.mp3 ");
            else if (this.getFrequence()<=102.0 && this.getFrequence()>98.0)
                proc = Runtime.getRuntime().exec("omxplayer /mnt/cle/Musique/Radio/Skyrock.mp3 ");
            else if (this.getFrequence()<=108 && this.getFrequence()>102.0)
                proc = Runtime.getRuntime().exec("omxplayer /mnt/cle/Musique/Radio/NRJ.mp3 ");
        } catch (IOException ex) {
            Logger.getLogger(Radio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eteindre()
    {
        etat = false;
        try {
             proc1 = Runtime.getRuntime().exec("^C");
        } catch (IOException e) {
        }
    
    }
    
    public Radio()
    {
        etat = false;
        frequence = 100;
    }
    
}
