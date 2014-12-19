package Native;

import java.util.TimeZone;
import android.app.Activity;
import android.net.Uri;
import android.database.Cursor;
import android.provider.CalendarContract.Calendars;
import android.content.ContentResolver;
import com.codename1.ui.Dialog;
import android.content.ContentValues;
import android.provider.CalendarContract.Events;

public class CalendarioImpl {
    
    public static final String[] EVENT_PROJECTION = new String[] {
            Calendars._ID,                           //0
            Calendars.NAME,                          //1
            Calendars.OWNER_ACCOUNT,                 //2
            Calendars.ACCOUNT_TYPE,                  //3
            Calendars.ACCOUNT_NAME,                  //4
            Calendars.CALENDAR_DISPLAY_NAME         //5
        };
        
        private static final int PROJECTION_ID_INDEX = 0;
        private static final int PROJECTION_NAME_INDEX = 1;
        private static final int PROJECTION_OWNER_ACCOUNT_INDEX = 2;
        private static final int PROJECTION_ACCOUNT_TYPE_INDEX = 3;
        private static final int PROJECTION_ACCOUNT_NAME_INDEX = 4;
        private static final int PROJECTION_CALENDAR_DISPLAY_NAME_INDEX = 5;
        
    public String obtenerCalendarios() {
        
        String strCalendarios="";
        Activity activity = com.codename1.impl.android.AndroidNativeUtil.getActivity();
        ContentResolver contentResolver = activity.getContentResolver();
        
        Uri calendarios  = Calendars.CONTENT_URI;
        Cursor cursor = contentResolver.query(calendarios,EVENT_PROJECTION,null,null,null);
        
        while(cursor.moveToNext())
        {
            strCalendarios+=cursor.getString(PROJECTION_ID_INDEX)+"|"+cursor.getString(PROJECTION_ACCOUNT_NAME_INDEX)+":"+cursor.getString(PROJECTION_NAME_INDEX)+"\n";
        }
        
        return strCalendarios;
    }

    
    
    public int agregarEventoCalendarioDefault(String param, String param1, String param2, long param3, long param4) {
        int intIdNuevoEvento = -1;
        

        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        
        values.put(Events.DTSTART, param3);
        values.put(Events.DTEND, param4);
        values.put(Events.TITLE, param);
        values.put(Events.DESCRIPTION,param1);
        values.put(Events.CALENDAR_ID, 1);
        values.put(Events.EVENT_TIMEZONE, TimeZone.getDefault().getID());
        values.put(Events.EVENT_LOCATION, param2);
        Uri uri = cr.insert(Events.CONTENT_URI, values);

        intIdNuevoEvento= (int)Long.parseLong(uri.getLastPathSegment());
        
        return intIdNuevoEvento;
    }

    public int agregarEventoCalendarioEspecifico(int param, String param1, String param2, String param3, long param4, long param5) {
        return 0;
    }

    

    public boolean isSupported() {
        return true;
    }

}
