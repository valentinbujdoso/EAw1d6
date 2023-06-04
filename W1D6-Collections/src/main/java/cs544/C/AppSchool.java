package cs544.C;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AppSchool {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //asd
        Student student1 = new Student(1L, "First1", "Last2");
        Student student2 = new Student(2L, "First2", "Last2");
        Student student3 = new Student(3L, "First3", "Last3");
        School school1 = new School("MIU");
        school1.addStudent(student1);
        school1.addStudent(student2);
        school1.addStudent(student3);

        em.persist(school1);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<School> query = em.createQuery("from School", School.class);
        List<School> schoolList = query.getResultList();
        for (School school : schoolList) {
            System.out.println(school);
        }

        em.getTransaction().commit();
        em.close();
    }
}
