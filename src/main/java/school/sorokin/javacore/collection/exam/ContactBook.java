package school.sorokin.javacore.collection.exam;

import school.sorokin.javacore.reflection.lesson3.Book;

import java.util.*;

public class ContactBook {
    private final List<Contact> contactList;
    private final Set<Contact> contactSet;
    private final Map<String, LinkedList<Contact>> contactMap;

    public ContactBook(){
        this.contactList = new ArrayList<>();
        this.contactSet = new HashSet<>();
        this.contactMap = new HashMap<>();
    }

    public void addContact(String name, String phone, String email, String group){
        Contact contact = new Contact(name, phone, email, group);
        if (!contactSet.contains(contact)){
            contactSet.add(contact);
            contactList.add(contact);
            contactMap.computeIfAbsent(group, k -> new LinkedList<>()).add(contact);
            return;
        }
        System.out.println("Такой элемент уже есть в контактной книге.");
    }

    public void removeContact(String email){

        try {

        Contact contact = contactSet.stream().filter(e -> e.getEmail().equals(email)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Контакт уже отсутствует в контактной книге."));

        contactSet.remove(contact);
        contactList.remove(contact);
        contactMap.getOrDefault(contact.getGroup(), new LinkedList<>()).remove(contact);
        System.out.println("Контакт удален из контактной книги");
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public void watchAllContacts(){

        Iterator<Contact> iterator = contactList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void searchContactByName(String name){
        try {
            Contact contact = contactList.stream().filter(e -> e.getName().equals(name)).findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Контакта с таким именем не существует в книге."));

            System.out.println(contact);
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public void searchByGroup(String group){
        LinkedList<Contact> contacts = contactMap.get(group);

        if (contacts == null){
            System.out.println("Такой группы не существует");
            return;
        }

        System.out.printf("Group %s: \n", group);
        for (Contact contact : contacts){
            System.out.println(contact);
        }
    }
}
