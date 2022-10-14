package StringCalculate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void test3() {
        String input = "a+b";
        String result = Main.prepareAndCalculate(input);
        Assert.assertEquals(result, "ab");
    }

    @Test
    void test10() {
        String input = "hi/acjk";
        Assert.assertThrows(IllegalStateException.class, () -> Main.prepareAndCalculate(input));
    }

    @Test
    void test7() {
        String input = "11+3";
        Assert.assertThrows(IllegalArgumentException.class, () -> Main.prepareAndCalculate(input));
    }

    @Test
    void test9() {
        String input = "3+word";
        Assert.assertThrows(Exception.class, () -> Main.prepareAndCalculate(input));
    }

    @Test
    void test5() {
        String input = "word*3";
        String result = Main.prepareAndCalculate(input);
        Assert.assertEquals(result, "wordwordword");
    }

    @Test
    void test41() {
        String input = "word/2";
        String result = Main.prepareAndCalculate(input);
        Assert.assertEquals(result, "wo");
    }

    @Test
    void test42() {
        String input = "word/4";
        String result = Main.prepareAndCalculate(input);
        Assert.assertEquals(result, "w");
    }

//    @Test
//    void test61() {
//        String input = "Bye-bye!" '-' "World!";
//        String result = Main.prepareAndCalculate(input);
//        Assert.assertEquals(result, "Bye-bye!");
//    }
//
//    @Test
//    void test62() {
//        String input = "wordhi-hi";
//        String result = Main.prepareAndCalculate(input);
//        Assert.assertEquals(result, "word");
//    }

    @Test
    void test72() {
        String input = "world*10";
        String result = Main.prepareAndCalculate(input);
        Assert.assertEquals(result, "worldworldworldworldworldworldworldworldworldworld...");
    }


//    @Test
//    void test11() {
//        String input = "11^6";
//        Assert.assertThrows(Exception.class, () -> Main.myMethod(input));
//    }


}
