package cs544.B;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@EqualsAndHashCode
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade=CascadeType.PERSIST)
    private List<Flight> flightList = new ArrayList<>();

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger(String name, List<Flight> flight) {
        this.name = name;
        flightList = flight;
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

}
