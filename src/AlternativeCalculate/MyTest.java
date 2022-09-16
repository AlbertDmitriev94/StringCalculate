package AlternativeCalculate;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void test0() {
        String input = "10+3";
        int result = Main.myMethod(input);
        Assert.assertEquals(result, 13);
    }

    @Test
    void test7() {
        String input = "11+3";
        Assert.assertThrows(IllegalArgumentException.class, () -> Main.myMethod(input));
    }

    @Test
    void test9() {
        String input = "3+word";
        Assert.assertThrows(Exception.class, () -> Main.myMethod(input));
    }

    @Test
    void test11() {
        String input = "11^6";
        Assert.assertThrows(Exception.class, () -> Main.myMethod(input));
    }


}
