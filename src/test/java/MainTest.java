import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void OpenFileTest() {
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            Main.OpenFile("");
        });
        Assertions.assertDoesNotThrow(() -> {
            Scanner obj = Main.OpenFile("./suborDat.csv");
            Assertions.assertTrue(obj instanceof Scanner);
        });
    }

}