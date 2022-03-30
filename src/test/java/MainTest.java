import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testToInt() {
        final int FAIL = -9999;
        assert(Main.romanToInteger("0") == -9999);
        assert(Main.romanToInteger("-I") == -9999);
        assert(Main.romanToInteger("I") == 1);
        assert(Main.romanToInteger("IV") == 4);
        assert(Main.romanToInteger("II") == 2);
        assert(Main.romanToInteger("III") == 3);
        assert(Main.romanToInteger("IIII") == -9999);
        assert(Main.romanToInteger("V") == 5);
        assert(Main.romanToInteger("VI") == 6);
        assert(Main.romanToInteger("VII") == 7);
        assert(Main.romanToInteger("VIII") == 8);
        assert(Main.romanToInteger("IX") == 9);
        assert(Main.romanToInteger("VIIII") == -9999);
        assert(Main.romanToInteger("X") == 10);
        assert(Main.romanToInteger("XL") == 40);
        assert(Main.romanToInteger("XC") == 90);
        assert(Main.romanToInteger("IXIV") == -9999);
        assert(Main.romanToInteger("VIV") == -9999);
        assert(Main.romanToInteger("CD") == 400);
        assert(Main.romanToInteger("CM") == 900);
        assert(Main.romanToInteger("CMXC") == 990);
        assert(Main.romanToInteger("CMXCIX") == 999);
        assert(Main.romanToInteger("CMXCIV") == 994);
        assert(Main.romanToInteger("CDXCIX") == 499);
        assert(Main.romanToInteger("CDXC") == 490);
        assert(Main.romanToInteger("LIV") == 54);
        assert(Main.romanToInteger("CDL") == 450);
        assert(Main.romanToInteger("DXL") == 540);
        assert(Main.romanToInteger("IXX") == -9999);
        assert(Main.romanToInteger("XXX") == 30);
        assert(Main.romanToInteger("XXXX") == -9999);
        assert(Main.romanToInteger("M") == 1000);
        assert(Main.romanToInteger("MM") == 2000);
        assert(Main.romanToInteger("MMMM") == -9999);
        assert(Main.romanToInteger("MMMCMXCIX") == 3999);
        assert(Main.romanToInteger("MMMDCCCXL") == 3840);
        assert(Main.romanToInteger("CDCC") == FAIL);
        assert(Main.romanToInteger("CC") == 200);
        assert(Main.romanToInteger("DCII") == 602);
        assert(Main.romanToInteger("CDII") == 402);
        assert(Main.romanToInteger("VV") == FAIL);
        assert(Main.romanToInteger("LL") == FAIL);
        assert(Main.romanToInteger("DD") == FAIL);
        assert(Main.romanToInteger("LXXXIX") == 89);
        assert(Main.romanToInteger("DCCCLXXXIX") == 889);
        assert(Main.romanToInteger("XCIX") == 99);
        assert(Main.romanToInteger("x") == FAIL);
        assert(Main.romanToInteger("") == FAIL);
        assert(Main.romanToInteger("XCIV") == 94);
        assert(Main.romanToInteger("DCCLXXXIX") == 789);
        assert(Main.romanToInteger("MMCDXXI") == 2421);
        assert(Main.romanToInteger("MIX") == 1009);
        assert(Main.romanToInteger("MMMM") == FAIL);
        assert(Main.romanToInteger("XCX") == FAIL);
        assert(Main.romanToInteger("IXI") == FAIL);
        assert(Main.romanToInteger("XV") == 15);
        assert(Main.romanToInteger(null) == FAIL);
    }

    @Test
    void testToRoman() {
        assert(Main.integerToRoman(0) == null);
        assert(Main.integerToRoman(-1) == null);
        assert(Main.integerToRoman(4000) == null);
        assert(Main.integerToRoman(1).equals("I"));
        assert(Main.integerToRoman(2).equals("II"));
        assert(Main.integerToRoman(3).equals("III"));
        assert(Main.integerToRoman(5).equals("V"));
        assert(Main.integerToRoman(6).equals("VI"));
        assert(Main.integerToRoman(7).equals("VII"));
        assert(Main.integerToRoman(8).equals("VIII"));
        assert(Main.integerToRoman(9).equals("IX"));
        assert(Main.integerToRoman(10).equals("X"));
        assert(Main.integerToRoman(40).equals("XL"));
        assert(Main.integerToRoman(90).equals("XC"));
        assert(Main.integerToRoman(400).equals("CD"));
        assert(Main.integerToRoman(900).equals("CM"));
        assert(Main.integerToRoman(990).equals("CMXC"));
        assert(Main.integerToRoman(999).equals("CMXCIX"));
        assert(Main.integerToRoman(994).equals("CMXCIV"));
        assert(Main.integerToRoman(499).equals("CDXCIX"));
        assert(Main.integerToRoman(490).equals("CDXC"));
        assert(Main.integerToRoman(54).equals("LIV"));
        assert(Main.integerToRoman(450).equals("CDL"));
        assert(Main.integerToRoman(540).equals("DXL"));
        assert(Main.integerToRoman(30).equals("XXX"));
        assert(Main.integerToRoman(1000).equals("M"));
        assert(Main.integerToRoman(2000).equals("MM"));
        assert(Main.integerToRoman(3000).equals("MMM"));
        assert(Main.integerToRoman(3840).equals("MMMDCCCXL"));
        assert(Main.integerToRoman(200).equals("CC"));
        assert(Main.integerToRoman(602).equals("DCII"));
        assert(Main.integerToRoman(402).equals("CDII"));
        assert(Main.integerToRoman(89).equals("LXXXIX"));
        assert(Main.integerToRoman(889).equals("DCCCLXXXIX"));
        assert(Main.integerToRoman(99).equals("XCIX"));
        assert(Main.integerToRoman(94).equals("XCIV"));
        assert(Main.integerToRoman(789).equals("DCCLXXXIX"));
        assert(Main.integerToRoman(2421).equals("MMCDXXI"));
        assert(Main.integerToRoman(15).equals("XV"));
    }

    @Test
    void test_romanCalculator() {
        assert(Main.romanCalculator("I+I").equals("II"));
        assert(Main.romanCalculator("I + I").equals("II"));
        assert(Main.romanCalculator("   I+I   ").equals("II"));
        assert(Main.romanCalculator("II+I").equals("III"));
        assert(Main.romanCalculator("C/L").equals("II"));
    }
}