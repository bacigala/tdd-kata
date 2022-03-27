import org.junit.jupiter.api.*;
import java.io.*;
import java.util.Arrays;
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

    @Test
    void TestConatainsEnoughtColumns()
    {
        List<String> data = Arrays.asList(new String[]{});
        Assertions.assertFalse(Main.ContainsEnougthColumns(data, 0));
        data = Arrays.asList(new String[]{"", ""});
        Assertions.assertFalse(Main.ContainsEnougthColumns(data, -1));
        data = Arrays.asList(new String[]{"abc", "ced"});
        Assertions.assertFalse(Main.ContainsEnougthColumns(data, -1));
        data = Arrays.asList(new String[]{"abc", "ced"});
        Assertions.assertFalse(Main.ContainsEnougthColumns(data, 5));
        Assertions.assertTrue(Main.ContainsEnougthColumns(data, 0));
        Assertions.assertTrue(Main.ContainsEnougthColumns(data, 1));
    }

    @Test
    void TestIsAllowedInList()
    {
        List<String> data = Arrays.asList(new String[]{"1", "2", "3"});
        List<String> allowed = Arrays.asList(new String[]{"1", "2", "3"});
        int cols[] = {0, 1, 2};
        int falseCols[] = {3};
        Assertions.assertTrue(Main.IsAllowedInList(data, allowed, cols));
        Assertions.assertFalse(Main.IsAllowedInList(data, allowed, falseCols));
    }

    @Test
    void TestIsNotAllowedInList1()
    {
        List<String> data = Arrays.asList(new String[]{"1", "2", "3", "4"});
        List<String> allowed = Arrays.asList(new String[]{"1", "2", "3"});
        int cols[] = {0, 1, 2, 3};
        Assertions.assertFalse(Main.IsAllowedInList(data, allowed, cols));
    }
    @Test
    void TestIsNotAllowedInList2()
    {
        List<String> data = Arrays.asList(new String[]{"1", "2", "3", "4"});
        List<String> allowed = Arrays.asList(new String[]{"5", "6", "7"});
        int cols[] = {0};
        Assertions.assertFalse(Main.IsAllowedInList(data, allowed, cols));
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestData {

    private String filename = "./suborDat.csv";
    private final String delim = ";";
    private List<String> data;
    private SoftAssertions softAssertions;
    private Scanner scanner;

    @BeforeAll
    void SetUpAll() throws FileNotFoundException {
        System.setOut(new PrintStream(new File("output-file.txt")));
    }


    @BeforeEach
    void SetUp() throws FileNotFoundException {
        scanner = Main.OpenFile(filename);
        Assertions.assertNotEquals(scanner, null);
        softAssertions = new SoftAssertions();
    }

    @AfterEach
    public void tearDown() {
        softAssertions.assertAll();
        scanner.close();
    }

    @Test
    void TestColumnsCount() {
        softAssertions.assertThat(Main.GetLinesWithMissingColumnsCount(scanner, delim)).isEqualTo(0);
    }

    @Test
    void TestLineNumbers() {
        softAssertions.assertThat(Main.AreMissingLines(scanner, delim)).isEqualTo(0);
    }

    @Test
    void TestQuestionsScale1to7() {
        Main.GetHeader(scanner, delim);
        String line = Main.GetNextLine(scanner);
        List<String> allowed = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "9", "0");
        int[] questions = {1, 2, 3, 4, 5, 6, 7, 8, 9, 21, 28, 29, 30, 31, 32, 33, 34, 35, 36};
        while (line != null) {
            data = Main.ParseLine(line, delim);
            softAssertions.assertThat(Main.IsAllowedInList(data, allowed, questions)).isTrue();
            line = Main.GetNextLine(scanner);
        }
    }

    @Test
    void TestQuestionsScale1to4() {
        Main.GetHeader(scanner, delim);
        String line = Main.GetNextLine(scanner);
        List<String> allowed = Arrays.asList("1", "2", "3", "4", "9", "0");
        int[] questions = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 23, 24, 25, 26, 27};
        while (line != null) {
            data = Main.ParseLine(line, delim);
            softAssertions.assertThat(Main.IsAllowedInList(data, allowed, questions)).isTrue();
            line = Main.GetNextLine(scanner);
        }
    }

    @Test
    void TestQuestionsScale1to5() {
        Main.GetHeader(scanner, delim);
        String line = Main.GetNextLine(scanner);
        List<String> allowed = Arrays.asList("1", "2", "3", "4", "5", "9", "0");
        int[] questions = {22};
        while (line != null) {
            data = Main.ParseLine(line, delim);
            softAssertions.assertThat(Main.IsAllowedInList(data, allowed, questions)).isTrue();
            line = Main.GetNextLine(scanner);
        }
    }
}