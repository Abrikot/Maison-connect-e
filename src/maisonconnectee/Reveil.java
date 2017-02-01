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
public class Reveil {
    private int heureSemaine; //Sous la forme HHMM
    private int heureWeekEnd; //Sous la forme HHMM

    public void setHeureSemaine(int heureSemaine) {
        this.heureSemaine = heureSemaine;
    }

    public void setHeureWeekEnd(int heureWeekEnd) {
        this.heureWeekEnd = heureWeekEnd;
    }

    public int getHeureSemaine() {
        return heureSemaine;
    }

    public int getHeureWeekEnd() {
        return heureWeekEnd;
    }
    
    public Reveil()
    {
        heureSemaine = 700;
        heureWeekEnd = 1100;
    }
}
