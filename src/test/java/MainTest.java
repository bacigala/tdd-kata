import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testToInt() {
        final int FAIL = -9999;
        assert(Main.toInteger("0") == -9999);
        assert(Main.toInteger("-I") == -9999);
        assert(Main.toInteger("I") == 1);
        assert(Main.toInteger("IV") == 4);
        assert(Main.toInteger("II") == 2);
        assert(Main.toInteger("III") == 3);
        assert(Main.toInteger("IIII") == -9999);
        assert(Main.toInteger("V") == 5);
        assert(Main.toInteger("VI") == 6);
        assert(Main.toInteger("VII") == 7);
        assert(Main.toInteger("VIII") == 8);
        assert(Main.toInteger("IX") == 9);
        assert(Main.toInteger("VIIII") == -9999);
        assert(Main.toInteger("X") == 10);
        assert(Main.toInteger("XL") == 40);
        assert(Main.toInteger("XC") == 90);
        assert(Main.toInteger("IXIV") == -9999);
        assert(Main.toInteger("VIV") == -9999);
        assert(Main.toInteger("CD") == 400);
        assert(Main.toInteger("CM") == 900);
        assert(Main.toInteger("CMXC") == 990);
        assert(Main.toInteger("CMXCIX") == 999);
        assert(Main.toInteger("CMXCIV") == 994);
        assert(Main.toInteger("CDXCIX") == 499);
        assert(Main.toInteger("CDXC") == 490);
        assert(Main.toInteger("LIV") == 54);
        assert(Main.toInteger("CDL") == 450);
        assert(Main.toInteger("DXL") == 540);
        assert(Main.toInteger("IXX") == -9999);
        assert(Main.toInteger("XXX") == 30);
        assert(Main.toInteger("XXXX") == -9999);
        assert(Main.toInteger("M") == 1000);
        assert(Main.toInteger("MM") == 2000);
        assert(Main.toInteger("MMMM") == -9999);
        assert(Main.toInteger("MMMCMXCIX") == 3999);
        assert(Main.toInteger("MMMDCCCXL") == 3840);
        assert(Main.toInteger("CDCC") == FAIL);
        assert(Main.toInteger("CC") == 200);
        assert(Main.toInteger("DCII") == 602);
        assert(Main.toInteger("CDII") == 402);
        assert(Main.toInteger("VV") == FAIL);
        assert(Main.toInteger("LL") == FAIL);
        assert(Main.toInteger("DD") == FAIL);
        assert(Main.toInteger("LXXXIX") == 89);
        assert(Main.toInteger("DCCCLXXXIX") == 889);
        assert(Main.toInteger("XCIX") == 99);
        assert(Main.toInteger("x") == FAIL);
        assert(Main.toInteger("") == FAIL);
        assert(Main.toInteger("XCIV") == 94);
        assert(Main.toInteger("DCCLXXXIX") == 789);
        assert(Main.toInteger("MMCDXXI") == 2421);
        assert(Main.toInteger("MIX") == 1009);
        assert(Main.toInteger("MMMM") == FAIL);
        assert(Main.toInteger("XCX") == FAIL);
        assert(Main.toInteger("IXI") == FAIL);
        assert(Main.toInteger("XV") == 15);
    }

}