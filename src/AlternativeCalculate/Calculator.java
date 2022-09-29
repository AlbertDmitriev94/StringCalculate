package AlternativeCalculate;

import static AlternativeCalculate.Main.initializer;

public class Calculator {
    public String calculate() {
        StringBuilder stringBuilder = new StringBuilder(initializer.firstNumber);
        if (!initializer.firstNumberIsInt && !initializer.secondNumberIsInt && initializer.operator == '+') {
            stringBuilder.append(initializer.secondNumber);
        } else if (!initializer.firstNumberIsInt && !initializer.secondNumberIsInt && initializer.operator == '/') {
            throw new IllegalStateException("Ошибка при вычислении");
        } else if (!initializer.firstNumberIsInt && !initializer.secondNumberIsInt && initializer.operator == '-') {
            return subtraction();
        } else if (!initializer.firstNumberIsInt && initializer.secondNumberIsInt && initializer.operator == '/') {
            return initializer.firstNumber.substring(0, initializer.firstNumber.length() / Integer.parseInt(initializer.secondNumber));
        } else if (!initializer.firstNumberIsInt && initializer.secondNumberIsInt && initializer.operator == '*') {
            wordBuild(stringBuilder);
        }
        return addThreeDots(stringBuilder);
    }

    public String subtraction() {
        int indexSecondWord = initializer.firstNumber.indexOf(initializer.secondNumber);
        if (indexSecondWord == -1) {
            return initializer.firstNumber;
        } else {
            return initializer.firstNumber.substring(0, indexSecondWord);
        }
    }

    public void wordBuild(StringBuilder stringBuilder) {
        for (int i = 0; i < Integer.parseInt(initializer.secondNumber) - 1; i++) {
            stringBuilder.append(initializer.firstNumber);
        }
    }

    private static String addThreeDots(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 40) {
            return stringBuilder + "...";
        }
        return stringBuilder.toString();
    }
    }
