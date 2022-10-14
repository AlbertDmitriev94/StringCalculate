package StringCalculate;

import static StringCalculate.Main.validOperators;

public class Initializer {
    static String firstOperand, secondOperand;
    static char operator;
    static int firstOperandInt, secondOperandInt;
    static String [] arrayWithNumbers;
    static boolean firstOperandIsInt, secondOperandIsInt, firstOperandIsIntInString, secondOperandIsIntInString = false;
    public void initOperator(String inputWithoutSpace) {
        char[] arrayOfInputChars = new char[1000];
        for (int i = 0; i < inputWithoutSpace.length(); i++) {
            arrayOfInputChars[i] = inputWithoutSpace.charAt(i);
            if (arrayOfInputChars[i] == '+') {
                operator = '+';
                arrayOfInputChars [i] = ' ';
            }
            if (arrayOfInputChars [i] != '\"') {
                if (arrayOfInputChars[i] == '-' && arrayOfInputChars[i - 1] == '\"') {
                    operator = '-';
//определилил что это настоящии минус (строка 19), значит мы можем вставить пробел под этим элементом.
                    arrayOfInputChars [i] = ' ';
                }
            }
            if (arrayOfInputChars[i] == '*') {
                operator = '*';
                arrayOfInputChars [i] = ' ';
            }
            if (arrayOfInputChars[i] == '/') {
                operator = '/';
                arrayOfInputChars [i] = ' ';
            }
        }
        initArrayWithNumbers(arrayOfInputChars, validOperators);
    }

    public void initArrayWithNumbers(char[] arrayOfInputChars, String validOperators) {
        arrayWithNumbers = String.valueOf(arrayOfInputChars).split(" ");
    }

    public void initOperand(String[] arrayWithNumbers) {
//        if (!arrayWithNumbers[0].contains("\"")) {
//            throw new IllegalArgumentException("Первым аргументом выражения, подаваемого на вход, должна быть строка");
//        };
        firstOperand = arrayWithNumbers[0].trim().replaceAll("^\"|\"$", "");
        secondOperand = arrayWithNumbers[1].trim().replaceAll("^\"|\"$", "");
    }

    public void defineNumbers() {
        try {
            firstOperandInt = Integer.parseInt(firstOperand);
            firstOperandIsInt = true;
            //Если ""3"" внутри строки то firstOperandIsIntInString=true;
        } catch (Exception exception) {
            firstOperandIsInt = false;
        }
        try {
            secondOperandInt = Integer.parseInt(secondOperand);
            secondOperandIsInt = true;
        } catch (Exception exception) {
            secondOperandIsInt = false;
        }
    }
}


