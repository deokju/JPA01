package jpastart.main;

import jpastart.jpa.EMF;
import jpastart.reserve.model.Room;

import javax.persistence.EntityManager;

public class RoomMain {
    public static void main(String[] args) {
        EMF.init();
        //registRoom(new Room("R002", "야놀자2", "5인 이용가능 방"));
        printRoom("R001");
    }

    private static void registRoom(Room room) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        em.persist(room);
        em.getTransaction().commit();
        em.close();
    }

    private static void printRoom(String name) {
        EntityManager em = EMF.createEntityManager();
        em.getTransaction().begin();
        Room room = em.find(Room.class, name);
        System.out.println(room.getDbId());
        em.close();
    }
}
