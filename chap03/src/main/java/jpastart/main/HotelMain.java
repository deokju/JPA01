package jpastart.main;

import jpastart.jpa.EMF;
import jpastart.reserve.model.Grade;
import jpastart.reserve.model.Hotel;
import jpastart.reserve.model.Room;

import javax.persistence.EntityManager;

public class HotelMain {
    private static EntityManager em = null;
    static
    {
        EMF.init();
        em = EMF.createEntityManager();
    }

    public static void main(String[] args) {
        EMF.init();
        em.getTransaction().begin();

        try{
            //handleRegistHotel(new Hotel("H001-02", "좋은 호텔", Grade.STAR4));
            handlePrintHotel("H001-02");
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("오류발생 오류발생");
            e.printStackTrace();
        }finally {
            em.close();
        }

    }

    private static void handleRegistHotel(Hotel hotel) {
        em.persist(hotel);
    }

    private static void handlePrintHotel(String hotelId) {
        Hotel hotel = em.find(Hotel.class, hotelId);
        System.out.println(hotel);
    }
}
