/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisonconnectee;

import grovepi.GrovePi;
import grovepi.sensors.Buzzer;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Maxence
 */
public class Cafe {
    private int type;
    private boolean sucre;
    static int i = 0; // Compteur pour l'allumage de la LED
    
    public Cafe()
    {
        type = 0;
        sucre = false;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setSucre(boolean sucre) {
        this.sucre = sucre;
    }

    public int getType() {
        return type;
    }

    public boolean isSucre() {
        return sucre;
    }
    
    public void remplir(LumiereInterieure LumInt, Volets v)
    {
        GrovePi p = new GrovePi();
        Buzzer b = new Buzzer(p,8);
        b.setState(true);

        Timer timer = new Timer();
        
        TimerTask vide = new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("test");
                p.analogWrite(3,(int)(LumInt.getLuminosite()*2.5));
                p.analogWrite(5,(int)(LumInt.getLuminosite()*2.5));
                p.analogWrite(6,(int)(LumInt.getLuminosite()*2.5));
                if(v.isPosition()==true)
                    p.analogWrite(4,(int)(LumInt.getLuminosite()*2.5));
                i--;
                if (i < 0)
                {
                    p.analogWrite(3, 0);
                    p.analogWrite(4, 0);
                    p.analogWrite(5, 0);
                    p.analogWrite(6, 0);
                    
                    this.cancel();
                }
            }
        };
        
        TimerTask remplissage = new TimerTask()
        {
            @Override
            public void run()
            {
                i++;
                b.setState(!b.getState());
                p.analogWrite(3, (int)(LumInt.getLuminosite()*2.5)); //café
                p.analogWrite(5, (int)(LumInt.getLuminosite()*2.5)); //chauffage
                p.analogWrite(6, (int)(LumInt.getLuminosite()*2.5)); //bain
                if(v.isPosition()==true)
                    p.analogWrite(4,(int)(LumInt.getLuminosite()*2.5)); //volets
                
                if (i > 254)
                {
                    b.setState(false);
                    timer.scheduleAtFixedRate(vide, 0, 500);
                    this.cancel();
                }
            }
        };
        
        timer.scheduleAtFixedRate(remplissage, 0, 10);
    }
}
