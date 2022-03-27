import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public static List<String> GetHeader(Scanner scanner, String delim) {
        String header = GetNextLine(scanner);
        return ParseLine(header, delim);
    }

    public static int AreMissingLines(Scanner scanner, String delim){
        int missingLines = 0;
        int fileLineNumber = 0;
        int lineCounter = 1;
        List<String> data;

        GetHeader(scanner, delim);
        String line = GetNextLine(scanner);
        while (line != null) {
            if (!IsEmptyLine(line)) {
                data = ParseLine(line, delim);
                if (ContainsEnougthColumns(data, 1)) {
                    fileLineNumber = Integer.parseInt(data.get(0));
                    if (lineCounter != fileLineNumber) {
                        System.out.println("Expected line: " + lineCounter + ", Got: " + fileLineNumber +
                                ". Probably missing line: " + lineCounter);
                        missingLines++;
                        lineCounter = fileLineNumber;
                    }
                }
            }
            else {
                System.out.println("Empty line: " + lineCounter);
            }
            line = GetNextLine(scanner);
            lineCounter++;
        }
        return missingLines;
    }

    public static int GetLinesWithMissingColumnsCount(Scanner scanner, String delim) {
        int missing = 0;
        int lineNum = 2;
        List<String> header = GetHeader(scanner, delim);
        int ExpectedColsCountFromHeader = header.size();
        List<String> data;
        String line = GetNextLine(scanner);
        while (line != null) {
            data = Main.ParseLine(line, delim);
            if (data.size() < ExpectedColsCountFromHeader) {
                System.out.println("Missing columns at line: " + lineNum);
                missing++;
            }
            else if (data.size() > ExpectedColsCountFromHeader) {
                System.out.println("Trailing columns at line: " + lineNum);
                missing++;
            }
            line = Main.GetNextLine(scanner);
            lineNum++;
        }
        return missing;
    }

    public static boolean IsAllowedInList(List<String> data, List<String> allowed, int[] columns) {
        boolean isAllowed = true;
        for (int i = 0; i < columns.length; i++) {
            if (ContainsEnougthColumns(data, columns[i])) {
                if (!allowed.contains(data.get(columns[i]))){
                    isAllowed = false;
                    System.out.println("Line: " + data.get(0) + ". Value <" + data.get(columns[i]) + "> at column " +
                            columns[i] + " is not allowed");
                }
            }
            else {
                if (!data.get(0).isBlank())
                    System.out.println("Line: " + data.get(0) + ".Accessing value at column:" + columns[i] + ", but line has only " +
                        data.size() + " columns");
                return false;
            }
        }
        return isAllowed;
    }

    public static boolean ContainsEnougthColumns(List<String> data, int column) {
        if ((data.size() > column) && (column >= 0))
            return true;
        else
            return false;
    }

    public static List<String> ParseLine(String line, String delim) {
        List<String> tokens = Arrays.asList(line.split(delim));
        return tokens;
    }

    public static boolean IsEmptyLine(String line) {
        return (line.isEmpty() || line.isBlank());
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
