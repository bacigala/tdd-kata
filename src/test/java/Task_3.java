
    import org.junit.jupiter.api.Test;
    import static org.junit.Assert.*;

public class Task_3 {

    @Test
    void PrazdnaAbeceda() {
        RomanNumber roman = new RomanNumber ("");
        roman.setRomanNumber("MMDCIX");
        assertEquals(roman.getValue(), 2609);
    }

    @Test
    void ASDFG() {
        RomanNumber roman = new RomanNumber ("ASDFG");
        roman.setRomanNumber("GGGSA");
        assertEquals(roman.getValue(), 306);
    }

    @Test
    void LLA() {
        RomanNumber roman = new RomanNumber ("ALP");
        roman.setRomanNumber("LA");
        roman.setRomanNumber("LLA");
        assertEquals(roman.getValue(), 6);
    }

    @Test
    void KLO() {
        RomanNumber roman = new RomanNumber ("POILK");
        roman.setRomanNumber("PI");
        roman.setRomanNumber("KLO");
        assertEquals(roman.getValue(), 155);
    }

    @Test
    void IAVXLCQDM() {
        RomanNumber roman = new RomanNumber ("IAVXLCQDM");
        roman.setRomanNumber("QVA");
        assertEquals(roman.getValue(), 1015);
    }

    @Test
    void I() {
        RomanNumber roman = new RomanNumber ("I");
        roman.setRomanNumber("I");
        assertEquals(roman.getValue(), 1);
    }

    @Test
    void IVXLCDMPQRSTUWY() {
        RomanNumber roman = new RomanNumber("IVXLCDMPQRSTUWY");
        roman.setRomanNumber("YWUSSSRMMMXLVI");
        assertEquals(roman.getValue(), 16353046);
    }

    // Wrong roman number
    @Test
    void PrazdneCislo() {
        RomanNumber roman = new RomanNumber ("IVX");
        roman.setRomanNumber("");
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void ZleZnakyCisla() {
        RomanNumber roman = new RomanNumber ("IVXLCDM");
        roman.setRomanNumber("MMDXXL");
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void IV_IVI() {
        RomanNumber roman = new RomanNumber ("IV");
        roman.setRomanNumber("IVI");
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void IV_VIV() {
        RomanNumber roman = new RomanNumber ("IV");
        roman.setRomanNumber("VIV");
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void IVX_VX() {
        RomanNumber roman = new RomanNumber ("IVX");
        roman.setRomanNumber("VX");
        assertEquals(roman.getValue(), 0);
    }

    @Test
    void IIX() {
        RomanNumber roman = new RomanNumber ("IVX");
        roman.setRomanNumber("IIX");
        assertEquals(roman.getValue(), 0);
    }
    @Test
    void IVXL_LC() {
        RomanNumber roman = new RomanNumber ("IVXL");
        roman.setRomanNumber("LC");
        assertEquals(roman.getValue(), 0);
    }
    @Test
    void ZlaAbeceda() {
        RomanNumber roman = new RomanNumber ("IVXLCDMSAC");
        roman.setRomanNumber("SMMDCCCLXXXVIII");
        assertEquals(roman.getValue(), 0);
    }



    //Class RomanNumberFull
//Set roman number
    @Test
    void IVXLCDM_MMMDCCCXCIV_Zero() {
        RomanNumberFull roman = new RomanNumberFull();
        roman.setRomanNumber("MMMDCCCXCIV");
        assertEquals(roman.getValue(), 3894);
    }
    @Test
    void IVX_X_Zero() {
        RomanNumberFull roman = new RomanNumberFull("OIVX");
        roman.setRomanNumber("XIV");
        assertEquals(roman.getValue(), 14);
    }
    @Test
    void IVXLCDMPQRSTUWY_YWUSSSRMMMXLVI_Zero() {
        RomanNumberFull roman = new RomanNumberFull("OIVXLCDMPQRSTUWY");
        roman.setRomanNumber("YWUSSSRMMMXLVI");
        assertEquals(roman.getValue(), 16353046);
    }
    @Test
    void ABCD_DCCC_Zero() {
        RomanNumberFull roman = new RomanNumberFull("OABCD");
        roman.setRomanNumber("DCCCAC");
        assertEquals(roman.getValue(), 89);
    }
    @Test
    void TestEfektivnostiPatiek_Zero() {
        RomanNumberFull roman = new RomanNumberFull("OIVXLCDMPQRSTUW");
        for ( int i = 0; i < 1000; i++) {
            roman.setRomanNumber("WUSSSRMMMXLVIII");
            if (roman.getValue() != 6353048) {
                assertTrue(false);
            }
        }
        assertTrue (true);
    }



    //Wrong roman number
    @Test
    void IV_OIV_Zero() {
        RomanNumberFull roman = new RomanNumberFull("OIV");
        assertFalse(roman.setRomanNumber("OI"));
        assertEquals(roman.getValue(), 0);
    }



    //Get roman number
    @Test
    void IVXLCDMPQRSTUWYZ_53864324_Zero() {
        RomanNumberFull roman = new RomanNumberFull("OIVXLCDMPQRSTUWYZ");
        roman.setValue(53864324);
        assertEquals(roman.getRomanNumber(), "ZUUUTSSSRQMPCCCXXIV");
    }
    @Test
    void IVXLCDM_3896_Zero() {
        RomanNumberFull roman = new RomanNumberFull();
        roman.setValue(-3896);
        assertEquals(roman.getRomanNumber(), "-MMMDCCCXCVI");
    }
    @Test
    void OMPQRSTUWYZABCD() {
        RomanNumberFull roman = new RomanNumberFull("OMPQRSTUWYZABCD");
        roman.setValue(7777777);
        assertEquals(roman.getRomanNumber(), "DCCBAAZYYWUUTSSRQQPMM");
    }
    @Test
    void O() {
        RomanNumberFull roman = new RomanNumberFull("OMPQRSTUWYZABCD");
        roman.setValue(0);
        assertEquals(roman.getRomanNumber(), "O");
    }
}
