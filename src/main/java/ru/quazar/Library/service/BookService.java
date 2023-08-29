package ru.quazar.Library.service;

import ru.quazar.Library.model.Book;
import ru.quazar.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @version $Id: FileGetter.java,v 1.0 2021-01-15 20:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 *
 */

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book savedBook = repository.findById(id).get();
        savedBook.setAuthor(book.getAuthor());
        savedBook.setTitle(book.getTitle());
        savedBook.setPrice(book.getPrice());
        return repository.save(savedBook);
    }

    public Book getBook(Long id) {
        return repository.findById(id).get();
    }

    public void deleteAllBooks() {
        repository.deleteAll();
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
