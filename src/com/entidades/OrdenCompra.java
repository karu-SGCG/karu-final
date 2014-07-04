package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OrdenCompra generated by hbm2java
 */
public class OrdenCompra  implements java.io.Serializable {


     private int nroOcompra;
     private MtProveedores mtProveedores;
     private Date fecha;
     private BigDecimal total;
     private char estado;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set ordCompraDets = new HashSet(0);
     private Set ordCompraDets_1 = new HashSet(0);

    public OrdenCompra() {
    }

	
    public OrdenCompra(int nroOcompra, MtProveedores mtProveedores, Date fecha, BigDecimal total, char estado) {
        this.nroOcompra = nroOcompra;
        this.mtProveedores = mtProveedores;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }
    public OrdenCompra(int nroOcompra, MtProveedores mtProveedores, Date fecha, BigDecimal total, char estado, String usuarioMod, String accionMod, Date fechaMod, Set ordCompraDets, Set ordCompraDets_1) {
       this.nroOcompra = nroOcompra;
       this.mtProveedores = mtProveedores;
       this.fecha = fecha;
       this.total = total;
       this.estado = estado;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.ordCompraDets = ordCompraDets;
       this.ordCompraDets_1 = ordCompraDets_1;
    }
   
    public int getNroOcompra() {
        return this.nroOcompra;
    }
    
    public void setNroOcompra(int nroOcompra) {
        this.nroOcompra = nroOcompra;
    }
    public MtProveedores getMtProveedores() {
        return this.mtProveedores;
    }
    
    public void setMtProveedores(MtProveedores mtProveedores) {
        this.mtProveedores = mtProveedores;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public char getEstado() {
        return this.estado;
    }
    
    public void setEstado(char estado) {
        this.estado = estado;
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
    public Set getOrdCompraDets() {
        return this.ordCompraDets;
    }
    
    public void setOrdCompraDets(Set ordCompraDets) {
        this.ordCompraDets = ordCompraDets;
    }
    public Set getOrdCompraDets_1() {
        return this.ordCompraDets_1;
    }
    
    public void setOrdCompraDets_1(Set ordCompraDets_1) {
        this.ordCompraDets_1 = ordCompraDets_1;
    }




}


