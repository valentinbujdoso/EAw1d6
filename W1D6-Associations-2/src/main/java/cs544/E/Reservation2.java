package cs544.E;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Reservation2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="book2_isbn")
    private Book2 book;

    public Reservation2(String date) {
        this.date = date;
    }
}
