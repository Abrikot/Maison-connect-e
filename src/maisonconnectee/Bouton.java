/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisonconnectee;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Maxence
 */
public class Bouton extends JLabel{
    private final int width;
    private final int height;
    
    
    public Bouton(String file, int width, int height)
    {
        this.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/data/" + file)).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
        this.width = width;
        this.height = height;
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(width,height);
    }
}
