import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testToInt() {
        final int FAIL = -9999;
        Main m = new Main();
        assert(m.RomanToDecimal("0") == -9999);
        assert(m.RomanToDecimal("-I") == -9999);
        assert(m.RomanToDecimal("I") == 1);
        assert(m.RomanToDecimal("IV") == 4);
        assert(m.RomanToDecimal("II") == 2);
        assert(m.RomanToDecimal("III") == 3);
        assert(m.RomanToDecimal("IIII") == -9999);
        assert(m.RomanToDecimal("V") == 5);
        assert(m.RomanToDecimal("VI") == 6);
        assert(m.RomanToDecimal("VII") == 7);
        assert(m.RomanToDecimal("VIII") == 8);
        assert(m.RomanToDecimal("IX") == 9);
        assert(m.RomanToDecimal("VIIII") == -9999);
        assert(m.RomanToDecimal("X") == 10);
        assert(m.RomanToDecimal("XL") == 40);
        assert(m.RomanToDecimal("XC") == 90);
        assert(m.RomanToDecimal("IXIV") == -9999);
        assert(m.RomanToDecimal("VIV") == -9999);
        assert(m.RomanToDecimal("CD") == 400);
        assert(m.RomanToDecimal("CM") == 900);
        assert(m.RomanToDecimal("CMXC") == 990);
        assert(m.RomanToDecimal("CMXCIX") == 999);
        assert(m.RomanToDecimal("CMXCIV") == 994);
        assert(m.RomanToDecimal("CDXCIX") == 499);
        assert(m.RomanToDecimal("CDXC") == 490);
        assert(m.RomanToDecimal("LIV") == 54);
        assert(m.RomanToDecimal("CDL") == 450);
        assert(m.RomanToDecimal("DXL") == 540);
        assert(m.RomanToDecimal("IXX") == -9999);
        assert(m.RomanToDecimal("XXX") == 30);
        assert(m.RomanToDecimal("XXXX") == -9999);
        assert(m.RomanToDecimal("M") == 1000);
        assert(m.RomanToDecimal("MM") == 2000);
        assert(m.RomanToDecimal("MMMM") == -9999);
        assert(m.RomanToDecimal("MMMCMXCIX") == 3999);
        assert(m.RomanToDecimal("MMMDCCCXL") == 3840);
        assert(m.RomanToDecimal("CDCC") == FAIL);
        assert(m.RomanToDecimal("CC") == 200);
        assert(m.RomanToDecimal("DCII") == 602);
        assert(m.RomanToDecimal("CDII") == 402);
        assert(m.RomanToDecimal("VV") == FAIL);
        assert(m.RomanToDecimal("LL") == FAIL);
        assert(m.RomanToDecimal("DD") == FAIL);
        assert(m.RomanToDecimal("LXXXIX") == 89);
        assert(m.RomanToDecimal("DCCCLXXXIX") == 889);
        assert(m.RomanToDecimal("XCIX") == 99);
        assert(m.RomanToDecimal("x") == FAIL);
        assert(m.RomanToDecimal("") == FAIL);
        assert(m.RomanToDecimal("XCIV") == 94);
        assert(m.RomanToDecimal("DCCLXXXIX") == 789);
        assert(m.RomanToDecimal("MMCDXXI") == 2421);
        assert(m.RomanToDecimal("MIX") == 1009);
        assert(m.RomanToDecimal("MMMM") == FAIL);
        assert(m.RomanToDecimal("XCX") == FAIL);
        assert(m.RomanToDecimal("IXI") == FAIL);
        assert(m.RomanToDecimal("XV") == 15);
        assert(m.RomanToDecimal(null) == FAIL);
    }

}