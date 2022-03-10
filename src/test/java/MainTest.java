import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testToInt() {
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
    }

}