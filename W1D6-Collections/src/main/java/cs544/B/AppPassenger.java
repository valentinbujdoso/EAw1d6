package cs544.B;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AppPassenger {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Passenger p1 = new Passenger("Passenger1");
        Flight flight1 = new Flight("ABC123", "BUD", "DSM", "1/1/2022");
        Flight flight2 = new Flight("321CBA", "DSM", "BUD", "1/2/2022");
        p1.addFlight(flight1);
        p1.addFlight(flight2);

        em.persist(p1);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Passenger> query = em.createQuery("from Passenger", Passenger.class);
        List<Passenger> passengerList = query.getResultList();
        for (Passenger passenger : passengerList) {
            System.out.println(passenger);
        }
        em.getTransaction().commit();
        em.close();
    }
}
