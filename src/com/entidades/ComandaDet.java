package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;

/**
 * ComandaDet generated by hbm2java
 */
public class ComandaDet  implements java.io.Serializable {


     private ComandaDetId id;
     private ComandaCab comandaCab;
     private Character estado;
     private String codArticulo;
     private BigDecimal cantidad;
     private BigDecimal subtotal;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;

    public ComandaDet() {
    }

	
    public ComandaDet(ComandaDetId id, ComandaCab comandaCab, String codArticulo, BigDecimal cantidad, BigDecimal subtotal) {
        this.id = id;
        this.comandaCab = comandaCab;
        this.codArticulo = codArticulo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    public ComandaDet(ComandaDetId id, ComandaCab comandaCab, Character estado, String codArticulo, BigDecimal cantidad, BigDecimal subtotal, String usuarioMod, String accionMod, Date fechaMod) {
       this.id = id;
       this.comandaCab = comandaCab;
       this.estado = estado;
       this.codArticulo = codArticulo;
       this.cantidad = cantidad;
       this.subtotal = subtotal;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
    }
   
    public ComandaDetId getId() {
        return this.id;
    }
    
    public void setId(ComandaDetId id) {
        this.id = id;
    }
    public ComandaCab getComandaCab() {
        return this.comandaCab;
    }
    
    public void setComandaCab(ComandaCab comandaCab) {
        this.comandaCab = comandaCab;
    }
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    public String getCodArticulo() {
        return this.codArticulo;
    }
    
    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }
    public BigDecimal getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getSubtotal() {
        return this.subtotal;
    }
    
    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
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


