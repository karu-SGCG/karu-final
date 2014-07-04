package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;

/**
 * MovValores generated by hbm2java
 */
public class MovValores  implements java.io.Serializable {

     private int nroOperacion;
     private Caja caja;
     private MtMonedas mtMonedas;
     private MtBancos mtBancos;
     //private TsBancosCtas tsBancosCtas;
     private String nroCtaCte;
     private Date fechaOper;
     private Integer refDeposito;
     private BigDecimal totalDepositado;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;

    public MovValores() {
    }

	
    public MovValores(int nroOperacion) {
        this.nroOperacion = nroOperacion;
    }
    public MovValores(int nroOperacion, Caja caja, MtMonedas mtMonedas, MtBancos mtBancos, TsBancosCtas tsBancosCtas, Date fechaOper, Integer refDeposito, BigDecimal totalDepositado, String usuarioMod, String accionMod, Date fechaMod) {
       this.nroOperacion = nroOperacion;
       this.caja = caja;
       this.mtMonedas = mtMonedas;
       this.mtBancos = mtBancos;
       //this.tsBancosCtas = tsBancosCtas;
       this.fechaOper = fechaOper;
       this.refDeposito = refDeposito;
       this.totalDepositado = totalDepositado;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
    }
   
    public int getNroOperacion() {
        return this.nroOperacion;
    }
    
    public void setNroOperacion(int nroOperacion) {
        this.nroOperacion = nroOperacion;
    }
    public Caja getCaja() {
        return this.caja;
    }
    
    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    public MtMonedas getMtMonedas() {
        return this.mtMonedas;
    }
    
    public void setMtMonedas(MtMonedas mtMonedas) {
        this.mtMonedas = mtMonedas;
    }
    public MtBancos getMtBancos() {
        return this.mtBancos;
    }
    
    public void setMtBancos(MtBancos mtBancos) {
        this.mtBancos = mtBancos;
    }
   // public TsBancosCtas getTsBancosCtas() {
       // return this.tsBancosCtas;
    //}
    
    //public void setTsBancosCtas(TsBancosCtas tsBancosCtas) {
      //  this.tsBancosCtas = tsBancosCtas;
   // }
    public Date getFechaOper() {
        return this.fechaOper;
    }
    
    public void setFechaOper(Date fechaOper) {
        this.fechaOper = fechaOper;
    }
    public Integer getRefDeposito() {
        return this.refDeposito;
    }
    
    public void setRefDeposito(Integer refDeposito) {
        this.refDeposito = refDeposito;
    }
    public BigDecimal getTotalDepositado() {
        return this.totalDepositado;
    }
    
    public void setTotalDepositado(BigDecimal totalDepositado) {
        this.totalDepositado = totalDepositado;
    }
    public String getUsuarioMod() {
        return this.usuarioMod;
    }
    
    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }
    public String getAccionMod() {
        return this.accionMod;
    }
    
    public void setAccionMod(String accionMod) {
        this.accionMod = accionMod;
    }
    public Date getFechaMod() {
        return this.fechaMod;
    }
    
    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    public String getNroCtaCte() {
        return nroCtaCte;
    }

    public void setNroCtaCte(String nroCtaCte) {
        this.nroCtaCte = nroCtaCte;
    }
}


