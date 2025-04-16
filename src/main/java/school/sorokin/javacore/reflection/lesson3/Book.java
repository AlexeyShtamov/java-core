package school.sorokin.javacore.reflection.lesson3;

import java.lang.reflect.Method;

public class Book  {

    private String authorName;

    private String description;

    public Book(String authorName, String description) {
        this.authorName = authorName;
        this.description = description;
    }

    @Author(authorName = "Алексей Штамов", date = "16-04-2025")
    public void readDescription() {
        System.out.println("This method is annotated.");
    }

    @Author(authorName = "Иван Петров", date = "10-04-2025")
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public static void main(String[] args) {
         Method[] methods = Book.class.getDeclaredMethods();

         for (Method method : methods){
             if (method.isAnnotationPresent(Author.class)){
                 Author annotation = method.getAnnotation(Author.class);

                 System.out.println(annotation.authorName() + " " + annotation.date());
             }
         }
    }
}
