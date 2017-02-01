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
public class MotDePasse {
    private String mdp;

    public MotDePasse(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public boolean setMdp(String mdp) {
        if (mdp.length() > 3)
        {
            this.mdp = mdp;
            return true;
        }
        return false;
    }
    
    public boolean compareMdp(String mdp)
    {
        if (mdp.equals(this.mdp))
            return true;
        return false;
    }
}
