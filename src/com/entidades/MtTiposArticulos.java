package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MtTiposArticulos generated by hbm2java
 */
public class MtTiposArticulos  implements java.io.Serializable {


     private int codTipoArticulo;
     private String nomTipoArticulo;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set mtArticuloses = new HashSet(0);

    public MtTiposArticulos() {
    }

	
    public MtTiposArticulos(int codTipoArticulo, String nomTipoArticulo) {
        this.codTipoArticulo = codTipoArticulo;
        this.nomTipoArticulo = nomTipoArticulo;
    }
    public MtTiposArticulos(int codTipoArticulo, String nomTipoArticulo, String usuarioMod, String accionMod, Date fechaMod, Set mtArticuloses) {
       this.codTipoArticulo = codTipoArticulo;
       this.nomTipoArticulo = nomTipoArticulo;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.mtArticuloses = mtArticuloses;
    }
   
    public int getCodTipoArticulo() {
        return this.codTipoArticulo;
    }
    
    public void setCodTipoArticulo(int codTipoArticulo) {
        this.codTipoArticulo = codTipoArticulo;
    }
    public String getNomTipoArticulo() {
        return this.nomTipoArticulo;
    }
    
    public void setNomTipoArticulo(String nomTipoArticulo) {
        this.nomTipoArticulo = nomTipoArticulo;
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
    public Set getMtArticuloses() {
        return this.mtArticuloses;
    }
    
    public void setMtArticuloses(Set mtArticuloses) {
        this.mtArticuloses = mtArticuloses;
    }




}


