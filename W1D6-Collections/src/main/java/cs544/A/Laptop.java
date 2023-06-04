package cs544.A;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String band;
    private String type;
    @ManyToOne
    @JoinColumn(name="employee_id")
    private Employee employee;

    public Laptop(String band, String type, Employee employee) {
        this.band = band;
        this.type = type;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", band='" + band + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
