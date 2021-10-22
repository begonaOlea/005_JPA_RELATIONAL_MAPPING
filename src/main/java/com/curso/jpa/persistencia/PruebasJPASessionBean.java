
package com.curso.jpa.persistencia;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Record;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PruebasJPASessionBean {
    
    @PersistenceContext
    private EntityManager em;

    public void probarOneToOne(){
        
        Customer c = new Customer();
        Record rec = new Record();
        rec.setRecordName("Registro1");
        em.persist(rec);
        
        c.setCustomerName("Laura");
        c.setRecord(rec);
        em.persist(c);
        
        
    }
    
    
}
