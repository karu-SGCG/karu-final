/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import com.entidades.MtArticulos;
import com.entidades.MtMarcas;
import com.entidades.MtProveedores;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Fausto
 */
public class RetornoCombos {
    private void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }
    private Session st;
    
    public MtMarcas retornoMarcaPorDescripcion(String descripcion){
        sessionHibernate();
        MtMarcas tipRet = null;
        try {
            Query query = st.createQuery("From MtMarcas c Where c.nomMarca = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtMarcas)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más marcas de tipo: " + descripcion);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el servicio" + e.getMessage());
        }
        return tipRet;
    }
    
    public MtArticulos retornoArticuloPorDescripcion(String descripcion){
        sessionHibernate();
        MtArticulos tipRet = null;
        try {
            Query query = st.createQuery("From MtArticulos c Where c.nomArticulo = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtArticulos)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más articulos de tipo: " + descripcion);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el servicio" + e.getMessage());
        }
        return tipRet;
    }
    
    public MtProveedores retornoProveedorPorDescripcion(String descripcion){
        sessionHibernate();
        MtProveedores tipRet = null;
        try {
            Query query = st.createQuery("From MtProveedores c Where c.nomTit = ?");
            query.setParameter(0, descripcion);
            try {
                tipRet = (MtProveedores)query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hay más proveedores de tipo: " + descripcion);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en el servicio" + e.getMessage());
        }
        return tipRet;
    }
    
}
