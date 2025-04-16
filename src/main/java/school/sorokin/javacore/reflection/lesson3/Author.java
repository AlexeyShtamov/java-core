package school.sorokin.javacore.reflection.lesson3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // Сохраняем аннотацию в байт-коде
@Target(ElementType.METHOD) // Аннотация будет использоваться только на методах
public @interface Author {
    String authorName() default "authorName"; // Параметр с значением по умолчанию
    String date() default "defaultDate"; // Параметр с значением по умолчанию
}