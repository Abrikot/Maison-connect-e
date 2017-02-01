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
public class LumiereExterieure {
    private boolean etat;
    
    public void allumer()
    {
        etat = true;
    }
    
    public void eteindre()
    {
        etat = false;
    }
    
    public LumiereExterieure()
    {
        etat = false;
    }
}
