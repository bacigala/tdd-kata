
public class Main {

    public static void main(String[] args) {
        System.out.println(toInteger("I"));
    }

    public static int toInteger(String str) {
        final int FAIL = -9999;
        int result = 0;
        if (str.contains("-"))
            return FAIL;
        if (str.equals("0"))
            return FAIL;


        if (str.startsWith("XC"))
        {
            str = str.substring(0, str.length() - 2);
            result = 90;
        }
        else if (str.contains("XL"))
        {
            str = str.substring(0, str.length() - 2);
            result = 40;
        }

        if (str.startsWith("IX"))
        {
            str = str.substring(0, str.length() - 2);
            result += 9;
            if (str.length() == 0)
                return result;
            else
                return FAIL;
        }
        else if (str.contains("IV"))
        {
            str = str.substring(0, str.length() - 2);
            result += 4;
            if (str.length() == 0)
                return result;
            else
                return FAIL;
        }

        if (str.startsWith("L"))
        {
            result = 50;
            str = str.substring(1);
        }

        if (str.startsWith("V"))
        {
            result = 5;
            str = str.substring(1);
        }

        if (str.startsWith("X"))
        {
            result = 10;
            str = str.substring(1);
        }

        if (str.startsWith("I"))
        {
            if (str.length() > 3)
                result = FAIL;
            else
                result += str.length();
        }
        return result;
    }
}
