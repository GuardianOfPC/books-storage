package alexey.odinochenko.booksstorage.controller;

import alexey.odinochenko.booksstorage.data.model.Book;
import alexey.odinochenko.booksstorage.data.request.BookRequest;
import alexey.odinochenko.booksstorage.exception.BookNotFoundException;
import alexey.odinochenko.booksstorage.mapper.BookToDtoMapper;
import alexey.odinochenko.booksstorage.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookToDtoMapper bookToDtoMapper;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest request) {
        bookService.addBook(bookToDtoMapper.BookRequestToBook(request));
    }

    @GetMapping("/byAuthor")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookService.getByAuthor(author);
    }
}
