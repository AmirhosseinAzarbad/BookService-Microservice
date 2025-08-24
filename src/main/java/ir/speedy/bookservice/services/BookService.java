package ir.speedy.bookservice.services;

import ir.speedy.bookservice.models.Book;
import ir.speedy.bookservice.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(int id) {
        return bookRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Book not found"));
    }
}
