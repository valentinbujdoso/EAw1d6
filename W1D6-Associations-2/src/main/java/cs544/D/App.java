package cs544.D;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer1 = new Customer("Customer1");
        Reservation reservation1 = new Reservation("01/01/2022");
        Reservation reservation2 = new Reservation("02/01/2022");
        customer1.addReservation(reservation1);
        customer1.addReservation(reservation2);
        em.persist(customer1);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Customer> query = em.createQuery("from Customer2 ", Customer.class);

        List<Customer> customerList = query.getResultList();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        em.getTransaction().commit();
        em.close();
    }
}
