package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MtSucursales generated by hbm2java
 */
public class MtSucursales  implements java.io.Serializable {


     private String codSucursal;
     private MtEmpresas mtEmpresas;
     private MtCiudades mtCiudades;
     private String nomSucursal;
     private String direccion;
     private String telefono;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set mtCajeroses = new HashSet(0);
     private Set facturaCompras = new HashSet(0);
     private Set presupuestoCabs = new HashSet(0);
     private Set prProducs = new HashSet(0);
     private Set mtVendedoreses = new HashSet(0);
     private Set cajas = new HashSet(0);
     private Set prProduccions = new HashSet(0);
     private Set stExistenciaSucs = new HashSet(0);
     private Set facturaVentas = new HashSet(0);
     private Set stExistenciaSucs_1 = new HashSet(0);
     private Set prProduccions_1 = new HashSet(0);
     private Set mtUsuarioses = new HashSet(0);
     private Set mtComprobanteses = new HashSet(0);

    public MtSucursales() {
    }

	
    public MtSucursales(String codSucursal, MtEmpresas mtEmpresas, MtCiudades mtCiudades, String nomSucursal, String direccion, String telefono) {
        this.codSucursal = codSucursal;
        this.mtEmpresas = mtEmpresas;
        this.mtCiudades = mtCiudades;
        this.nomSucursal = nomSucursal;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public MtSucursales(String codSucursal, MtEmpresas mtEmpresas, MtCiudades mtCiudades, String nomSucursal, String direccion, String telefono, String usuarioMod, String accionMod, Date fechaMod, Set mtCajeroses, Set facturaCompras, Set presupuestoCabs, Set prProducs, Set mtVendedoreses, Set cajas, Set prProduccions, Set stExistenciaSucs, Set facturaVentas, Set stExistenciaSucs_1, Set prProduccions_1, Set mtUsuarioses, Set mtComprobanteses) {
       this.codSucursal = codSucursal;
       this.mtEmpresas = mtEmpresas;
       this.mtCiudades = mtCiudades;
       this.nomSucursal = nomSucursal;
       this.direccion = direccion;
       this.telefono = telefono;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.mtCajeroses = mtCajeroses;
       this.facturaCompras = facturaCompras;
       this.presupuestoCabs = presupuestoCabs;
       this.prProducs = prProducs;
       this.mtVendedoreses = mtVendedoreses;
       this.cajas = cajas;
       this.prProduccions = prProduccions;
       this.stExistenciaSucs = stExistenciaSucs;
       this.facturaVentas = facturaVentas;
       this.stExistenciaSucs_1 = stExistenciaSucs_1;
       this.prProduccions_1 = prProduccions_1;
       this.mtUsuarioses = mtUsuarioses;
       this.mtComprobanteses = mtComprobanteses;
    }
   
    public String getCodSucursal() {
        return this.codSucursal;
    }
    
    public void setCodSucursal(String codSucursal) {
        this.codSucursal = codSucursal;
    }
    public MtEmpresas getMtEmpresas() {
        return this.mtEmpresas;
    }
    
    public void setMtEmpresas(MtEmpresas mtEmpresas) {
        this.mtEmpresas = mtEmpresas;
    }
    public MtCiudades getMtCiudades() {
        return this.mtCiudades;
    }
    
    public void setMtCiudades(MtCiudades mtCiudades) {
        this.mtCiudades = mtCiudades;
    }
    public String getNomSucursal() {
        return this.nomSucursal;
    }
    
    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
    public Set getMtCajeroses() {
        return this.mtCajeroses;
    }
    
    public void setMtCajeroses(Set mtCajeroses) {
        this.mtCajeroses = mtCajeroses;
    }
    public Set getFacturaCompras() {
        return this.facturaCompras;
    }
    
    public void setFacturaCompras(Set facturaCompras) {
        this.facturaCompras = facturaCompras;
    }
    public Set getPresupuestoCabs() {
        return this.presupuestoCabs;
    }
    
    public void setPresupuestoCabs(Set presupuestoCabs) {
        this.presupuestoCabs = presupuestoCabs;
    }
    public Set getPrProducs() {
        return this.prProducs;
    }
    
    public void setPrProducs(Set prProducs) {
        this.prProducs = prProducs;
    }
    public Set getMtVendedoreses() {
        return this.mtVendedoreses;
    }
    
    public void setMtVendedoreses(Set mtVendedoreses) {
        this.mtVendedoreses = mtVendedoreses;
    }
    public Set getCajas() {
        return this.cajas;
    }
    
    public void setCajas(Set cajas) {
        this.cajas = cajas;
    }
    public Set getPrProduccions() {
        return this.prProduccions;
    }
    
    public void setPrProduccions(Set prProduccions) {
        this.prProduccions = prProduccions;
    }
    public Set getStExistenciaSucs() {
        return this.stExistenciaSucs;
    }
    
    public void setStExistenciaSucs(Set stExistenciaSucs) {
        this.stExistenciaSucs = stExistenciaSucs;
    }
    public Set getFacturaVentas() {
        return this.facturaVentas;
    }
    
    public void setFacturaVentas(Set facturaVentas) {
        this.facturaVentas = facturaVentas;
    }
    public Set getStExistenciaSucs_1() {
        return this.stExistenciaSucs_1;
    }
    
    public void setStExistenciaSucs_1(Set stExistenciaSucs_1) {
        this.stExistenciaSucs_1 = stExistenciaSucs_1;
    }
    public Set getPrProduccions_1() {
        return this.prProduccions_1;
    }
    
    public void setPrProduccions_1(Set prProduccions_1) {
        this.prProduccions_1 = prProduccions_1;
    }
    public Set getMtUsuarioses() {
        return this.mtUsuarioses;
    }
    
    public void setMtUsuarioses(Set mtUsuarioses) {
        this.mtUsuarioses = mtUsuarioses;
    }
    public Set getMtComprobanteses() {
        return this.mtComprobanteses;
    }
    
    public void setMtComprobanteses(Set mtComprobanteses) {
        this.mtComprobanteses = mtComprobanteses;
    }




}


