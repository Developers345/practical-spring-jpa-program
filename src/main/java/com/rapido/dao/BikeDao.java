package com.rapido.dao;

import com.rapido.entities.Bike;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*
According to the JPA specification:

@NamedQuery MUST be defined on an @Entity class
OR in META-INF/orm.xml

@NamedQueries({@NamedQuery(name = "getBikes" , query = "from Bike")})
*/

public class BikeDao {
 /*
    JpaTemplate removed from spring 6.X onwards
  */
    @PersistenceContext
    private EntityManager entityManager;

     public List<Bike> getBikes()
     {
         return entityManager.createNamedQuery("getBikes",Bike.class).getResultList();
     }

}
