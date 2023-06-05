package cs544.E;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Reservation2> reservation2List = new ArrayList<>();

    public Customer2(String name) {
        this.name = name;
    }

    public void addReservation(Reservation2 reservation2) {
        reservation2List.add(reservation2);
    }
}
