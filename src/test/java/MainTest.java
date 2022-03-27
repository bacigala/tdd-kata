import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

class MainTest {

    private final String delim = ";";
    private final int colsCount = 37;

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
        String line = Main.GetNextLine(obj);
        Assertions.assertNotNull(line);
        Assertions.assertTrue(line instanceof String);
    }

    @Test
    void TestParseLine() throws FileNotFoundException {
        Scanner obj = Main.OpenFile("./suborDat.csv");
        Assertions.assertTrue(obj instanceof Scanner);
        String line = Main.GetNextLine(obj);
        Assertions.assertNotNull(line);
        Assertions.assertTrue(line instanceof String);

        List<String> tokens = Main.ParseLine(line, delim);
        Assertions.assertEquals(tokens.size(), colsCount);
    }
}

class TestData {

    @Test
    void TestFileCols() {

    }
}