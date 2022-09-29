package AlternativeCalculate;

import java.util.Arrays;

import static AlternativeCalculate.Main.validOperators;

public class Validator {
    public void checkValidOperators(String[] arrayWithNumbers) {
        boolean isInvalidOperator = Arrays.asList(arrayWithNumbers).contains(validOperators);

        if (isInvalidOperator) {
            throw new IllegalArgumentException("Не верный знак операции");
        }
    }

    public void checkNumbers(String firstNumber, String secondNumber,boolean firstNumberIsInt) throws IllegalArgumentException {
        try {
            if (firstNumberIsInt) {
                throw new IllegalArgumentException("Первым аргументом выражения, подаваемого на вход, должна быть строка");
            }

            int numberTwo = Integer.parseInt(secondNumber);

            if (numberTwo < 1 || numberTwo > 10) {
                throw new IllegalArgumentException("Вы ввели значение, неудолетворяющее условию (числа должны быть " +
                        "целочисленными от 1 до 10)");
            }
        } catch (NumberFormatException e) {
            if (firstNumber.length() > 10 || secondNumber.length() > 10) {
                throw new IllegalArgumentException("Вы ввели значение, неудолетворяющее условию (длина строки должна быть не больше 10)");
            }
        }
    }
}
