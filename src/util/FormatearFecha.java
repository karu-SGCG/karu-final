package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author Carlos Patino
 */
public class FormatearFecha {

    public Date toDate(String fechaStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date date = new Date();
        try {
            //Hacemos la conversión con este procedimiento.
            if (fechaStr.equals("")) {
                date = null;
            } else {
                date = sdf.parse(fechaStr);
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error de formato de fecha: " + e,
                    "Conversion Fechas", JOptionPane.ERROR_MESSAGE);
        }
        return date;
    }

    public String toString(Date fechaDate) {
        String retorno = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (fechaDate != null) {
                retorno = sdf.format(fechaDate);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al convertir fecha. "
                    + ex.getMessage(), "Conversion Fechas", JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }

    public Date getFechaActual() {
        Date date = new Date();
        return date;
    }

    public FormatearFecha(String param) {

    }

    public FormatearFecha() {
    }
}
