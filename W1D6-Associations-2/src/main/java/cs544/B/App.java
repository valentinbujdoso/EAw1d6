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




        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Department> query = em.createQuery("from Department ", Department.class);

        List<Department> departmentList = query.getResultList();
        for (Department department : departmentList) {
            System.out.println(department);
        }
        em.getTransaction().commit();
        em.close();
    }
}
