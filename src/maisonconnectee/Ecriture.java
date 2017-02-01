/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisonconnectee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 *
 * @author Maxence
 */
public class Ecriture extends JComponent{
    protected String txt;
    protected int taille;
    protected int largeur;
    protected int hauteur;
    
    public Ecriture(String txt, int taille, int largeur, int hauteur) {
        this.txt = txt;
        this.taille = taille;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(largeur,hauteur); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        Font tmp = new Font("Bauhaus 93", Font.PLAIN, taille);
        g.setFont(tmp);
        g.setColor(new Color(84,179,170));
        //g.drawString(txt, (int)(this.getPreferredSize().getWidth()/2 - txt.length()*(1+taille/5)), 42);
        g.drawString(txt, (int)(tmp.getStringBounds(txt, (((Graphics2D)g).getFontRenderContext())).getX()),42);
    }
}
