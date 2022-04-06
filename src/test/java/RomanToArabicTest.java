import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class RomanToArabicTest {

    private final int FAIL = -9999;

    @Test
    void emptyString() {
        assertEquals(FAIL, RomanToArabic.convert(""));
    }

    @Test
    void invalidValue() {
        assertEquals(FAIL, RomanToArabic.convert(" "));
        assertEquals(FAIL, RomanToArabic.convert("0"));
        assertEquals(FAIL, RomanToArabic.convert("hello"));
    }

    @Test
    void negativeValue() {
        assertEquals(FAIL, RomanToArabic.convert("-I"));
    }

    @Test
    void test1() {
        assertEquals(1, RomanToArabic.convert("I"));
    }

    @Test
    void test4() {
        assertEquals(4, RomanToArabic.convert("IV"));
    }

    @Test
    void test2() {
        assertEquals(2, RomanToArabic.convert("II"));
    }

    @Test
    void test3() {
        assertEquals(3, RomanToArabic.convert("III"));
    }

    @Test
    void testFake4TooManyI() {
        assertEquals(FAIL, RomanToArabic.convert("IIII"));
    }

    @Test
    void test5() {
        assertEquals(5, RomanToArabic.convert("V"));
    }

    @Test
    void test6() {
        assertEquals(6, RomanToArabic.convert("VI"));
    }

    @Test
    void test7() {
        assertEquals(7, RomanToArabic.convert("VII"));
    }

    @Test
    void test8() {
        assertEquals(8, RomanToArabic.convert("VIII"));
    }

    @Test
    void test9() {
        assertEquals(9, RomanToArabic.convert("IX"));
    }

    @Test
    void testFake9TooManyI() {
        assertEquals(FAIL, RomanToArabic.convert("VIIII"));
    }

    @Test
    void test10() {
        assertEquals(10, RomanToArabic.convert("X"));
    }

    @Test
    void test40() {
        assertEquals(40, RomanToArabic.convert("XL"));
    }

    @Test
    void test90() {
        assertEquals(90, RomanToArabic.convert("XC"));
    }

    @Test
    void test9_4() {
        assertEquals(FAIL, RomanToArabic.convert("IXIV"));
    }

    @Test
    void test5_4() {
        assertEquals(FAIL, RomanToArabic.convert("VIV"));
    }

    @Test
    void test400() {
        assertEquals(400, RomanToArabic.convert("CD"));
    }

    @Test
    void test900() {
        assertEquals(900, RomanToArabic.convert("CM"));
    }

    @Test
    void test990() {
        assertEquals(990, RomanToArabic.convert("CMXC"));
    }

    @Test
    void test999() {
        assertEquals(999, RomanToArabic.convert("CMXCIX"));
    }

    @Test
    void test994() {
        assertEquals(994, RomanToArabic.convert("CMXCIV"));
    }

    @Test
    void test499() {
        assertEquals(499, RomanToArabic.convert("CDXCIX"));
    }

    @Test
    void test490() {
        assertEquals(490, RomanToArabic.convert("CDXC"));
    }

    @Test
    void test54() {
        assertEquals(54, RomanToArabic.convert("LIV"));
    }

    @Test
    void test450() {
        assertEquals(450, RomanToArabic.convert("CDL"));
    }

    @Test
    void test540() {
        assertEquals(540, RomanToArabic.convert("DXL"));
    }

    @Test
    void test9_10() {
        assertEquals(FAIL, RomanToArabic.convert("IXX"));
    }

    @Test
    void test30() {
        assertEquals(30, RomanToArabic.convert("XXX"));
    }

    @Test
    void testFake40_tooManyX() {
        assertEquals(FAIL, RomanToArabic.convert("XXXX"));
    }

    @Test
    void test1000() {
        assertEquals(1000, RomanToArabic.convert("M"));
    }

    @Test
    void test2000() {
        assertEquals(2000, RomanToArabic.convert("MM"));
    }

    @Test
    void test3000() {
        assertEquals(3000, RomanToArabic.convert("MMM"));
    }

    @Test
    void test3999() {
        assertEquals(3999, RomanToArabic.convert("MMMCMXCIX"));
    }

    @Test
    void test3840() {
        assertEquals(3840, RomanToArabic.convert("MMMDCCCXL"));
    }

    @Test
    void testFakeCDCC() {
        assertEquals(FAIL, RomanToArabic.convert("CDCC"));
    }

    @Test
    void test200() {
        assertEquals(200, RomanToArabic.convert("CC"));
    }

    @Test
    void test602() {
        assertEquals(602, RomanToArabic.convert("DCII"));
    }

    @Test
    void test402() {
        assertEquals(402, RomanToArabic.convert("CDII"));
    }

    @Test
    void testFakeVV() {
        assertEquals(FAIL, RomanToArabic.convert("VV"));
    }

    @Test
    void testFakeLL() {
        assertEquals(FAIL, RomanToArabic.convert("LL"));
    }

    @Test
    void testFakeDD() {
        assertEquals(FAIL, RomanToArabic.convert("DD"));
    }

    @Test
    void test89() {
        assertEquals(89, RomanToArabic.convert("LXXXIX"));
    }

    @Test
    void test889() {
        assertEquals(889, RomanToArabic.convert("DCCCLXXXIX"));
    }

    @Test
    void test99() {
        assertEquals(99, RomanToArabic.convert("XCIX"));
    }

    @Test
    void test94() {
        assertEquals(94, RomanToArabic.convert("XCIV"));
    }

    @Test
    void test789() {
        assertEquals(789, RomanToArabic.convert("DCCLXXXIX"));
    }

    @Test
    void test2421() {
        assertEquals(2421, RomanToArabic.convert("MMCDXXI"));
    }

    @Test
    void test1009() {
        assertEquals(1009, RomanToArabic.convert("MIX"));
    }

    @Test
    void testFake4000() {
        assertEquals(FAIL, RomanToArabic.convert("MMMM"));
    }

    @Test
    void testFakeXCX() {
        assertEquals(FAIL, RomanToArabic.convert("XCX"));
    }

    @Test
    void testFakeIXI() {
        assertEquals(FAIL, RomanToArabic.convert("IXI"));
    }

    @Test
    void test15() {
        assertEquals(15, RomanToArabic.convert("XV"));
    }

    @Test
    void testNull() {
        assertEquals(FAIL, RomanToArabic.convert(null));
    }

}
