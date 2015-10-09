package com.gslab.aerohive.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author GS-1044
 *
 */
public class EntityManagerUtility {
    
    private static final EntityManagerFactory entityManagerFactory;
      static {
        try {
          entityManagerFactory = Persistence.createEntityManagerFactory("transaction_unit");
        } catch (Throwable ex) {          
          throw new ExceptionInInitializerError(ex);
        }
      }
 
      public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
 
      }
    }
 