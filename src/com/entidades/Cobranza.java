package com.entidades;
// Generated 11/05/2014 07:53:35 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Cobranza generated by hbm2java
 */
public class Cobranza  implements java.io.Serializable {


     private int nroRecibo;
     private Caja caja;
     private String codCliente;
     private Date fecha;
     private int formaPago;
     private char estado;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;

    public Cobranza() {
    }

	
    public Cobranza(int nroRecibo, Caja caja, String codCliente, Date fecha, int formaPago) {
        this.nroRecibo = nroRecibo;
        this.caja = caja;
        this.codCliente = codCliente;
        this.fecha = fecha;
        this.formaPago = formaPago;
    }
    public Cobranza(int nroRecibo, Caja caja, String codCliente, Date fecha, int formaPago, String usuarioMod, String accionMod, Date fechaMod) {
       this.nroRecibo = nroRecibo;
       this.caja = caja;
       this.codCliente = codCliente;
       this.fecha = fecha;
       this.formaPago = formaPago;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
    }
   
    public int getNroRecibo() {
        return this.nroRecibo;
    }
    
    public void setNroRecibo(int nroRecibo) {
        this.nroRecibo = nroRecibo;
    }
    public Caja getCaja() {
        return this.caja;
    }
    
    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    public String getCodCliente() {
        return this.codCliente;
    }
    
    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getFormaPago() {
        return this.formaPago;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
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




}

