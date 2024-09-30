package book.api.Book.API;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> searchByYear(int year) {
        return bookRepository.findByYear(year);
    }

    public List<Book> searchByAuthor(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }

    public List<Book> searchByRating(int rating) {
        return bookRepository.findByRating(rating);
    }

    public Book rateBook(Long bookId, int rating) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        book.setRating(rating);
        return bookRepository.save(book);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}