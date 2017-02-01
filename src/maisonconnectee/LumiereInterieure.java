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
public class LumiereInterieure {
    private boolean etat;
    private int luminosite;
    
    public void allumer()
    {
        etat = true;
    }
    
    public void eteindre()
    {
        etat = false;
    }

    public int getLuminosite() {
        return luminosite;
    }

    public void setLuminosite(int luminosite) {
        this.luminosite = luminosite;
    }
    
    public LumiereInterieure()
    {
        etat = false;
        this.luminosite = 80;
    }
}
