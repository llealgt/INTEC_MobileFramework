/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Devices;

import com.codename1.capture.Capture;
import com.codename1.ui.events.ActionListener;

/**
 *Clase utilizada en el manejo de la camara
 * @author Luis Leal
 */
public class Camara {
    
    //variable que determina si el dispositivo tiene camara disponible
    private static boolean boolTieneCamara;
    
    static
    {
        boolTieneCamara = Capture.hasCamera();
    }
    
    /**
     * Funcion que toma una foto
     * @return ubicacion de la foto dentro del dispositivo,null si no se toma foto
     */
    public static String tomarFoto()
    {
        String strUbicacion=null;
        
        if(boolTieneCamara)
        {
            strUbicacion = Capture.capturePhoto();
        }
        
        return strUbicacion;
    }
    
    
}
