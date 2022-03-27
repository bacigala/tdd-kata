import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Main {


    private static Scanner scanner;
    private static final String delim = ";";
    private static int colsCount = 0;


    public static void main(String[] args) throws FileNotFoundException {
//        scanner = OpenFile("./suborDat.csv");
//
//        int actualCols;
//        int lineCounter = 1;
//
//        String line = GetNextLine(scanner);
//        tokens = ParseLine(line, delim);
//        int expectedColsCount = tokens.size();
//
//        while (line != null) {
//            line = GetNextLine(scanner);
//            tokens = ParseLine(line, delim);
//            actualCols = CheckCols(expectedColsCount, tokens);
//            if (actualCols != 0)
//                System.out.println("Columns at line " + lineCounter + " are not equal header with " + colsCount +
//                        " columns, has only " + actualCols + " column/s.");
//            lineCounter++;
//
//        }
    }

//    public static int CheckCols(int ExpectedColsCount, Scanner scan) {
//        String line = GetNextLine(scanner);
//    }

    public static List<String> ParseLine(String line, String delim) {
        List<String> tokens = Arrays.asList(line.split(delim));
        return tokens;
    }

    public static String GetNextLine(Scanner reader){
        if (reader.hasNextLine())
            return reader.nextLine();
        return null;
    }

    public static Scanner OpenFile(String filename) throws FileNotFoundException {
        try {
            File myObj = new File(filename);
            return new Scanner(myObj);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw e;
        }
    }
}
