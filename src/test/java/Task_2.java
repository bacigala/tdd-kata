
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class Task_2 {

    @Test
    void IVXLCDM_1_Zero() {
        RomanNumberFull roman = new RomanNumberFull();
        assertEquals(roman.maximum(), 3999);
        assertEquals(roman.minimum(), -3999);
    }

    @Test
    void OI() {
        RomanNumberFull roman = new RomanNumberFull("OI");
        assertEquals(roman.maximum(), 3);
        assertEquals(roman.minimum(), -3);
    }

    @Test
    void O() {
        RomanNumberFull roman = new RomanNumberFull("O");
        assertEquals(roman.maximum(), 3999);
        assertEquals(roman.minimum(), -3999);
    }

    @Test
    void ABCDEFGHIJKLMN() {
        RomanNumberFull roman = new RomanNumberFull("ABCDEFGHIJKLMN");
        assertEquals(roman.maximum(), 3999999);
        assertEquals(roman.minimum(), -3999999);
    }

    @Test
    void IVXLCDMPQRSTUWYZ_53864324_Zero() {
        RomanNumberFull roman = new RomanNumberFull("OIVXLCDMPQRSTUWYZ");
        assertEquals(roman.maximum(), 89999999);
        assertEquals(roman.minimum(), -89999999);
    }


    //Value
    @Test
    void IVXLCDM_3896() {
        RomanNumberFull roman = new RomanNumberFull();
        roman.setValue(-3896);
        assertEquals(roman.getValue(), -3896);
    }

    @Test
    void Zero() {
        RomanNumberFull roman = new RomanNumberFull();
        assertTrue(roman.setValue(0));
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void IVXLCDM_NO_NUMBER_MAX_Zero() {
        RomanNumberFull roman = new RomanNumberFull();
        assertFalse(roman.setValue(4000));
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void I_I_5() {
        RomanNumberFull roman = new RomanNumberFull("I");
        roman.setValue(5);
        assertEquals(roman.getValue(), 5);
    }

    @Test
    void IVXLCDMPQRSTUWYZ_53864324() {
        RomanNumberFull roman = new RomanNumberFull("OIVXLCDMPQRSTUWYZ");
        roman.setValue(53864324);
        assertEquals(roman.getValue(), 53864324);
    }


    @Test
    void TestEfektivnosti_Zero() {
        for (int i = 0; i < 1000; i++) {
            RomanNumberFull roman = new RomanNumberFull("OIVXLCDMPQRSTUWY");
            roman.setValue(16353048);
            if (roman.getValue() != 16353048) {
                assertTrue(false);
            }
        }
        assertTrue(true);
    }

}
