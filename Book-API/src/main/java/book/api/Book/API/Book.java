package book.api.Book.API;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import book.api.Book.API.Author;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int year;
    private int rating; // rating from 1-5

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
