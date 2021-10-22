/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.curso.jpa.web;

import com.curso.jpa.persistencia.PruebasJPASessionBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author begonaolea
 */
@Named(value = "pruebasJPAManagedBean")
@RequestScoped
public class PruebasJPAManagedBean {

    
    @EJB
    private PruebasJPASessionBean servicio;
   
    
    public void btnPruebaOneToOne(){
        servicio.probarOneToOne();
    }
    
    
     public void btnPruebaOneToOneFind(){
        servicio.probarFindOneToOne();
    }
    
     public void btnPruebaManyToOne(){
         servicio.probarManyToOne();
     }
     
}
