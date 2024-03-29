package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MtClientes generated by hbm2java
 */
public class MtClientes  implements java.io.Serializable {


     private String codTit;
     private MtSexos mtSexos;
     private MtCiudades mtCiudades;
     private MtEstcivil mtEstcivil;
     private MtTiposClientes mtTiposClientes;
     private MtTipoDocumentos mtTipoDocumentos;
     private String nroDocum;
     private String nomTit;
     private String dirTitular;
     private String telTitular;
     private String celTitular;
     private String email;
     private char esActivo;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set comandaCabs = new HashSet(0);
     private Set presupuestoCabs = new HashSet(0);
     private Set facturaVentas = new HashSet(0);

    public MtClientes() {
    }

	
    public MtClientes(String codTit, MtSexos mtSexos, MtCiudades mtCiudades, MtEstcivil mtEstcivil, MtTiposClientes mtTiposClientes, MtTipoDocumentos mtTipoDocumentos, String nroDocum, String nomTit, String dirTitular, char esActivo) {
        this.codTit = codTit;
        this.mtSexos = mtSexos;
        this.mtCiudades = mtCiudades;
        this.mtEstcivil = mtEstcivil;
        this.mtTiposClientes = mtTiposClientes;
        this.mtTipoDocumentos = mtTipoDocumentos;
        this.nroDocum = nroDocum;
        this.nomTit = nomTit;
        this.dirTitular = dirTitular;
        this.esActivo = esActivo;
    }
    public MtClientes(String codTit, MtSexos mtSexos, MtCiudades mtCiudades, MtEstcivil mtEstcivil, MtTiposClientes mtTiposClientes, MtTipoDocumentos mtTipoDocumentos, String nroDocum, String nomTit, String dirTitular, String telTitular, String celTitular, String email, char esActivo, String usuarioMod, String accionMod, Date fechaMod, Set comandaCabs, Set presupuestoCabs, Set facturaVentas) {
       this.codTit = codTit;
       this.mtSexos = mtSexos;
       this.mtCiudades = mtCiudades;
       this.mtEstcivil = mtEstcivil;
       this.mtTiposClientes = mtTiposClientes;
       this.mtTipoDocumentos = mtTipoDocumentos;
       this.nroDocum = nroDocum;
       this.nomTit = nomTit;
       this.dirTitular = dirTitular;
       this.telTitular = telTitular;
       this.celTitular = celTitular;
       this.email = email;
       this.esActivo = esActivo;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.comandaCabs = comandaCabs;
       this.presupuestoCabs = presupuestoCabs;
       this.facturaVentas = facturaVentas;
    }
   
    public String getCodTit() {
        return this.codTit;
    }
    
    public void setCodTit(String codTit) {
        this.codTit = codTit;
    }
    public MtSexos getMtSexos() {
        return this.mtSexos;
    }
    
    public void setMtSexos(MtSexos mtSexos) {
        this.mtSexos = mtSexos;
    }
    public MtCiudades getMtCiudades() {
        return this.mtCiudades;
    }
    
    public void setMtCiudades(MtCiudades mtCiudades) {
        this.mtCiudades = mtCiudades;
    }
    public MtEstcivil getMtEstcivil() {
        return this.mtEstcivil;
    }
    
    public void setMtEstcivil(MtEstcivil mtEstcivil) {
        this.mtEstcivil = mtEstcivil;
    }
    public MtTiposClientes getMtTiposClientes() {
        return this.mtTiposClientes;
    }
    
    public void setMtTiposClientes(MtTiposClientes mtTiposClientes) {
        this.mtTiposClientes = mtTiposClientes;
    }
    public MtTipoDocumentos getMtTipoDocumentos() {
        return this.mtTipoDocumentos;
    }
    
    public void setMtTipoDocumentos(MtTipoDocumentos mtTipoDocumentos) {
        this.mtTipoDocumentos = mtTipoDocumentos;
    }
    public String getNroDocum() {
        return this.nroDocum;
    }
    
    public void setNroDocum(String nroDocum) {
        this.nroDocum = nroDocum;
    }
    public String getNomTit() {
        return this.nomTit;
    }
    
    public void setNomTit(String nomTit) {
        this.nomTit = nomTit;
    }
    public String getDirTitular() {
        return this.dirTitular;
    }
    
    public void setDirTitular(String dirTitular) {
        this.dirTitular = dirTitular;
    }
    public String getTelTitular() {
        return this.telTitular;
    }
    
    public void setTelTitular(String telTitular) {
        this.telTitular = telTitular;
    }
    public String getCelTitular() {
        return this.celTitular;
    }
    
    public void setCelTitular(String celTitular) {
        this.celTitular = celTitular;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public char getEsActivo() {
        return this.esActivo;
    }
    
    public void setEsActivo(char esActivo) {
        this.esActivo = esActivo;
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
    public Set getComandaCabs() {
        return this.comandaCabs;
    }
    
    public void setComandaCabs(Set comandaCabs) {
        this.comandaCabs = comandaCabs;
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




}


