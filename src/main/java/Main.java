
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.RomanToDecimal("I"));
    }

    private String romanInput;

    private final int IndexBaseOne = 0;
    private final int One = 1;
    private final int IndexBaseFour = 1;
    private final int Four = 4;
    private final int IndexBaseFive = 2;
    private final int Five = 5;
    private final int IndexBaseNine = 3;
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
        hundreds[IndexBaseOne].base = tens[IndexBaseOne].base = ones[IndexBaseOne].base = One;
        hundreds[IndexBaseFour].base = tens[IndexBaseFour].base = ones[IndexBaseFour].base = Four;
        hundreds[IndexBaseFive].base = tens[IndexBaseFive].base = ones[IndexBaseFive].base = Five;
        hundreds[IndexBaseNine].base = tens[IndexBaseNine].base = ones[IndexBaseNine].base = Nine;
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
        if ((result = GetFourFiveNineInt(inArr[IndexBaseFive])) != 0)
            return result;
        if ((result = GetFourFiveNineInt(inArr[IndexBaseNine])) != 0)
            return result;
        return GetFourFiveNineInt(inArr[IndexBaseFour]);
    }

    public int AddSumOfRepeatableAndNonRepeatable(Roman[] inArr, int res){
        res += GetNonRepeatableValue(inArr);
        if (res % inArr[IndexBaseFive].GetIntegerForm() == 0) {
            res += GetRepeatableValue(inArr[IndexBaseOne]);
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
