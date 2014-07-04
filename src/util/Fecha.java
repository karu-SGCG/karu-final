package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 * @author Carlos Patino
 */
public class Fecha {

    public String fechaString(Date fecha) {
        String retorno = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (fecha != null) {
                retorno = sdf.format(fecha.getTime());
            } else {
                retorno = "";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha: " + e);
        }
        return retorno;
    }

    public String horaString(Date fecha) {
        String retorno = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            if (fecha != null) {
                retorno = sdf.format(fecha.getTime());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de formato de hora: " + e);
        }
        return retorno;
    }

    public String fechaHoraString(Date fecha) {
        String retorno = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            if (fecha != null) {
                retorno = sdf.format(fecha.getTime());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha: " + e);
        }
        return retorno;
    }

    public Date fechaDate(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date cal = new Date();
        try {
            cal = sdf.parse(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha: " + e);
        }
        return cal;
    }
    
     public Date fechaDate2(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date cal = new Date();
        try {
            cal = sdf.parse(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha: " + e);
        }
        return cal;
    }

    public Date fechaHoraDate(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date cal = new Date();
        try {
            cal = sdf.parse(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha: " + e);
        }
        return cal;
    }

    public Date obtenerFechaSistema() {
        Date cal = new Date();
        return cal;
    }

    //Sumarle dias a una fecha determinada
    //@param fch La fecha para sumarle los dias
    //@param dias Numero de dias a agregar
    //@return La fecha agregando los dias
    public static java.sql.Date sumarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Restarle dias a una fecha determinada
    //@param fch La fecha
    //@param dias Dias a restar
    //@return La fecha restando los dias
    public static synchronized java.sql.Date restarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, -dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas
    public static synchronized int diferenciasDeFechas(Date fechaInicial, Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }
}
