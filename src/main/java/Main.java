import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
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
