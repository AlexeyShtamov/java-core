package school.sorokin.javacore.testing.lesson2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.sorokin.javacore.testing.Lesson2;

import static junit.framework.Assert.assertEquals;

public class Lesson2Test {

    private Lesson2 lesson2;

    @BeforeEach
    void arrange(){
        lesson2 = new Lesson2();
    }

    @Test
    void multiplyTest(){

        int result = lesson2.multiply(5, 2);

        assertEquals(10, result);
    }

    @Test
    void sumTest(){
        int result = lesson2.sum(5, 2);

        assertEquals(7, result);
    }

}
