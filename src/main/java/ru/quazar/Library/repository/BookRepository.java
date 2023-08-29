package ru.quazar.Library.repository;

import ru.quazar.Library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @version $Id: FileGetter.java,v 1.0 2021-01-15 20:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 *
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
