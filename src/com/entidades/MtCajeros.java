package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * MtCajeros generated by hbm2java
 */
public class MtCajeros  implements java.io.Serializable {


     private int nroTrans;
     private Caja caja;
     private MtSucursales mtSucursales;
     private MtUsuarios mtUsuarios;
     private Character activo;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;

    public MtCajeros() {
    }

	
    public MtCajeros(int nroTrans) {
        this.nroTrans = nroTrans;
    }
    public MtCajeros(int nroTrans, Caja caja, MtSucursales mtSucursales, MtUsuarios mtUsuarios, Character activo, String usuarioMod, String accionMod, Date fechaMod) {
       this.nroTrans = nroTrans;
       this.caja = caja;
       this.mtSucursales = mtSucursales;
       this.mtUsuarios = mtUsuarios;
       this.activo = activo;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
    }
   
    public int getNroTrans() {
        return this.nroTrans;
    }
    
    public void setNroTrans(int nroTrans) {
        this.nroTrans = nroTrans;
    }
    public Caja getCaja() {
        return this.caja;
    }
    
    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    public MtSucursales getMtSucursales() {
        return this.mtSucursales;
    }
    
    public void setMtSucursales(MtSucursales mtSucursales) {
        this.mtSucursales = mtSucursales;
    }
    public MtUsuarios getMtUsuarios() {
        return this.mtUsuarios;
    }
    
    public void setMtUsuarios(MtUsuarios mtUsuarios) {
        this.mtUsuarios = mtUsuarios;
    }
    public Character getActivo() {
        return this.activo;
    }
    
    public void setActivo(Character activo) {
        this.activo = activo;
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


