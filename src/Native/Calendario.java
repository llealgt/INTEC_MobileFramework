/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Native;

import com.codename1.system.NativeInterface;

/**
 *
 * @author Luis Leal
 */
public interface Calendario extends NativeInterface {
    
    public String obtenerCalendarios();
    public int agregarEventoCalendarioDefault(String strTitulo,String strDescripcion,String strUbicacion,long longInicioMilis,long longInicioEnd);
    public int agregarEventoCalendarioEspecifico(int intIdCalendario,String strTitulo,String strDescripcion,String strUbicacion,long longInicioMilis,long longInicioEnd);
}
