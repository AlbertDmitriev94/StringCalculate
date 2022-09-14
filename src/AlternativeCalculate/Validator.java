package AlternativeCalculate;

public class Validator {

    public static void checkNumbersIsNoMoreTen(int numberOne, int numberTwo) {
        if ((numberOne < 1) || (numberOne > 10) || (numberTwo < 1) || (numberTwo > 10)) {
            throw new IllegalArgumentException("Вы ввели значение, неудолетворяющее условию (числа должны быть целочисленными от 1 до 10)");
        }
    }

}
