package StringCalculate;

import java.util.Arrays;

import static StringCalculate.Initializer.*;
import static StringCalculate.Main.validOperators;

public class Validator {
    public void checkValidOperator(String[] arrayWithNumbers) {
        if (Arrays.asList(arrayWithNumbers).contains(validOperators)) {
            throw new IllegalArgumentException("Не верный знак операции");
        }
    }

    public void checkNumbers() throws IllegalArgumentException {
        //Сделать 2 проверки: 1. если внутри строки число, то не надо кидать исключение, если внутри буквы, кинуть искл.
        // (18строка)
        //3 + "hello" + "3" - на первую тройку кидать исключение, на вторую - рассчет
//        if (firstOperandIsInt) {
//            throw new IllegalArgumentException("Первым аргументом выражения, подаваемого на вход, должна быть строка");
//        }
//        if (firstOperand.lastIndexOf("\"")) || firstOperandIsInt == true) {
//            throw new IllegalArgumentException("Первым аргументом выражения, подаваемого на вход, должна быть строка")
//        }
        if (!arrayWithNumbers[0].contains("\"")) {
            if (secondOperandIsInt && (secondOperandInt < 1 || secondOperandInt > 10)) {
                throw new IllegalArgumentException("Вы ввели значение, неудолетворяющее условию (числа должны быть " +
                        "целочисленными от 1 до 10)");
            }
        }

        if (firstOperand.length() > 10 || secondOperand.length() > 10) {
            throw new IllegalArgumentException("Вы ввели значение, неудолетворяющее условию (длина строки должна быть " +
                    "не больше 10)");
        }
    }
}

