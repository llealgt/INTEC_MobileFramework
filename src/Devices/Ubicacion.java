/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Devices;

import com.codename1.location.Location;
import com.codename1.location.LocationManager;
import java.io.IOException;

/**
 *Clase utilizada para el manejo de servicios de ubicacion GPS
 * @author Luis Leal
 */
public class Ubicacion {
    
    public Location obtenerUbicacionActual() throws IOException 
    {
        return LocationManager.getLocationManager().getCurrentLocation();
    }
}
