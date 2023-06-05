package cs544.A;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Employee2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeenumber;
    private String name;
    @ManyToOne
    @JoinColumn(name="department_id")
    private Department department;


    public Employee2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeenumber=" + employeenumber +
                ", name='" + name + '\'' +
                '}';
    }
}
