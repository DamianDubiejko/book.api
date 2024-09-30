package book.api.Book.API;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookServiceTest {

    private final BookRepository bookRepository = Mockito.mock(BookRepository.class);
    private final BookService bookService = new BookService(bookRepository);

    @Test
    void rateBook() {
        Book book = new Book(1L, "Test Book", 2020, 0, null);
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Mockito.when(bookRepository.save(book)).thenReturn(book);

        Book ratedBook = bookService.rateBook(1L, 4);
        assertEquals(4, ratedBook.getRating());
    }
}
