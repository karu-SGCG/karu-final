package com.entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 * FacturaVenta generated by hbm2java
 */
public class FacturaVenta  implements java.io.Serializable {

     private int nroTrans;
     private Caja caja;
     private MtTipoComprobantes mtTipoComprobantes;
     private MtSucursales mtSucursales;
     private MtMonedas mtMonedas;
     private MtFormaPago mtFormaPago;
     private MtClientes mtClientes;
     private MtCondicionPago mtCondicionPago;
     private Date fecha;
     private BigDecimal totalGravada;
     private BigDecimal totalExenta;
     private BigDecimal totalIva10;
     private BigDecimal totalIva5;
     private Character estado;
     private Integer nroComanda;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private String codSucFac;
     private String codTributFac;
     private Integer nroDocum;
     private Date vencimiento;
     private BigDecimal tipoCambio;
     private String notaCredito;
     private String observacion;

    public FacturaVenta() {
    }

	
    public FacturaVenta(int nroTrans) {
        this.nroTrans = nroTrans;
    }
    public FacturaVenta(int nroTrans, Caja caja, MtTipoComprobantes mtTipoComprobantes, MtSucursales mtSucursales, MtMonedas mtMonedas, MtFormaPago mtFormaPago, MtClientes mtClientes, MtCondicionPago mtCondicionPago, Date fecha, BigDecimal totalGravada, BigDecimal totalExenta, BigDecimal totalIva10, BigDecimal totalIva5, Character estado, Integer nroComanda, String usuarioMod, String accionMod, Date fechaMod, String codSucFac, String codTributFac, Integer nroDocum, Date vencimiento, BigDecimal tipoCambio, String notaCredito, String observacion) {
       this.nroTrans = nroTrans;
       this.caja = caja;
       this.mtTipoComprobantes = mtTipoComprobantes;
       this.mtSucursales = mtSucursales;
       this.mtMonedas = mtMonedas;
       this.mtFormaPago = mtFormaPago;
       this.mtClientes = mtClientes;
       this.mtCondicionPago = mtCondicionPago;
       this.fecha = fecha;
       this.totalGravada = totalGravada;
       this.totalExenta = totalExenta;
       this.totalIva10 = totalIva10;
       this.totalIva5 = totalIva5;
       this.estado = estado;
       this.nroComanda = nroComanda;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.codSucFac = codSucFac;
       this.codTributFac = codTributFac;
       this.nroDocum = nroDocum;
       this.vencimiento = vencimiento;
       this.tipoCambio = tipoCambio;
       this.notaCredito = notaCredito;
       this.observacion = observacion;
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
    public MtTipoComprobantes getMtTipoComprobantes() {
        return this.mtTipoComprobantes;
    }
    
    public void setMtTipoComprobantes(MtTipoComprobantes mtTipoComprobantes) {
        this.mtTipoComprobantes = mtTipoComprobantes;
    }
    public MtSucursales getMtSucursales() {
        return this.mtSucursales;
    }
    
    public void setMtSucursales(MtSucursales mtSucursales) {
        this.mtSucursales = mtSucursales;
    }
    public MtMonedas getMtMonedas() {
        return this.mtMonedas;
    }
    
    public void setMtMonedas(MtMonedas mtMonedas) {
        this.mtMonedas = mtMonedas;
    }
    public MtFormaPago getMtFormaPago() {
        return this.mtFormaPago;
    }
    
    public void setMtFormaPago(MtFormaPago mtFormaPago) {
        this.mtFormaPago = mtFormaPago;
    }
    public MtClientes getMtClientes() {
        return this.mtClientes;
    }
    
    public void setMtClientes(MtClientes mtClientes) {
        this.mtClientes = mtClientes;
    }
    public MtCondicionPago getMtCondicionPago() {
        return this.mtCondicionPago;
    }
    
    public void setMtCondicionPago(MtCondicionPago mtCondicionPago) {
        this.mtCondicionPago = mtCondicionPago;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public BigDecimal getTotalGravada() {
        return this.totalGravada;
    }
    
    public void setTotalGravada(BigDecimal totalGravada) {
        this.totalGravada = totalGravada;
    }
    public BigDecimal getTotalExenta() {
        return this.totalExenta;
    }
    
    public void setTotalExenta(BigDecimal totalExenta) {
        this.totalExenta = totalExenta;
    }
    public BigDecimal getTotalIva10() {
        return this.totalIva10;
    }
    
    public void setTotalIva10(BigDecimal totalIva10) {
        this.totalIva10 = totalIva10;
    }
    public BigDecimal getTotalIva5() {
        return this.totalIva5;
    }
    
    public void setTotalIva5(BigDecimal totalIva5) {
        this.totalIva5 = totalIva5;
    }
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    public Integer getNroComanda() {
        return this.nroComanda;
    }
    
    public void setNroComanda(Integer nroComanda) {
        this.nroComanda = nroComanda;
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
    public String getCodSucFac() {
        return this.codSucFac;
    }
    
    public void setCodSucFac(String codSucFac) {
        this.codSucFac = codSucFac;
    }
    public String getCodTributFac() {
        return this.codTributFac;
    }
    
    public void setCodTributFac(String codTributFac) {
        this.codTributFac = codTributFac;
    }
    public Integer getNroDocum() {
        return this.nroDocum;
    }
    
    public void setNroDocum(Integer nroDocum) {
        this.nroDocum = nroDocum;
    }
    public Date getVencimiento() {
        return this.vencimiento;
    }
    
    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }
    public BigDecimal getTipoCambio() {
        return this.tipoCambio;
    }
    
    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
    public String getNotaCredito() {
        return this.notaCredito;
    }
    
    public void setNotaCredito(String notaCredito) {
        this.notaCredito = notaCredito;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}

