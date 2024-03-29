package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ComandaCab generated by hbm2java
 */
public class ComandaCab  implements java.io.Serializable {


     private int nroComanda;
     private MtClientes mtClientes;
     private short nroMesa;
     private Date fecha;
     private Character estado;
     private BigDecimal total;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set comandaDets = new HashSet(0);
     private Set comandaDets_1 = new HashSet(0);

    public ComandaCab() {
    }

	
    public ComandaCab(int nroComanda, short nroMesa, Date fecha, BigDecimal total) {
        this.nroComanda = nroComanda;
        this.nroMesa = nroMesa;
        this.fecha = fecha;
        this.total = total;
    }
    public ComandaCab(int nroComanda, MtClientes mtClientes, short nroMesa, Date fecha, Character estado, BigDecimal total, String usuarioMod, String accionMod, Date fechaMod, Set comandaDets, Set comandaDets_1) {
       this.nroComanda = nroComanda;
       this.mtClientes = mtClientes;
       this.nroMesa = nroMesa;
       this.fecha = fecha;
       this.estado = estado;
       this.total = total;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.comandaDets = comandaDets;
       this.comandaDets_1 = comandaDets_1;
    }
   
    public int getNroComanda() {
        return this.nroComanda;
    }
    
    public void setNroComanda(int nroComanda) {
        this.nroComanda = nroComanda;
    }
    public MtClientes getMtClientes() {
        return this.mtClientes;
    }
    
    public void setMtClientes(MtClientes mtClientes) {
        this.mtClientes = mtClientes;
    }
    public short getNroMesa() {
        return this.nroMesa;
    }
    
    public void setNroMesa(short nroMesa) {
        this.nroMesa = nroMesa;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
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
    public Set getComandaDets() {
        return this.comandaDets;
    }
    
    public void setComandaDets(Set comandaDets) {
        this.comandaDets = comandaDets;
    }
    public Set getComandaDets_1() {
        return this.comandaDets_1;
    }
    
    public void setComandaDets_1(Set comandaDets_1) {
        this.comandaDets_1 = comandaDets_1;
    }




}


