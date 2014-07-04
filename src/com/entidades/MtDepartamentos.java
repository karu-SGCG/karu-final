package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MtDepartamentos generated by hbm2java
 */
public class MtDepartamentos  implements java.io.Serializable {


     private int codDepartamento;
     private MtPaises mtPaises;
     private String nomDepartamento;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set mtCiudadeses = new HashSet(0);
     private Set mtCiudadeses_1 = new HashSet(0);

    public MtDepartamentos() {
    }

	
    public MtDepartamentos(int codDepartamento, MtPaises mtPaises, String nomDepartamento) {
        this.codDepartamento = codDepartamento;
        this.mtPaises = mtPaises;
        this.nomDepartamento = nomDepartamento;
    }
    public MtDepartamentos(int codDepartamento, MtPaises mtPaises, String nomDepartamento, String usuarioMod, String accionMod, Date fechaMod, Set mtCiudadeses, Set mtCiudadeses_1) {
       this.codDepartamento = codDepartamento;
       this.mtPaises = mtPaises;
       this.nomDepartamento = nomDepartamento;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.mtCiudadeses = mtCiudadeses;
       this.mtCiudadeses_1 = mtCiudadeses_1;
    }
   
    public int getCodDepartamento() {
        return this.codDepartamento;
    }
    
    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }
    public MtPaises getMtPaises() {
        return this.mtPaises;
    }
    
    public void setMtPaises(MtPaises mtPaises) {
        this.mtPaises = mtPaises;
    }
    public String getNomDepartamento() {
        return this.nomDepartamento;
    }
    
    public void setNomDepartamento(String nomDepartamento) {
        this.nomDepartamento = nomDepartamento;
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
    public Set getMtCiudadeses() {
        return this.mtCiudadeses;
    }
    
    public void setMtCiudadeses(Set mtCiudadeses) {
        this.mtCiudadeses = mtCiudadeses;
    }
    public Set getMtCiudadeses_1() {
        return this.mtCiudadeses_1;
    }
    
    public void setMtCiudadeses_1(Set mtCiudadeses_1) {
        this.mtCiudadeses_1 = mtCiudadeses_1;
    }




}


