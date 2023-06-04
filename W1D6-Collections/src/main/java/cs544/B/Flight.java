package cs544.B;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.SQLData;

@Entity
@Data
@NoArgsConstructor
//@EqualsAndHashCode
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightnumber;
    @Column(name = "dest")
    private String from;
    @Column(name = "arr")
    private String to;
    private String date;

    public Flight(String flightnumber, String from, String to, String date) {
        this.flightnumber = flightnumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }
}
