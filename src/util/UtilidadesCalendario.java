/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Fausto
 */
public class UtilidadesCalendario {

    public static Calendar StringACalendario(String fecha) {
        //A este método le pasamo como parámetro un String con formato fecha específico
        //y la convierte en objeto Calendar.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Obtenemos una instancia del objeto Calendar.
        Calendar cal = Calendar.getInstance();
        //Utilizamos un try para controlar entrada de datos erroneos.
        try {
            //Hacemos la conversión con este procedimiento.
            cal.setTime(sdf.parse(fecha));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha: " + e);
        }
        return cal;
    }

    public static String FechaActualString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
    }

    public static Date FechaHoraActual() {
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }

    public static String CalendarioAString(Calendar fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Calendar cal = Calendar.getInstance();
        return sdf.format(fecha.getTime());
    }
    
    public static String DateAString(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Calendar cal = Calendar.getInstance();
        return sdf.format(fecha.getTime());
    }    
}
