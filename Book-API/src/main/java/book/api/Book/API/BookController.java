package book.api.Book.API;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import book.api.Book.API.Book;
import book.api.Book.API.Author;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer rating,
            @RequestParam(required = false) String author) {

        if (title != null)
            return bookService.searchByTitle(title);
        if (year != null)
            return bookService.searchByYear(year);
        if (rating != null)
            return bookService.searchByRating(rating);
        if (author != null)
            return bookService.searchByAuthor(author);
        return bookService.getAllBooks();
    }

    @PostMapping("/rate/{id}")
    public ResponseEntity<Book> rateBook(@PathVariable Long id, @RequestParam int rating) {
        if (rating < 1 || rating > 5) {
            return ResponseEntity.badRequest().build();
        }
        Book ratedBook = bookService.rateBook(id, rating);
        return ResponseEntity.ok(ratedBook);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return ResponseEntity.ok(newBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
