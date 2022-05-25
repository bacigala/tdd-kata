import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class Task_1 {

    @Test
    void abeceda_I() {
        RomanNumber roman = new RomanNumber("I");
        assertEquals(roman.romanLetters(), "I");
    }

    @Test
    void Abeceda_IVXLCDMQF() {
        RomanNumber roman = new RomanNumber("IVXLCDMQF");
        assertEquals(roman.romanLetters(), "IVXLCDMQF");
    }

    @Test
    void ZlaAbecedaPismena() {
        RomanNumber roman = new RomanNumber("IVXLCDMSAC");
        assertEquals(roman.romanLetters(), "IVXLCDM");
    }

    //Maximum
    @Test
    void maxZlychPismeniek() {
        RomanNumber roman = new RomanNumber("IVXLCI");
        assertEquals(roman.maxNumber(), 3999);
    }

    @Test
    void prazdnyMax() {
        RomanNumber roman = new RomanNumber(" ");
        assertEquals(roman.maxNumber(), 3999);
    }

    @Test
    void max_V() {
        RomanNumber roman = new RomanNumber("V");
        assertEquals(roman.maxNumber(), 3);
    }

    @Test
    void max_IV() {
        RomanNumber roman = new RomanNumber("IV");
        assertEquals(roman.maxNumber(), 8);
    }

    @Test
    void max_IVXL() {
        RomanNumber roman = new RomanNumber("IVXL");
        assertEquals(roman.maxNumber(), 89);
    }

    @Test
    void max_IVXLC() {
        RomanNumber roman = new RomanNumber("IVXLC");
        assertEquals(roman.maxNumber(), 399);
    }

    @Test
    void max_IVXLCDMQF() {
        RomanNumber roman = new RomanNumber("IVXLCDMQF");
        assertEquals(roman.maxNumber(), 39999);
    }

    @Test
    void IVXLCDM_3896() {
        RomanNumber roman  = new RomanNumber();
        roman.setValue(3896);
        assertEquals(roman.getValue(), 3896);
    }

    @Test
    void I_3() {
        RomanNumber roman = new RomanNumber("I");
        roman.setValue(3);
        assertEquals(roman.getValue(), 3);
    }

    @Test
    void IVXLCDM_0() {
        RomanNumber roman = new RomanNumber();
        assertFalse(roman.setValue(0));
    }

    @Test
    void IVXLCDM_NO_NUMBER() {
        RomanNumber roman = new RomanNumber();
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void IVXLCDM_NO_NUMBER_MAX() {
        RomanNumber roman = new RomanNumber();
        assertFalse(roman.setValue(4000));
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void IVXLCDMPQRSTUWYZ_53864324() {
        RomanNumber roman = new RomanNumber("IVXLCDMPQRSTUWYZ");
        roman.setValue(53864324);
        assertEquals(roman.getValue(), 53864324);
    }

    @Test
    void IVX_10() {
        RomanNumber roman = new RomanNumber("IVX");
        roman.setValue(10);
        assertEquals(roman.getValue(), 10);
    }

    @Test
    void IVX_39() {
        RomanNumber roman = new RomanNumber("IVX");
        roman.setValue(39);
        assertEquals(roman.getValue(), 39);
    }

    @Test
    void IVX_40() {
        RomanNumber roman = new RomanNumber("IVX");
        roman.setValue(40);
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void IVXLCDMPQRSTUWY_16353046() {
        RomanNumber roman = new RomanNumber("IVXLCDMPQRSTUWY");
        roman.setValue(16353046);
        assertEquals(roman.getValue(), 16353046);
    }

    @Test
    void ABCD_80() {
        RomanNumber roman = new RomanNumber("ABCD");
        roman.setValue(80);
        assertEquals(roman.getValue(), 80);
    }

}
