import java.util.Collections;
import java.util.TreeMap;

public class ArabicToRoman {
    private static final TreeMap<Integer, String> SYMBOL_VALUE = new TreeMap<Integer, String>(Collections.reverseOrder()) {
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
        if (integer <= 0 || integer >= 4000)
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
