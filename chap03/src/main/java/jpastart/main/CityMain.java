package jpastart.main;

import jpastart.jpa.EMF;
import jpastart.reserve.model.Area;
import jpastart.reserve.model.City;

import javax.persistence.EntityManager;

public class CityMain {
    public static void main(String[] args) {
        EMF.init();
        EntityManager em = EMF.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(new City());
            em.persist(new Area());
            em.getTransaction().commit();
        }catch( Exception e ) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }

}
