package ru.quazar.Library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.quazar.Library.model.Book;
import ru.quazar.Library.repository.BookRepository;
import ru.quazar.Library.service.LoadFileToList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @version $Id: FileGetter.java,v 1.0 2021-01-15 20:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 *
 */

@Component
public class LibraryRunner implements CommandLineRunner {

    private List< Book > booksCatalog;
    private static final Logger logger = LoggerFactory.getLogger(SpringBootMultithreadApplication.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) {
        String strArgs = Arrays.stream(args).collect(Collectors.joining(" "));
        logger.info("Application started with arguments:" + strArgs);
        System.out.println("Loading argument: " + strArgs);
        booksCatalog = new LoadFileToList().makeListFromFile(strArgs);

        booksCatalog.forEach(System.out::println);
        initDatabase(bookRepository);
    }

    @Bean
    CommandLineRunner initDatabase(BookRepository repository) {
        return args -> {
            for (Book myBook : booksCatalog) {
                repository.save(myBook);
            }
        };
    }

}