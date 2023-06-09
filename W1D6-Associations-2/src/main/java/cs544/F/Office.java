package cs544.F;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomnumber;
    private String building;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Employee3> employeeList = new ArrayList<>();

    public Office(String building) {
        this.building = building;
    }

    public void addEmployee(Employee3 employee) {
        employeeList.add(employee);
        employee.setOffice(this);
    }
}
