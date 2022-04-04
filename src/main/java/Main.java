
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.RomanToDecimal("I"));
    }
    private Roman thousand = new Roman("M", 1, 3);

    private Roman hundreds[] = {
            new Roman("C", 1, 2),
            new Roman("CD", 4, 2),
            new Roman("D", 5, 2),
            new Roman("CM", 9, 2),
    };

    private Roman tens[] = {
            new Roman("X", 1, 1),
            new Roman("XL", 4, 1),
            new Roman("L", 5, 1),
            new Roman("XC", 9, 1),
    };

    private Roman ones[] = {
            new Roman("I", 1, 0),
            new Roman("IV", 4, 0),
            new Roman("V", 5, 0),
            new Roman("IX", 9, 0),
    };

    private int IndexFour = 1;
    private int IndexFive = 2;
    private int IndexNine = 3;

    private String romanInput;

    public int MCXItoDecimal(Roman romanNumber) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (romanInput.startsWith(romanNumber.romanForm)) {
                result += romanNumber.GetIntegerForm();
                romanInput = romanInput.substring(1);
            }
        }
        return result;
    }

    public int GetFourFiveNineInt(Roman roman) {
        int result = 0;
        if (romanInput.startsWith(roman.romanForm)) {
            romanInput = romanInput.substring(roman.romanForm.length());
            result += roman.GetIntegerForm();
        }
        return result;
    }

    public int Blah2(Roman[] inArr) {
        int result = GetFourFiveNineInt(inArr[IndexFive]);
        if (result != 0)
            return result;
        result = GetFourFiveNineInt(inArr[IndexNine]);
        if (result != 0)
            return result;
        return GetFourFiveNineInt(inArr[IndexFour]);
    }

    public int RomanToDecimal(String str) {
        romanInput = str;
        final int FAIL = -9999;
        int result = 0;
        if (romanInput == null || romanInput.equals(""))
            return FAIL;

        result += MCXItoDecimal(thousand);

        result += Blah2(hundreds);

        if (result % 500 == 0) {
            result += MCXItoDecimal(hundreds[0]);
        }

        result += Blah2(tens);

        if (result % 50 == 0) {
            result += MCXItoDecimal(tens[0]);
        }

        result += Blah2(ones);

        if (result % 5 == 0)
            result += MCXItoDecimal(ones[0]);

        if (romanInput.length() > 0) {
            return FAIL;
        }
        return result;
    }
}
