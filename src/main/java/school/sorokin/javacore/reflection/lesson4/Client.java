package school.sorokin.javacore.reflection.lesson4;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws IllegalAccessException {
        Person person1 = new Person("Bob", 25);
        Person person2 = new Person(null, 25);
        Person person3 = new Person("Bob", 442324234);
        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);

        for (Person person : people){
            Field[] fields = Person.class.getDeclaredFields();

            for (Field field : fields){
                field.setAccessible(true);
                if (field.isAnnotationPresent(Size.class)){
                    Size size = field.getAnnotation(Size.class);
                    Validator.isSizeCorrect((int) field.get(person), size.min(), size.max());
                }

                if (field.isAnnotationPresent(NotNull.class)){;
                    Validator.isNotNull((String) field.get(person));
                }
            }
        }
    }


}
