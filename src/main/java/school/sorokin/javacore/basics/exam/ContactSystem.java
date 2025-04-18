package school.sorokin.javacore.basics.exam;

import java.util.Arrays;
import java.util.Scanner;

public class ContactSystem {

    private String[] names = new String[100];
    private String[] phoneNumbers = new String[100];

    private int count = 0;

    private static final String START_TEXT = """
                \n\nНапишите номер действия, которое хотите совершить:
                Добавить контакт - 1
                Просмотреть контакты - 2
                Найти контакт - 3
                Удалить контакт - 4
                Выйти - 5
                
                Ваша цифра ->""";

    public static void main(String[] args) {

        boolean isWork = true;
        ContactSystem cs = new ContactSystem();

        Scanner scanner = new Scanner(System.in);
        while (isWork){
            System.out.print(START_TEXT);
            int numOfAction = Integer.parseInt(scanner.nextLine());

            switch (numOfAction){
                case 1 -> cs.addContact(scanner);
                case 2 -> cs.viewAllContacts();
                case 3 -> cs.findContact(scanner);
                case 4 -> cs.deleteContact(scanner);
                case 5 -> isWork = false;
                default -> System.out.println("Такой операции не существует");
            }

        }
        System.out.println("До скорой встречи!");
    }


    public void addContact(Scanner scanner){
        if (names.length <= count + 1){
            System.out.println("Нет места для добавления нового контакта");
            return;
        }

        System.out.print("\nДобавление контакта\n");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("\nВведите номер телефона: ");
        String phoneNumber = scanner.nextLine();

        this.names[count] = name;
        this.phoneNumbers[count++] = phoneNumber;

        System.out.print("\nКонтакт добавлен");

    }

    public void viewAllContacts(){
        System.out.print("\nПросмотр контакта\n");

        for (int i = 0; i < this.names.length; i++) {
            if(names[i] != null)
                System.out.printf("Имя: %s. Номер телефона: %s\n", this.names[i], this.phoneNumbers[i]);
        }
    }

    public void findContact(Scanner scanner){
        System.out.print("\nПоиск контакт\n");

        System.out.print("Введите имя контакта, который хотите найти: ");
        String name = scanner.nextLine();

        for (int i = 0; i < this.names.length; i++) {
            if (name != null && name.equals(this.names[i])){
                System.out.printf("\nНорме телефона контакта %s - %s\n", this.names[i], this.phoneNumbers[i]);
                return;
            }
        }
        System.out.println("\nНет контакта с таким именем.");
    }

    public void deleteContact(Scanner scanner){
        System.out.print("\nУдаление контакта\n");

        System.out.print("Введите имя контакта, который хотите удалить: ");
        String name = scanner.nextLine();

        boolean isFound = false;
        for (int i = 0; i < this.names.length; i++) {

            int currentIndex = 0;
            if (name != null && name.equals(this.names[i])){
                isFound = true;
                currentIndex = i;
                System.out.printf("\nКонтакта %s - удален\n", this.names[i]);
            }

            if (isFound && currentIndex != i){
                names[i - 1] = names[i];
                phoneNumbers[i - 1] = phoneNumbers[i];
            }
        }
        if (isFound){
            names[names.length - 1] = null;
            phoneNumbers[phoneNumbers.length - 1] = null;
            count--;
        } else System.out.println("\nНет номера с таким именем");
    }


}
