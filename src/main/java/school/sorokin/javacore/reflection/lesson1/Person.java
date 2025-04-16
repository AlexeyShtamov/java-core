package school.sorokin.javacore.reflection.lesson1;

public class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello(){
        System.out.println(name + " is talking \"Hello\"");
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
