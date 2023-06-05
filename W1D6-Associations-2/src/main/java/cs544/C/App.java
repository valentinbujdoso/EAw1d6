package cs544.C;

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

        Student2 student1 = new Student2(1L, "firstname1", "lastname1");
        Course course1 = new Course("123N", "Course1");
        student1.addCourse(course1);

        em.persist(student1);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Student2> query = em.createQuery("from Student2 ", Student2.class);

        List<Student2> studentList = query.getResultList();
        for (Student2 student : studentList) {
            System.out.println(student);
        }
        em.getTransaction().commit();
        em.close();
    }
}
