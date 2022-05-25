

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class Task_5 {

    @Test
    void cislice_I_1() {
        RomanNumber number = new RomanNumber("I", 1);
        assertEquals(number.maxNumber(), 3);
    }
    @Test
    void cislice_I_0() {
        RomanNumber number = new RomanNumber("IV", 0);
        assertEquals(number.maxNumber(), 3999);
    }
    @Test
    void maxPrivelky() {
        RomanNumber number = new RomanNumber("IVXLC", 4000);
        assertEquals(number.maxNumber(), 3999);
    }
    @Test
    void inaNula_II() {
        RomanNumber number = new RomanNumber("XYZ", 5);
        assertEquals(number.romanLetters(), "XY");
        assertEquals(number.maxNumber(), 8);
    }
    @Test
    void OIVXLCDMPQWE_II() {
        RomanNumber number = new RomanNumber("IVXLCDMPQWE", 8900);
        assertEquals(number.maxNumber(), 8999);
    }
    @Test
    void maximumOIVXLC_II() {
        RomanNumber number = new RomanNumber("IVXLCD", 399);
        assertEquals(number.maxNumber(), 399);
    }
    @Test
    void O_II() {
        RomanNumber number = new RomanNumber("IV", -1);
        assertEquals(number.maxNumber(), 3999);
    }
    @Test
    void minimumOIVXL_II() {
        RomanNumber number = new RomanNumber("IVXLC", 111);
        assertEquals(number.maxNumber(), 399);
    }
    @Test
    void prazdne_II() {
        RomanNumber number = new RomanNumber("", 3);
        assertEquals(number.maxNumber(), 3);
    }
    @Test
    void male() {
        RomanNumber number = new RomanNumber("IUHTw", 100);
        assertEquals(number.maxNumber(), 399);
    }
    @Test
    void rimskeCisla_max3() {
        RomanNumber number = new RomanNumber("IVXLC", 1);
        assertEquals(number.romanLetters(), "I");
    }
    @Test
    void rimskeCisla_max499() {
        RomanNumber number = new RomanNumber("IVXLCDM", 499);
        assertEquals(number.romanLetters(), "IVXLCD");
    }
}
