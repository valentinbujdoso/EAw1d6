package cs544.E;

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

        Customer2 customer21 = new Customer2("Customer1");
        Reservation2 reservation21 = new Reservation2("01/01/2022");
        Reservation2 reservation2 = new Reservation2("02/01/2022");
        Book2 book1 = new Book2("isbn1", "title1", "author1");
        Book2 book2 = new Book2("isbn2", "title2", "author2");
        Book2 book3 = new Book2("isbn3", "title3", "author3");
        Book2 book4 = new Book2("isbn4", "title4", "author4");
        reservation21.setBook(book1);
        reservation21.setBook(book2);
        reservation2.setBook(book3);
        reservation2.setBook(book4);
        customer21.addReservation(reservation21);
        customer21.addReservation(reservation2);

        em.persist(customer21);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Customer2> query = em.createQuery("from Customer2 ", Customer2.class);

        List<Customer2> customer2List = query.getResultList();
        for (Customer2 customer2 : customer2List) {
            System.out.println(customer2);
        }
        em.getTransaction().commit();
        em.close();
    }
}
