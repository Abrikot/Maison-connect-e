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
public class Background extends JLabel{
    public Background(String file)
    {
        super();
        this.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/data/" + file)).getImage().getScaledInstance(752, 448, Image.SCALE_DEFAULT)));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(752,448);
    }
    
    
}
