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

    //
    //  TESTS FOR ALTERNATIVE "ROMAN" SYSTEMS, using minimal systems
    //

    @Test
    void test1_alternative() {
        assertEquals(1, RomanToArabic.convert("A", "A"));
        assertEquals(1, RomanToArabic.convert("Q", "Q"));
    }

    @Test
    void test4_alternative() {
        assertEquals(4, RomanToArabic.convert("AB", "AB"));
    }

    @Test
    void test2_alternative() {
        assertEquals(2, RomanToArabic.convert("A", "AA"));
    }

    @Test
    void test3_alternative() {
        assertEquals(3, RomanToArabic.convert("A","AAA"));
    }

    @Test
    void testFake4TooManyI_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("A","AAAA"));
    }

    @Test
    void test5_alternative() {
        assertEquals(5, RomanToArabic.convert("AB","B"));
    }

    @Test
    void test6_alternative() {
        assertEquals(6, RomanToArabic.convert("AB","BA"));
    }

    @Test
    void test7_alternative() {
        assertEquals(7, RomanToArabic.convert("AB","BAA"));
    }

    @Test
    void test8_alternative() {
        assertEquals(8, RomanToArabic.convert("AB","BAAA"));
    }

    @Test
    void test9_alternative() {
        assertEquals(9, RomanToArabic.convert("ABC", "AC"));
    }

    @Test
    void testFake9TooManyI_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("AB","BAAAA"));
    }

    @Test
    void test10_alternative() {
        assertEquals(10, RomanToArabic.convert("ABC","C"));
    }

    @Test
    void test40_alternative() {
        assertEquals(40, RomanToArabic.convert("ABCD","CD"));
    }

    @Test
    void test90_alternative() {
        assertEquals(90, RomanToArabic.convert("ABCDE","CE"));
    }

    @Test
    void test9_4_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABC","ACAB"));
    }

    @Test
    void test5_4_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("AB", "BAB"));
    }

    @Test
    void test400_alternative() {
        assertEquals(400, RomanToArabic.convert("ABCDEF", "EF"));
    }

    @Test
    void test900_alternative() {
        assertEquals(900, RomanToArabic.convert("ABCDEFG","EG"));
    }

    @Test
    void test990_alternative() {
        assertEquals(990, RomanToArabic.convert("ABCDEFG","EGCE"));
    }

    @Test
    void test999_alternative() {
        assertEquals(999, RomanToArabic.convert("ABCDEFG", "EGCEAC"));
    }

    @Test
    void test994_alternative() {
        assertEquals(994, RomanToArabic.convert("ABCDEFG","EGCEAB"));
    }

    @Test
    void test499_alternative() {
        assertEquals(499, RomanToArabic.convert("ABCDEF","EFCEAC"));
    }

    @Test
    void test490_alternative() {
        assertEquals(490, RomanToArabic.convert("ABCDEF","EFCE"));
    }

    @Test
    void test54_alternative() {
        assertEquals(54, RomanToArabic.convert("ABCD","DAB"));
    }

    @Test
    void test450_alternative() {
        assertEquals(450, RomanToArabic.convert("ABCDEF","EFD"));
    }

    @Test
    void test540_alternative() {
        assertEquals(540, RomanToArabic.convert("ABCDEF", "FCD"));
    }

    @Test
    void test9_10_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABC", "ACC"));
    }

    @Test
    void test30_alternative() {
        assertEquals(30, RomanToArabic.convert("ABC", "CCC"));
    }

    @Test
    void testFake40_tooManyX_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABC", "CCCC"));
    }

    @Test
    void test1000_alternative() {
        assertEquals(1000, RomanToArabic.convert("ABCDEFG", "G"));
    }

    @Test
    void test2000_alternative() {
        assertEquals(2000, RomanToArabic.convert("ABCDEFG", "GG"));
    }

    @Test
    void test3000_alternative() {
        assertEquals(3000, RomanToArabic.convert("ABCDEFG","GGG"));
    }

    @Test
    void test3999_alternative() {
        assertEquals(3999, RomanToArabic.convert("ABCDEFG", "GGGEGCEAC"));
    }

    @Test
    void test3840_alternative() {
        assertEquals(3840, RomanToArabic.convert("ABCDEFG", "GGGFEEECD"));
    }

    @Test
    void testFakeCDCC_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABCDEF", "EFEE"));
    }

    @Test
    void test200_alternative() {
        assertEquals(200, RomanToArabic.convert("ABCDE", "EE"));
    }

    @Test
    void test602_alternative() {
        assertEquals(602, RomanToArabic.convert("ABCDEF", "FEAA"));
    }

    @Test
    void test402_alternative() {
        assertEquals(402, RomanToArabic.convert("ABCDEF","EFAA"));
    }

    @Test
    void testFakeVV_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("AB","BB"));
    }

    @Test
    void testFakeLL_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABCD", "DD"));
    }

    @Test
    void testFakeDD_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABCDEF", "FF"));
    }

    @Test
    void test89_alternative() {
        assertEquals(89, RomanToArabic.convert("ABCD", "DCCCAC"));
    }

    @Test
    void test889_alternative() {
        assertEquals(889, RomanToArabic.convert("ABCDEF", "FEEEDCCCAC"));
    }

    @Test
    void test99_alternative() {
        assertEquals(99, RomanToArabic.convert("ABCDE", "CEAC"));
    }

    @Test
    void test94_alternative() {
        assertEquals(94, RomanToArabic.convert("ABCDE", "CEAB"));
    }

    @Test
    void test789_alternative() {
        assertEquals(789, RomanToArabic.convert("ABCDEF", "FEEDCCCAC"));
    }

    @Test
    void test2421_alternative() {
        assertEquals(2421, RomanToArabic.convert("ABCDEFG", "GGEFCCA"));
    }

    @Test
    void test1009_alternative() {
        assertEquals(1009, RomanToArabic.convert("ABCDEFG", "GAC"));
    }

    @Test
    void testFake4000_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABCDEFG", "GGGG"));
    }

    @Test
    void testFakeXCX_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABCDE", "CEC"));
    }

    @Test
    void testFakeIXI_alternative() {
        assertEquals(FAIL, RomanToArabic.convert("ABC", "ACA"));
    }

    @Test
    void test15_alternative() {
        assertEquals(15, RomanToArabic.convert("ABC", "CB"));
    }

    @Test
    void testNullParameters() {
        assertEquals(FAIL, RomanToArabic.convert(null, null));
    }

    //
    //  ALTERNATIVE ROMAN SYSTEMS - tests from assignment
    //

    @Test
    void test_fromAssignment1() {
        assertEquals(8, RomanToArabic.convert("IV", "VIII"));
    }

    @Test
    void test_fromAssignment2() {
        assertEquals(3, RomanToArabic.convert("A", "AAA"));
    }

    @Test
    void test_fromAssignment3() {
        assertEquals(FAIL, RomanToArabic.convert("I", "IV"));
    }

    @Test
    void test_fromAssignment4() {
        assertEquals(89, RomanToArabic.convert("IVXL", "LXXXIX"));
    }

    @Test
    void test_fromAssignment5() {
        assertEquals(1015, RomanToArabic.convert("IAVXLCQDM", "QVA"));
    }

    @Test
    void test_fromAssignment6() {
        assertEquals(300000, RomanToArabic.convert("IVXLCDMPQRS", "SSS"));
    }

    @Test
    void test_fromAssignment7() {
        assertEquals(FAIL, RomanToArabic.convert("", "IV"));
    }

    @Test
    void test_fromAssignment8() {
        assertEquals(FAIL, RomanToArabic.convert("IVXLX", "IV"));
    }

    //
    //  ALTERNATIVE ROMAN SYSTEMS - more tests
    //

    @Test
    void test_nullRomanSystem() {
        assertEquals(FAIL, RomanToArabic.convert(null, "I"));
    }

    @Test
    void test_unnecessarilyLongSystem() {
        assertEquals(1, RomanToArabic.convert("AB", "A"));
        assertEquals(1, RomanToArabic.convert("ABC", "A"));
        assertEquals(15, RomanToArabic.convert("ABCDEFGHIJKLM", "CB"));
    }

    @Test
    void test_symbolsNotFromSystem() {
        assertEquals(FAIL, RomanToArabic.convert("ABCDE", "X"));
        assertEquals(FAIL, RomanToArabic.convert("ABCDE", "QQ"));
    }

    @Test
    void test_longestSystem() {
        assertEquals(1, RomanToArabic.convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "A"));
        assertEquals(2, RomanToArabic.convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "AA"));
    }

    //
    //  maximal possible Integer value in roman system
    //

    @Test
    void maxValueInRomanSystem_invalidSystem_null() {
        assertEquals(FAIL, RomanToArabic.highestIntegerFromRomanSystem(null));
    }

    @Test
    void maxValueInRomanSystem_invalidSystem_emptyString() {
        assertEquals(FAIL, RomanToArabic.highestIntegerFromRomanSystem(""));
    }

    @Test
    void maxValueInRomanSystem_invalidSystem_repeatedSymbol() {
        assertEquals(FAIL, RomanToArabic.highestIntegerFromRomanSystem("AA"));
        assertEquals(FAIL, RomanToArabic.highestIntegerFromRomanSystem("ABCDEA"));
        assertEquals(FAIL, RomanToArabic.highestIntegerFromRomanSystem("ABCDECFGH"));
    }

    @Test
    void maxValueInRomanSystem_invalidSystem_invalidSymbol() {
        assertEquals(FAIL, RomanToArabic.highestIntegerFromRomanSystem(" "));
        assertEquals(FAIL, RomanToArabic.highestIntegerFromRomanSystem("a"));
        assertEquals(FAIL, RomanToArabic.highestIntegerFromRomanSystem("ABCDEC.FGH"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_1() {
        assertEquals(3, RomanToArabic.highestIntegerFromRomanSystem("A"));
        assertEquals(3, RomanToArabic.highestIntegerFromRomanSystem("I"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_2() {
        assertEquals(8, RomanToArabic.highestIntegerFromRomanSystem("AB"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_3() {
        assertEquals(39, RomanToArabic.highestIntegerFromRomanSystem("ABC"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_4() {
        assertEquals(89, RomanToArabic.highestIntegerFromRomanSystem("ABCD"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_5() {
        assertEquals(399, RomanToArabic.highestIntegerFromRomanSystem("ABCDE"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_6() {
        assertEquals(899, RomanToArabic.highestIntegerFromRomanSystem("ABCDEF"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_7() {
        assertEquals(3999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFG"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_8() {
        assertEquals(8999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGH"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_9() {
        assertEquals(39999, RomanToArabic.highestIntegerFromRomanSystem("IVXLCDMQF"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_10() {
        assertEquals(89999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJ"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_11() {
        assertEquals(399999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJK"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_12() {
        assertEquals(899999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJKL"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_13() {
        assertEquals(3999999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJKLM"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_14() {
        assertEquals(8999999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJKLMN"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_15() {
        assertEquals(39999999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJKLMNO"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_16() {
        assertEquals(89999999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJKLMNOP"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_17() {
        assertEquals(399999999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJKLMNOPQ"));
    }

    @Test
    void maxValueInRomanSystem_SystemLength_18() {
        assertEquals(899999999, RomanToArabic.highestIntegerFromRomanSystem("ABCDEFGHIJKLMNOPQR"));
    }

}
