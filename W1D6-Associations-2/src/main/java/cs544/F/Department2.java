package cs544.F;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Department2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Employee3> employeeList = new ArrayList<>();

    public Department2(String name) {
        this.name = name;
    }

    public void addEmployee(Employee3 employee) {
        employeeList.add(employee);
        employee.setDepartment(this);
    }
}
