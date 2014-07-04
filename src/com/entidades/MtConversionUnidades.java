package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;

/**
 * MtConversionUnidades generated by hbm2java
 */
public class MtConversionUnidades  implements java.io.Serializable {


     private MtConversionUnidadesId id;
     private MtUnidMedidas mtUnidMedidas;
     private BigDecimal factor;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;

    public MtConversionUnidades() {
    }

	
    public MtConversionUnidades(MtConversionUnidadesId id, MtUnidMedidas mtUnidMedidas, BigDecimal factor) {
        this.id = id;
        this.mtUnidMedidas = mtUnidMedidas;
        this.factor = factor;
    }
    public MtConversionUnidades(MtConversionUnidadesId id, MtUnidMedidas mtUnidMedidas, BigDecimal factor, String usuarioMod, String accionMod, Date fechaMod) {
       this.id = id;
       this.mtUnidMedidas = mtUnidMedidas;
       this.factor = factor;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
    }
   
    public MtConversionUnidadesId getId() {
        return this.id;
    }
    
    public void setId(MtConversionUnidadesId id) {
        this.id = id;
    }
    public MtUnidMedidas getMtUnidMedidas() {
        return this.mtUnidMedidas;
    }
    
    public void setMtUnidMedidas(MtUnidMedidas mtUnidMedidas) {
        this.mtUnidMedidas = mtUnidMedidas;
    }
    public BigDecimal getFactor() {
        return this.factor;
    }
    
    public void setFactor(BigDecimal factor) {
        this.factor = factor;
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


