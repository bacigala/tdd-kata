import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

    @Test
    void ReadLineTest() throws FileNotFoundException {
        Scanner obj = Main.OpenFile("./suborDat.csv");
        Assertions.assertTrue(obj instanceof Scanner);
        String line = Main.ReadLine(obj);
        Assertions.assertNotNull(line);
        Assertions.assertTrue(line instanceof String);
    }

}