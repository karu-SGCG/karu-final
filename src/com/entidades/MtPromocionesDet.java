package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;

/**
 * MtPromocionesDet generated by hbm2java
 */
public class MtPromocionesDet  implements java.io.Serializable {


     private MtPromocionesDetId id;
     private MtTiposClientes mtTiposClientes;
     private MtPromocionesCab mtPromocionesCab;
     private BigDecimal porcentajeDto;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;

    public MtPromocionesDet() {
    }

	
    public MtPromocionesDet(MtPromocionesDetId id, MtTiposClientes mtTiposClientes, MtPromocionesCab mtPromocionesCab, BigDecimal porcentajeDto) {
        this.id = id;
        this.mtTiposClientes = mtTiposClientes;
        this.mtPromocionesCab = mtPromocionesCab;
        this.porcentajeDto = porcentajeDto;
    }
    public MtPromocionesDet(MtPromocionesDetId id, MtTiposClientes mtTiposClientes, MtPromocionesCab mtPromocionesCab, BigDecimal porcentajeDto, String usuarioMod, String accionMod, Date fechaMod) {
       this.id = id;
       this.mtTiposClientes = mtTiposClientes;
       this.mtPromocionesCab = mtPromocionesCab;
       this.porcentajeDto = porcentajeDto;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
    }
   
    public MtPromocionesDetId getId() {
        return this.id;
    }
    
    public void setId(MtPromocionesDetId id) {
        this.id = id;
    }
    public MtTiposClientes getMtTiposClientes() {
        return this.mtTiposClientes;
    }
    
    public void setMtTiposClientes(MtTiposClientes mtTiposClientes) {
        this.mtTiposClientes = mtTiposClientes;
    }
    public MtPromocionesCab getMtPromocionesCab() {
        return this.mtPromocionesCab;
    }
    
    public void setMtPromocionesCab(MtPromocionesCab mtPromocionesCab) {
        this.mtPromocionesCab = mtPromocionesCab;
    }
    public BigDecimal getPorcentajeDto() {
        return this.porcentajeDto;
    }
    
    public void setPorcentajeDto(BigDecimal porcentajeDto) {
        this.porcentajeDto = porcentajeDto;
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


