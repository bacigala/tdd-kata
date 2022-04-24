import java.util.Collections;
import java.util.TreeMap;

public class ArabicToRoman {
    private final static int ROMAN_MINIMUM = 1;
    private final static int ROMAN_MAXIMUM = 3999;
    private final static TreeMap<Integer, String> SYMBOL_VALUE = new TreeMap<>(Collections.reverseOrder()) {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };

    public static String convert(int integer) {
        if (integer < ROMAN_MINIMUM || integer > ROMAN_MAXIMUM)
            return null;

        StringBuilder result = new StringBuilder();

        for (Integer i : SYMBOL_VALUE.keySet()) {
            while (integer >= i) {
                result.append(SYMBOL_VALUE.get(i));
                integer -= i;
            }
        }

        return result.toString();
    }

}
