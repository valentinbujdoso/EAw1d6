package cs544.A;

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


        Department dept1 = new Department("Department1");
        Employee2 employee1 = new Employee2("Employee1");
        Employee2 employee2 = new Employee2("Employee1");

        dept1.addEmployee(employee1);
        dept1.addEmployee(employee2);

        em.persist(dept1);


        Department dept2 = new Department("Department2");
        Employee2 employee3 = new Employee2("Employee3");

        dept2.addEmployee(employee3);

        em.persist(dept2);


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
