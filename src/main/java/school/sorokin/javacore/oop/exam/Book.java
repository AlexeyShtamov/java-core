package school.sorokin.javacore.oop.exam;

import java.util.Objects;

import static school.sorokin.javacore.oop.exam.Type.BOOK;

public class Book extends Publication implements Printable{

    private String ISBN;

    public Book(String title, String author, int year, String ISBN) {
        super(title, author, year);
        this.ISBN = ISBN;
    }


    @Override
    public String getType() {
        return BOOK.getName();
    }

    @Override
    public void printDetails() {
        System.out.printf("%s с названием '%s'. ISBN: %s. © %s, %d\n",
                getType(), getTitle(), ISBN, getAuthor(), getYear());
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                '}' + " " + super.toString();
    }
}
