package school.sorokin.javacore.exception.exam;

import java.util.*;

public class Library {

    private final List<Book> catalog;

    public Library(){
        this.catalog = new ArrayList<>();
    }


    public void addBook(String title, String author, int copies){
        catalog.add(new Book(title, author, copies));
    }

    public void takeBook(String title) throws NoAvailableCopiesException, ItemNotFoundException {
       Book book = catalog.stream().filter(e -> e.getTitle().equals(title)).findFirst()
               .orElseThrow(() -> new ItemNotFoundException("ERROR: Нет книги с названием " + title));

       if (book.getAvailableCopies() == 0) throw new NoAvailableCopiesException("ERROR: 0 экземпляров книги " + title);

       book.setAvailableCopies(book.getAvailableCopies() - 1);

    }

    public void returnBook(String title) throws ItemNotFoundException {
        Book book = catalog.stream().filter(e -> e.getTitle().equals(title)).findFirst()
                .orElseThrow(() -> new ItemNotFoundException("ERROR: Нет книги с названием " + title));

        book.setAvailableCopies(book.getAvailableCopies() + 1);
    }

    public List<Book> getAllBooks(){
        return catalog;
    }
}
