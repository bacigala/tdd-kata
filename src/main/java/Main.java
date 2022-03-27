
public class Main {

    public static void main(String[] args) {
        System.out.println(toInteger("I"));
    }

    public static int toInteger(String str) {
        final int FAIL = -9999;
        int result = 0;
        if (str == null || str.equals(""))
            return FAIL;


        for (int i = 0; i < 3; i++) {
            if (str.startsWith("M")) {
                result += 1000;
                str = str.substring(1);
            }
        }

        if (str.startsWith("D")) {
            str = str.substring(1);
            result += 500;
        } else if (str.startsWith("CM")) {
            str = str.substring(2);
            result += 900;
        } else if (str.startsWith("CD")) {
            str = str.substring(2);
            result += 400;
        }

        if (result % 500 == 0) {
            for (int i = 0; i < 3; i++) {
                if (str.startsWith("C")) {
                    result += 100;
                    str = str.substring(1);
                }
            }
        }


        if (str.startsWith("L")) {
            result += 50;
            str = str.substring(1);
        } else if (str.startsWith("XC")) {
            str = str.substring(2);
            result += 90;
        } else if (str.contains("XL")) {
            str = str.substring(2);
            result += 40;
        }
        if (result % 50 == 0){
            for (int i = 0; i < 3; i++) {
                if (str.startsWith("X")) {
                    result += 10;
                    str = str.substring(1);
                }
            }
        }

        if (str.startsWith("IX")) {
            str = str.substring(2);
            result += 9;
            if (str.length() == 0)
                return result;
            else
                return FAIL;
        } else if (str.contains("IV")) {
            str = str.substring(2);
            result += 4;
            if (str.length() == 0)
                return result;
            else
                return FAIL;
        }

        if (str.startsWith("V")) {
            result += 5;
            str = str.substring(1);
        }

        for (int i = 0; i < 3; i++) {
            if (str.startsWith("I")) {
                result++;
                str = str.substring(1);
            }
        }

        if (str.length() > 0) {
            return FAIL;
        }

        return result;
    }
}
