
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.RomanToDecimal("I"));
    }
    private Roman thousand = new Roman("M", 1000);
    private String romanInput;

    public int Blah(String roman, int decimal) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (romanInput.startsWith(roman)) {
                result += decimal;
                romanInput = romanInput.substring(1);
            }
        }
        return result;
    }

    public int RomanToDecimal(String str) {
        romanInput = str;
        final int FAIL = -9999;
        int result = 0;
        if (romanInput == null || romanInput.equals(""))
            return FAIL;

        result += Blah(thousand.roman, thousand.decimal);
//        for (int i = 0; i < 3; i++) {
//            if (romanInput.startsWith("M")) {
//                result += 1000;
//                romanInput = romanInput.substring(1);
//            }
//        }

        if (romanInput.startsWith("D")) {
            romanInput = romanInput.substring(1);
            result += 500;
        } else if (romanInput.startsWith("CM")) {
            romanInput = romanInput.substring(2);
            result += 900;
        } else if (romanInput.startsWith("CD")) {
            romanInput = romanInput.substring(2);
            result += 400;
        }

        if (result % 500 == 0) {
            for (int i = 0; i < 3; i++) {
                if (romanInput.startsWith("C")) {
                    result += 100;
                    romanInput = romanInput.substring(1);
                }
            }
        }


        if (romanInput.startsWith("L")) {
            result += 50;
            romanInput = romanInput.substring(1);
        } else if (romanInput.startsWith("XC")) {
            romanInput = romanInput.substring(2);
            result += 90;
        } else if (romanInput.contains("XL")) {
            romanInput = romanInput.substring(2);
            result += 40;
        }
        if (result % 50 == 0){
            for (int i = 0; i < 3; i++) {
                if (romanInput.startsWith("X")) {
                    result += 10;
                    romanInput = romanInput.substring(1);
                }
            }
        }

        if (romanInput.startsWith("IX")) {
            romanInput = romanInput.substring(2);
            result += 9;
            if (romanInput.length() == 0)
                return result;
            else
                return FAIL;
        } else if (romanInput.contains("IV")) {
            romanInput = romanInput.substring(2);
            result += 4;
            if (romanInput.length() == 0)
                return result;
            else
                return FAIL;
        }

        if (romanInput.startsWith("V")) {
            result += 5;
            romanInput = romanInput.substring(1);
        }

        for (int i = 0; i < 3; i++) {
            if (romanInput.startsWith("I")) {
                result++;
                romanInput = romanInput.substring(1);
            }
        }

        if (romanInput.length() > 0) {
            return FAIL;
        }

        return result;
    }
}
