package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0



/**
 * ValoresDetId generated by hbm2java
 */
public class ValoresDetId  implements java.io.Serializable {


     private int nroTrans;
     private int linea;
     private String codDocum;

    public ValoresDetId() {
    }

    public ValoresDetId(int nroTrans, int linea, String codDocum) {
       this.nroTrans = nroTrans;
       this.linea = linea;
       this.codDocum = codDocum;
    }
   
    public int getNroTrans() {
        return this.nroTrans;
    }
    
    public void setNroTrans(int nroTrans) {
        this.nroTrans = nroTrans;
    }
    public int getLinea() {
        return this.linea;
    }
    
    public void setLinea(int linea) {
        this.linea = linea;
    }
    public String getCodDocum() {
        return this.codDocum;
    }
    
    public void setCodDocum(String codDocum) {
        this.codDocum = codDocum;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ValoresDetId) ) return false;
		 ValoresDetId castOther = ( ValoresDetId ) other; 
         
		 return (this.getNroTrans()==castOther.getNroTrans())
 && (this.getLinea()==castOther.getLinea())
 && ( (this.getCodDocum()==castOther.getCodDocum()) || ( this.getCodDocum()!=null && castOther.getCodDocum()!=null && this.getCodDocum().equals(castOther.getCodDocum()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNroTrans();
         result = 37 * result + this.getLinea();
         result = 37 * result + ( getCodDocum() == null ? 0 : this.getCodDocum().hashCode() );
         return result;
   }   


}


