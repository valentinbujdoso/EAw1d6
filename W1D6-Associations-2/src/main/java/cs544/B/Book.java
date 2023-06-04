package cs544.B;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;
    @ManyToOne
    @JoinTable(name = "book_publisher",
        joinColumns = { @JoinColumn(name = "publisher_id")},
        inverseJoinColumns = { @JoinColumn(name = "books_id")})
    private Publisher publisher;
}
