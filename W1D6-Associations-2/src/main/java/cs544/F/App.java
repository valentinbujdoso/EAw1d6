package cs544.F;

import cs544.E.Book2;
import cs544.E.Customer2;
import cs544.E.Reservation2;
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

        Department2 department1 = new Department2("Department1");
        Department2 department2 = new Department2("Department2");
        Office office1 = new Office("Office1");
        Office office2 = new Office("Office2");
        Employee3 employee1 = new Employee3("Name1");
        Employee3 employee2 = new Employee3("Name2");
        Employee3 employee3 = new Employee3("Name3");

        department1.addEmployee(employee1);
        office1.addEmployee(employee1);

        department2.addEmployee(employee2);

        office2.addEmployee(employee3);

        em.persist(department1);
        em.persist(department2);
        em.persist(office1);
        em.persist(office2);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Department2> query = em.createQuery("from Department2 ", Department2.class);

        List<Department2> departmentList = query.getResultList();
        for (Department2 department : departmentList) {
            System.out.println(department);
        }


        TypedQuery<Office> queryOffice = em.createQuery("from Office ", Office.class);

        List<Office> officeList = queryOffice.getResultList();
        for (Office office : officeList) {
            System.out.println(office);
        }
        em.getTransaction().commit();
        em.close();
    }
}
