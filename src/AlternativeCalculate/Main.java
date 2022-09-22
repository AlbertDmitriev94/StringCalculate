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

        String result = Main.myMethod(input);

        System.out.println("Результат: ");
        System.out.println(firstNumber + " " + operation + " " + secondNumber + " = " + result);

    }

    static String myMethod(String input) {
        /*
         * Убираем пробелы:
         */
        String inputWithoutSpace = input.replaceAll(" ", "");

        initOperatorAndNumbers(inputWithoutSpace);
//        converting(firstNumber, secondNumber);
        if (!isNumber(firstNumber) && !isNumber(secondNumber) && operation == '/') {
            throw new IllegalStateException("Ошибка при вычислении");
        }

        if (!isNumber(firstNumber) && !isNumber(secondNumber) && operation == '-') {
            int indexSecondWord = firstNumber.indexOf(secondNumber);
            if (indexSecondWord == -1) {
                return firstNumber;
            } else {
                return firstNumber.substring(0, indexSecondWord);
            }
        }


        if (!isNumber(firstNumber) && isNumber(secondNumber) && operation == '/') {
            return firstNumber.substring(0, firstNumber.length() / Integer.parseInt(secondNumber));
        }

        if (!isNumber(firstNumber) && isNumber(secondNumber) && operation == '*') {
            StringBuilder stringBuilder = new StringBuilder(firstNumber);
            for (int i = 0; i < Integer.parseInt(secondNumber) - 1; i++) {
                stringBuilder.append(firstNumber);
            }
            return stringBuilder.toString();
        }

        checkNumbers(firstNumber, secondNumber);
        String result = calculation(firstNumber, secondNumber, operation);

        if (result.length()>40){
            return result+"...";
        }else {
            return result;
        }
    }

//    private static void converting(String firstNumber, String secondNumberWithTrim) {
////        if (isRoman) {
////            numberOneAfterConverting = romanToArabic(firstNumber);
////            numberTwoAfterConverting = romanToArabic(secondNumberWithTrim);
////        } else {
//        numberOneAfterConverting = Integer.parseInt(firstNumber);
//        numberTwoAfterConverting = Integer.parseInt(secondNumberWithTrim);
////        }
//    }

    public static String calculation(String firstNumber, String secondNumber, char operator) {


        return switch (operator) {
            case '+' -> firstNumber + secondNumber;
//            case '-' -> firstNumber - secondNumber;
//            case '*' -> firstNumber * secondNumber;
//            case '/' -> firstNumber / secondNumber;
            default -> throw new IllegalStateException("Ошибка при вычислении");
        };
    }

    private static void initOperatorAndNumbers(String input) {
        char[] arrayOfInputChars = new char[1000];

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
        firstNumber = arrayWithNumbers[0].trim().replaceAll("^\"|\"$", "");
        secondNumber = arrayWithNumbers[1].trim().replaceAll("^\"|\"$", "");
    }

    public static void checkNumbers(String firstNumber, String secondNumber) throws IllegalArgumentException {
        try {

            if (isNumber(firstNumber) && !isNumber(secondNumber)) {
                throw new IllegalArgumentException("Первым аргументом выражения, подаваемого на вход, должна быть строка");
            }


            int numberOne = Integer.parseInt(firstNumber);
            int numberTwo = Integer.parseInt(secondNumber);

            if ((numberOne < 1) || (numberOne > 10) || (numberTwo < 1) || (numberTwo > 10)) {
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