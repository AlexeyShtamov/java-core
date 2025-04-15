package school.sorokin.javacore.testing.lesson4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.sorokin.javacore.testing.Lesson4;

import static junit.framework.Assert.assertEquals;

public class DirtyCalculatorTest {

    private Lesson4 calculator;

    @BeforeEach
    void init(){
        calculator = new Lesson4();
    }

    @Test
    void sumCalculatroOperationTest() {
        // Проверка сложения
        assertEquals(5, calculator.sum(2, 3));
    }

    @Test
    void subtractCalculatroOperationTest() {
        // Проверка вычитания
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    void multiplyCalculatroOperationTest() {
        // Проверка умножения
        assertEquals(6, calculator.multiply(2, 3));
    }
}
