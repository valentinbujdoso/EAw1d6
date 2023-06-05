package cs544.C;

import cs544.B.Book;
import cs544.B.Publisher;
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

        Student student1 = new Student(1L, "firstname1", "lastname1");
        Course course1 = new Course("123N", "Course1");
        student1.addCourse(course1);

        em.persist(student1);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Student> query = em.createQuery("from Student ", Student.class);

        List<Student> studentList = query.getResultList();
        for (Student student : studentList) {
            System.out.println(student);
        }
        em.getTransaction().commit();
        em.close();
    }
}
