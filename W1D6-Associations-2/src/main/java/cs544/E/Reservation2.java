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
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Book2> bookList = new ArrayList<>();

    public Reservation2(String date) {
        this.date = date;
    }

    public void addBook(Book2 book) {
        bookList.add(book);
    }
}
