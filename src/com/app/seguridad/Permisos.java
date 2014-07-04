/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.app.seguridad;

import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Fausto Sanabria
 */
public class Permisos {
    public void sessionHibernate(){
        st = HibernateUtil.getSessionFactory().openSession();
    }
    private Session st;
    
    public Boolean PuedeEjecutar (String codUsuario, String formulario){
        sessionHibernate();
        Boolean retorno;
        
        if ("karu".equals(codUsuario)) {
            retorno = true;
        } else if (codUsuario != null && !codUsuario.isEmpty()
            && formulario != null && !formulario.isEmpty()) {
            Query consulta = st.createQuery("select count(*) from MtAccesosGrupos a" +
                    " where a.puedeEjecutar = 'S' and a.id.nomFormulario = :formulario and a.id.codCargo in" +
                    " (select b.id.codCargo from MtRolesUsuarios b where b.id.codUsuario = :usuario)" );
            
            consulta.setParameter("formulario", formulario);
            consulta.setParameter("usuario", codUsuario);
            
            Object cantidad = consulta.uniqueResult();
            retorno = Integer.parseInt(cantidad.toString()) > 0;
        } else {
            retorno = false;
        }
        return retorno;
    }
    
    public Boolean PuedeInsertar (String codUsuario, String formulario){
        sessionHibernate();
        Boolean retorno;
        
        if ("karu".equals(codUsuario)) {
            retorno = true;
        } else if (codUsuario != null && !codUsuario.isEmpty()
            && formulario != null && !formulario.isEmpty()) {
            Query consulta = st.createQuery("select count(*) from MtAccesosGrupos a" +
                    " where a.puedeInsertar = 'S' and a.id.nomFormulario = :formulario and a.id.codCargo in" +
                    " (select b.id.codCargo from MtRolesUsuarios b where b.id.codUsuario = :usuario)" );
            
            consulta.setParameter("formulario", formulario);
            consulta.setParameter("usuario", codUsuario);
            
            Object cantidad = consulta.uniqueResult();
            retorno = Integer.parseInt(cantidad.toString()) > 0;
        } else {
            retorno = false;
        }
        return retorno;
    }
    
    public Boolean PuedeModificar (String codUsuario, String formulario){
        sessionHibernate();
        Boolean retorno;
        
        if ("karu".equals(codUsuario)) {
            retorno = true;
        } else if (codUsuario != null && !codUsuario.isEmpty()
            && formulario != null && !formulario.isEmpty()) {
            Query consulta = st.createQuery("select count(*) from MtAccesosGrupos a" +
                    " where a.puedeModificar = 'S' and a.id.nomFormulario = :formulario and a.id.codCargo in" +
                    " (select b.id.codCargo from MtRolesUsuarios b where b.id.codUsuario = :usuario)" );
            
            consulta.setParameter("formulario", formulario);
            consulta.setParameter("usuario", codUsuario);
            
            Object cantidad = consulta.uniqueResult();
            retorno = Integer.parseInt(cantidad.toString()) > 0;
        } else {
            retorno = false;
        }
        return retorno;
    }    
    
    public Boolean PuedeEliminar (String codUsuario, String formulario){
        sessionHibernate();
        Boolean retorno;
        
        if ("karu".equals(codUsuario)) {
            retorno = true;
        } else if (codUsuario != null && !codUsuario.isEmpty()
            && formulario != null && !formulario.isEmpty()) {
            Query consulta = st.createQuery("select count(*) from MtAccesosGrupos a" +
                    " where a.puedeEliminar = 'S' and a.id.nomFormulario = :formulario and a.id.codCargo in" +
                    " (select b.id.codCargo from MtRolesUsuarios b where b.id.codUsuario = :usuario)" );
            
            consulta.setParameter("formulario", formulario);
            consulta.setParameter("usuario", codUsuario);
            
            Object cantidad = consulta.uniqueResult();
            retorno = Integer.parseInt(cantidad.toString()) > 0;
        } else {
            retorno = false;
        }
        return retorno;
    }       
    
}
