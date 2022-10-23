package StringCalculate;

import java.util.Scanner;

public class Main {
    /*
     * Создаем экземпляр для инициализации операндов и оператора
     */
    static Initializer initializer = new Initializer();
    /*
     * Создаем экземпляр для проверки валидности операндов и оператора
     */
    static Validator validator = new Validator();
    /*
     * Создаем экземпляр для вычисления
     */
    static Calculator calculator = new Calculator();
    static String validOperators = "[+-/*]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение для вычисления");
        /*
         * Считываем строку, которую ввел пользователь:
         */
        String input = scanner.nextLine();
        /*
         *Подготовка к вычислению и вычисление
         */
        String result = prepareAndCalculate(input);
        /*
         *Вывод результата
         */
        System.out.println("\"" + result + "\"");
    }

    static String prepareAndCalculate(String input) {
        prepareForCalculate(input);
        return calculator.calculate();
    }

    private static void prepareForCalculate(String input) {
        //Инициализация оператора
        initializer.initOperator(input.replaceAll(" ", ""));
        //Проверка валидности оператора
        validator.checkValidOperator(initializer.arrayWithNumbers);
        //Инициализация первого и второго операнда
        //initializer.initOperand(initializer.arrayWithNumbers);
        //Проверка операнда является ли он числом или строкой
        initializer.defineNumbers(initializer.arrayWithNumbers);
        //Проверка чисел
        validator.checkNumbers();
    }
}
