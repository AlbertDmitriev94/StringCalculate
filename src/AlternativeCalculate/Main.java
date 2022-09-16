package AlternativeCalculate;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int numberOneAfterConverting, numberTwoAfterConverting;
    static String firstNumber, secondNumber;
    static char operation;

    static String validOperators = "[+-/*]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строки или числа");
        /*
         * Считываем строку, которую ввел пользователь:
         */
        String input = scanner.nextLine();

        /*
         * Убираем пробелы:
         */
        String inputWithoutSpace = input.replaceAll(" ", "");

        initOperatorAndNumbers(inputWithoutSpace);
        converting(firstNumber, secondNumber);
        checkNumbersIsNoMoreTen(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber));
        int result = calculation(numberOneAfterConverting, numberTwoAfterConverting, operation);

        System.out.println("Результат: ");
        System.out.println(firstNumber + " " + operation + " " + secondNumber + " = " + result);

    }

    private static void converting(String firstNumber, String secondNumberWithTrim) {
//        if (isRoman) {
//            numberOneAfterConverting = romanToArabic(firstNumber);
//            numberTwoAfterConverting = romanToArabic(secondNumberWithTrim);
//        } else {
            numberOneAfterConverting = Integer.parseInt(firstNumber);
            numberTwoAfterConverting = Integer.parseInt(secondNumberWithTrim);
//        }
    }
    public static int calculation(int numberOne, int numberTwo, char operator) {
        return switch (operator) {
            case '+' -> numberOne + numberTwo;
            case '-' -> numberOne - numberTwo;
            case '*' -> numberOne * numberTwo;
            case '/' -> numberOne / numberTwo;
            default -> throw new IllegalStateException("Ошибка при вычислении");
        };
    }

    private static void initOperatorAndNumbers(String input) {
        char[] arrayOfInputChars = new char[10];

        //итерация для инициализации оператора
        for (int i = 0; i < input.length(); i++) {
            arrayOfInputChars[i] = input.charAt(i);
            if (arrayOfInputChars[i] == '+') {
                operation = '+';
            }
            if (arrayOfInputChars[i] == '-') {
                operation = '-';
            }
            if (arrayOfInputChars[i] == '*') {
                operation = '*';
            }
            if (arrayOfInputChars[i] == '/') {
                operation = '/';
            }
        }
        String inputChars = String.valueOf(arrayOfInputChars);
        String[] arrayWithNumbers = inputChars.split(validOperators);

        //проверка валидности оператора
        boolean isInvalidOperator = Arrays.asList(arrayWithNumbers).contains(validOperators);

        if (isInvalidOperator) {
            throw new IllegalArgumentException("Не верный знак операции");
        }
             //инициализация первого и второго числа
        firstNumber = arrayWithNumbers[0].trim();
        secondNumber = arrayWithNumbers[1].trim();
    }

    public static void checkNumbersIsNoMoreTen(int numberOne, int numberTwo) {
        if ((numberOne < 1) || (numberOne > 10) || (numberTwo < 1) || (numberTwo > 10)) {
            throw new IllegalArgumentException("Вы ввели значение, неудолетворяющее условию (числа должны быть " +
                    "целочисленными от 1 до 10)");
        }
    }
}