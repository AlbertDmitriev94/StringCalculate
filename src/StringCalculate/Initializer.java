package StringCalculate;

public class Initializer {
    static String firstOperand, secondOperand;
    static char operator;
    static int firstOperandInt, secondOperandInt;
    static String [] arrayWithNumbers;
    static boolean firstOperandIsInt, secondOperandIsInt = false;
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
        initArrayWithNumbers(arrayOfInputChars);
    }

    public void initArrayWithNumbers(char[] arrayOfInputChars) {
        arrayWithNumbers = String.valueOf(arrayOfInputChars).split(" ");
    }

    public void initOperand(String[] arrayWithNumbers) {
        firstOperand = arrayWithNumbers[0].trim().replaceAll("^\"|\"$", "");
        secondOperand = arrayWithNumbers[1].trim().replaceAll("^\"|\"$", "");
    }

    public void defineNumbers() {
        try {
            firstOperandInt = Integer.parseInt(firstOperand);
            firstOperandIsInt = true;
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


