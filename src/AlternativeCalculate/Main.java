package AlternativeCalculate;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String firstNumber, secondNumber;
    static char operation;

    static String validOperators = "[+-/*]";

    static boolean firstNumberIsInt, secondNumberIsInt = false;

    static int firstNumberInt, secondNumberInt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строки или числа");
        /*
         * Считываем строку, которую ввел пользователь:
         */
        String input = scanner.nextLine();

        String result = Main.myMethod(input);

        System.out.println("\"" + result + "\"");

    }

    static String myMethod(String input) {

        initOperatorAndNumbers(input);

        checkNumbers(firstNumber, secondNumber);
        /*
         * Убираем пробелы:
         */

        StringBuilder stringBuilder = new StringBuilder(firstNumber);
        if (!firstNumberIsInt && !secondNumberIsInt && operation == '+') {
            stringBuilder.append(secondNumber);
        } else if (!firstNumberIsInt && !secondNumberIsInt && operation == '/') {
            throw new IllegalStateException("Ошибка при вычислении");
        } else if (!firstNumberIsInt && !secondNumberIsInt && operation == '-') {
            return subtraction();
        } else if (!firstNumberIsInt && secondNumberIsInt && operation == '/') {
            return firstNumber.substring(0, firstNumber.length() / Integer.parseInt(secondNumber));
        } else if (!firstNumberIsInt && secondNumberIsInt && operation == '*') {
            wordBuild(stringBuilder);
        }
        return addThreeDots(stringBuilder);
    }

    private static String subtraction() {
        int indexSecondWord = firstNumber.indexOf(secondNumber);
        if (indexSecondWord == -1) {
            return firstNumber;
        } else {
            return firstNumber.substring(0, indexSecondWord);
        }
    }

    private static void wordBuild(StringBuilder stringBuilder) {
        for (int i = 0; i < Integer.parseInt(secondNumber) - 1; i++) {
            stringBuilder.append(firstNumber);
        }
    }

    private static String addThreeDots(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 40) {
            return stringBuilder + "...";
        }
        return stringBuilder.toString();
    }

    private static void initOperatorAndNumbers(String input) {
        String inputWithoutSpace = input.replaceAll(" ", "");
        char[] arrayOfInputChars = new char[1000];

        //итерация для инициализации оператора
        for (int i = 0; i < inputWithoutSpace.length(); i++) {
            arrayOfInputChars[i] = inputWithoutSpace.charAt(i);
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
       checkValidOperators(arrayWithNumbers);
        //инициализация первого и второго числа
        initNumbers(arrayWithNumbers);
        defineNumbers();
    }

    private static void checkValidOperators (String [] arrayWithNumbers) {
        boolean isInvalidOperator = Arrays.asList(arrayWithNumbers).contains(validOperators);

        if (isInvalidOperator) {
            throw new IllegalArgumentException("Не верный знак операции");
        }
    }

    private static void initNumbers (String [] arrayWithNumbers) {
        firstNumber = arrayWithNumbers[0].trim().replaceAll("^\"|\"$", "");
        secondNumber = arrayWithNumbers[1].trim().replaceAll("^\"|\"$", "");
    }
    private static void defineNumbers() {
        try {
            firstNumberInt = Integer.parseInt(firstNumber);
            firstNumberIsInt = true;
        } catch (Exception exception) {
            firstNumberIsInt = false;
        }
        try {
            secondNumberInt = Integer.parseInt(secondNumber);
            secondNumberIsInt = true;
        } catch (Exception exception) {
            secondNumberIsInt = false;
        }
    }

    public static void checkNumbers(String firstNumber, String secondNumber) throws IllegalArgumentException {
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

    /*
     * Признак, определяющий то, что пользователь ввел числа
     */
    public static boolean isNumber(String number) throws RuntimeException {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}