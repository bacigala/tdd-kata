
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

    private int IndexOne = 0;
    private int IndexFour = 1;
    private int IndexFive = 2;
    private int IndexNine = 3;

    private String romanInput;

    public int GetRepeatableValue(Roman romanNumber) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (romanInput.startsWith(romanNumber.symbol)) {
                result += romanNumber.GetIntegerForm();
                romanInput = romanInput.substring(1);
            }
        }
        return result;
    }

    public int GetFourFiveNineInt(Roman roman) {
        if (romanInput.startsWith(roman.symbol)) {
            romanInput = romanInput.substring(roman.symbol.length());
            return roman.GetIntegerForm();
        }
        return 0;
    }

    public int GetNonRepeatableValue(Roman[] inArr) {
        int result = 0;
        if ((result = GetFourFiveNineInt(inArr[IndexFive])) != 0)
            return result;
        if ((result = GetFourFiveNineInt(inArr[IndexNine])) != 0)
            return result;
        return GetFourFiveNineInt(inArr[IndexFour]);
    }

    public int AddSumOfRepeatableAndNonRepeatable(Roman[] inArr, int res){
        res += GetNonRepeatableValue(inArr);
        if (res % inArr[IndexFive].GetIntegerForm() == 0) {
            res += GetRepeatableValue(inArr[IndexOne]);
        }
        return res;
    }

    public int RomanToDecimal(String str) {
        romanInput = str;
        final int FAIL = -9999;
        int result = 0;
        if (romanInput == null || romanInput.equals(""))
            return FAIL;

        result = GetRepeatableValue(thousand);

        result = AddSumOfRepeatableAndNonRepeatable(hundreds, result);
        result = AddSumOfRepeatableAndNonRepeatable(tens, result);
        result = AddSumOfRepeatableAndNonRepeatable(ones, result);

        if (romanInput.length() > 0) {
            return FAIL;
        }
        return result;
    }
}
