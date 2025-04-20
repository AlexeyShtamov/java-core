package school.sorokin.javacore.oop.exam;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private final static String MAIN_TEXT = """
            \nВыберите номер опции:
            Опция 1: Добавить новую публикацию.
            Опция 2: Вывести список всех публикаций.
            Опция 3: Поиск публикации по автору.
            Опция 4: Вывести общее количество публикаций.
            Опция 0: Выход.
            """;

    public static void main(String[] args) {

        boolean inProgress = true;


        Library library = new Library();

        while (inProgress){
            System.out.println(MAIN_TEXT);
            int option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1 -> addPublication(library);
                case 2 -> library.listPublications();
                case 3 -> findPubByAuthor(library);
                case 4 -> System.out.printf("Общее количество публикаций: %d\n"
                        , Publication.getPublicationCount());
                case 0 -> inProgress = false;
                default -> System.out.println("Операции с таким номером нет");
            }
        }

    }

    private static void findPubByAuthor(Library library){
        System.out.println("\nВведите имя автора: ");
        String author = scanner.nextLine();
        System.out.println();
        library.searchByAuthor(author);
    }

    private static void addPublication(Library library){
        System.out.println("Выберите тип публикации: 1 – Book, 2 – Newspaper, 3 – Magazine");
        int type = Integer.parseInt(scanner.nextLine());

        if (type > 3 || type < 1){
            System.out.println("Нет такого типа публикации.");
            return;
        }

        System.out.print("Введите название: ");
        String title = scanner.nextLine();
        System.out.print("\nВведите автора: ");
        String author = scanner.nextLine();
        System.out.print("\nВведите год: ");
        int year = Integer.parseInt(scanner.nextLine());

        switch (type){
            case 1 -> {
                System.out.print("\nВведите ISBN: ");
                String ISBN = scanner.nextLine();
                Publication book = new Book(title, author, year, ISBN);
                library.addPublication(book);
                System.out.println("\nКнига добавлена: " + book);
            }
            case 2 -> {
                System.out.print("\nВведите день публикации: ");
                String publicationDay = scanner.nextLine();
                Publication newspaper = new Newspaper(title, author, year, publicationDay);
                library.addPublication(newspaper);
                System.out.println("\nГазета добавлена: " + newspaper);
            }
            case 3 -> {
                System.out.print("\nВведите номер выпуска: ");
                int issueNumber = Integer.parseInt(scanner.nextLine());
                Publication magazine = new Magazine(title, author, year, issueNumber);
                library.addPublication(magazine);
                System.out.println("\nЖурнал добавлен: " + magazine);
            }
        }
    }
}
