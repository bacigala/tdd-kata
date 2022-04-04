
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.RomanToDecimal("I"));
    }

    private String romanInput;

    private final int IndexOne = 0;
    private final int One = 1;
    private final int IndexFour = 1;
    private final int Four = 4;
    private final int IndexFive = 2;
    private final int Five = 5;
    private final int IndexNine = 3;
    private final int Nine = 9;

    private Roman thousand = new Roman("M", 1, 3);

    private Roman hundreds[] = {
            new Roman("C"),
            new Roman("CD"),
            new Roman("D"),
            new Roman("CM"),
    };

    private Roman tens[] = {
            new Roman("X"),
            new Roman("XL"),
            new Roman("L"),
            new Roman("XC"),
    };

    private Roman ones[] = {
            new Roman("I"),
            new Roman("IV"),
            new Roman("V"),
            new Roman("IX"),
    };

    private void InitializeRomanTables()
    {
        for(int i = 0; i < 4; i++)
        {
            hundreds[i].exponent = 2;
            tens[i].exponent = 1;
            ones[i].exponent = 0;
        }
        hundreds[IndexOne].base = tens[IndexOne].base = ones[IndexOne].base = One;
        hundreds[IndexFour].base = tens[IndexFour].base = ones[IndexFour].base = Four;
        hundreds[IndexFive].base = tens[IndexFive].base = ones[IndexFive].base = Five;
        hundreds[IndexNine].base = tens[IndexNine].base = ones[IndexNine].base = Nine;
    }



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
        InitializeRomanTables();
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
