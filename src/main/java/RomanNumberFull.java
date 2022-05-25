
public class RomanNumberFull extends RomanNumber {

    private final String ZERO_ROMAN_SYSTEM = "OIVXLCDM";

    protected RomanNumberFull() {
        romanSystem = ZERO_ROMAN_SYSTEM;
    }

    public RomanNumberFull(String romanSystem) {
        romanSystem = romanSystem.replaceAll("\\s", "");

        if (!RomanToArabic.isValidRomanSystem(romanSystem) || (romanSystem.length() < 2)) {
            romanSystem = ZERO_ROMAN_SYSTEM;
        }

        this.romanSystem = romanSystem;
    }

    public int minimum() {
        return -maximum();
    }

    public int maximum() {
        return RomanToArabic.highestIntegerFromRomanSystem(romanSystem.substring(1));
    }

    @Override
    public boolean setValue(int value) {
        if (!isFromValidInterval(value)) {
            return false;
        }
        numericValue = value;
        return true;
    }

    @Override
    public boolean setRomanNumber(String romanNumber) {
        int arabicValue = RomanToArabic.convert(romanSystem.substring(1), romanNumber);

        if (arabicValue == FAIL || !isFromValidInterval(arabicValue)) {
            return false;
        }

        if (arabicValue == 1) {
            numericValue = 0;
            return true;
        }

        arabicValue = RomanToArabic.convert(romanSystem.substring(1), romanNumber);

        numericValue = arabicValue;
        return true;
    }

    @Override
    public String getRomanNumber() {
        if (numericValue == 0) {
            return String.valueOf(romanSystem.charAt(0));
        }

        if (numericValue < 0) {
            return "-" + ArabicToRoman.convert(-numericValue, romanSystem.substring(1), minimum(), maximum());
        }

        return ArabicToRoman.convert(numericValue, romanSystem.substring(1), minimum(), maximum());
    }

    @Override
    protected boolean isFromValidInterval(int value) {
        return (value >= minimum()) && (value <= maximum());
    }

    public boolean calculator(String expression) {
        RomanCalculator.Result result = RomanCalculator.eval(expression);
        if (!result.hasValidResult) {
            return false;
        }
        numericValue = result.result;
        return true;
    }

}
