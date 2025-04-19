package school.sorokin.javacore.oop.exam;

public enum Type {
    BOOK("Книга"),
    MAGAZINE("Журнал"),
    NEWSPAPER("Газета");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
