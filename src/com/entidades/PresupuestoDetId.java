package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0



/**
 * PresupuestoDetId generated by hbm2java
 */
public class PresupuestoDetId  implements java.io.Serializable {


     private int nroTrans;
     private String codArticulo;

    public PresupuestoDetId() {
    }

    public PresupuestoDetId(int nroTrans, String codArticulo) {
       this.nroTrans = nroTrans;
       this.codArticulo = codArticulo;
    }
   
    public int getNroTrans() {
        return this.nroTrans;
    }
    
    public void setNroTrans(int nroTrans) {
        this.nroTrans = nroTrans;
    }
    public String getCodArticulo() {
        return this.codArticulo;
    }
    
    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PresupuestoDetId) ) return false;
		 PresupuestoDetId castOther = ( PresupuestoDetId ) other; 
         
		 return (this.getNroTrans()==castOther.getNroTrans())
 && ( (this.getCodArticulo()==castOther.getCodArticulo()) || ( this.getCodArticulo()!=null && castOther.getCodArticulo()!=null && this.getCodArticulo().equals(castOther.getCodArticulo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNroTrans();
         result = 37 * result + ( getCodArticulo() == null ? 0 : this.getCodArticulo().hashCode() );
         return result;
   }   


}


