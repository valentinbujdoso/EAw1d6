package cs544.D;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Reservation> reservationList = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }
}
