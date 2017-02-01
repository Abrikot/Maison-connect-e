/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisonconnectee;

import grovepi.GrovePi;
import grovepi.sensors.ButtonSensor;
import grovepi.sensors.Buzzer;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import jdk.nashorn.internal.objects.NativeDebug;

/**
 *
 * @author Maxence
 */
public class MaisonConnectee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String font = "BAUHS93.TTF";
            String nomApplication = "MaisonConnectee";
            Runtime.getRuntime().exec(new String[] {"/bin/sh", "-c", "if [ ! -f /usr/share/fonts/" + font +" ] ; then cd /home/pi/NetBeansProjects/" + nomApplication + "Connectee/dist/ ; jar -xf " + nomApplication + ".jar data/" + font + " ; cd data ; sudo cp " + font + " /usr/share/fonts ; rm -r ../data ; fi"});
        }
        catch (Exception exc) {}
        Bain bain = new Bain();
        Cafe cafe = new Cafe();
        Chauffage chauffage = new Chauffage();
        LumiereExterieure lumExt = new LumiereExterieure();
        LumiereInterieure lumInt = new LumiereInterieure();
        Radio radio = new Radio();
        Reveil reveil = new Reveil();
        Volets volets = new Volets();
        Video video=new Video();
        
        MaFenetre f = new MaFenetre(bain, cafe, chauffage, lumExt, lumInt, radio, reveil, volets);
        f.setVisible(true);
        

        
        Date date = new Date();
        //reveil.setHeureSemaine(date.getHours()*100+(100*((date.getMinutes()+1)/60))+(date.getMinutes()+1)%60);
        //reveil.setHeureSemaine(date.getHours()*100+(100*((date.getMinutes())/60))+(date.getMinutes())%60);
        
        TimerTask task = new TimerTask() { // Vérifie l'heure afin de déclencher ou non le réveil
            @Override
            public void run() {
                Date dateTmp = new Date();
                System.out.println(dateTmp.getHours()*100 + dateTmp.getMinutes());
                System.out.println(reveil.getHeureSemaine());
                if ((dateTmp.getDay() > 0 && dateTmp.getDay() < 6 && reveil.getHeureSemaine() == dateTmp.getHours()*100 + dateTmp.getMinutes())
                || ((dateTmp.getDay() == 0 || dateTmp.getDay() == 6) && reveil.getHeureWeekEnd()== dateTmp.getHours()*100 + dateTmp.getMinutes()))
                {
                    bain.remplir();
                    chauffage.allumer();
                    cafe.remplir(lumInt, volets);
                    radio.allumer();
                    System.out.println("Il est l'heure !");
                }
                f.changementHeure();
            }
        };
        
        Timer timer = new Timer();
        TimerTask initTimer = new TimerTask() //Fonction d'initialisation du timer pour le réveil
        {
            @Override
            public void run()
            {
                if (new Date().getSeconds() == 00)
                {
                    timer.scheduleAtFixedRate(task, 0, 60000);
                    this.cancel();
                }
            }
        };
        
        Timer initTime = new Timer();
        initTime.scheduleAtFixedRate(initTimer, 0,50);
        
        GrovePi p = new GrovePi();
        p.analogWrite(3, 0);
        p.analogWrite(4, 0);
        p.analogWrite(5, 0);
        p.analogWrite(6, 0);
        ButtonSensor s = new ButtonSensor(p, 2);
        Buzzer b = new Buzzer(p, 8);
        
        TimerTask detectionIntrus = new TimerTask()
        {
            @Override
            public void run()
            {
                if (s.getState())
                {
                    b.setState(true);
                    p.analogWrite(3, 0);
                    p.analogWrite(4, 0);
                    p.analogWrite(5, 0);
                    p.analogWrite(6, 0);
                    video.allumer();
                }    
                else
                {
                    b.setState(false);
                }
                    
            }
        };
        
        Timer detectionTimer = new Timer();
        detectionTimer.scheduleAtFixedRate(detectionIntrus, 0, 50);
        
    }
}