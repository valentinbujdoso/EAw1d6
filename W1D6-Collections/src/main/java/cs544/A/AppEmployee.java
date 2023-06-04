package cs544.A;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AppEmployee {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee emp1 = new Employee("firstName1", "lastName1");
        Laptop laptop1 = new Laptop("band1", "1", emp1);
        Laptop laptop2 = new Laptop("band1", "2", emp1);
        emp1.addLaptop(laptop1);
        emp1.addLaptop(laptop2);
        em.persist(emp1);


        Employee emp2 = new Employee("firstName2", "lastName2");
        Laptop laptop3 = new Laptop("band2", "1", emp2);
        emp2.addLaptop(laptop3);
        em.persist(emp2);

        Employee emp3 = new Employee("firstName3", "lastName3");
        Laptop laptop4 = new Laptop("band3", "1", emp3);
        emp3.addLaptop(laptop4);
        em.persist(emp3);

        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        List<Employee> employeeList = query.getResultList();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        em.getTransaction().commit();
        em.close();
    }
}
