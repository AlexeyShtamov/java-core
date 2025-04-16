package school.sorokin.javacore.reflection.lesson2;

public class Student {

    private String name;
    private short age;
    public String university;

    public Student(String name, short age, String university) {
        this.name = name;
        this.age = age;
        this.university = university;
    }

    private Student(){
        this.name = "default_name";
        this.age = 0;
        this.university = "default_university";
    }

    public void introduce(){
        System.out.println("My name is " + name);
    }

    private void  studySecretly(){
        System.out.println("My age is" + age);
    }
}
