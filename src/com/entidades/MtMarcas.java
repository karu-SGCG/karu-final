package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MtMarcas generated by hbm2java
 */
public class MtMarcas  implements java.io.Serializable {


     private String codMarca;
     private String nomMarca;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set mtArticuloses = new HashSet(0);
     private Set mtArticuloses_1 = new HashSet(0);

    public MtMarcas() {
    }

	
    public MtMarcas(String codMarca, String nomMarca) {
        this.codMarca = codMarca;
        this.nomMarca = nomMarca;
    }
    public MtMarcas(String codMarca, String nomMarca, String usuarioMod, String accionMod, Date fechaMod, Set mtArticuloses, Set mtArticuloses_1) {
       this.codMarca = codMarca;
       this.nomMarca = nomMarca;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.mtArticuloses = mtArticuloses;
       this.mtArticuloses_1 = mtArticuloses_1;
    }
   
    public String getCodMarca() {
        return this.codMarca;
    }
    
    public void setCodMarca(String codMarca) {
        this.codMarca = codMarca;
    }
    public String getNomMarca() {
        return this.nomMarca;
    }
    
    public void setNomMarca(String nomMarca) {
        this.nomMarca = nomMarca;
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
    public Set getMtArticuloses_1() {
        return this.mtArticuloses_1;
    }
    
    public void setMtArticuloses_1(Set mtArticuloses_1) {
        this.mtArticuloses_1 = mtArticuloses_1;
    }




}

