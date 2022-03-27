import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Main {

    public static void main(String[] args) {
        

    }

    public static boolean IsAllowedInList(List<String> data, List<String> allowed, int[] columns) {
        boolean isAllowed = true;
        for (int i = 0; i < columns.length; i++) {
            if (ContainsEnougthColumns(data, columns[i])) {
                if (!allowed.contains(data.get(columns[i]))){
                    isAllowed = false;
                    System.out.println("Value " + data.get(columns[i]) + " is not allowed");
                }
            }
            else {
                System.out.println("Not enough columns");
                return false;
            }
        }
        return isAllowed;
    }

    public static boolean ContainsEnougthColumns(List<String> data, int column) {
        if (data.size() > column && column >= 0)
            return true;
        else
            return false;
    }

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
