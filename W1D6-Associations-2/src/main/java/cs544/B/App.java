package cs544.B;

import cs544.A.Department;
import cs544.A.Employee;
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

        Book book1 = new Book("isbn1", "title1", "author1", null);
        em.persist(book1);

        Publisher publisher1 = new Publisher("Publisher1");
        Book book2 = new Book("isbn2", "title2", "author2", publisher1);
        em.persist(book2);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("from Book ", Book.class);

        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println(book);
        }
        em.getTransaction().commit();
        em.close();
    }
}
