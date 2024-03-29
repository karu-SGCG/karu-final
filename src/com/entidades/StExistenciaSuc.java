package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;

/**
 * StExistenciaSuc generated by hbm2java
 */
public class StExistenciaSuc  implements java.io.Serializable {


     private StExistenciaSucId id;
     private MtEmpresas mtEmpresas;
     private MtArticulos mtArticulos;
     private MtSucursales mtSucursales;
     private MtEstadosArt mtEstadosArt;
     private BigDecimal cantidad;
     private BigDecimal stockMinimo;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;

    public StExistenciaSuc() {
    }

	
    public StExistenciaSuc(StExistenciaSucId id, MtEmpresas mtEmpresas, MtArticulos mtArticulos, MtSucursales mtSucursales, MtEstadosArt mtEstadosArt, BigDecimal cantidad, BigDecimal stockMinimo) {
        this.id = id;
        this.mtEmpresas = mtEmpresas;
        this.mtArticulos = mtArticulos;
        this.mtSucursales = mtSucursales;
        this.mtEstadosArt = mtEstadosArt;
        this.cantidad = cantidad;
        this.stockMinimo = stockMinimo;
    }
    public StExistenciaSuc(StExistenciaSucId id, MtEmpresas mtEmpresas, MtArticulos mtArticulos, MtSucursales mtSucursales, MtEstadosArt mtEstadosArt, BigDecimal cantidad, BigDecimal stockMinimo, String usuarioMod, String accionMod, Date fechaMod) {
       this.id = id;
       this.mtEmpresas = mtEmpresas;
       this.mtArticulos = mtArticulos;
       this.mtSucursales = mtSucursales;
       this.mtEstadosArt = mtEstadosArt;
       this.cantidad = cantidad;
       this.stockMinimo = stockMinimo;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
    }
   
    public StExistenciaSucId getId() {
        return this.id;
    }
    
    public void setId(StExistenciaSucId id) {
        this.id = id;
    }
    public MtEmpresas getMtEmpresas() {
        return this.mtEmpresas;
    }
    
    public void setMtEmpresas(MtEmpresas mtEmpresas) {
        this.mtEmpresas = mtEmpresas;
    }
    public MtArticulos getMtArticulos() {
        return this.mtArticulos;
    }
    
    public void setMtArticulos(MtArticulos mtArticulos) {
        this.mtArticulos = mtArticulos;
    }
    public MtSucursales getMtSucursales() {
        return this.mtSucursales;
    }
    
    public void setMtSucursales(MtSucursales mtSucursales) {
        this.mtSucursales = mtSucursales;
    }
    public MtEstadosArt getMtEstadosArt() {
        return this.mtEstadosArt;
    }
    
    public void setMtEstadosArt(MtEstadosArt mtEstadosArt) {
        this.mtEstadosArt = mtEstadosArt;
    }
    public BigDecimal getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getStockMinimo() {
        return this.stockMinimo;
    }
    
    public void setStockMinimo(BigDecimal stockMinimo) {
        this.stockMinimo = stockMinimo;
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


