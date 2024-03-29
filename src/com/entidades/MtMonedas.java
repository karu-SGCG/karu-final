package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MtMonedas generated by hbm2java
 */
public class MtMonedas  implements java.io.Serializable {


     private int codMoneda;
     private String nomMoneda;
     private String simbolo;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set presupuestoCabs = new HashSet(0);
     private Set facturaVentas = new HashSet(0);
     private Set arqueoDets = new HashSet(0);
     private Set tsBancosCtases = new HashSet(0);
     private Set movValoreses = new HashSet(0);
     private Set tiposCambioses = new HashSet(0);
     private Set mtArticulosesForCodMonedaVenta = new HashSet(0);
     private Set mtArticulosesForCodMonedaCompra = new HashSet(0);
     private Set mtArticulosesForCodMonedaVenta_1 = new HashSet(0);
     private Set mtArticulosesForCodMonedaCompra_1 = new HashSet(0);
     private Set facturaCompras = new HashSet(0);

    public MtMonedas() {
    }

	
    public MtMonedas(int codMoneda, String nomMoneda, String simbolo) {
        this.codMoneda = codMoneda;
        this.nomMoneda = nomMoneda;
        this.simbolo = simbolo;
    }
    public MtMonedas(int codMoneda, String nomMoneda, String simbolo, String usuarioMod, String accionMod, Date fechaMod, Set presupuestoCabs, Set facturaVentas, Set arqueoDets, Set tsBancosCtases, Set movValoreses, Set tiposCambioses, Set mtArticulosesForCodMonedaVenta, Set mtArticulosesForCodMonedaCompra, Set mtArticulosesForCodMonedaVenta_1, Set mtArticulosesForCodMonedaCompra_1, Set facturaCompras) {
       this.codMoneda = codMoneda;
       this.nomMoneda = nomMoneda;
       this.simbolo = simbolo;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.presupuestoCabs = presupuestoCabs;
       this.facturaVentas = facturaVentas;
       this.arqueoDets = arqueoDets;
       this.tsBancosCtases = tsBancosCtases;
       this.movValoreses = movValoreses;
       this.tiposCambioses = tiposCambioses;
       this.mtArticulosesForCodMonedaVenta = mtArticulosesForCodMonedaVenta;
       this.mtArticulosesForCodMonedaCompra = mtArticulosesForCodMonedaCompra;
       this.mtArticulosesForCodMonedaVenta_1 = mtArticulosesForCodMonedaVenta_1;
       this.mtArticulosesForCodMonedaCompra_1 = mtArticulosesForCodMonedaCompra_1;
       this.facturaCompras = facturaCompras;
    }
   
    public int getCodMoneda() {
        return this.codMoneda;
    }
    
    public void setCodMoneda(int codMoneda) {
        this.codMoneda = codMoneda;
    }
    public String getNomMoneda() {
        return this.nomMoneda;
    }
    
    public void setNomMoneda(String nomMoneda) {
        this.nomMoneda = nomMoneda;
    }
    public String getSimbolo() {
        return this.simbolo;
    }
    
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
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
    public Set getPresupuestoCabs() {
        return this.presupuestoCabs;
    }
    
    public void setPresupuestoCabs(Set presupuestoCabs) {
        this.presupuestoCabs = presupuestoCabs;
    }
    public Set getFacturaVentas() {
        return this.facturaVentas;
    }
    
    public void setFacturaVentas(Set facturaVentas) {
        this.facturaVentas = facturaVentas;
    }
    public Set getArqueoDets() {
        return this.arqueoDets;
    }
    
    public void setArqueoDets(Set arqueoDets) {
        this.arqueoDets = arqueoDets;
    }
    public Set getTsBancosCtases() {
        return this.tsBancosCtases;
    }
    
    public void setTsBancosCtases(Set tsBancosCtases) {
        this.tsBancosCtases = tsBancosCtases;
    }
    public Set getMovValoreses() {
        return this.movValoreses;
    }
    
    public void setMovValoreses(Set movValoreses) {
        this.movValoreses = movValoreses;
    }
    public Set getTiposCambioses() {
        return this.tiposCambioses;
    }
    
    public void setTiposCambioses(Set tiposCambioses) {
        this.tiposCambioses = tiposCambioses;
    }
    public Set getMtArticulosesForCodMonedaVenta() {
        return this.mtArticulosesForCodMonedaVenta;
    }
    
    public void setMtArticulosesForCodMonedaVenta(Set mtArticulosesForCodMonedaVenta) {
        this.mtArticulosesForCodMonedaVenta = mtArticulosesForCodMonedaVenta;
    }
    public Set getMtArticulosesForCodMonedaCompra() {
        return this.mtArticulosesForCodMonedaCompra;
    }
    
    public void setMtArticulosesForCodMonedaCompra(Set mtArticulosesForCodMonedaCompra) {
        this.mtArticulosesForCodMonedaCompra = mtArticulosesForCodMonedaCompra;
    }
    public Set getMtArticulosesForCodMonedaVenta_1() {
        return this.mtArticulosesForCodMonedaVenta_1;
    }
    
    public void setMtArticulosesForCodMonedaVenta_1(Set mtArticulosesForCodMonedaVenta_1) {
        this.mtArticulosesForCodMonedaVenta_1 = mtArticulosesForCodMonedaVenta_1;
    }
    public Set getMtArticulosesForCodMonedaCompra_1() {
        return this.mtArticulosesForCodMonedaCompra_1;
    }
    
    public void setMtArticulosesForCodMonedaCompra_1(Set mtArticulosesForCodMonedaCompra_1) {
        this.mtArticulosesForCodMonedaCompra_1 = mtArticulosesForCodMonedaCompra_1;
    }
    public Set getFacturaCompras() {
        return this.facturaCompras;
    }
    
    public void setFacturaCompras(Set facturaCompras) {
        this.facturaCompras = facturaCompras;
    }




}


