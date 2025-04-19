package school.sorokin.javacore.oop.exam;

import java.util.Objects;

import static school.sorokin.javacore.oop.exam.Type.MAGAZINE;

public class Magazine extends Publication implements Printable{

    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getType() {
        return MAGAZINE.getName();
    }

    @Override
    public void printDetails() {
        System.out.printf("%s с названием '%s'. Issue number: %d. © %s, %d\n",
                getType(), getTitle(), issueNumber, getAuthor(), getYear());
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return issueNumber == magazine.issueNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issueNumber);
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber=" + issueNumber +
                '}' + " " + super.toString();
    }
}
