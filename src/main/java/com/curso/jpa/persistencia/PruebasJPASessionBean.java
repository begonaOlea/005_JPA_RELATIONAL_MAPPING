
package com.curso.jpa.persistencia;

import com.curso.jpa.entidades.Customer;
import com.curso.jpa.entidades.Orders;
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
        rec.setRecordName("Registro2");
        //em.persist(rec);  //graba en la bd RECORD
        
       
        c.setCustomerName("Maria");
        c.setRecord(rec);
        em.persist(c);  // GRABA EN LA BD CUSTOMER y el CUSTOMERRECORD_RECID es el id de rec
        
        
        
        
    }
    
    public void probarFindOneToOne(){
        
        Customer cliente = em.find(Customer.class, 1);
       // System.out.println("el cliente es " + cliente.getCustomerName());
        System.out.println("su registo es " + cliente.getRecord().getRecordName());
        
    }
    
    public Customer findByID(int id){
        //tx new
        Customer cliente = em.find(Customer.class, id);
        return cliente;
        //tx commit
    }
    
    
    public void probarManyToOne(){
        
        Customer cliente = em.find(Customer.class, 1);
       
        Orders o = new Orders();
        o.setDescription("pedido bolis");
        o.setCustomer(cliente);  // new Customer().setId(1); 
        em.persist(o);
        
        //cliente.getOrdersCollection().add(o);
        
        //commit
       
    }
    
}
