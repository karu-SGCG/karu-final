/*
    Clase que permite la conversion y formateo de valores numericos.
*/
package util;

import java.math.BigDecimal;

/**
 * @author Carlos Patiño
 */
public class FormatearNumero {
    
    public FormatearNumero(){}
    
    public BigDecimal toDecimal(String valor) {
        BigDecimal retorno = BigDecimal.ZERO;
        //si no esta vacio entonces
        if (!valor.isEmpty()) {
            // primero elimina los puntos y luego remplaza las comas en puntos.
            String formatoValido = valor.replace(".", "").replace(",", ".");
            retorno = new BigDecimal(formatoValido);
        }
        return retorno;
    }
    
    public String toNumerico(BigDecimal valor) {
        String retorno = "";
            String formatoValido = valor.toString().replace(",", "").replace(".", ",");
            retorno = formatoValido;
        return retorno;
    }
}
