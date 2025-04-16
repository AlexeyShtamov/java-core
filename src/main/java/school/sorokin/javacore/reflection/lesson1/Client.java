package school.sorokin.javacore.reflection.lesson1;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Client {

    public static void main(String[] args) {
        Class<?> clazz = Person.class;

        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(Arrays.toString(clazz.getInterfaces()));
        System.out.println(Modifier.isPublic(clazz.getModifiers()));
    }
}
