package school.sorokin.javacore.collection.exam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String MAIN_TEXT = """
            Выберите номер операции:
            «1»: Добавить контакт
            «2»: Удалить контакт
            «3»: Посмотреть все контакты
            «4»: Найти контакт
            «5»: Посмотреть контакты по группе
            «0»: Выход
            """;

    private final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();

        boolean isWork = true;
        while (isWork){

            System.out.println(MAIN_TEXT);

            int operation = Integer.parseInt(scanner.nextLine());

            switch (operation){
                case 1 -> addContact(contactBook);
                case 2 -> removeContact(contactBook);
                case 3 -> watchAllContacts(contactBook);
                case 4 -> searchContactByName(contactBook);
                case 5 -> searchByGroup(contactBook);
                case 0 -> isWork = false;
                default -> throw new InputMismatchException("ERROR: Вы ввели несуществующую операцию.");
                }
        }
    }

    private static void addContact(ContactBook contactBook){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите номер телефона: ");
        String phone = scanner.nextLine();
        System.out.println("Введите email: ");
        String email = scanner.nextLine();
        System.out.println("Введите группу: ");
        String group = scanner.nextLine();

        contactBook.addContact(name, phone, email, group);
    }

    private static void removeContact(ContactBook contactBook){
        System.out.println("Введите email: ");
        String email = scanner.nextLine();

        contactBook.removeContact(email);
    }

    private static void watchAllContacts(ContactBook contactBook){
        System.out.println("Список всех контактов:");
        contactBook.watchAllContacts();
    }

    private static void searchContactByName(ContactBook contactBook){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();

        contactBook.searchContactByName(name);
    }

    private static void searchByGroup(ContactBook contactBook){
        System.out.println("Введите группу: ");
        String group = scanner.nextLine();

        contactBook.searchByGroup(group);
    }

}
