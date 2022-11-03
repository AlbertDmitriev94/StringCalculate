package StringCalculate;

public class Initializer {
    static String firstOperand, secondOperand;
    static char operator;
    static int firstOperandInt, secondOperandInt;
    static String[] arrayWithNumbers;
    static boolean firstOperandIsInt, secondOperandIsInt, firstOperandIsIntInString, secondOperandIsIntInString = false;

    public void initOperator(String inputWithoutSpace) {
        char[] arrayOfInputChars = new char[100];
        for (int i = 0; i < inputWithoutSpace.length(); i++) {
            arrayOfInputChars[i] = inputWithoutSpace.charAt(i);
            if (arrayOfInputChars[i] == '+') {
                operator = '+';
                arrayOfInputChars[i] = ' ';
            }
            if (arrayOfInputChars[i] != '\"') {
                if (arrayOfInputChars[i] == '-' && arrayOfInputChars[i - 1] == '\"') {
                    operator = '-';
                    arrayOfInputChars[i] = ' ';
                }
            }
            if (arrayOfInputChars[i] == '*') {
                operator = '*';
                arrayOfInputChars[i] = ' ';
            }
            if (arrayOfInputChars[i] == '/') {
                operator = '/';
                arrayOfInputChars[i] = ' ';
            }
        }
        initArrayWithNumbers(arrayOfInputChars);
    }


    public void initArrayWithNumbers(char[] arrayOfInputChars) {
        arrayWithNumbers = String.valueOf(arrayOfInputChars).split(" ");
    }

//    public void initOperand(String[] arrayWithNumbers) {
//        firstOperand = arrayWithNumbers[0].trim().replaceAll("\"", "");
//        secondOperand = arrayWithNumbers[1].trim().replaceAll("\"", "");
//    }

//    public void checkSplitOperator (String[] arrayWithNumbers) {
//        if (secondOperand.contains("^\"|\"$")) {
//            throw new IllegalStateException("Ошибка при вычислении");
//        }
//        secondOperand = arrayWithNumbers[1].trim().replaceAll("^\"|\"$", "");
//    }

    public void defineNumbers(String[] arrayWithNumbers) {
        try {
            firstOperand = arrayWithNumbers[0].trim().replaceAll("\"", "");
            secondOperand = arrayWithNumbers[1].trim().replaceAll("\"", "");
            firstOperandInt = Integer.parseInt(firstOperand);
            firstOperandIsInt = true;
            secondOperandInt = Integer.parseInt(secondOperand);
            secondOperandIsInt = true;
            if (arrayWithNumbers[0].contains("\"")){
                firstOperandIsIntInString = true;
            }
            if (arrayWithNumbers[1].contains("\"")){
                secondOperandIsIntInString = true;
            }
            /*
            В блоке трай после парсинт проверять ферстоперанд на наличие кавычек.
             */
        } catch (Exception exception) {
            firstOperandIsInt = false;
            try {
                secondOperandInt = Integer.parseInt(secondOperand);
                secondOperandIsInt = true;
            } catch (Exception exception1) {
                secondOperandIsInt = false;
            }
        }
    }
}


