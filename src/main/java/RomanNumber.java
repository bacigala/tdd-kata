
public class RomanNumber {

    protected String DEFAULT_ROMAN_SYSTEM = "IVXLCDM";
    protected int ROMAN_SYSTEM_MINIMUM_VALUE = 1;
    protected String romanSystem;
    protected int numericValue = 0;
    protected final int FAIL = -9999;

    protected RomanNumber() {
        romanSystem = DEFAULT_ROMAN_SYSTEM;
    }

    public RomanNumber(String romanSystem) {
        if (!RomanToArabic.isValidRomanSystem(romanSystem)) {
            romanSystem = DEFAULT_ROMAN_SYSTEM;
        }
        this.romanSystem = romanSystem;
    }

    public RomanNumber(String romanSystem, int max) {
        this.romanSystem = romanSystem;
        if (!RomanToArabic.isValidRomanSystem(this.romanSystem) || (max < 1 || max > maxNumber(this.romanSystem)) || this.romanSystem.isEmpty()) {
            this.romanSystem = DEFAULT_ROMAN_SYSTEM;
        } else if (max == 1) {
            this.romanSystem = String.valueOf(romanSystem.charAt(0));

        }
        if (RomanToArabic.isValidRomanSystem(this.romanSystem) && max < maxNumber(this.romanSystem)) {
            for (int i = 0; i < this.romanSystem.length(); i++) {
                String newRomanSystem = this.romanSystem.substring(0, this.romanSystem.length() - i);
                if (RomanToArabic.highestIntegerFromRomanSystem(newRomanSystem) < max) {
                    this.romanSystem = this.romanSystem.substring(0, this.romanSystem.length() - i + 1);
                    return;
                } else if (RomanToArabic.highestIntegerFromRomanSystem(newRomanSystem) == max) {
                    this.romanSystem = this.romanSystem.substring(0, this.romanSystem.length() - i);
                    return;
                }

            }
        }

    }

    public String romanLetters() {
        return romanSystem;
    }

    public int maxNumber() {
        return RomanToArabic.highestIntegerFromRomanSystem(romanSystem);
    }

    public int maxNumber(String romanSystem) {
        return RomanToArabic.highestIntegerFromRomanSystem(romanSystem);
    }

    public boolean setValue(int value) {
        if (!isFromValidInterval(value)) {
            return false;
        }
        numericValue = value;
        return true;
    }

    public int getValue() {
        return numericValue;
    }

    public boolean setRomanNumber(String romanNumber) {
        int arabicValue = RomanToArabic.convert(romanSystem, romanNumber);
        if (arabicValue == FAIL || !isFromValidInterval(arabicValue)) {
            return false;
        }
        numericValue = arabicValue;
        return true;
    }

    public String getRomanNumber() {
        return ArabicToRoman.convert(numericValue, romanSystem, 1, maxNumber());
    }

    protected boolean isFromValidInterval(int value) {
        return (value >= ROMAN_SYSTEM_MINIMUM_VALUE) && (value <= maxNumber());
    }

}
