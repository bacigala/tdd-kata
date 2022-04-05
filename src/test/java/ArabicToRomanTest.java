import org.junit.jupiter.api.Test;

public class ArabicToRomanTest {

    @Test
    void allTests() {
        assert(ArabicToRoman.convert(0) == null);
        assert(ArabicToRoman.convert(-1) == null);
        assert(ArabicToRoman.convert(4000) == null);
        assert(ArabicToRoman.convert(1).equals("I"));
        assert(ArabicToRoman.convert(2).equals("II"));
        assert(ArabicToRoman.convert(3).equals("III"));
        assert(ArabicToRoman.convert(5).equals("V"));
        assert(ArabicToRoman.convert(6).equals("VI"));
        assert(ArabicToRoman.convert(7).equals("VII"));
        assert(ArabicToRoman.convert(8).equals("VIII"));
        assert(ArabicToRoman.convert(9).equals("IX"));
        assert(ArabicToRoman.convert(10).equals("X"));
        assert(ArabicToRoman.convert(40).equals("XL"));
        assert(ArabicToRoman.convert(90).equals("XC"));
        assert(ArabicToRoman.convert(400).equals("CD"));
        assert(ArabicToRoman.convert(900).equals("CM"));
        assert(ArabicToRoman.convert(990).equals("CMXC"));
        assert(ArabicToRoman.convert(999).equals("CMXCIX"));
        assert(ArabicToRoman.convert(994).equals("CMXCIV"));
        assert(ArabicToRoman.convert(499).equals("CDXCIX"));
        assert(ArabicToRoman.convert(490).equals("CDXC"));
        assert(ArabicToRoman.convert(54).equals("LIV"));
        assert(ArabicToRoman.convert(450).equals("CDL"));
        assert(ArabicToRoman.convert(540).equals("DXL"));
        assert(ArabicToRoman.convert(30).equals("XXX"));
        assert(ArabicToRoman.convert(1000).equals("M"));
        assert(ArabicToRoman.convert(2000).equals("MM"));
        assert(ArabicToRoman.convert(3000).equals("MMM"));
        assert(ArabicToRoman.convert(3840).equals("MMMDCCCXL"));
        assert(ArabicToRoman.convert(200).equals("CC"));
        assert(ArabicToRoman.convert(602).equals("DCII"));
        assert(ArabicToRoman.convert(402).equals("CDII"));
        assert(ArabicToRoman.convert(89).equals("LXXXIX"));
        assert(ArabicToRoman.convert(889).equals("DCCCLXXXIX"));
        assert(ArabicToRoman.convert(99).equals("XCIX"));
        assert(ArabicToRoman.convert(94).equals("XCIV"));
        assert(ArabicToRoman.convert(789).equals("DCCLXXXIX"));
        assert(ArabicToRoman.convert(2421).equals("MMCDXXI"));
        assert(ArabicToRoman.convert(15).equals("XV"));
    }

}
