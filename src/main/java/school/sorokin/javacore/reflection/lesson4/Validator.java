package school.sorokin.javacore.reflection.lesson4;

public class Validator {
    public static void isNotNull(String name){
        if (name == null){
            System.out.println("Name should be not Null");
        }
    }
    public static void isSizeCorrect(int value, int min, int max){
        if (!(value >= min && value <= max)){
            System.out.println("Age should be between " + min + " and " + max);
        }
    }
}
