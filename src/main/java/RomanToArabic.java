import java.util.ArrayList;
import java.util.Collections;

public class RomanToArabic {

    private static String romanInput;

    private final static int INDEX_ONE = 0;
    private final static int INDEX_FOUR = 1;
    private final static int INDEX_FIVE = 2;
    private final static int INDEX_NINE = 3;
    private final static int MAX_REPEATABLE_SYMBOLS = 3;
    private final static int FAIL = -9999;

    private static RomanNumber[] constructRomanOrder(String romanCharacters, int order) {
        // "romanCharacters" is e.g. "IVX", "XLC", ...
        final int INDEX_SYMBOL_ONE = 0;
        final int INDEX_SYMBOL_FIVE = 1;
        final int INDEX_SYMBOL_HIGHER_ORDER_ONE = 2;

        if (romanCharacters == null || romanCharacters.isEmpty())
            return null;

        RomanNumber[] result = new RomanNumber[4];

        result[INDEX_ONE] = new RomanNumber(String.valueOf(romanCharacters.charAt(INDEX_SYMBOL_ONE)), 1, order);

        if (romanCharacters.length() > 1) {
            String four = String.valueOf(romanCharacters.charAt(INDEX_ONE)) + romanCharacters.charAt(INDEX_SYMBOL_FIVE);
            result[INDEX_FOUR] = new RomanNumber(four, 4, order);
            result[INDEX_FIVE] = new RomanNumber(String.valueOf(romanCharacters.charAt(INDEX_SYMBOL_FIVE)), 5, order);
        }

        if (romanCharacters.length() > 2) {
            String nine = String.valueOf(romanCharacters.charAt(INDEX_SYMBOL_ONE))
                    + romanCharacters.charAt(INDEX_SYMBOL_HIGHER_ORDER_ONE);
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

    public static boolean isValidRomanSystem(String romanSystem) {
        return (romanSystem != null && !romanSystem.isEmpty() && isAlphabetic(romanSystem)
                && !hasDuplicities(romanSystem) && isUpperCase(romanSystem));
    }

    private static ArrayList<RomanNumber[]> constructRomanOrders(String romanSystem) {
        if (!isValidRomanSystem(romanSystem))
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

        if (str == null)
            return FAIL;

        str = str.replaceAll("\\s", "");
        if (str.equals(""))
            return FAIL;

        if (str.equals("O")) {
            return 0;
        }

        romanInput = str;

        ArrayList<RomanNumber[]> romanOrders = constructRomanOrders(romanSystem);
        if (romanOrders == null || romanOrders.isEmpty())
            return FAIL;

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

    public static int highestIntegerFromRomanSystem(String romanSystem) {
        if (!isValidRomanSystem(romanSystem))
            return FAIL;
        int res = Integer.parseInt((romanSystem.length() % 2 == 0 ? '8' : '3') +
                "9".repeat(Math.round((float) romanSystem.length() / 2) - 1));
        return res;
    }

    // this actually constructs the highest roman number :)
    public static String highestRomanFromRomanSystem(String romanSystem) {
        if (!isValidRomanSystem(romanSystem))
            return null;

        StringBuilder highestRomanNumber = new StringBuilder();
        int position = romanSystem.length()-1;

        if (romanSystem.length() % 2 == 0)
            highestRomanNumber.append(romanSystem.charAt(position--));

        highestRomanNumber.append(String.valueOf(romanSystem.charAt(position)).repeat(MAX_REPEATABLE_SYMBOLS));

        position -= 2;
        while (position >= 0) {
            highestRomanNumber.append(romanSystem.charAt(position));
            highestRomanNumber.append(romanSystem.charAt(position+2));
            position -= 2;
        }

        return highestRomanNumber.toString();
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
