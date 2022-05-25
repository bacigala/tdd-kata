import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;

public class ArabicToRoman {
    private final static int ROMAN_MINIMUM = 1;
    private final static int ROMAN_MAXIMUM = 3999;
//    private static TreeMap<Integer, String> SYMBOL_VALUE = new TreeMap<>(Collections.reverseOrder()) {
//        {
//            put(1000, "M");
//            put(900, "CM");
//            put(500, "D");
//            put(400, "CD");
//            put(100, "C");
//            put(90, "XC");
//            put(50, "L");
//            put(40, "XL");
//            put(10, "X");
//            put(9, "IX");
//            put(5, "V");
//            put(4, "IV");
//            put(1, "I");
//        }
//    };



    public static TreeMap<Integer, String> setSystem(String system) {
        TreeMap<Integer, String> newSystem = new TreeMap<>(Collections.reverseOrder());

        int order = 1;
        for (int position = 0; position < system.length(); position += 2) {

            // 1, 10, 100...
            newSystem.put(order, String.valueOf(system.charAt(position)));

            if (position + 1 < system.length()) {
                // 4, 40, 400
                newSystem.put(order * 4, new StringBuilder().append(system.charAt(position)).append(system.charAt(position+1)).toString());

                // 5, 50, 500 ...
                newSystem.put(order * 5, String.valueOf(system.charAt(position+1)));
            }

            if (position + 2 < system.length()) {
                // 9, 90, 900 ...
                newSystem.put(order * 9, new StringBuilder().append(system.charAt(position)).append(system.charAt(position+2)).toString());
            }

            order *= 10;
        }

        return newSystem;
    }



    public static String convert(int integer, int min, int max) {
        return convert(integer, "IVXLCDM", min, max);
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
