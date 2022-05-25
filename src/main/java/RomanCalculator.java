import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RomanCalculator {
    private static final int FAIL = -9999;
    private static final ArrayList<Character> OPERATORS = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
    private static final ArrayList<Character> SYMBOLS = new ArrayList<>(Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M'));

    private static String cleanSequenceOf(List<Character> allowed, String string) {
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

    private static int lengthOfStartSequenceOf(Collection<Character> characters, String string) {
        if (string == null || string.isEmpty())
            return 0;

        for (int position = 0; position < string.length(); position++) {
            if (!characters.contains(string.charAt(position)) && string.charAt(position) != ' ')
                return position;
        }

        return string.length();
    }

    private static String[] cutStartSequenceOf(List<Character> characters, String expression) {
        int sequenceLength = lengthOfStartSequenceOf(characters, expression);
        String sequence = cleanSequenceOf(characters, expression.substring(0, sequenceLength));
        return new String[] {sequence, expression.substring(sequenceLength)};
    }


    public static String evaluate(String expression) {
        final String WRONG_INPUT_MESSAGE = "Wrong input";
        final String WRONG_RESULT_MESSAGE = "Wrong number";

        if (expression == null || expression.isEmpty())
            return WRONG_INPUT_MESSAGE;

        // first operand
        String[] processedFirstNumber = cutStartSequenceOf(SYMBOLS, expression);
        int firstNumber = RomanToArabic.convert(processedFirstNumber[0]);
        if (firstNumber == FAIL)
            return WRONG_INPUT_MESSAGE;
        expression = processedFirstNumber[1];

        // operator
        String[] processedOperator = cutStartSequenceOf(OPERATORS, expression);
        if (processedOperator[0] == null || processedOperator[0].length() > 1)
            return WRONG_INPUT_MESSAGE;
        char operator = processedOperator[0].charAt(0);
        expression = processedOperator[1];

        // second operand
        String[] processedSecondNumber = cutStartSequenceOf(SYMBOLS, expression);
        int secondNumber = RomanToArabic.convert(processedSecondNumber[0]);
        if (secondNumber == FAIL)
            return WRONG_INPUT_MESSAGE;
        expression = processedSecondNumber[1];

        // check: was everything parsed?
        if (expression.length() > 0)
            return WRONG_INPUT_MESSAGE;

        // calculate integerResult
        Integer integerResult = ArabicCalculator.evaluate(firstNumber, secondNumber, operator);
        if (integerResult == null) {
            boolean fractionalResult = operator == '/' && firstNumber % secondNumber != 0;
            return fractionalResult ? WRONG_RESULT_MESSAGE : WRONG_INPUT_MESSAGE;
        }
        if (integerResult <= 0)
            return WRONG_RESULT_MESSAGE;

        // convert integerResult to romanResult
        String romanResult = ArabicToRoman.convert(integerResult);
        if (romanResult == null)
            return WRONG_RESULT_MESSAGE;

        return romanResult;
    }

    public static Result eval(String expression) {

        if (expression == null || expression.isEmpty())
            return new Result(false, 0);

        // first operand
        String[] processedFirstNumber = cutStartSequenceOf(SYMBOLS, expression);
        int firstNumber = RomanToArabic.convert(processedFirstNumber[0]);
        if (firstNumber == FAIL)
            return new Result(false, 0);
        expression = processedFirstNumber[1];

        // operator
        String[] processedOperator = cutStartSequenceOf(OPERATORS, expression);
        if (processedOperator[0] == null || processedOperator[0].length() > 1)
            return new Result(false, 0);
        char operator = processedOperator[0].charAt(0);
        expression = processedOperator[1];

        // second operand
        String[] processedSecondNumber = cutStartSequenceOf(SYMBOLS, expression);
        int secondNumber = RomanToArabic.convert(processedSecondNumber[0]);
        if (secondNumber == FAIL)
            return new Result(false, 0);
        expression = processedSecondNumber[1];

        // check: was everything parsed?
        if (expression.length() > 0)
            return new Result(false, 0);

        // calculate integerResult
        Integer integerResult = ArabicCalculator.evaluate(firstNumber, secondNumber, operator);
        if (integerResult == null) {
            return new Result(false, 0);
        }

        return new Result(true, integerResult);
    }

    public static class Result {
        public boolean hasValidResult;
        public int result;

        Result(boolean valid, int result) {
            this.hasValidResult = valid;
            this.result = result;
        }
    }

}
