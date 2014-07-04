package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0



/**
 * MtRolesUsuariosId generated by hbm2java
 */
public class MtRolesUsuariosId  implements java.io.Serializable {


     private int codCargo;
     private String codUsuario;

    public MtRolesUsuariosId() {
    }

    public MtRolesUsuariosId(int codCargo, String codUsuario) {
       this.codCargo = codCargo;
       this.codUsuario = codUsuario;
    }
   
    public int getCodCargo() {
        return this.codCargo;
    }
    
    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }
    public String getCodUsuario() {
        return this.codUsuario;
    }
    
    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MtRolesUsuariosId) ) return false;
		 MtRolesUsuariosId castOther = ( MtRolesUsuariosId ) other; 
         
		 return (this.getCodCargo()==castOther.getCodCargo())
 && ( (this.getCodUsuario()==castOther.getCodUsuario()) || ( this.getCodUsuario()!=null && castOther.getCodUsuario()!=null && this.getCodUsuario().equals(castOther.getCodUsuario()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCodCargo();
         result = 37 * result + ( getCodUsuario() == null ? 0 : this.getCodUsuario().hashCode() );
         return result;
   }   


}

