import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RomanCalculator {
    private static final int FAIL = -9999;
    public static final ArrayList<Character> OPERATORS = new ArrayList<>(Arrays.asList('+', '-', '.', '/'));
    public static final ArrayList<Character> SYMBOLS = new ArrayList<>(Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M'));


    public static String parseSequenceOf(List<Character> allowed, String string) {
        if (string == null || string.isEmpty() || allowed == null || allowed.isEmpty())
            return null;

        StringBuilder result = new StringBuilder();

        for (int position = 0; position < string.length(); position++) {
            if (allowed.contains(string.charAt(position))) {
                result.append(string.charAt(position));
            } else if (string.charAt(position) != ' ') {
                break;
            }
        }

        return result.toString();
    }

    public static int lengthOfStartSequenceOf(Collection<Character> characters, String string) {
        if (string == null || string.isEmpty())
            return 0;

        for (int position = 0; position < string.length(); position++) {
            if (!characters.contains(string.charAt(position)) && string.charAt(position) != ' ')
                return position;
        }

        return string.length();
    }

    public static String evaluate(String expression) {
        final String WRONG_INPUT_MESSAGE = "Wrong input";
        final String WRONG_RESULT_MESSAGE = "Wrong number";

        // first operand
        int firstNumberLength = lengthOfStartSequenceOf(SYMBOLS, expression);
        int firstNumber = RomanToArabic.convert(parseSequenceOf(SYMBOLS, expression.substring(0, firstNumberLength)));
        if (firstNumber == FAIL)
            return WRONG_INPUT_MESSAGE;
        expression = expression.substring(firstNumberLength);

        // operator
        int operatorLength = lengthOfStartSequenceOf(OPERATORS, expression);
        String operatorSequence = parseSequenceOf(OPERATORS, expression.substring(0, operatorLength));
        if (operatorSequence.length() > 1)
            return WRONG_INPUT_MESSAGE;
        char operator = operatorSequence.charAt(0);
        expression = expression.substring(operatorLength);

        // second operand
        int secondNumberLength = lengthOfStartSequenceOf(SYMBOLS, expression);
        int secondNumber = RomanToArabic.convert(parseSequenceOf(SYMBOLS, expression.substring(0, secondNumberLength)));
        if (secondNumber == FAIL)
            return WRONG_INPUT_MESSAGE;
        expression = expression.substring(secondNumberLength);

        // check: was everything parsed?
        if (expression.length() > 0)
            return WRONG_INPUT_MESSAGE;

        // calculate integerResult
        int integerResult = 0;
        switch (operator) {
            case '+':
                integerResult = firstNumber + secondNumber;
                break;
            case '-':
                if (firstNumber < secondNumber)
                    return WRONG_INPUT_MESSAGE;
                integerResult = firstNumber - secondNumber;
                break;
            case '*':
                integerResult = firstNumber * secondNumber;
                break;
            case '/':
                if (firstNumber % secondNumber != 0)
                    return WRONG_RESULT_MESSAGE;
                integerResult = firstNumber / secondNumber;
                break;
        }

        // validate integerResult
        String result = ArabicToRoman.convert(integerResult);
        if (result == null)
            return WRONG_RESULT_MESSAGE;

        return result;
    }
}