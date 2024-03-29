package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0



/**
 * MovValDetId generated by hbm2java
 */
public class MovValDetId  implements java.io.Serializable {


     private int nroOperacion;
     private int nroLinea;

    public MovValDetId() {
    }

    public MovValDetId(int nroOperacion, int nroLinea) {
       this.nroOperacion = nroOperacion;
       this.nroLinea = nroLinea;
    }
   
    public int getNroOperacion() {
        return this.nroOperacion;
    }
    
    public void setNroOperacion(int nroOperacion) {
        this.nroOperacion = nroOperacion;
    }
    public int getNroLinea() {
        return this.nroLinea;
    }
    
    public void setNroLinea(int nroLinea) {
        this.nroLinea = nroLinea;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MovValDetId) ) return false;
		 MovValDetId castOther = ( MovValDetId ) other; 
         
		 return (this.getNroOperacion()==castOther.getNroOperacion())
 && (this.getNroLinea()==castOther.getNroLinea());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNroOperacion();
         result = 37 * result + this.getNroLinea();
         return result;
   }   


}


