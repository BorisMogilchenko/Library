package ru.quazar.Library.service;

import lombok.Data;
import ru.quazar.Library.model.Book;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @version $Id: FileGetter.java,v 1.0 2019-08-15 23:30:42 Exp $
 * @author  <A HREF="mailto:boris.mogilchenko@yandex.ru">Boris Mogilchenko</A>
 */

@Data
public class LoadFileToList {

    public List<Book> makeListFromFile(String strArgs) {

        String inFileName = "";

        GettingFileService gettingFileService = new GettingFileService();

        if (strArgs.length() == 0) {
            inFileName = "";
        } else {
            inFileName = strArgs;
        }

        File inputFile = gettingFileService.getFileWithConditions(inFileName);
        List< Book > booksCatalog = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(inputFile);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader bufRead = new BufferedReader(isr)
        ) {
            String line;
            long id = 1L;

            while ((line = bufRead.readLine()) != null) {
                List<String> booksProperty = Arrays.asList(line.split("\\s*,\\s*"));
                booksCatalog.add(new Book(id++, false, booksProperty.get(0), booksProperty.get(1), new BigDecimal(booksProperty.get(2))));
            }
        } catch (
                IOException ex) {
            ex.printStackTrace(System.out);
        }
/*        booksCatalog.forEach(bk -> {
            System.out.println("Название книги: " + bk.getTitle());
            System.out.println("Наличие книги: " + (bk.getBusy() ? "Нет" : "Да"));
        });*/

        return booksCatalog;
    }

}
