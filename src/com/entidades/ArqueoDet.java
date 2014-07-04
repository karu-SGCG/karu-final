package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;

/**
 * ArqueoDet generated by hbm2java
 */
public class ArqueoDet  implements java.io.Serializable {


     private ArqueoDetId id;
     private MtMonedas mtMonedas;
     private Integer formaPago;
     private BigDecimal importeEsperado;
     private BigDecimal importeArqueado;
     private BigDecimal diferencia;
     private Integer tipoMov;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;

    public ArqueoDet() {
    }

	
    public ArqueoDet(ArqueoDetId id) {
        this.id = id;
    }
    public ArqueoDet(ArqueoDetId id, MtMonedas mtMonedas, Integer formaPago, BigDecimal importeEsperado, BigDecimal importeArqueado, BigDecimal diferencia, Integer tipoMov, String usuarioMod, String accionMod, Date fechaMod) {
       this.id = id;
       this.mtMonedas = mtMonedas;
       this.formaPago = formaPago;
       this.importeEsperado = importeEsperado;
       this.importeArqueado = importeArqueado;
       this.diferencia = diferencia;
       this.tipoMov = tipoMov;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
    }
   
    public ArqueoDetId getId() {
        return this.id;
    }
    
    public void setId(ArqueoDetId id) {
        this.id = id;
    }
    public MtMonedas getMtMonedas() {
        return this.mtMonedas;
    }
    
    public void setMtMonedas(MtMonedas mtMonedas) {
        this.mtMonedas = mtMonedas;
    }
    public Integer getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(Integer formaPago) {
        this.formaPago = formaPago;
    }
    public BigDecimal getImporteEsperado() {
        return this.importeEsperado;
    }
    
    public void setImporteEsperado(BigDecimal importeEsperado) {
        this.importeEsperado = importeEsperado;
    }
    public BigDecimal getImporteArqueado() {
        return this.importeArqueado;
    }
    
    public void setImporteArqueado(BigDecimal importeArqueado) {
        this.importeArqueado = importeArqueado;
    }
    public BigDecimal getDiferencia() {
        return this.diferencia;
    }
    
    public void setDiferencia(BigDecimal diferencia) {
        this.diferencia = diferencia;
    }
    public Integer getTipoMov() {
        return this.tipoMov;
    }
    
    public void setTipoMov(Integer tipoMov) {
        this.tipoMov = tipoMov;
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


