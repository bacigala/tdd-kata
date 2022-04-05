public class RomanConverter {

    private static String romanInput;

    private final static int INDEX_ONE = 0;
    private final static int INDEX_FOUR = 1;
    private final static int INDEX_FIVE = 2;
    private final static int INDEX_NINE = 3;

    private static final RomanNumber THOUSAND = new RomanNumber("M", 1, 3);

    private static final RomanNumber[] HUNDREDS = {
            new RomanNumber("C"),
            new RomanNumber("CD"),
            new RomanNumber("D"),
            new RomanNumber("CM"),
    };

    private static final RomanNumber[] TENS = {
            new RomanNumber("X"),
            new RomanNumber("XL"),
            new RomanNumber("L"),
            new RomanNumber("XC"),
    };

    private static final RomanNumber[] ONES = {
            new RomanNumber("I"),
            new RomanNumber("IV"),
            new RomanNumber("V"),
            new RomanNumber("IX"),
    };

    private static void initializeRomanTables() {
        for (int i = 0; i < 4; i++) {
            HUNDREDS[i].exponent = 2;
            TENS[i].exponent = 1;
            ONES[i].exponent = 0;
        }
        HUNDREDS[INDEX_ONE].base = TENS[INDEX_ONE].base = ONES[INDEX_ONE].base = 1;
        HUNDREDS[INDEX_FOUR].base = TENS[INDEX_FOUR].base = ONES[INDEX_FOUR].base = 4;
        HUNDREDS[INDEX_FIVE].base = TENS[INDEX_FIVE].base = ONES[INDEX_FIVE].base = 5;
        HUNDREDS[INDEX_NINE].base = TENS[INDEX_NINE].base = ONES[INDEX_NINE].base = 9;
    }

    private static int getRepeatableValue(RomanNumber romanNumber) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (romanInput.startsWith(romanNumber.symbol)) {
                result += romanNumber.asInteger();
                romanInput = romanInput.substring(romanNumber.symbol.length());
            }
        }
        return result;
    }

    private static int getFourFiveNineInt(RomanNumber romanNumber) {
        if (romanInput.startsWith(romanNumber.symbol)) {
            romanInput = romanInput.substring(romanNumber.symbol.length());
            return romanNumber.asInteger();
        }
        return 0;
    }

    private static int getNonRepeatableValue(RomanNumber[] inArr) {
        int result;
        if ((result = getFourFiveNineInt(inArr[INDEX_FIVE])) != 0)
            return result;
        if ((result = getFourFiveNineInt(inArr[INDEX_NINE])) != 0)
            return result;
        return getFourFiveNineInt(inArr[INDEX_FOUR]);
    }

    private static int sumOrder(RomanNumber[] inArr){
        int result = getNonRepeatableValue(inArr);
        if (result % inArr[INDEX_FIVE].asInteger() == 0) {
            result += getRepeatableValue(inArr[INDEX_ONE]);
        }
        return result;
    }

    public static int romanToDecimal(String str) {
        final int FAIL = -9999;
        if (str == null || str.equals(""))
            return FAIL;
        initializeRomanTables();
        romanInput = str;
        int result;

        result = getRepeatableValue(THOUSAND);

        result += sumOrder(HUNDREDS);
        result += sumOrder(TENS);
        result += sumOrder(ONES);

        if (romanInput.length() > 0) {
            return FAIL;
        }
        return result;
    }

    private static class RomanNumber {
        public String symbol;
        public int base, exponent;

        public RomanNumber(String symbol) {
            this.symbol = symbol;
        }

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
