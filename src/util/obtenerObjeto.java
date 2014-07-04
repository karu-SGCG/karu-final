
package util;

import org.hibernate.Session;

/**
 *
 * @author carlitox
 */
public class obtenerObjeto {
     private Session st;

    private void sessionHibernate() {
        st = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Object retornar(){
      return null;  
    }
}
