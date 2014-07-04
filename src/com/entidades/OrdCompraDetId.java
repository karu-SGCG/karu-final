package com.entidades;
// Generated 22/06/2014 01:16:55 PM by Hibernate Tools 3.6.0



/**
 * OrdCompraDetId generated by hbm2java
 */
public class OrdCompraDetId  implements java.io.Serializable {


     private int nroOcompra;
     private int linea;

    public OrdCompraDetId() {
    }

    public OrdCompraDetId(int nroOcompra, int linea) {
       this.nroOcompra = nroOcompra;
       this.linea = linea;
    }
   
    public int getNroOcompra() {
        return this.nroOcompra;
    }
    
    public void setNroOcompra(int nroOcompra) {
        this.nroOcompra = nroOcompra;
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
		 if ( !(other instanceof OrdCompraDetId) ) return false;
		 OrdCompraDetId castOther = ( OrdCompraDetId ) other; 
         
		 return (this.getNroOcompra()==castOther.getNroOcompra())
 && (this.getLinea()==castOther.getLinea());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getNroOcompra();
         result = 37 * result + this.getLinea();
         return result;
   }   


}


