package Native;


/**
 * 
 *  @author Luis Leal
 */
public interface Calendario extends com.codename1.system.NativeInterface {

	public String obtenerCalendarios();

	public int agregarEventoCalendarioDefault(String strTitulo, String strDescripcion, String strUbicacion, long longInicioMilis, long longInicioEnd);

	public int agregarEventoCalendarioEspecifico(int intIdCalendario, String strTitulo, String strDescripcion, String strUbicacion, long longInicioMilis, long longInicioEnd);
}
