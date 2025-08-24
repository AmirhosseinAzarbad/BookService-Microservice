package ir.speedy.bookservice.controllers;

import ir.speedy.bookservice.models.Book;
import ir.speedy.bookservice.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book/v1")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable int id) {
        return bookService.findBookById(id);
    }

    @GetMapping("/show")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping("/insert")
    public Book insertBook(@RequestBody Book book) {
        return bookService.insertBook(book);
    }
}
