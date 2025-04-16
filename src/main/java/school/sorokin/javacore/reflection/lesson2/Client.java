package school.sorokin.javacore.reflection.lesson2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) throws RuntimeException {
        try {
            Constructor<?> constructors = Student.class.getDeclaredConstructor();
            constructors.setAccessible(true);

            Student student = (Student) constructors.newInstance();

            Field[] fields = Student.class.getDeclaredFields();

            for (Field field: fields){
                System.out.println(field.getName());
            }

            System.out.println("-------------------------");

            Field field = Student.class.getDeclaredField("name");
            field.setAccessible(true);

            field.set(student, "Andrey");
            System.out.println(field.get(student));

            System.out.println("-------------------------");

            Method method = Student.class.getDeclaredMethod("studySecretly");
            method.setAccessible(true);
            method.invoke(student);

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
