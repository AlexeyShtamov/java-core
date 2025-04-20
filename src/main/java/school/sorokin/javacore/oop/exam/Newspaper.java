package school.sorokin.javacore.oop.exam;

import java.util.Objects;

import static school.sorokin.javacore.oop.exam.Type.NEWSPAPER;

public class Newspaper extends Publication implements Printable{

    private String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }

    @Override
    public String getType() {
        return NEWSPAPER.getName();
    }

    @Override
    public void printDetails() {
        System.out.printf("%s с названием '%s'. Day of publication: %s. © %s, %d\n",
                getType(), getTitle(), publicationDay, getAuthor(), getYear());
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "publicationDay='" + publicationDay + '\'' +
                '}' + " " + super.toString();
    }
}
