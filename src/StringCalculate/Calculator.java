package StringCalculate;

import static StringCalculate.Initializer.*;

public class Calculator {
    public String calculate() {
        StringBuilder stringBuilder = new StringBuilder(firstOperand);
        if (firstOperandIsIntInString) {
            throw new IllegalArgumentException("Первым аргументом выражения, подаваемого на вход, должна быть строка");
        }
        if (!firstOperandIsInt && !secondOperandIsInt && operator == '+') {
            throw new IllegalArgumentException("Первым аргументом выражения, подаваемого на вход, должна быть строка");
        }
        if (arrayWithNumbers[0].contains("\"") && firstOperandIsIntInString && secondOperandIsInt && operator == '+') {
            throw new IllegalStateException("Ошибка при вычислении");
        } else if (arrayWithNumbers[0].contains("\"") && firstOperandIsInt && secondOperandIsInt && operator == '+') {
            stringBuilder.append(secondOperand);
        } else if (!firstOperandIsInt && !secondOperandIsInt && operator == '+') {
            stringBuilder.append(secondOperand);
        } else if (!firstOperandIsInt && !secondOperandIsInt && operator == '/') {
            throw new IllegalStateException("Ошибка при вычислении");
        } else if (!firstOperandIsInt && secondOperandIsInt && operator == '/') {
            return firstOperand.substring(0, firstOperand.length() / secondOperandInt);
        } else if (!firstOperandIsInt && !secondOperandIsInt && operator == '-') {
            return subtractWord();
        } else if (!firstOperandIsInt && secondOperandIsInt && operator == '*') {
            buildWord(stringBuilder);
        } else if (!firstOperandIsInt && !secondOperandIsInt && operator == '*') {
            throw new IllegalStateException("Ошибка при вычислении");
        } else if (!arrayWithNumbers[0].contains("\"")) {
            throw new IllegalArgumentException("Первым аргументом выражения, подаваемого на вход, должна быть строка");
        }
        ;
        /*
         *Если больше 40 символов, то в результат добавляется троеточие
         */
        return addThreeDots(stringBuilder);
    }

    public String subtractWord() {
        firstOperand = firstOperand.replaceAll("\"", "");
        secondOperand = secondOperand.replaceAll("\"", "");
        return firstOperand.replace(secondOperand, "");
    }

    public void buildWord(StringBuilder stringBuilder) {
        for (int i = 0; i < secondOperandInt - 1; i++) {
            stringBuilder.append(firstOperand);
        }
    }

    private static String addThreeDots(StringBuilder stringBuilder) {
        return stringBuilder.length() > 40 ? stringBuilder + "..." : stringBuilder.toString();
    }
}
