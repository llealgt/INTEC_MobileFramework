/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geographics;

import com.codename1.maps.Coord;
import com.codename1.maps.MapComponent;
import com.codename1.maps.layers.PointLayer;
import com.codename1.maps.layers.PointsLayer;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Luis Leal
 */
public class Lugar {
    private double doubleLongitud;
    private double doubleLatitud;
    private String strNombre;
    
    public Lugar(double doubleLongitud, double doubleLatitud) {
        this.doubleLongitud = doubleLongitud;
        this.doubleLatitud = doubleLatitud;
    }

    public double getDoubleLongitud() {
        return doubleLongitud;
    }

    public void setDoubleLongitud(double doubleLongitud) {
        this.doubleLongitud = doubleLongitud;
    }

    public double getDoubleLatitud() {
        return doubleLatitud;
    }

    public void setDoubleLatitud(double doubleLatitud) {
        this.doubleLatitud = doubleLatitud;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }
    
    public Lugar(Hashtable registro)
    {
        
    }
    
    public static Vector<Lugar> obtenerLugaresDesdeJSON(Vector resultadoJSON)
    {
        Vector <Lugar> vector = new Vector();
        
        //llenado actual para pruebas,sustitiur con uso de web service
        vector.add(new Lugar(-90.507411,14.5984,"Taco Bell Zona 10"));
        vector.add(new Lugar(-90.522908,14.586075,"Wendy's Zona 13"));
        vector.add(new Lugar(-90.520107,14.598896,"Kentuky Zona 9"));
        vector.add(new Lugar(-90.5532851817406,14.6235204153361,"TIkal Futura"));
        vector.add(new Lugar(-90.516379,14.595669,"Obelisco"));
        return vector;
    }

    public Lugar(double doubleLongitud, double doubleLatitud, String strNombre) {
        this.doubleLongitud = doubleLongitud;
        this.doubleLatitud = doubleLatitud;
        this.strNombre = strNombre;
    }
    
    public static  void ubicarLugaresEnMapa(Vector <Lugar> lugares,MapComponent mapa)
    {
        try
        {
            Image image = Image.createImage("/blue_pin.png");
            PointsLayer capa = new PointsLayer();
            capa.setPointIcon(image);
            
            for(Lugar lugar:lugares)
            {
                Coord coordenada = new Coord(lugar.getDoubleLatitud(),lugar.getDoubleLongitud());
                PointLayer punto = new PointLayer(coordenada,lugar.getStrNombre(),null);
                punto.setDisplayName(true);
                capa.addPoint(punto);
            }
            
            
            mapa.addLayer(capa);
            mapa.zoomToLayers();
            
            
        }
        catch(Exception err)
        {
            Dialog.show("ocurrio error", err.getMessage(), "Ok", "Cancelar");
        }
        
    }
}
