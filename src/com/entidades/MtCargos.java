package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MtCargos generated by hbm2java
 */
public class MtCargos  implements java.io.Serializable {


     private int codCargo;
     private String nomCargo;
     private String usuarioMod;
     private String accionMod;
     private Date fechaMod;
     private Set mtRolesUsuarioses = new HashSet(0);
     private Set mtEmpleadoses = new HashSet(0);

    public MtCargos() {
    }

	
    public MtCargos(int codCargo, String nomCargo) {
        this.codCargo = codCargo;
        this.nomCargo = nomCargo;
    }
    public MtCargos(int codCargo, String nomCargo, String usuarioMod, String accionMod, Date fechaMod, Set mtRolesUsuarioses, Set mtEmpleadoses) {
       this.codCargo = codCargo;
       this.nomCargo = nomCargo;
       this.usuarioMod = usuarioMod;
       this.accionMod = accionMod;
       this.fechaMod = fechaMod;
       this.mtRolesUsuarioses = mtRolesUsuarioses;
       this.mtEmpleadoses = mtEmpleadoses;
    }
   
    public int getCodCargo() {
        return this.codCargo;
    }
    
    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }
    public String getNomCargo() {
        return this.nomCargo;
    }
    
    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
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
    public Set getMtRolesUsuarioses() {
        return this.mtRolesUsuarioses;
    }
    
    public void setMtRolesUsuarioses(Set mtRolesUsuarioses) {
        this.mtRolesUsuarioses = mtRolesUsuarioses;
    }
    public Set getMtEmpleadoses() {
        return this.mtEmpleadoses;
    }
    
    public void setMtEmpleadoses(Set mtEmpleadoses) {
        this.mtEmpleadoses = mtEmpleadoses;
    }




}


