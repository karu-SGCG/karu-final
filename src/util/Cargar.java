/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/* @author Fausto */

import com.entidades.MtClientes;
import com.entidades.TiposCambios;
import com.entidades.TiposCambiosId;
import java.awt.HeadlessException;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

public class Cargar {

    private Session st;

    private void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }

    public Object resultadoUnico(String QuerySql, Class tipo) {
        sessionHibernate();
        Object retorno = null;
        try {
            try {
                SQLQuery consulta = st.createSQLQuery(QuerySql);
                consulta.addEntity(tipo);
                retorno = consulta.uniqueResult();
                if (retorno == null) {
                    JOptionPane.showMessageDialog(null, "La sentencia no ha retornado ningun valor.",
                            "Aviso", JOptionPane.ERROR_MESSAGE);
                }
            } catch (HibernateException ex) {
                JOptionPane.showMessageDialog(null, "La sentencia Select ha retornado mas de un valor. " + "\n" +  ex.getMessage(),
                        "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error." + ex.getMessage(),
                    "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }
    
    public BigDecimal buscarTipoCambio(Date fecha, int codMoneda, char tipo) {
        BigDecimal retorno = BigDecimal.ZERO;
        if (codMoneda != 1) {
            sessionHibernate();
            TiposCambiosId id = new TiposCambiosId(fecha, codMoneda);
            try {
                TiposCambios tipoCambio = (TiposCambios) st.get(TiposCambios.class, id);
                if (tipoCambio == null) {
                    JOptionPane.showMessageDialog(null, "No existe tipo de cambio para la fecha. ", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (tipo == 'C' || tipo == 'c') {
                        retorno = tipoCambio.getTipoCompra();
                    } else {
                        retorno = tipoCambio.getTipoVenta();
                    }
                }
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "[1]Ha ocurrido un error al recuperar el registro. " + "\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "[2]Ha ocurrido un error al recuperar el registro. " + "\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            retorno = BigDecimal.ONE;
        }
        return retorno;
    }
    
    public BigDecimal buscarDescuento(String cod_cliente, Integer cod_forma_pago, Date fecha) {
        BigDecimal retorno = BigDecimal.ZERO;

        sessionHibernate();
        String consulta = "From MtClientes Where nroDocum = :nro_docum";
        Query query = st.createQuery(consulta);
        query.setParameter("nro_docum", cod_cliente);
        MtClientes objCliente = (MtClientes) query.uniqueResult();

        if (objCliente == null) {
            JOptionPane.showMessageDialog(null, "No existe el código del cliente", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String consulta1 = "select max(b.porcentaje_dto) from mt_promociones_cab a inner join mt_promociones_det b on a.id_promo = b.id_promo "
                    + "where a.esta_activo = 'S' and a.cod_forma_pago = :cod_forma_pago"
                    + " and (a.es_por_fecha = 'N' or (a.fecha_inicio >= :fecha1 and fecha_fin <= :fecha2))"
                    + " and b.cod_tipo_cliente = :cod_tipo_cliente";

            SQLQuery query2 = st.createSQLQuery(consulta1);
            query2.setParameter("cod_forma_pago", cod_forma_pago);
            query2.setParameter("fecha1", fecha);
            query2.setParameter("fecha2", fecha);
            query2.setParameter("cod_tipo_cliente", objCliente.getMtTiposClientes().getCodTipoCliente());

            Object descuento = query2.uniqueResult();
            if (descuento != null) {
                retorno = new BigDecimal(descuento.toString());
            }
        }
        return retorno;
    }
    
    
}
