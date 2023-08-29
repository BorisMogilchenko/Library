package ru.quazar.Library.controller;

import ru.quazar.Library.model.Book;
import ru.quazar.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @version $Id: FileGetter.java,v 1.0 2021-01-15 20:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 *
 */

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/books")
    Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("books/{id}")
    Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.updateBook(id, book);
    }

    @GetMapping("/books/{id}")
    Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/books")
    void deleteAllBooks() {
        bookService.deleteAllBooks();
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
