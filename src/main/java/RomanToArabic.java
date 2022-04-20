import java.util.ArrayList;
import java.util.Collections;

public class RomanToArabic {

    private static String romanInput;

    private final static int INDEX_ONE = 0;
    private final static int INDEX_FOUR = 1;
    private final static int INDEX_FIVE = 2;
    private final static int INDEX_NINE = 3;
    private final static int MAX_REPEATABLE_SYMBOLS = 3;

    private static RomanNumber[] constructRomanOrder(String romanCharacters, int order) {
        if (romanCharacters == null || romanCharacters.isEmpty())
            return null;

        RomanNumber[] result = new RomanNumber[4];

        result[INDEX_ONE] = new RomanNumber(String.valueOf(romanCharacters.charAt(0)), 1, order);

        if (romanCharacters.length() > 1) {
            result[INDEX_FOUR] = new RomanNumber(romanCharacters.substring(0,2), 4, order);
            result[INDEX_FIVE] = new RomanNumber(String.valueOf(romanCharacters.charAt(1)), 5, order);
        }

        if (romanCharacters.length() > 2) {
            String nine = String.valueOf(romanCharacters.charAt(0)) + romanCharacters.charAt(2);
            result[INDEX_NINE] = new RomanNumber(nine, 9, order);
        }

        return result;
    }

    private static boolean hasDuplicities(String string) {
        if (string == null)
            return false;

        for (int positionA = 0; positionA < string.length()-1; positionA++)
            for (int positionB = positionA+1; positionB < string.length(); positionB++)
                if (string.charAt(positionA) == string.charAt(positionB))
                    return true;

        return false;
    }

    private static boolean isUpperCase(String string) {
        if (string == null)
            return true;

        for (int position = 0; position < string.length(); position++)
            if (!Character.isUpperCase(string.charAt(position)))
                return false;

        return true;
    }

    private static boolean isAlphabetic(String string) {
        if (string == null)
            return true;

        for (int position = 0; position < string.length(); position++)
            if (!Character.isLetter(string.charAt(position)))
                return false;

        return true;
    }

    private static ArrayList<RomanNumber[]> constructRomanOrders(String romanSystem) {
        if (romanSystem == null || romanSystem.isEmpty() || !isAlphabetic(romanSystem)
                    || hasDuplicities(romanSystem) || !isUpperCase(romanSystem))
            return null;

        ArrayList<RomanNumber[]> result = new ArrayList<>();

        int position = 0, order = 0;
        while (position < romanSystem.length()) {
            int lengthOfOrderSystem = Math.min(3, romanSystem.length() - position);
            result.add(constructRomanOrder(romanSystem.substring(position, position + lengthOfOrderSystem), order++));
            position += 2;
        }

        return result;
    }

    private static int getRepeatableValue(RomanNumber romanNumber) {
        int result = 0;
        for (int i = 0; i < MAX_REPEATABLE_SYMBOLS; i++) {
            if (romanInput.startsWith(romanNumber.symbol)) {
                result += romanNumber.asInteger();
                romanInput = romanInput.substring(romanNumber.symbol.length());
            }
        }
        return result;
    }

    private static int getFourFiveNineValue(RomanNumber romanNumber) {
        if (romanInput.startsWith(romanNumber.symbol)) {
            romanInput = romanInput.substring(romanNumber.symbol.length());
            return romanNumber.asInteger();
        }
        return 0;
    }

    private static int getNonRepeatableValue(RomanNumber[] inArr) {
        int result;
        for (int index : new int[]{INDEX_FOUR, INDEX_FIVE, INDEX_NINE}) {
            if (inArr[index] != null && (result = getFourFiveNineValue(inArr[index])) != 0)
                return result;
        }
        return 0;
    }

    private static int sumOrder(RomanNumber[] inArr){
        int result = getNonRepeatableValue(inArr);
        if (result % inArr[INDEX_FIVE].asInteger() == 0)
            result += getRepeatableValue(inArr[INDEX_ONE]);
        return result;
    }

    public static int convert(String str) {
        return convert("IVXLCDM", str);
    }

    public static int convert(String romanSystem, String str) {
        final int FAIL = -9999;

        ArrayList<RomanNumber[]> romanOrders = constructRomanOrders(romanSystem);
        if (romanOrders == null || romanOrders.isEmpty())
            return FAIL;

        if (str == null || str.equals(""))
            return FAIL;
        romanInput = str;

        int result = 0;

        if (romanSystem.length() % 2 == 1) {
            result += getRepeatableValue(romanOrders.get(romanOrders.size() - 1)[INDEX_ONE]);
            romanOrders.remove(romanOrders.size() - 1);
        }

        Collections.reverse(romanOrders);
        for (RomanNumber[] order : romanOrders)
            result += sumOrder(order);

        if (!romanInput.isEmpty())
            return FAIL;
        return result;
    }

    private static class RomanNumber {
        public String symbol;
        public int base, exponent;

        public RomanNumber(String symbol, int base, int exponent) {
            this.symbol = symbol;
            this.base = base;
            this.exponent = exponent;
        }

        public int asInteger() {
            return base * (int)Math.pow(10, exponent);
        }
    }

}
