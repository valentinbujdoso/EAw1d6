package cs544.F;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeenumber;
    private String name;
    @ManyToOne
    @JoinColumn(name="department2_id")
    private Department2 department;
    @ManyToOne
    @JoinColumn(name = "office_roomnumber")
    private Office office;

    public Employee3(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee3{" +
                "employeenumber=" + employeenumber +
                ", name='" + name + '\'' +
                '}';
    }
}
