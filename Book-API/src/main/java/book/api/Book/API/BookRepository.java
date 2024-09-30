package book.api.Book.API;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByYear(int year);

    List<Book> findByRating(int rating);

    @Query("SELECT b FROM Book b WHERE b.author.name = :name")
    List<Book> findByAuthorName(String name);
}
