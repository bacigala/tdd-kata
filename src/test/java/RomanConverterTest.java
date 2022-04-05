import org.junit.jupiter.api.Test;

class RomanConverterTest {

    @Test
    void testToInt() {
        final int FAIL = -9999;
        assert(RomanConverter.romanToDecimal("0") == FAIL);
        assert(RomanConverter.romanToDecimal("-I") == FAIL);
        assert(RomanConverter.romanToDecimal("I") == 1);
        assert(RomanConverter.romanToDecimal("IV") == 4);
        assert(RomanConverter.romanToDecimal("II") == 2);
        assert(RomanConverter.romanToDecimal("III") == 3);
        assert(RomanConverter.romanToDecimal("IIII") == FAIL);
        assert(RomanConverter.romanToDecimal("V") == 5);
        assert(RomanConverter.romanToDecimal("VI") == 6);
        assert(RomanConverter.romanToDecimal("VII") == 7);
        assert(RomanConverter.romanToDecimal("VIII") == 8);
        assert(RomanConverter.romanToDecimal("IX") == 9);
        assert(RomanConverter.romanToDecimal("VIIII") == FAIL);
        assert(RomanConverter.romanToDecimal("X") == 10);
        assert(RomanConverter.romanToDecimal("XL") == 40);
        assert(RomanConverter.romanToDecimal("XC") == 90);
        assert(RomanConverter.romanToDecimal("IXIV") == FAIL);
        assert(RomanConverter.romanToDecimal("VIV") == FAIL);
        assert(RomanConverter.romanToDecimal("CD") == 400);
        assert(RomanConverter.romanToDecimal("CM") == 900);
        assert(RomanConverter.romanToDecimal("CMXC") == 990);
        assert(RomanConverter.romanToDecimal("CMXCIX") == 999);
        assert(RomanConverter.romanToDecimal("CMXCIV") == 994);
        assert(RomanConverter.romanToDecimal("CDXCIX") == 499);
        assert(RomanConverter.romanToDecimal("CDXC") == 490);
        assert(RomanConverter.romanToDecimal("LIV") == 54);
        assert(RomanConverter.romanToDecimal("CDL") == 450);
        assert(RomanConverter.romanToDecimal("DXL") == 540);
        assert(RomanConverter.romanToDecimal("IXX") == FAIL);
        assert(RomanConverter.romanToDecimal("XXX") == 30);
        assert(RomanConverter.romanToDecimal("XXXX") == FAIL);
        assert(RomanConverter.romanToDecimal("M") == 1000);
        assert(RomanConverter.romanToDecimal("MM") == 2000);
        assert(RomanConverter.romanToDecimal("MMMM") == FAIL);
        assert(RomanConverter.romanToDecimal("MMMCMXCIX") == 3999);
        assert(RomanConverter.romanToDecimal("MMMDCCCXL") == 3840);
        assert(RomanConverter.romanToDecimal("CDCC") == FAIL);
        assert(RomanConverter.romanToDecimal("CC") == 200);
        assert(RomanConverter.romanToDecimal("DCII") == 602);
        assert(RomanConverter.romanToDecimal("CDII") == 402);
        assert(RomanConverter.romanToDecimal("VV") == FAIL);
        assert(RomanConverter.romanToDecimal("LL") == FAIL);
        assert(RomanConverter.romanToDecimal("DD") == FAIL);
        assert(RomanConverter.romanToDecimal("LXXXIX") == 89);
        assert(RomanConverter.romanToDecimal("DCCCLXXXIX") == 889);
        assert(RomanConverter.romanToDecimal("XCIX") == 99);
        assert(RomanConverter.romanToDecimal("x") == FAIL);
        assert(RomanConverter.romanToDecimal("") == FAIL);
        assert(RomanConverter.romanToDecimal("XCIV") == 94);
        assert(RomanConverter.romanToDecimal("DCCLXXXIX") == 789);
        assert(RomanConverter.romanToDecimal("MMCDXXI") == 2421);
        assert(RomanConverter.romanToDecimal("MIX") == 1009);
        assert(RomanConverter.romanToDecimal("MMMM") == FAIL);
        assert(RomanConverter.romanToDecimal("XCX") == FAIL);
        assert(RomanConverter.romanToDecimal("IXI") == FAIL);
        assert(RomanConverter.romanToDecimal("XV") == 15);
        assert(RomanConverter.romanToDecimal(null) == FAIL);
    }

}