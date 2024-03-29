package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0



/**
 * ArqueoDetId generated by hbm2java
 */
public class ArqueoDetId  implements java.io.Serializable {


     private int nroOperacion;
     private int linea;

    public ArqueoDetId() {
    }

    public ArqueoDetId(int nroOperacion, int linea) {
       this.nroOperacion = nroOperacion;
       this.linea = linea;
    }
   
    public int getNroOperacion() {
        return this.nroOperacion;
    }
    
    public void setNroOperacion(int nroOperacion) {
        this.nroOperacion = nroOperacion;
    }
    public int getLinea() {
        return this.linea;
    }
    
    public void setLinea(int linea) {
        this.linea = linea;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ArqueoDetId) ) return false;
		 ArqueoDetId castOther = ( ArqueoDetId ) other; 
         
		 return (this.getNroOperacion()==castOther.getNroOperacion())
 && (this.getLinea()==castOther.getLinea());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNroOperacion();
         result = 37 * result + this.getLinea();
         return result;
   }   


}


