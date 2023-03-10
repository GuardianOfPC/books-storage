package alexey.odinochenko.booksstorage.service;

import alexey.odinochenko.booksstorage.data.entity.BookEntity;
import alexey.odinochenko.booksstorage.exception.BookNotFoundException;
import alexey.odinochenko.booksstorage.mapper.BookToEntityMapper;
import alexey.odinochenko.booksstorage.data.model.Book;
import alexey.odinochenko.booksstorage.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookToEntityMapper bookToEntityMapper;

    @Override
    public Book getBookById(Long id) throws BookNotFoundException {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));

        return bookToEntityMapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for (BookEntity bookEntity : iterable) {
            books.add(bookToEntityMapper.bookEntityToBook(bookEntity));
        }

        return books;
    }

    @Override
    public void addBook(Book book) {
        BookEntity bookEntity = bookToEntityMapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    @Override
    public List<Book> getByAuthor(String author) {
        List<BookEntity> iterable = bookRepository.findAllByAuthorContaining(author);
        ArrayList<Book> books = new ArrayList<>();
        iterable.forEach(e -> {
            books.add(bookToEntityMapper.bookEntityToBook(e));
        });

        return books;
    }
}
