import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class ArabicToRomanTest {

    @Test
    void zero() {
        assertNull(ArabicToRoman.convert(0));
    }

    @Test
    void tooLow() {
        assertNull(ArabicToRoman.convert(-1));
        assertNull(ArabicToRoman.convert(-1000));
    }

    @Test
    void tooHigh() {
        assertNull(ArabicToRoman.convert(4000));
        assertNull(ArabicToRoman.convert(6000));
    }

    @Test
    void test1() {
        assertEquals("I", ArabicToRoman.convert(1));
    }

    @Test
    void test2() {
        assertEquals("II", ArabicToRoman.convert(2));
    }

    @Test
    void test3() {
        assertEquals("III", ArabicToRoman.convert(3));
    }

    @Test
    void test4() {
        assertEquals("IV", ArabicToRoman.convert(4));
    }

    @Test
    void test5() {
        assertEquals("V", ArabicToRoman.convert(5));
    }

    @Test
    void test6() {
        assertEquals("VI", ArabicToRoman.convert(6));
    }

    @Test
    void test7() {
        assertEquals("VII", ArabicToRoman.convert(7));
    }

    @Test
    void test8() {
        assertEquals("VIII", ArabicToRoman.convert(8));
    }

    @Test
    void test9() {
        assertEquals("IX", ArabicToRoman.convert(9));
    }

    @Test
    void test10() {
        assertEquals("X", ArabicToRoman.convert(10));
    }

    @Test
    void test40() {
        assertEquals("XL", ArabicToRoman.convert(40));
    }

    @Test
    void test90() {
        assertEquals("XC", ArabicToRoman.convert(90));
    }

    @Test
    void test400() {
        assertEquals("CD", ArabicToRoman.convert(400));
    }

    @Test
    void test900() {
        assertEquals("CM", ArabicToRoman.convert(900));
    }

    @Test
    void test990() {
        assertEquals("CMXC", ArabicToRoman.convert(990));
    }

    @Test
    void test994() {
        assertEquals("CMXCIV", ArabicToRoman.convert(994));
    }

    @Test
    void test999() {
        assertEquals("CMXCIX", ArabicToRoman.convert(999));
    }

    @Test
    void test490() {
        assertEquals("CDXC", ArabicToRoman.convert(490));
    }

    @Test
    void test499() {
        assertEquals("CDXCIX", ArabicToRoman.convert(499));
    }

    @Test
    void test54() {
        assertEquals("LIV", ArabicToRoman.convert(54));
    }

    @Test
    void test450() {
        assertEquals("CDL", ArabicToRoman.convert(450));
    }

    @Test
    void test540() {
        assertEquals("DXL", ArabicToRoman.convert(540));
    }

    @Test
    void test30() {
        assertEquals("XXX", ArabicToRoman.convert(30));
    }

    @Test
    void test1000() {
        assertEquals("M", ArabicToRoman.convert(1000));
    }

    @Test
    void test2000() {
        assertEquals("MM", ArabicToRoman.convert(2000));
    }

    @Test
    void test3000() {
        assertEquals("MMM", ArabicToRoman.convert(3000));
    }

    @Test
    void test3840() {
        assertEquals("MMMDCCCXL", ArabicToRoman.convert(3840));
    }

    @Test
    void test200() {
        assertEquals("CC", ArabicToRoman.convert(200));
    }

    @Test
    void test602() {
        assertEquals("DCII", ArabicToRoman.convert(602));
    }

    @Test
    void test402() {
        assertEquals("CDII", ArabicToRoman.convert(402));
    }

    @Test
    void test89() {
        assertEquals("LXXXIX", ArabicToRoman.convert(89));
    }

    @Test
    void test889() {
        assertEquals("DCCCLXXXIX", ArabicToRoman.convert(889));
    }

    @Test
    void test99() {
        assertEquals("XCIX", ArabicToRoman.convert(99));
    }

    @Test
    void test94() {
        assertEquals("XCIV", ArabicToRoman.convert(94));
    }

    @Test
    void test789() {
        assertEquals("DCCLXXXIX", ArabicToRoman.convert(789));
    }

    @Test
    void test2421() {
        assertEquals("MMCDXXI", ArabicToRoman.convert(2421));
    }

    @Test
    void test15() {
        assertEquals("XV", ArabicToRoman.convert(15));
    }

}
