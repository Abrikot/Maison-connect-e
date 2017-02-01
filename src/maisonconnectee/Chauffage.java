package maisonconnectee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxence
 */
public class Chauffage {
    private boolean etat; //false pour éteint, true pour allumé
    private float temperature; //Indique la température désirée du chauffage

    public void setTemperature(float temperature) {
        if (temperature > 0)
            this.temperature = temperature;
    }

    public float getTemperature() {
        return temperature;
    }
    
    public void allumer()
    {
        etat = true;
    }
    
    public void eteindre()
    {
        etat = false;
    }
    
    public Chauffage ()
    {
        etat = false;
        temperature = 20;
    }
}
