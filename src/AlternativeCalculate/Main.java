package AlternativeCalculate;

import java.util.Scanner;

public class Main {
    static Initializer initializer = new Initializer();
    static Validator validator = new Validator();
    static Calculator calculate = new Calculator();
    static String validOperators = "[+-/*]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строки или числа");
        /*
         * Считываем строку, которую ввел пользователь:
         */
        String input = scanner.nextLine();

        String result = Main.prepareAndCalculate(input);

        System.out.println("\"" + result + "\"");
    }

    static String prepareAndCalculate(String input) {
        prepareForCalculate(input);
        return calculate.calculate();
    }

    private static void prepareForCalculate(String input) {
        String inputWithoutSpace = input.replaceAll(" ", "");
        //итерация для инициализации оператора
        initializer.initOperators(inputWithoutSpace);
        //проверка валидности оператора
        validator.checkValidOperators(initializer.arrayWithNumbers);
        //инициализация первого и второго числа
        initializer.initNumbers(initializer.arrayWithNumbers);
        initializer.defineNumbers();
        validator.checkNumbers(initializer.firstNumber, initializer.secondNumber, initializer.firstNumberIsInt);
    }
}
