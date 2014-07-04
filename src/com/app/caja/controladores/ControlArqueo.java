
package com.app.caja.controladores;

import com.entidades.ArqueoCab;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * @author Carlos Patiño
 */
public class ControlArqueo {

    private Session st;

    public ControlArqueo() {
        hibernateSession();
    }

    private void hibernateSession() {
        st = HibernateUtil.getSessionFactory().openSession();
    }
    
    public ArqueoCab estadoCaja(String caja, Date fecha, char estado){
        ArqueoCab retorno = null;
        try {
            //A: abierto, C:cerrado
            Query query = st.createQuery("From ArqueoCab a Where date(a.fechaDesde) = date(?) "
                                     + " and a.codCaja = ? and a.estado = ?");
            query.setParameter(0, fecha);
            query.setParameter(1, caja);
            query.setParameter(2, estado);
            
            retorno = (ArqueoCab) query.uniqueResult();

        } catch (NonUniqueResultException nex) {
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar habilitación de caja."
                    + "\n" + ex.getMessage(), "Arqueo de Caja", JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }
}
