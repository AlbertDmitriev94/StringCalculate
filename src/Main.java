import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int numberOneAfterConverting, numberTwoAfterConverting;
    static String firstNumber, secondNumber;
    static char operation;
    static boolean isRoman;
    static String[] romanNumbers = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
            "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XL", "L", "LX", "LXX", "XC", "C"
    };
    static String validOperators = "[+-/*]";

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение арабскими [2+2] или римскими [II+II] числами (диапазон от 1 до 10)");

        /*
         * Считываем строку, которую ввел пользователь:
         */
        String userInput = scanner.nextLine();

        String userInputWithoutSpace = userInput.replaceAll(" ", "");

        String result = calc(userInputWithoutSpace);

        printResult(result, firstNumber, secondNumber);
    }

    public static String calc(String input) throws Exception {
        char[] charBlock = new char[10];

        initOperatorAndNumbers(input, charBlock);

        isRoman = isRoman(firstNumber, secondNumber);

        int result;

        if (isRoman) {
            converting(firstNumber, secondNumber);
            checkNumbersIsNoMoreTen(numberOneAfterConverting, numberTwoAfterConverting);
            result = calculation(numberOneAfterConverting, numberTwoAfterConverting, operation);
            if (result < 1) {
                throw new Exception("При результате римских чисел вышло значение 0 или отрицательное число");
            }
        } else {
            int firstNumberInt = Integer.parseInt(firstNumber);
            int secondNumberInt = Integer.parseInt(secondNumber);

            checkNumbersIsNoMoreTen(firstNumberInt, secondNumberInt);
            result = calculation(firstNumberInt, secondNumberInt, operation);
        }
        return String.valueOf(result);
    }

    /*
     * Преобразование римских чисел в арабские если пользователь ввел римские,
     * иначе арабские числа в строке приводятся в целочисленный тип
     */
    private static void converting(String firstNumber, String secondNumberWithTrim) {
        if (isRoman) {
            numberOneAfterConverting = romanToArabic(firstNumber);
            numberTwoAfterConverting = romanToArabic(secondNumberWithTrim);
        } else {
            numberOneAfterConverting = Integer.parseInt(firstNumber);
            numberTwoAfterConverting = Integer.parseInt(secondNumberWithTrim);
        }
    }

    /*
     * Вывод в консоль вычисления и его результата для римских или арабских чисел
     */
    private static void printResult(String result, String firstNumber, String secondNumberWithTrim) {
        if (isRoman) {
            String resultRoman = convertArabToRoman(result);
            System.out.println("Результат (для римских цифр): ");
            System.out.println(firstNumber + " " + operation + " " + secondNumberWithTrim + " = " + resultRoman);
        } else {
            System.out.println("Результат (для арабских цифр): ");
            System.out.println(firstNumber + " " + operation + " " + secondNumberWithTrim + " = " + result);
        }
    }

    /*
     * Инициализация оператора, первого и второго числа
     */
    private static void initOperatorAndNumbers(String userInput, char[] charBlock) {

        //итерация для инициализации оператора
        for (int i = 0; i < userInput.length(); i++) {
            charBlock[i] = userInput.charAt(i);
            if (charBlock[i] == '+') {
                operation = '+';
            }
            if (charBlock[i] == '-') {
                operation = '-';
            }
            if (charBlock[i] == '*') {
                operation = '*';
            }
            if (charBlock[i] == '/') {
                operation = '/';
            }
        }
        String[] arrayWithNumbers = String.valueOf(charBlock).split(validOperators);


        //проверка валидности оператора
        boolean isInvalidOperator = Arrays.asList(arrayWithNumbers).contains(validOperators);

        long count = countOccurrences(String.valueOf(charBlock));

        if (isInvalidOperator) {
            throw new IllegalArgumentException("Не верный знак операции");
        }

        //инициализация первого и второго числа
        firstNumber = arrayWithNumbers[0].trim();
        secondNumber = arrayWithNumbers[1].trim();


        if (count > 1) {
            throw new IllegalArgumentException("Ошибка!Введите не более двух операндов");
        }
    }

    private static int countOccurrences(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (c== '+'||c=='-'||c=='/'||c=='*') {
                counter++;
            }
        }
        return counter;
    }
    /*
     * Проверка, что пользователь ввел числа от 1 до 10 включительно, иначе бросается ошибка.
     */
    private static void checkNumbersIsNoMoreTen(int numberOne, int numberTwo) {
        if ((numberOne < 1) || (numberOne > 10) || (numberTwo < 1) || (numberTwo > 10)) {
            throw new IllegalArgumentException("Вы ввели значение, неудолетворяющее условию (числа должны быть целочисленными от 1 до 10)");
        }
    }

    /*
     * Признак, определяющий то, что пользователь ввел римские числа
     */
    private static boolean isRoman(String firstNumber, String secondNumber) {
        return Arrays.asList(romanNumbers).contains(firstNumber.trim()) && Arrays.asList(romanNumbers).contains(secondNumber.trim());
    }

    /*
     * Преобразование арабского числа в римское
     */
    private static String convertArabToRoman(String arabicNumber) {
        return romanNumbers[Integer.parseInt(arabicNumber)];
    }

    /*
     * Преобразование римского числа в арабское
     */
    private static int romanToArabic(String roman) {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new IllegalStateException("Введено число за диапазоном допустимых значений: " + roman);
        };
    }

    /*
     * Вычисление
     */
    public static int calculation(int numberOne, int numberTwo, char operator) {
        return switch (operator) {
            case '+' -> numberOne + numberTwo;
            case '-' -> numberOne - numberTwo;
            case '*' -> numberOne * numberTwo;
            case '/' -> numberOne / numberTwo;
            default -> throw new IllegalStateException("Ошибка при вычислении");
        };
    }
}
