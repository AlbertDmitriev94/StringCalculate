package AlternativeCalculate;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void test10() {
        String input = "hi/acjk";
        Assert.assertThrows(IllegalStateException.class, () -> Main.myMethod(input));
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
    void test5() {
        String input = "word*3";
        String result = Main.myMethod(input);
        Assert.assertEquals(result, "wordwordword");
    }

    @Test
    void test41() {
        String input = "word/2";
        String result = Main.myMethod(input);
        Assert.assertEquals(result, "wo");
    }

    @Test
    void test42() {
        String input = "word/1";
        String result = Main.myMethod(input);
        Assert.assertEquals(result, "word");
    }

    @Test
    void test61() {
        String input = "word-hi";
        String result = Main.myMethod(input);
        Assert.assertEquals(result, "word");
    }

    @Test
    void test62() {
        String input = "wordhi-hi";
        String result = Main.myMethod(input);
        Assert.assertEquals(result, "word");
    }

    @Test
    void test72() {
        String input = "wordwordwordwordwordwordwordwordwordwwor+d";
        String result = Main.myMethod(input);
        Assert.assertEquals(result, "wordwordwordwordwordwordwordwordwordwword...");
    }
//
//    @Test
//    void test11() {
//        String input = "11^6";
//        Assert.assertThrows(Exception.class, () -> Main.myMethod(input));
//    }


}
