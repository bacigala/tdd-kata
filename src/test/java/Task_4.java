
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class Task_4 {

    @Test
    void ZakladnyVypocet5() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertTrue(romanNumber.calculator("I+I"));
        assertEquals(romanNumber.getRomanNumber(), "II");
    }

    @Test
    void AddZero() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertTrue(romanNumber.calculator("IV + O"));
        assertEquals(romanNumber.getRomanNumber(), "IV");
    }

    @Test
    void AddToZero() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertTrue(romanNumber.calculator("O + IV"));
        assertEquals(romanNumber.getRomanNumber(), "IV");
    }

    @Test
    void Scitanie5() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        romanNumber.calculator("L+XL");
        assertEquals(romanNumber.getRomanNumber(), "XC");
    }

    @Test
    void Rozdiel5() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        romanNumber.calculator("MMDCCLXXXIII-MDCLXVI");
        assertEquals(romanNumber.getRomanNumber(), "MCXVII");
    }

    @Test
    void Delenie5() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        romanNumber.calculator("MMMDC/MD");
        assertEquals(romanNumber.getRomanNumber(), "II");
    }

    @Test
    void Nasobenie5() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        romanNumber.calculator("XIV*VI");
        assertEquals(romanNumber.getRomanNumber(), "LXXXIV");
    }

    @Test
    void mensi() {
        RomanNumberFull romanNumber = new RomanNumberFull("OIVXLCDMPQRSTUWY");
        romanNumber.calculator("YYMMDCCLXXXIII - YYMDCLXVI");
        assertEquals(romanNumber.getRomanNumber(), "MCXVII");
    }

    @Test
    void vacsi() {
        RomanNumberFull romanNumber = new RomanNumberFull("OIVXLCDMPQRSTUWY");
        romanNumber.calculator("YYMDCLXVI - YYMMDCCLXXXIII");
        assertEquals(romanNumber.getRomanNumber(), "-MCXVII");
    }

    @Test
    void rovny() {
        RomanNumberFull romanNumber = new RomanNumberFull("OIVXLCDMPQRSTUWY");
        romanNumber.calculator(" - YYMMDCCLXXXIII - - YYMMDCCLXXXIII ");
        assertEquals(romanNumber.getRomanNumber(), "O");
    }


    //Wrong expressions
    @Test
    void PrazdnyVyraz() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator(""));
    }

    @Test
    void DvaOperatory() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("MMDC-*MD"));
    }

    @Test
    void DvePatky() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("VV-I"));
    }

    @Test
    void ZleCislo() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("I-MMMIM"));
    }

    @Test
    void ChybaOperand() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("MXII"));
    }

    @Test
    void ChybaDruhy() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("MMDCCLXXXII+"));
    }

    @Test
    void ChybaPrvy() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("+MMDCCLXXXII"));
    }

    @Test
    void Privela() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("MMDC-MD a"));
    }

    @Test
    void DesiatkaZaPatkou() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("DM+III"));
    }

    @Test
    void ZleUmiestnenie() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("MCMM+I"));
    }

    @Test
    void NeznamyOperator5() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("X^II"));
    }

    @Test
    void NeznamaCislica5() {
        RomanNumberFull romanNumber = new RomanNumberFull();
        assertFalse(romanNumber.calculator("GL+V"));
    }

    @Test
    void Efektivita() {
        RomanNumberFull romanNumber = new RomanNumberFull("OIVXLCDMPQRSTUWY");
        for (int i = 0; i < 1000; i++) {
            romanNumber.calculator("YYMMDCCLXXXIII-YYMDCLXVI");
        }
        assertEquals(romanNumber.getRomanNumber(), "MCXVII");
    }

}
