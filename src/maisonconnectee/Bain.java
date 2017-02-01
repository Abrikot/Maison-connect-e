/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisonconnectee;

/**
 *
 * @author Maxence
 */
public class Bain {
    private float temperature;
    private boolean etat; //false pour vide, true pour plein

    public void setTemperature(float temperature) {
        if (temperature > 0)
            this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }
    
    public void remplir()
    {
        etat = true;
    }
    
    public void vider()
    {
        etat = false;
    }
    
    public Bain()
    {
        etat = false;
        temperature = 37;
    }
}
