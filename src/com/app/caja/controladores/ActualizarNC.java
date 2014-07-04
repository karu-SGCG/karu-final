
package com.app.caja.controladores;

import com.entidades.FacturaVenta;
import com.entidades.SaPendientes;
import java.math.BigDecimal;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 * @author Carlos Patiño
 */
public class ActualizarNC {

    private Session sta;
    private int trans;
    private BigDecimal importe;

    public ActualizarNC() {
       iniciar();
    }
    
    public ActualizarNC(int trans){
       this.trans = trans;
        iniciar();
        actualizar();
    }
    
     public void actualizarNC(int trans, BigDecimal importe){
       this.trans = trans;
       this.importe = importe;
        iniciar();
        actualizar();
    }

    private void iniciar(){
       hibernateSession();
    }
    
    private void hibernateSession() {
        sta = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void actualizar(){
        try {
            
            FacturaVenta nc = obtenerNC();
            SaPendientes saldoNc = obtenerSaldo(nc);
            BigDecimal saldo = saldoNc.getSaldo();
            
            this.sta.beginTransaction();
            saldoNc.setSaldo(saldo.subtract(importe));
            this.sta.update(saldoNc);
            this.sta.getTransaction().commit();
            
        } catch (Exception e) {
            this.sta.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    
    public FacturaVenta obtenerNC(){
        FacturaVenta fac = new FacturaVenta();
        try{  
            fac = (FacturaVenta) sta.get(FacturaVenta.class, this.trans);
        }catch (Exception e){
            e.printStackTrace();
        }
        return fac;
    }
    
    public SaPendientes obtenerSaldo(FacturaVenta nc) {
        SaPendientes retorno = new SaPendientes();
        try {

            Query query = sta.createQuery("From SaPendientes p Where p.codTit = ? "
                    + " and p.codDocum = ? and p.codSucFac = ? "
                    + " and p.codTributFac = ? and p.nroDocum = ? ");
            query.setParameter(0, nc.getMtClientes().getCodTit());
            query.setParameter(1, nc.getMtTipoComprobantes().getCodComp());
            query.setParameter(2, nc.getCodSucFac());
            query.setParameter(3, nc.getCodTributFac());
            query.setParameter(4, nc.getNroDocum());

            retorno = (SaPendientes) query.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
}
