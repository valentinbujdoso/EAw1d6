package cs544.A;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="employee", cascade=CascadeType.PERSIST)
    private Set<Laptop> laptopSet = new HashSet<>();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, Set<Laptop> laptopSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.laptopSet = laptopSet;
    }

    public void addLaptop(Laptop laptop) {
        this.laptopSet.add(laptop);
    }
}
