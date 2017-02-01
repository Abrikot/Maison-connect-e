/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maisonconnectee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;

import com.hopding.jrpicam.RPiCamera;
import com.hopding.jrpicam.enums.AWB;
import com.hopding.jrpicam.enums.DRC;
import com.hopding.jrpicam.enums.Encoding;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;


/**
 *
 * @author benja
 */
public class Video {
    RPiCamera piCamera = null;
    private boolean allumer;

    public Video() {
        allumer= false;
        try {
            String saveDir = "/home/pi/Desktop/Image_Intru";
            piCamera = new RPiCamera(saveDir);
        } catch (FailedToRunRaspistillException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void shootStill(RPiCamera piCamera) {
        piCamera.setAWB(AWB.AUTO); //Change Automatic White Balance setting to automatic 
        piCamera.setDRC(DRC.OFF); //Turn off Dynamic Range Compression
        piCamera.setContrast(100); //Set maximum contrast
        piCamera.setSharpness(100); //Set maximum sharpness
        piCamera.setQuality(100); //Set maximum quality
        piCamera.setTimeout(1000); //Wait 1 second to take the image
        piCamera.turnOnPreview(); //Turn on image preview
        piCamera.setEncoding(Encoding.PNG); //Change encoding of images to PNG
        //Take a 650x650 still image and save it as "/home/pi/Desktop/A Cool Picture.png"
        int i = 1;
        while (i<11) {
            try {
                File image = piCamera.takeStill("image" + i + ".png", 650, 650);
                System.out.println("New PNG image saved to:\n\t" + image.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        
    }
    public void allumer()
    {
        allumer = true;
        if (piCamera != null) {
            shootStill(piCamera);
        }
    }
    
    public void eteindre()
    {
        allumer = false;
    }
    
    
}
