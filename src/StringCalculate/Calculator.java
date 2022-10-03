package StringCalculate;

import static StringCalculate.Initializer.*;

public class Calculator {
    public String calculate() {
        StringBuilder stringBuilder = new StringBuilder(firstOperand);
        if (!firstOperandIsInt && !secondOperandIsInt && operator == '+') {
            stringBuilder.append(secondOperand);
        } else if (!firstOperandIsInt && !secondOperandIsInt && operator == '/') {
            throw new IllegalStateException("Ошибка при вычислении");
        } else if (!firstOperandIsInt && secondOperandIsInt && operator == '/') {
            return firstOperand.substring(0, firstOperand.length() / secondOperandInt);
        } else if (!firstOperandIsInt && !secondOperandIsInt && operator == '-') {
            return subtractWord();
        } else if (!firstOperandIsInt && secondOperandIsInt && operator == '*') {
            buildWord(stringBuilder);
        }
        /*
         *Если больше 40 символов, то в результат добавляется троеточие
         */
        return addThreeDots(stringBuilder);
    }

    public String subtractWord() {
        int indexSecondWord = firstOperand.indexOf(secondOperand);
        return switch (indexSecondWord) {
            case -1 -> firstOperand;
            default -> firstOperand.substring(0, indexSecondWord);
        };
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
