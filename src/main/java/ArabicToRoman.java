import java.util.Collections;
import java.util.TreeMap;

public class ArabicToRoman {
    private final static int ROMAN_MINIMUM = 1;
    private final static int ROMAN_MAXIMUM = 3999;

    public static TreeMap<Integer, String> setSystem(String system) {
        TreeMap<Integer, String> newSystem = new TreeMap<>(Collections.reverseOrder());

        int order = 1;
        for (int position = 0; position < system.length(); position += 2) {

            // 1, 10, 100...
            newSystem.put(order, String.valueOf(system.charAt(position)));

            if (position + 1 < system.length()) {
                // 4, 40, 400
                newSystem.put(order * 4, String.valueOf(system.charAt(position)) + system.charAt(position + 1));

                // 5, 50, 500 ...
                newSystem.put(order * 5, String.valueOf(system.charAt(position+1)));
            }

            if (position + 2 < system.length()) {
                // 9, 90, 900 ...
                newSystem.put(order * 9, String.valueOf(system.charAt(position)) + system.charAt(position + 2));
            }

            order *= 10;
        }

        return newSystem;
    }

    public static String convert(int integer) {
        return convert(integer, "IVXLCDM", ROMAN_MINIMUM, ROMAN_MAXIMUM);
    }

    public static String convert(int integer, String romanSystem, int min, int max) {
        TreeMap<Integer, String> SYMBOL_VALUE = setSystem(romanSystem);

        if (integer < min || integer >= max)
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
