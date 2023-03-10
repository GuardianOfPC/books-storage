package alexey.odinochenko.booksstorage.service.BookService;

import alexey.odinochenko.booksstorage.data.model.Book;
import alexey.odinochenko.booksstorage.exception.BookNotFoundException;

import java.util.List;

public interface BookService {
    Book getBookById(Long id) throws BookNotFoundException;

    List<Book> getAllBooks();

    void addBook(Book book);

    List<Book> getByAuthor(String author);
}
