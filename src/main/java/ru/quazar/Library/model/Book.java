package ru.quazar.Library.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 *
 * @version $Id: FileGetter.java,v 1.0 2021-01-15 20:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 *
 */

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean isBusy;
    private String title;
    private String author;
    private BigDecimal price;

    public Book() {};

    public Book(long id, boolean isBusy, String title, String author, BigDecimal price) {
        this.id = id;
        this.isBusy = isBusy;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
