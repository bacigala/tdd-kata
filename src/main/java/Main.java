import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

    }

    public static List<String> ParseLine(String line, String delim) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(line, delim);
        while (tokenizer.hasMoreElements())
            tokens.add(tokenizer.nextToken());
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
