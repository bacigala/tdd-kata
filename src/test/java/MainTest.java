import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.assertj.core.api.SoftAssertions;


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
        Assertions.assertTrue(line.startsWith("cisdot"));
        line = Main.GetNextLine(obj);
        Assertions.assertTrue(!(line.startsWith("cisdot")));
    }

    @Test
    void TestParseLine() throws FileNotFoundException {
        String line = "1;;2";
        Assertions.assertEquals(3, Main.ParseLine(line, delim).size());

        Scanner obj = Main.OpenFile("./suborDat.csv");
        Assertions.assertTrue(obj instanceof Scanner);
        line = Main.GetNextLine(obj);
        Assertions.assertNotNull(line);
        Assertions.assertTrue(line instanceof String);

        List<String> tokens = Main.ParseLine(line, delim);
        Assertions.assertEquals(colsCount, tokens.size());
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestData {

    private String filename = "./suborDat.csv";
    private final String delim = ";";
    private int ExpectedColsCountFromHeader;
    private List<String> cols;
    private int fileLineNumber;
    private int lineCounter;
    private SoftAssertions softAssertions;
    private Scanner scanner;


    @BeforeEach
    void SetUp() throws FileNotFoundException {
        scanner = Main.OpenFile(filename);
        Assertions.assertNotEquals(scanner, null);
        lineCounter = 1;
        softAssertions = new SoftAssertions();
    }

    @AfterEach
    public void tearDown() {
        softAssertions.assertAll();
        scanner.close();
//        if (!cols.isEmpty())
//            cols.clear();
    }

    @Test
    void TestColumnsCount() {
        String line = Main.GetNextLine(scanner);
        Assertions.assertNotNull(line);
        ExpectedColsCountFromHeader = Main.ParseLine(line, delim).size();
        line = Main.GetNextLine(scanner);
        while (line != null) {
            cols = Main.ParseLine(line, delim);
            softAssertions.assertThat(cols.size()).isEqualTo(ExpectedColsCountFromHeader);
            line = Main.GetNextLine(scanner);
        }
    }

    @Test
    void TestLineNumbers() {
        String line = Main.GetNextLine(scanner);
        Main.ParseLine(line, delim).size();
        line = Main.GetNextLine(scanner);
        while (line != null) {
            cols = Main.ParseLine(line, delim);
            fileLineNumber = Integer.parseInt(cols.get(0));
            softAssertions.assertThat(lineCounter).isEqualTo(fileLineNumber);
            if (lineCounter != fileLineNumber)
                lineCounter = fileLineNumber;
            line = Main.GetNextLine(scanner);
            lineCounter++;
        }
    }

    @Test
    void TestQuestionsScale1to7() {
        String line = Main.GetNextLine(scanner);
        Main.ParseLine(line, delim).size();
        line = Main.GetNextLine(scanner);
        String[] allowed = { "1", "2", "3", "4", "5", "6", "7", "9", "0" };
        int[] questions = {1, 2, 3, 4, 5, 6, 7, 8, 9, 21, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        while (line != null) {
            cols = Main.ParseLine(line, delim);
            for (int i = 0; i < questions.length; i++) {
                if (cols.size() > questions[i])
                    softAssertions.assertThat(cols.get(questions[i])).containsAnyOf(allowed);
            }
            line = Main.GetNextLine(scanner);
        }
    }

    @Test
    void TestQuestionsScale1to4() {
        String line = Main.GetNextLine(scanner);
        Main.ParseLine(line, delim).size();
        line = Main.GetNextLine(scanner);
        String[] allowed = {"1", "2", "3", "4", "9", "0" };
        int[] questions = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 23, 24, 25, 26, 27};
        while (line != null) {
            cols = Main.ParseLine(line, delim);
            for (int i = 0; i < questions.length; i++) {
                if (cols.size() > questions[i])
                    softAssertions.assertThat(cols.get(questions[i])).containsAnyOf(allowed);
            }
            line = Main.GetNextLine(scanner);
        }
    }

    @Test
    void TestQuestionsScale1to5() {
        String line = Main.GetNextLine(scanner);
        Main.ParseLine(line, delim).size();
        line = Main.GetNextLine(scanner);
        String[] allowed = {"1", "2", "3", "4", "5", "9", "0" };
        int[] questions = {22};
        while (line != null) {
            cols = Main.ParseLine(line, delim);
            for (int i = 0; i < questions.length; i++) {
                if (cols.size() > questions[i])
                    softAssertions.assertThat(cols.get(questions[i])).containsAnyOf(allowed);
            }
            line = Main.GetNextLine(scanner);
        }
    }
}