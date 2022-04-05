import org.junit.jupiter.api.Test;

class RomanToArabicTest {

    @Test
    void testToInt() {
        final int FAIL = -9999;
        assert(RomanToArabic.convert("0") == FAIL);
        assert(RomanToArabic.convert("-I") == FAIL);
        assert(RomanToArabic.convert("I") == 1);
        assert(RomanToArabic.convert("IV") == 4);
        assert(RomanToArabic.convert("II") == 2);
        assert(RomanToArabic.convert("III") == 3);
        assert(RomanToArabic.convert("IIII") == FAIL);
        assert(RomanToArabic.convert("V") == 5);
        assert(RomanToArabic.convert("VI") == 6);
        assert(RomanToArabic.convert("VII") == 7);
        assert(RomanToArabic.convert("VIII") == 8);
        assert(RomanToArabic.convert("IX") == 9);
        assert(RomanToArabic.convert("VIIII") == FAIL);
        assert(RomanToArabic.convert("X") == 10);
        assert(RomanToArabic.convert("XL") == 40);
        assert(RomanToArabic.convert("XC") == 90);
        assert(RomanToArabic.convert("IXIV") == FAIL);
        assert(RomanToArabic.convert("VIV") == FAIL);
        assert(RomanToArabic.convert("CD") == 400);
        assert(RomanToArabic.convert("CM") == 900);
        assert(RomanToArabic.convert("CMXC") == 990);
        assert(RomanToArabic.convert("CMXCIX") == 999);
        assert(RomanToArabic.convert("CMXCIV") == 994);
        assert(RomanToArabic.convert("CDXCIX") == 499);
        assert(RomanToArabic.convert("CDXC") == 490);
        assert(RomanToArabic.convert("LIV") == 54);
        assert(RomanToArabic.convert("CDL") == 450);
        assert(RomanToArabic.convert("DXL") == 540);
        assert(RomanToArabic.convert("IXX") == FAIL);
        assert(RomanToArabic.convert("XXX") == 30);
        assert(RomanToArabic.convert("XXXX") == FAIL);
        assert(RomanToArabic.convert("M") == 1000);
        assert(RomanToArabic.convert("MM") == 2000);
        assert(RomanToArabic.convert("MMMM") == FAIL);
        assert(RomanToArabic.convert("MMMCMXCIX") == 3999);
        assert(RomanToArabic.convert("MMMDCCCXL") == 3840);
        assert(RomanToArabic.convert("CDCC") == FAIL);
        assert(RomanToArabic.convert("CC") == 200);
        assert(RomanToArabic.convert("DCII") == 602);
        assert(RomanToArabic.convert("CDII") == 402);
        assert(RomanToArabic.convert("VV") == FAIL);
        assert(RomanToArabic.convert("LL") == FAIL);
        assert(RomanToArabic.convert("DD") == FAIL);
        assert(RomanToArabic.convert("LXXXIX") == 89);
        assert(RomanToArabic.convert("DCCCLXXXIX") == 889);
        assert(RomanToArabic.convert("XCIX") == 99);
        assert(RomanToArabic.convert("x") == FAIL);
        assert(RomanToArabic.convert("") == FAIL);
        assert(RomanToArabic.convert("XCIV") == 94);
        assert(RomanToArabic.convert("DCCLXXXIX") == 789);
        assert(RomanToArabic.convert("MMCDXXI") == 2421);
        assert(RomanToArabic.convert("MIX") == 1009);
        assert(RomanToArabic.convert("MMMM") == FAIL);
        assert(RomanToArabic.convert("XCX") == FAIL);
        assert(RomanToArabic.convert("IXI") == FAIL);
        assert(RomanToArabic.convert("XV") == 15);
        assert(RomanToArabic.convert(null) == FAIL);
    }

    @Test
    void test_romanCalculator() {
        assert(RomanCalculator.evaluate("I+I").equals("II"));
        assert(RomanCalculator.evaluate("I + I").equals("II"));
        assert(RomanCalculator.evaluate("   I+I   ").equals("II"));
        assert(RomanCalculator.evaluate("II+I").equals("III"));
        assert(RomanCalculator.evaluate("C/L").equals("II"));
    }

}