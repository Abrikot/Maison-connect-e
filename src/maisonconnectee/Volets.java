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
public class Volets {
    private boolean position; // false = fermés, true = ouverts
    
    public void ouvrir()
    {
        position = true;
    }
    
    public void fermer()
    {
        position = false;
    }

    public Volets()
    {
    position = false;
    }

    public boolean isPosition() {
        return position;
    }
    
}
