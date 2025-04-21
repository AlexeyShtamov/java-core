package school.sorokin.javacore.exception.exam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String MAIN_TEXT = """
            Выберите номер операции:
            1. Вывести каталог.
            2. Добавить объект.
            3. Выдать объект.
            4. Вернуть объект.
            5. Выйти из приложения.
            """;

    private final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        Library library = new Library();

        boolean isWork = true;
        while (isWork){
            try {
                System.out.println(MAIN_TEXT);

                int operation;
                try {
                    operation = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Вы ввели число в неправильно формате.");
                    continue;
                }

                switch (operation){
                    case 1 -> watchAllBooks(library);
                    case 2 -> addBook(library);
                    case 3 -> issueBook(library);
                    case 4 -> returnBook(library);
                    case 5 -> isWork = false;
                    default -> throw new InputMismatchException("ERROR: Вы ввели несуществующую операцию.");
                }

            } catch (NoAvailableCopiesException | ItemNotFoundException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();

    }

    private static void watchAllBooks(Library library){
        for (Book book : library.getAllBooks()){
            System.out.println(book);
        }
    }

    private static void issueBook(Library library) throws NoAvailableCopiesException, ItemNotFoundException {
        System.out.println("Введите название книги, которую хотите взять: ");
        String title = scanner.nextLine();

        library.takeBook(title);
        System.out.println("Книга взята.");
    }

    private static void returnBook(Library library) throws ItemNotFoundException {
        System.out.println("Введите название книги, которую хотите вернуть: ");
        String title = scanner.nextLine();

        library.returnBook(title);
        System.out.println("Книга возвращена.");
    }

    private static void addBook(Library library){
        System.out.println("Введите название книги, которую хотите добавить в каталог: ");
        String title = scanner.nextLine();
        System.out.println("Введите автора: ");
        String author = scanner.nextLine();

        System.out.println("Введите количество, которое хотите добавить: ");
        try {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity < 0)
                throw new NegativeOrZeroQuantityException("ERROR: Вы не можете добавить " + quantity + " экземпляров." +
                        " Количество должно быть больше 0.");

            library.addBook(title, author, quantity);

        } catch (NegativeOrZeroQuantityException e) {
            System.out.println(e.getMessage());
            return;
        } catch (NumberFormatException e){
            System.out.println("Вы ввели число в неправильно формате.");
            return;
        }

        System.out.println("Книга добавлена.");

    }

}
